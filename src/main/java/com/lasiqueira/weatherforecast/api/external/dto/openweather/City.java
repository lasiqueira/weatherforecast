
package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "coord",
    "country",
    "population"
})
public class City {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("country")
    private String country;
    @JsonProperty("population")
    private Integer population;

    public City() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public String getCountry() {
        return this.country;
    }

    public Integer getPopulation() {
        return this.population;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof City)) return false;
        final City other = (City) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$coord = this.getCoord();
        final Object other$coord = other.getCoord();
        if (this$coord == null ? other$coord != null : !this$coord.equals(other$coord)) return false;
        final Object this$country = this.getCountry();
        final Object other$country = other.getCountry();
        if (this$country == null ? other$country != null : !this$country.equals(other$country)) return false;
        final Object this$population = this.getPopulation();
        final Object other$population = other.getPopulation();
        if (this$population == null ? other$population != null : !this$population.equals(other$population))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof City;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $coord = this.getCoord();
        result = result * PRIME + ($coord == null ? 43 : $coord.hashCode());
        final Object $country = this.getCountry();
        result = result * PRIME + ($country == null ? 43 : $country.hashCode());
        final Object $population = this.getPopulation();
        result = result * PRIME + ($population == null ? 43 : $population.hashCode());
        return result;
    }

    public String toString() {
        return "City(id=" + this.getId() + ", name=" + this.getName() + ", coord=" + this.getCoord() + ", country=" + this.getCountry() + ", population=" + this.getPopulation() + ")";
    }
}
