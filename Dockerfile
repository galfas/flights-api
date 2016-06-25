FROM tomcat:9.0.0-jre8

MAINTAINER Marcelo Saciloto

user root

ADD . /usr/local/tomcat/
WORKDIR /usr/local/tomcat/

COPY ./target/flights-api-1.0.0.war  /usr/local/tomcat/webapps/api.war
