package com.HistoryUserOne.UserHistory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VenueDTO {

    private int venueId;
    @NotBlank(message = "You need to fill al the params")
    @NotNull(message = "You need to fill al the params")
    private String venueName;
    @NotBlank(message = "You need to fill al the params")
    @NotNull(message = "You need to fill al the params")
    private String venueAddress;
    private String venueDescription;


    public VenueDTO(Integer venueId, String venueName) {
        this.venueId = venueId;
        this.venueName = venueName;
    }

}
