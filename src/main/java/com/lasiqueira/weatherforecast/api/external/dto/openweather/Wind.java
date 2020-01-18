
package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speed",
    "deg"
})
public class Wind {

    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private Double deg;

    public Wind() {
    }

    public Double getSpeed() {
        return this.speed;
    }

    public Double getDeg() {
        return this.deg;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Wind)) return false;
        final Wind other = (Wind) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$speed = this.getSpeed();
        final Object other$speed = other.getSpeed();
        if (this$speed == null ? other$speed != null : !this$speed.equals(other$speed)) return false;
        final Object this$deg = this.getDeg();
        final Object other$deg = other.getDeg();
        if (this$deg == null ? other$deg != null : !this$deg.equals(other$deg)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Wind;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $speed = this.getSpeed();
        result = result * PRIME + ($speed == null ? 43 : $speed.hashCode());
        final Object $deg = this.getDeg();
        result = result * PRIME + ($deg == null ? 43 : $deg.hashCode());
        return result;
    }

    public String toString() {
        return "Wind(speed=" + this.getSpeed() + ", deg=" + this.getDeg() + ")";
    }
}
