FROM tomcat:9.0.58-jdk17-corretto

RUN yum update -y
# 必要に応じconf配下の設定ファイルをコピー(conf内はデフォルト設定ファイル)
# e.g COPY conf/server.xml /usr/local/tomcat/conf/server.xml