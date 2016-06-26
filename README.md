# flights-api
This project is built in java 8 with spring boot. It will expose an API that will retrieve, handle and return all the available flights from a given place and local 

##To launch the application##

###Using docker ###
You could launch it as a container, in this case you need to have docker installed in your server, 
and then you just need to execute the next commands:

- docker build -t flight-api.
- docker run -it --rm -p 80:80 flight-api-tomcat-web-last

It will launch your container, to test it  you will need to discovery the container IP and then just access it via browser in the port 8080.

The command "docker-machine ip" will return your IP and the you can access the api via:

(supossing the ip is 192.168.99.100)

http://192.168.99.100:8080/api/flights/from/DUB/to/DEL/datefrom/20151007/dateto/20151020/quantity/2

###Via maven ###
To run via maven, you just have to run the command:  mvn spring-boot:run


## Used design Patterns: ##
1. Builder
2. Strategy
3. Singleton
- In a future refactoring I would use the chain of responsibility to build the new Object form the xml.
###

