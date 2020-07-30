package com.marqusm.pollservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class PollLocation {
  private String name;
  private String address;
  private String countryCode;
  private String locationId;
}
