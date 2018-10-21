
package com.lasiqueira.weatherforecast.api.external.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "temp_min",
    "temp_max",
    "pressure",
    "sea_level",
    "grnd_level",
    "humidity",
    "temp_kf"
})
@Data
public class Main {

    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("sea_level")
    private Double seaLevel;
    @JsonProperty("grnd_level")
    private Double grndLevel;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("temp_kf")
    private Integer tempKf;

}
