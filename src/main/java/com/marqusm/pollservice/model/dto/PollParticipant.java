package com.marqusm.pollservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class PollParticipant {
  private Long id;
  private String name;
  private List<Integer> preferences;
}
