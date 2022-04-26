data "aws_caller_identity" "self" {}

resource "aws_ecs_task_definition" "wordpress-task-def" {
  family                   = "wordpress"
  requires_compatibilities = ["FARGATE"]
  cpu                      = "512"
  memory                   = "2048"
  network_mode             = "awsvpc"

  container_definitions = jsonencode([
    {
      "command" : [],
      "cpu" : 384,
      "environment" : [
        { "name" : "DB_HOST", "value" : "${var.db_endpoint}" },
        { "name" : "DB_PASSWORD", "value" : "${var.db_password}" }
      ],
      "essential" : true,
      "healthCheck" : {
        "command" : ["CMD-SHELL", "curl -f http://localhost:9000/ || exit 0"],
        "interval" : 30,
        "retries" : 3,
        "startPeriod" : 3,
        "timeout" : 5
      },
      "image" : "${data.aws_caller_identity.self.account_id}.dkr.ecr.ap-northeast-1.amazonaws.com/wp_app:latest",
      "logConfiguration" : {
        "logDriver" : "awslogs",
        "options" : { "awslogs-group" : "/ecs/wordpress", "awslogs-region" : "ap-northeast-1", "awslogs-stream-prefix" : "ecs" }
      },
      "memoryReservation" : 1536,
      "mountPoints" : [{ "containerPath" : "/var/www/html/", "sourceVolume" : "wordpress" }],
      "name" : "app",
      "portMappings" : [{ "containerPort" : 9000, "hostPort" : 9000, "protocol" : "tcp" }],
      "volumesFrom" : []
    },
    {
      "command" : ["envsubst '$$APP_HOST' < /etc/nginx/conf.d/default.conf.template > /etc/nginx/conf.d/default.conf \u0026\u0026 nginx -g 'daemon off;'"],
      "cpu" : 128,
      "dependsOn" : [{ "condition" : "START", "containerName" : "app" }],
      "entryPoint" : ["sh", "-c"],
      "environment" : [{ "name" : "APP_HOST", "value" : "localhost" }],
      "essential" : true,
      "healthCheck" : {
        "command" : ["CMD-SHELL", "curl -f http://localhost:80/healthcheck/|| exit 1"],
        "interval" : 30,
        "retries" : 3,
        "startPeriod" : 3,
        "timeout" : 5
      },
      "image" : "${data.aws_caller_identity.self.account_id}.dkr.ecr.ap-northeast-1.amazonaws.com/wp_web:latest",
      "links" : [],
      "logConfiguration" : {
        "logDriver" : "awslogs",
        "options" : {
          "awslogs-group" : "/ecs/wordpress",
          "awslogs-region" : "ap-northeast-1",
          "awslogs-stream-prefix" : "ecs"
        }
      },
      "memoryReservation" : 512,
      "mountPoints" : [{ "containerPath" : "/var/www/html/", "sourceVolume" : "wordpress" }],
      "name" : "web",
      "portMappings" : [{ "containerPort" : 80, "hostPort" : 80, "protocol" : "tcp" }],
      "volumesFrom" : []
    }
  ])

  volume {
    efs_volume_configuration {
      authorization_config {
        iam = "DISABLED"
      }

      file_system_id          = aws_efs_file_system.wordpress-efs.id
      root_directory          = "/"
      transit_encryption      = "DISABLED"
      transit_encryption_port = "0"
    }

    name = "wordpress"
  }
}
resource "aws_ecs_cluster" "wordpress-cluster" {
  capacity_providers = ["FARGATE_SPOT", "FARGATE"]
  name               = "wordpress"

  setting {
    name  = "containerInsights"
    value = "disabled"
  }
}
resource "aws_ecs_service" "wordpress-service" {
  cluster                            = "wordpress"
  name                               = "wordpress"
  platform_version                   = "1.4.0"
  scheduling_strategy                = "REPLICA"
  deployment_maximum_percent         = "200"
  deployment_minimum_healthy_percent = "100"
  desired_count                      = "2"
  enable_ecs_managed_tags            = "true"
  enable_execute_command             = "true"
  health_check_grace_period_seconds  = "30"
  launch_type                        = "FARGATE"
  task_definition                    = aws_ecs_task_definition.wordpress-task-def.arn

  load_balancer {
    container_name   = "web"
    container_port   = "80"
    target_group_arn = aws_lb_target_group.wordpress-tgg.arn
  }
  network_configuration {
    assign_public_ip = "true"
    security_groups  = ["${aws_security_group.wordpress-service-sg.id}"]
    subnets          = ["${aws_subnet.public-a.id}", "${aws_subnet.public-c.id}"]
  }
}
