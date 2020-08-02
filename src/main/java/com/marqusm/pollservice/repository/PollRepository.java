package com.marqusm.pollservice.repository;

import com.marqusm.pollservice.model.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollRepository extends MongoRepository<Poll, String> {}
