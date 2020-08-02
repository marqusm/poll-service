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


## Notes
Here, we have some points that might improve in the future:
- Return value on reading should be in batches (with pagination), not complete response.
It can happen the response is very large.
- We should have separated db model from dto model.
- Validation can be performed using some framework or with custom dedicated functions, for better readability and usability.
- Nice to have: Introduce 422 status for understandable but not processable requests.
- Database should have user/pass