# flights-api

This project is built in java 8 with spring boot. It will expose an API that will retrieve do a transformation and return all the available flights from a given place and local 

I focused on isolating all the objects from the XML API, because I want to be able to replace that API without having to change anything from my business model.

I would use a layer of cache in my Business layer even if it was for a few seconds, because I would have a better response time and also avoid the possibility the XML API could face some performance issues.

## Security

The API uses basic auth, the user and password is configured via properties:

the current configuration is:
user: flight 
password: 123456

##To launch the application##

###Using docker ###
You could launch it as a container, in this case you need to have docker installed in your server, 
and then you just need to execute the next commands in the root of the project:

1. *mvn package*
2. *docker build -t flight-api .*
3. *docker run -it --rm -p 8080:8080 flight-api*

It will launch your container, to test it  you will need to discovery the container IP and then just access it via browser in the port 8080.

The command *docker-machine ip* will return your IP and then you can access the API via browser:

(supposing that the container IP is 192.168.99.100)

http://192.168.99.100:8080/api/flights/from/DUB/to/DEL/datefrom/20151007/dateto/20151020/quantity/2


###Via maven ###
To start the application via maven, you just have to execute the command: 

*mvn spring-boot:run*

and then you could access the API via: 

http://127.0.0.1:8080/api/flights/from/DUB/to/DEL/datefrom/20151007/dateto/20151020/quantity/2

To execute the test, you have to execute: 

*mvn test*

## Used design Patterns: ##
1. Builder
2. Strategy
3. Singleton
- In a future refactoring I would use the chain of responsibility to build the new Flight Object from the xml.

## Next steps:
1. Create health check, to test all the external dependencies
2. Create a circuit breaker, to handle eventual dependency downtime.
3. Create a docker to perform the build and then use it as a volume to the deploy container.
4. It is necessary to improve the API security.
5. Improving the DAO tests