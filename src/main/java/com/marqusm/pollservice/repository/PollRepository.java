package com.marqusm.pollservice.repository;

import com.marqusm.pollservice.model.dto.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollRepository extends MongoRepository<Poll, String> {}
