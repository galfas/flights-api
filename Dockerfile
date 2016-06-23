FROM jetty:9.3-jre8

user root

COPY ./target/flights-api-0.1.0.jar /usr/local/jetty/webapps/

WORKDIR /usr/local/jetty/

EXPOSE 8080

CMD ["java","-Djava.io.tmpdir=/tmp/jetty","-jar","/usr/local/jetty/start.jar"]
