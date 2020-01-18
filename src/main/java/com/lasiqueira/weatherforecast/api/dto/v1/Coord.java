
package com.lasiqueira.weatherforecast.api.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lon",
    "lat"
})
public class Coord {

    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("lat")
    private Double lat;

    public Coord() {
    }

    public Double getLon() {
        return this.lon;
    }

    public Double getLat() {
        return this.lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof Coord)) return false;
        final Coord other = (Coord) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$lon = this.lon;
        final java.lang.Object other$lon = other.lon;
        if (this$lon == null ? other$lon != null : !this$lon.equals(other$lon)) return false;
        final java.lang.Object this$lat = this.lat;
        final java.lang.Object other$lat = other.lat;
        if (this$lat == null ? other$lat != null : !this$lat.equals(other$lat)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Coord;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $lon = this.lon;
        result = result * PRIME + ($lon == null ? 43 : $lon.hashCode());
        final java.lang.Object $lat = this.lat;
        result = result * PRIME + ($lat == null ? 43 : $lat.hashCode());
        return result;
    }

    public java.lang.String toString() {
        return "Coord(lon=" + this.lon + ", lat=" + this.lat + ")";
    }
}
