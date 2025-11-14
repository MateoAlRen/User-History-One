package com.HistoryUserOne.UserHistory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private static int counter = 0;
    private int eventId;
    private LocalDateTime date;
    @NotBlank(message = "You need to fill al the params")
    @NotNull(message = "You need to fill al the params")
    private String eventName;
    @NotBlank(message = "You need to fill al the params")
    @NotNull(message = "You need to fill al the params")
    private String eventDescription;

}
