package com.marqusm.pollservice;

import org.junit.ClassRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;

@AutoConfigureMockMvc
@SpringBootTest
public abstract class BaseIntegrationTest {

  @ClassRule public static MongoDBContainer testContainer = MongodbContainer.getInstance();

  @Autowired protected MockMvc mockMvc;
}
