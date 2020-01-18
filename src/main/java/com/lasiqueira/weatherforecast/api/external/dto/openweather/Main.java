
package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

    public Main() {
    }

    public Double getTemp() {
        return this.temp;
    }

    public Double getTempMin() {
        return this.tempMin;
    }

    public Double getTempMax() {
        return this.tempMax;
    }

    public Double getPressure() {
        return this.pressure;
    }

    public Double getSeaLevel() {
        return this.seaLevel;
    }

    public Double getGrndLevel() {
        return this.grndLevel;
    }

    public Integer getHumidity() {
        return this.humidity;
    }

    public Integer getTempKf() {
        return this.tempKf;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setTempKf(Integer tempKf) {
        this.tempKf = tempKf;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Main)) return false;
        final Main other = (Main) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$temp = this.getTemp();
        final Object other$temp = other.getTemp();
        if (this$temp == null ? other$temp != null : !this$temp.equals(other$temp)) return false;
        final Object this$tempMin = this.getTempMin();
        final Object other$tempMin = other.getTempMin();
        if (this$tempMin == null ? other$tempMin != null : !this$tempMin.equals(other$tempMin)) return false;
        final Object this$tempMax = this.getTempMax();
        final Object other$tempMax = other.getTempMax();
        if (this$tempMax == null ? other$tempMax != null : !this$tempMax.equals(other$tempMax)) return false;
        final Object this$pressure = this.getPressure();
        final Object other$pressure = other.getPressure();
        if (this$pressure == null ? other$pressure != null : !this$pressure.equals(other$pressure)) return false;
        final Object this$seaLevel = this.getSeaLevel();
        final Object other$seaLevel = other.getSeaLevel();
        if (this$seaLevel == null ? other$seaLevel != null : !this$seaLevel.equals(other$seaLevel)) return false;
        final Object this$grndLevel = this.getGrndLevel();
        final Object other$grndLevel = other.getGrndLevel();
        if (this$grndLevel == null ? other$grndLevel != null : !this$grndLevel.equals(other$grndLevel)) return false;
        final Object this$humidity = this.getHumidity();
        final Object other$humidity = other.getHumidity();
        if (this$humidity == null ? other$humidity != null : !this$humidity.equals(other$humidity)) return false;
        final Object this$tempKf = this.getTempKf();
        final Object other$tempKf = other.getTempKf();
        if (this$tempKf == null ? other$tempKf != null : !this$tempKf.equals(other$tempKf)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Main;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $temp = this.getTemp();
        result = result * PRIME + ($temp == null ? 43 : $temp.hashCode());
        final Object $tempMin = this.getTempMin();
        result = result * PRIME + ($tempMin == null ? 43 : $tempMin.hashCode());
        final Object $tempMax = this.getTempMax();
        result = result * PRIME + ($tempMax == null ? 43 : $tempMax.hashCode());
        final Object $pressure = this.getPressure();
        result = result * PRIME + ($pressure == null ? 43 : $pressure.hashCode());
        final Object $seaLevel = this.getSeaLevel();
        result = result * PRIME + ($seaLevel == null ? 43 : $seaLevel.hashCode());
        final Object $grndLevel = this.getGrndLevel();
        result = result * PRIME + ($grndLevel == null ? 43 : $grndLevel.hashCode());
        final Object $humidity = this.getHumidity();
        result = result * PRIME + ($humidity == null ? 43 : $humidity.hashCode());
        final Object $tempKf = this.getTempKf();
        result = result * PRIME + ($tempKf == null ? 43 : $tempKf.hashCode());
        return result;
    }

    public String toString() {
        return "Main(temp=" + this.getTemp() + ", tempMin=" + this.getTempMin() + ", tempMax=" + this.getTempMax() + ", pressure=" + this.getPressure() + ", seaLevel=" + this.getSeaLevel() + ", grndLevel=" + this.getGrndLevel() + ", humidity=" + this.getHumidity() + ", tempKf=" + this.getTempKf() + ")";
    }
}
