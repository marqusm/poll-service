# poll-service


## Build and run
To build the service, please run:
`./gradlew clean build`

To create docker image, run:
`docker build -t poll-service .`

To start the complete service using docker-compose, run:
docker-compose up

Note: To avoid dockers and just run the service, please run:
`java -jar build/libs/poll-service.jar`


## About the implementation
Spring Boot is chosen because of simplicity and speed of implementation.
Since this framework includes all necessary thing to start a service, it's a very good tool for fast development.

Mongo is a database engine.
That's because there is no relation in the data.
Also, data is only somewhat structured. Many sub-objects have different forms.
Also, I am expecting that this data exists in very large numbers. Mongo has native sharding.
All these facts, makes Mongo a very good choice.


### API
Since there is only reading of polls, there is only one endpoint:
`/polls`.
However, it contains 3 query parameters: `initiator_email`, `title` and `created_from`.

For example, after running the service, local URL might look like this:
`http://localhost:8080/polls?initiator_email=mh+sample@doodle.com` or
`http://localhost:8080/polls?title=super` or
`http://localhost:8080/polls?created_from=1485210475083`.

Also, the combination of these params is possible.

### Things to improve:
- Return value on reading should be in batches (with pagination), not complete response.
It can happen the response is very large.
- We should have separated db model from dto model.
- Validation can be performed using some framework or with custom dedicated functions, for better readability and usability.
- Nice to have: Introduce 422 status for understandable but not processable requests.
- Database should have user/pass


### The following steps would be:
- Security. We need to define roles and permissions for users.
We need API security as well (JWT and CSRF tokens for eg.).
- Requests caching to achieve better performance.
- Avoid manual build process. Do everything using Docker Compose.
