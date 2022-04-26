variable aws_access_key {}
variable aws_secret_key {}
variable aws_region {}
variable aws_vpc_cidr {}
variable product_name {}
variable data_center_ip {}

resource "aws_security_group" "hoge-alb-sg" {
  name   = "${product_name}-alb-sg"
  vpc_id = aws_vpc.hoge_vpc.id

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
    description = "open"
  }
}
resource "aws_security_group" "hoge-service-sg" {
  name   = "${product_name}-service-sg"
  vpc_id = aws_vpc.hoge_vpc.id
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port       = 80
    to_port         = 80
    protocol        = "tcp"
    security_groups = ["${aws_security_group.hoge-alb-sg.id}"]
  }
}
resource "aws_security_group" "hoge-rds-sg" {
  name   = "${product_name}-rds-sg"
  vpc_id = aws_vpc.hoge_vpc.id
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port       = 3306
    to_port         = 3306
    protocol        = "tcp"
    security_groups = ["${aws_security_group.hoge-service-sg.id}", "${data_center_ip}"]
  }
}