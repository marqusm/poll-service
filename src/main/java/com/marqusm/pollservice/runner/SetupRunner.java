package com.marqusm.pollservice.runner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marqusm.pollservice.model.dto.Poll;
import com.marqusm.pollservice.repository.PollRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class SetupRunner implements ApplicationRunner {

  @Autowired PollRepository pollRepository;

  @Transactional
  public void run(ApplicationArguments args) throws IOException {
    log.info("Setup Runner started");

    if (pollRepository.count() == 0) {
      val inputStream = new ClassPathResource("polls.json").getInputStream();
      val objectMapper = new ObjectMapper();
      val initData = objectMapper.readValue(inputStream, new TypeReference<List<Poll>>() {});
      pollRepository.saveAll(initData);
    }

    log.info("Setup Runner finished");
  }
}
