
package com.lasiqueira.weatherforecast.api.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "country",
    "coord"
})
public class CityDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("coord")
    private Coord coord;

    public CityDTO() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CityDTO)) return false;
        final var other = (CityDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$id = this.id;
        final java.lang.Object other$id = other.id;
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final java.lang.Object this$name = this.name;
        final java.lang.Object other$name = other.name;
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$country = this.country;
        final java.lang.Object other$country = other.country;
        if (this$country == null ? other$country != null : !this$country.equals(other$country)) return false;
        final java.lang.Object this$coord = this.coord;
        final java.lang.Object other$coord = other.coord;
        if (this$coord == null ? other$coord != null : !this$coord.equals(other$coord)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CityDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $id = this.id;
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final java.lang.Object $name = this.name;
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $country = this.country;
        result = result * PRIME + ($country == null ? 43 : $country.hashCode());
        final java.lang.Object $coord = this.coord;
        result = result * PRIME + ($coord == null ? 43 : $coord.hashCode());
        return result;
    }

    public java.lang.String toString() {
        return "CityDTO(id=" + this.id + ", name=" + this.name + ", country=" + this.country + ", coord=" + this.coord + ")";
    }
}
