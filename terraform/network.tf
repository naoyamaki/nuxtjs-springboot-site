variable aws_access_key {}
variable aws_secret_key {}
variable aws_region {}
variable cidr_network_part {}
variable product_name {}

# network/VPC
resource "aws_vpc" "hoge_vpc" {
  cidr_block           = "${var.cidr_network_part}"
  instance_tenancy     = "default"
  enable_dns_support   = "true"
  enable_dns_hostnames = "true"
  tags = {
    Name = "${product_name}_vpc"
  }
}
resource "aws_internet_gateway" "hoge_igw" {
  vpc_id = aws_vpc.hoge_vpc.id
}

# subnet
resource "aws_subnet" "public-a" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.0.0/24"
  availability_zone = "ap-northeast-1a"
  tags = {
    Name = "public_subnet_1a"
  }
}
resource "aws_subnet" "public-c" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.2.0/24"
  availability_zone = "ap-northeast-1c"
  tags = {
    Name = "public_subnet_1c"
  }
}
resource "aws_subnet" "public-d" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.4.0/24"
  availability_zone = "ap-northeast-1d"
  tags = {
    Name = "public_subnet_1d"
  }
}
resource "aws_subnet" "private-a-app" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.64.0/24"
  availability_zone = "ap-northeast-1a"
  tags = {
    Name = "private_subnet_1a_app"
  }
}
resource "aws_subnet" "private-c-app" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.66.0/24"
  availability_zone = "ap-northeast-1c"
  tags = {
    Name = "private_subnet_1c_app"
  }
}
resource "aws_subnet" "private-d-app" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.68.0/24"
  availability_zone = "ap-northeast-1d"
  tags = {
    Name = "private_subnet_1d_app"
  }
}
resource "aws_subnet" "private-a-db" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.128.0/24"
  availability_zone = "ap-northeast-1a"
  tags = {
    Name = "private_subnet_1a_db"
  }
}
resource "aws_subnet" "private-c-db" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.130.0/24"
  availability_zone = "ap-northeast-1c"
  tags = {
    Name = "private_subnet_1c_db"
  }
}
resource "aws_subnet" "private-d-db" {
  vpc_id            = aws_vpc.hoge_vpc.id
  cidr_block        = "${var.cidr_network_part}.132.0/24"
  availability_zone = "ap-northeast-1d"
  tags = {
    Name = "private_subnet_1d_db"
  }
}

# route_table
resource "aws_route_table" "public-route" {
  vpc_id = aws_vpc.hoge_vpc.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.hoge_igw.id
  }
}
resource "aws_route_table" "private-route" {
  vpc_id = aws_vpc.hoge_vpc.id
}

resource "aws_route_table_association" "puclic-a" {
  subnet_id      = aws_subnet.public-a.id
  route_table_id = aws_route_table.public-route.id
}
resource "aws_route_table_association" "puclic-c" {
  subnet_id      = aws_subnet.public-c.id
  route_table_id = aws_route_table.public-route.id
}
resource "aws_route_table_association" "puclic-c" {
  subnet_id      = aws_subnet.public-d.id
  route_table_id = aws_route_table.public-route.id
}