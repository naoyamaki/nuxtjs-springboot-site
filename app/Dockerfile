FROM tomcat:9.0.58-jdk17-corretto

ENV TZ Asia/Tokyo

RUN yum update -y
COPY conf/logging.properties /usr/local/tomcat/conf/logging.properties
COPY conf/server.xml /usr/local/tomcat/conf/server.xml
COPY conf/web.xml /usr/local/tomcat/conf/web.xml
# 必要に応じconf配下の設定ファイルをコピー(conf内はデフォルト設定ファイル)
# e.g COPY conf/server.xml /usr/local/tomcat/conf/server.xml