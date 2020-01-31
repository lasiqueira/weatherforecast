
package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lon"
})
public class Coord {

    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;

    public Coord() {
    }

    public Double getLat() {
        return this.lat;
    }

    public Double getLon() {
        return this.lon;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Coord)) return false;
        final var other = (Coord) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$lat = this.getLat();
        final Object other$lat = other.getLat();
        if (this$lat == null ? other$lat != null : !this$lat.equals(other$lat)) return false;
        final Object this$lon = this.getLon();
        final Object other$lon = other.getLon();
        if (this$lon == null ? other$lon != null : !this$lon.equals(other$lon)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Coord;
    }

    public int hashCode() {
        final var PRIME = 59;
        int result = 1;
        final Object $lat = this.getLat();
        result = result * PRIME + ($lat == null ? 43 : $lat.hashCode());
        final Object $lon = this.getLon();
        result = result * PRIME + ($lon == null ? 43 : $lon.hashCode());
        return result;
    }

    public String toString() {
        return "Coord(lat=" + this.getLat() + ", lon=" + this.getLon() + ")";
    }
}
