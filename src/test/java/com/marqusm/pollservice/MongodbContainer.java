package com.marqusm.pollservice;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.MongoDBContainer;

@Slf4j
public class MongodbContainer extends MongoDBContainer {
  private static final String IMAGE_VERSION = "mongo:4.2-bionic";
  private static MongoDBContainer container;

  private MongodbContainer() {
    super(IMAGE_VERSION);
  }

  public static MongoDBContainer getInstance() {
    if (container == null) {
      container = new MongodbContainer();
      //              .withEnv(
      //                  Map.of(
      //                      "MONGO_INITDB_ROOT_USERNAME", "root", "MONGO_INITDB_ROOT_PASSWORD",
      // "root"));
      container.start();
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("spring.data.mongodb.port", container.getMappedPort(27017).toString());
    log.info("MongoDB container started");
  }

  @Override
  public void stop() {
    // do nothing, JVM handles shut down
  }
}
