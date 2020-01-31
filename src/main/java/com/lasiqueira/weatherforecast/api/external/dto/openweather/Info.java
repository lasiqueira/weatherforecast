
package com.lasiqueira.weatherforecast.api.external.dto.openweather;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "main",
    "weather",
    "clouds",
    "wind",
    "rain",
    "snow",
    "sys",
    "dt_txt"
})
public class Info {

    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private List<Weather> weather = null;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("rain")
    private Rain rain;
    @JsonProperty("snow")
    private Snow snow;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("dt_txt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtTxt;

    public Info() {
    }

    public Integer getDt() {
        return this.dt;
    }

    public Main getMain() {
        return this.main;
    }

    public List<Weather> getWeather() {
        return this.weather;
    }

    public Clouds getClouds() {
        return this.clouds;
    }

    public Wind getWind() {
        return this.wind;
    }

    public Rain getRain() {
        return this.rain;
    }

    public Snow getSnow() {
        return this.snow;
    }

    public Sys getSys() {
        return this.sys;
    }

    public LocalDateTime getDtTxt() {
        return this.dtTxt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setDtTxt(LocalDateTime dtTxt) {
        this.dtTxt = dtTxt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Info)) return false;
        final var other = (Info) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$dt = this.getDt();
        final Object other$dt = other.getDt();
        if (this$dt == null ? other$dt != null : !this$dt.equals(other$dt)) return false;
        final Object this$main = this.getMain();
        final Object other$main = other.getMain();
        if (this$main == null ? other$main != null : !this$main.equals(other$main)) return false;
        final Object this$weather = this.getWeather();
        final Object other$weather = other.getWeather();
        if (this$weather == null ? other$weather != null : !this$weather.equals(other$weather)) return false;
        final Object this$clouds = this.getClouds();
        final Object other$clouds = other.getClouds();
        if (this$clouds == null ? other$clouds != null : !this$clouds.equals(other$clouds)) return false;
        final Object this$wind = this.getWind();
        final Object other$wind = other.getWind();
        if (this$wind == null ? other$wind != null : !this$wind.equals(other$wind)) return false;
        final Object this$rain = this.getRain();
        final Object other$rain = other.getRain();
        if (this$rain == null ? other$rain != null : !this$rain.equals(other$rain)) return false;
        final Object this$snow = this.getSnow();
        final Object other$snow = other.getSnow();
        if (this$snow == null ? other$snow != null : !this$snow.equals(other$snow)) return false;
        final Object this$sys = this.getSys();
        final Object other$sys = other.getSys();
        if (this$sys == null ? other$sys != null : !this$sys.equals(other$sys)) return false;
        final Object this$dtTxt = this.getDtTxt();
        final Object other$dtTxt = other.getDtTxt();
        if (this$dtTxt == null ? other$dtTxt != null : !this$dtTxt.equals(other$dtTxt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Info;
    }

    public int hashCode() {
        final var PRIME = 59;
        int result = 1;
        final Object $dt = this.getDt();
        result = result * PRIME + ($dt == null ? 43 : $dt.hashCode());
        final Object $main = this.getMain();
        result = result * PRIME + ($main == null ? 43 : $main.hashCode());
        final Object $weather = this.getWeather();
        result = result * PRIME + ($weather == null ? 43 : $weather.hashCode());
        final Object $clouds = this.getClouds();
        result = result * PRIME + ($clouds == null ? 43 : $clouds.hashCode());
        final Object $wind = this.getWind();
        result = result * PRIME + ($wind == null ? 43 : $wind.hashCode());
        final Object $rain = this.getRain();
        result = result * PRIME + ($rain == null ? 43 : $rain.hashCode());
        final Object $snow = this.getSnow();
        result = result * PRIME + ($snow == null ? 43 : $snow.hashCode());
        final Object $sys = this.getSys();
        result = result * PRIME + ($sys == null ? 43 : $sys.hashCode());
        final Object $dtTxt = this.getDtTxt();
        result = result * PRIME + ($dtTxt == null ? 43 : $dtTxt.hashCode());
        return result;
    }

    public String toString() {
        return "Info(dt=" + this.getDt() + ", main=" + this.getMain() + ", weather=" + this.getWeather() + ", clouds=" + this.getClouds() + ", wind=" + this.getWind() + ", rain=" + this.getRain() + ", snow=" + this.getSnow() + ", sys=" + this.getSys() + ", dtTxt=" + this.getDtTxt() + ")";
    }
}
