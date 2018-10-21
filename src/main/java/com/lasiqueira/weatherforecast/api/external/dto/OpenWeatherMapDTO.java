
package com.lasiqueira.weatherforecast.api.external.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cod",
    "message",
    "cnt",
    "list",
    "city"
})
@Data
public class OpenWeatherMapDTO {

    @JsonProperty("cod")
    public String cod;
    @JsonProperty("message")
    public Double message;
    @JsonProperty("cnt")
    public Integer cnt;
    @JsonProperty("list")
    public List<InfoList> infoList = null;
    @JsonProperty("city")
    public City city;

}
