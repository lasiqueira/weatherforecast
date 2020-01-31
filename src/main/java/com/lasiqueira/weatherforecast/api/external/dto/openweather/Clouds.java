
package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all"
})
public class Clouds {

    @JsonProperty("all")
    private Integer all;

    public Clouds() {
    }

    public Integer getAll() {
        return this.all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Clouds)) return false;
        final var other = (Clouds) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$all = this.getAll();
        final Object other$all = other.getAll();
        if (this$all == null ? other$all != null : !this$all.equals(other$all)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Clouds;
    }

    public int hashCode() {
        final var PRIME = 59;
        int result = 1;
        final Object $all = this.getAll();
        result = result * PRIME + ($all == null ? 43 : $all.hashCode());
        return result;
    }

    public String toString() {
        return "Clouds(all=" + this.getAll() + ")";
    }
}
