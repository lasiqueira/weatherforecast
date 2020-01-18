package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "3h"
})
public class Snow {
    @JsonProperty("3h")
    private Double val;

    public Snow() {
    }

    public Double getVal() {
        return this.val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Snow)) return false;
        final Snow other = (Snow) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$val = this.getVal();
        final Object other$val = other.getVal();
        if (this$val == null ? other$val != null : !this$val.equals(other$val)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Snow;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $val = this.getVal();
        result = result * PRIME + ($val == null ? 43 : $val.hashCode());
        return result;
    }

    public String toString() {
        return "Snow(val=" + this.getVal() + ")";
    }
}
