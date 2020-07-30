package com.marqusm.pollservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class PollInitiator {
  private String name;
  private String email;
  private Boolean notify;
  private String timeZone;
}
