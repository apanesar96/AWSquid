resource "aws_instance" "walking_skeleton" {
  ami                    = data.aws_ami.ubuntu.id
  key_name               = var.keypair_name
  instance_type          = var.instance_type
  vpc_security_group_ids = [data.aws_security_groups.http.ids[0], data.aws_security_groups.http.ids[1]]

  tags = merge(local.common_tags)

  user_data = <<EOF
#!/bin/bash
echo "CORS_URL=$(curl -s http://169.254.169.254/latest/meta-data/public-ipv4)" >> /home/ubuntu/.env
apt update
apt install -y docker.io
systemctl enable --now docker
usermod -aG docker ubuntu
docker run -p 8080:8080 apcodurance/awsquid:latest
EOF
}
