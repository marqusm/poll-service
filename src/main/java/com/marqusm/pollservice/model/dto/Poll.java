package com.marqusm.pollservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
@Document(collection = "polls")
public class Poll {
  @Id private String id;
  private String adminKey;
  private Long latestChange;
  private Long initiated;
  private Integer participantsCount;
  private Integer inviteesCount;
  private String type;
  private Integer rowConstraint;
  private Boolean timeZone;
  private String hidden;
  private Integer columnConstraint;
  private String preferencesType;
  private String state;
  private String locale;
  @TextIndexed private String title;
  private PollLocation location;
  private String description;
  private PollInitiator initiator;
  private List<Map<String, Object>> options;
  private String optionsHash;
  private List<PollParticipant> participants;
  private List<Map<String, Object>> invitees;
  private Boolean multiDay;
  private Boolean dateText;
  private String device;
  private String levels;
}
