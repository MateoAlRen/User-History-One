package com.HistoryUserOne.UserHistory.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue{

    private Integer venueId;
    private String venueName;
    private String venueAddress;
    private String venueDescription;
}
