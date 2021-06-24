package com.lasiqueira.weatherforecast.api.dto.v1;

import java.math.BigDecimal;
import java.util.Objects;

public class WeatherForecastMetricsDTO {
    private final BigDecimal averageTemperatureDay;
    private final BigDecimal averageTemperatureNight;
    private final BigDecimal averagePressure;

    WeatherForecastMetricsDTO(BigDecimal averageTemperatureDay, BigDecimal averageTemperatureNight, BigDecimal averagePressure) {
        this.averageTemperatureDay = averageTemperatureDay;
        this.averageTemperatureNight = averageTemperatureNight;
        this.averagePressure = averagePressure;
    }

    public static WeatherForecastMetricsDTOBuilder builder() {
        return new WeatherForecastMetricsDTOBuilder();
    }

    public BigDecimal getAverageTemperatureDay() {
        return this.averageTemperatureDay;
    }

    public BigDecimal getAverageTemperatureNight() {
        return this.averageTemperatureNight;
    }

    public BigDecimal getAveragePressure() {
        return this.averagePressure;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WeatherForecastMetricsDTO)) return false;
        final var other = (WeatherForecastMetricsDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$averageTemperatureDay = this.getAverageTemperatureDay();
        final Object other$averageTemperatureDay = other.getAverageTemperatureDay();
        if (!Objects.equals(this$averageTemperatureDay, other$averageTemperatureDay))
            return false;
        final Object this$averageTemperatureNight = this.getAverageTemperatureNight();
        final Object other$averageTemperatureNight = other.getAverageTemperatureNight();
        if (!Objects.equals(this$averageTemperatureNight, other$averageTemperatureNight))
            return false;
        final Object this$averagePressure = this.getAveragePressure();
        final Object other$averagePressure = other.getAveragePressure();
        if (this$averagePressure == null ? other$averagePressure != null : !this$averagePressure.equals(other$averagePressure))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WeatherForecastMetricsDTO;
    }

    public int hashCode() {
        final var PRIME = 59;
        int result = 1;
        final Object $averageTemperatureDay = this.getAverageTemperatureDay();
        result = result * PRIME + ($averageTemperatureDay == null ? 43 : $averageTemperatureDay.hashCode());
        final Object $averageTemperatureNight = this.getAverageTemperatureNight();
        result = result * PRIME + ($averageTemperatureNight == null ? 43 : $averageTemperatureNight.hashCode());
        final Object $averagePressure = this.getAveragePressure();
        result = result * PRIME + ($averagePressure == null ? 43 : $averagePressure.hashCode());
        return result;
    }

    public String toString() {
        return "WeatherForecastMetricsDTO(averageTemperatureDay=" + this.getAverageTemperatureDay() + ", averageTemperatureNight=" + this.getAverageTemperatureNight() + ", averagePressure=" + this.getAveragePressure() + ")";
    }

    public static class WeatherForecastMetricsDTOBuilder {
        private BigDecimal averageTemperatureDay;
        private BigDecimal averageTemperatureNight;
        private BigDecimal averagePressure;

        WeatherForecastMetricsDTOBuilder() {
        }

        public WeatherForecastMetricsDTO.WeatherForecastMetricsDTOBuilder averageTemperatureDay(BigDecimal averageTemperatureDay) {
            this.averageTemperatureDay = averageTemperatureDay;
            return this;
        }

        public WeatherForecastMetricsDTO.WeatherForecastMetricsDTOBuilder averageTemperatureNight(BigDecimal averageTemperatureNight) {
            this.averageTemperatureNight = averageTemperatureNight;
            return this;
        }

        public WeatherForecastMetricsDTO.WeatherForecastMetricsDTOBuilder averagePressure(BigDecimal averagePressure) {
            this.averagePressure = averagePressure;
            return this;
        }

        public WeatherForecastMetricsDTO build() {
            return new WeatherForecastMetricsDTO(averageTemperatureDay, averageTemperatureNight, averagePressure);
        }

        public String toString() {
            return "WeatherForecastMetricsDTO.WeatherForecastMetricsDTOBuilder(averageTemperatureDay=" + this.averageTemperatureDay + ", averageTemperatureNight=" + this.averageTemperatureNight + ", averagePressure=" + this.averagePressure + ")";
        }
    }
}
