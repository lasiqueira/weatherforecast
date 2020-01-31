
package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cod",
    "message",
    "cnt",
    "list",
    "city"
})
public class OpenWeatherMapDTO {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private Double message;
    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("list")
    private List<Info> info = null;
    @JsonProperty("city")
    private City city;

    public OpenWeatherMapDTO() {
    }

    public String getCod() {
        return this.cod;
    }

    public Double getMessage() {
        return this.message;
    }

    public Integer getCnt() {
        return this.cnt;
    }

    public List<Info> getInfo() {
        return this.info;
    }

    public City getCity() {
        return this.city;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OpenWeatherMapDTO)) return false;
        final var other = (OpenWeatherMapDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$cod = this.getCod();
        final Object other$cod = other.getCod();
        if (this$cod == null ? other$cod != null : !this$cod.equals(other$cod)) return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final Object this$cnt = this.getCnt();
        final Object other$cnt = other.getCnt();
        if (this$cnt == null ? other$cnt != null : !this$cnt.equals(other$cnt)) return false;
        final Object this$info = this.getInfo();
        final Object other$info = other.getInfo();
        if (this$info == null ? other$info != null : !this$info.equals(other$info)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OpenWeatherMapDTO;
    }

    public int hashCode() {
        final var PRIME = 59;
        int result = 1;
        final Object $cod = this.getCod();
        result = result * PRIME + ($cod == null ? 43 : $cod.hashCode());
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final Object $cnt = this.getCnt();
        result = result * PRIME + ($cnt == null ? 43 : $cnt.hashCode());
        final Object $info = this.getInfo();
        result = result * PRIME + ($info == null ? 43 : $info.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        return result;
    }

    public String toString() {
        return "OpenWeatherMapDTO(cod=" + this.getCod() + ", message=" + this.getMessage() + ", cnt=" + this.getCnt() + ", info=" + this.getInfo() + ", city=" + this.getCity() + ")";
    }
}
