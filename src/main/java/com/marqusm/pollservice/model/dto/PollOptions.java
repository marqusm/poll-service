package com.marqusm.pollservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class PollOptions {
  private Long start;
  private Long end;
  private Long startDateTime;
  private Long endDateTime;
  private Boolean available;
}
