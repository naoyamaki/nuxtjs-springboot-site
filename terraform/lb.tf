variable aws_access_key {}
variable aws_secret_key {}
variable aws_region {}
variable aws_vpc_cidr {}
variable product_name {}
variable data_center_ip {}

resource "aws_lb_target_group" "hoge-tgg" {
  deregistration_delay = "300"

  health_check {
    enabled             = "true"
    healthy_threshold   = "5"
    interval            = "30"
    matcher             = "200"
    path                = "/healthcheck/"
    port                = "traffic-port"
    protocol            = "HTTP"
    timeout             = "5"
    unhealthy_threshold = "2"
  }

  load_balancing_algorithm_type = "round_robin"
  name                          = "${product_name}-tgg"
  port                          = "80"
  protocol                      = "HTTP"
  protocol_version              = "HTTP1"
  slow_start                    = "0"

  stickiness {
    cookie_duration = "86400"
    enabled         = "false"
    type            = "lb_cookie"
  }

  target_type = "ip"
  vpc_id      = aws_vpc.hoge_vpc.id
}
resource "aws_lb" "hoge-alb" {
  drop_invalid_header_fields = "false"
  enable_deletion_protection = "false"
  enable_http2               = "false"
  idle_timeout               = "60"
  internal                   = "false"
  ip_address_type            = "ipv4"
  load_balancer_type         = "application"
  name                       = "hoge-alb"
  security_groups            = ["${aws_security_group.hoge-alb-sg.id}"]
  subnets                    = ["${aws_subnet.public-a.id}", "${aws_subnet.public-c.id}"]
}
resource "aws_lb_listener" "hoge-alb-listner" {
  load_balancer_arn = aws_lb.hoge-alb.arn
  port              = 443
  protocol          = "TCP"

  default_action {
    target_group_arn = aws_lb_target_group.hoge-tgg.arn
    type             = "forward"
  }
}