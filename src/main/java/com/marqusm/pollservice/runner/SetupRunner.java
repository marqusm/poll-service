package com.marqusm.pollservice.runner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marqusm.pollservice.model.Poll;
import com.marqusm.pollservice.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class SetupRunner implements ApplicationRunner {

  private final PollRepository pollRepository;
  private final ObjectMapper objectMapper;

  @Transactional
  public void run(ApplicationArguments args) throws IOException {
    log.info("Setup Runner started");

    if (pollRepository.count() == 0) {
      val polls = readResourceData();
      pollRepository.saveAll(polls);
    }

    log.info("Setup Runner finished");
  }

  private List<Poll> readResourceData() throws IOException {
    val inputStream = new ClassPathResource("polls.json").getInputStream();
    return objectMapper.readValue(inputStream, new TypeReference<>() {
    });
  }
}
