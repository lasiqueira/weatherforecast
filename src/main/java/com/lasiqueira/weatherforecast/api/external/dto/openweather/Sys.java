
package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pod"
})
public class Sys {

    @JsonProperty("pod")
    private String pod;

    public Sys() {
    }

    public String getPod() {
        return this.pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Sys)) return false;
        final var other = (Sys) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$pod = this.getPod();
        final Object other$pod = other.getPod();
        if (this$pod == null ? other$pod != null : !this$pod.equals(other$pod)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Sys;
    }

    public int hashCode() {
        final var PRIME = 59;
        int result = 1;
        final Object $pod = this.getPod();
        result = result * PRIME + ($pod == null ? 43 : $pod.hashCode());
        return result;
    }

    public String toString() {
        return "Sys(pod=" + this.getPod() + ")";
    }
}
