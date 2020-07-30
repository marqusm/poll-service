package com.marqusm.pollservice.service;

import com.marqusm.pollservice.model.dto.Poll;
import com.marqusm.pollservice.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class PollService {

  private final PollRepository pollRepository;
  private final MongoTemplate mongoTemplate;

  public List<Poll> getPolls(String initiatorEmail, String title, Long createdAfter) {
    Query query = new Query();
    if (initiatorEmail != null) {
      query.addCriteria(Criteria.where("initiator.email").is(initiatorEmail));
    }
    if (title != null) {
      query.addCriteria(Criteria.where("title").regex(String.format("(?i)\\s*%s\\s*", title)));
    }
    if (createdAfter != null) {
      query.addCriteria(Criteria.where("initiated").gte(createdAfter));
    }
    return mongoTemplate.find(query, Poll.class);
  }
}
