
package com.lasiqueira.weatherforecast.api.external.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lon"
})
@Data
public class Coord {

    @JsonProperty("lat")
    public Double lat;
    @JsonProperty("lon")
    public Double lon;

}
