package com.marqusm.pollservice.controller;

import com.marqusm.pollservice.model.dto.Poll;
import com.marqusm.pollservice.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/polls")
@RestController
public class PollController {

  private final PollService pollService;

  @GetMapping
  public List<Poll> getPolls(
      @RequestParam(name = "initiator_email", required = false) String initiatorEmail,
      @RequestParam(name = "title", required = false) String title,
      @RequestParam(name = "created_from", required = false) Long createdFrom) {
    return pollService.getPolls(initiatorEmail, title, createdFrom);
  }
}
