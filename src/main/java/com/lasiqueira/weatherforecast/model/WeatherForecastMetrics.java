package com.lasiqueira.weatherforecast.model;

import java.math.BigDecimal;

public class WeatherForecastMetrics {
    private final BigDecimal averageTemperatureDay;
    private final BigDecimal averageTemperatureNight;
    private final BigDecimal averagePressure;

    public WeatherForecastMetrics(BigDecimal averageTemperatureDay, BigDecimal averageTemperatureNight, BigDecimal averagePressure) {
        this.averageTemperatureDay = averageTemperatureDay;
        this.averageTemperatureNight = averageTemperatureNight;
        this.averagePressure = averagePressure;
    }

    public static WeatherForecastMetricsBuilder builder() {
        return new WeatherForecastMetricsBuilder();
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

    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof WeatherForecastMetrics)) return false;
        final WeatherForecastMetrics other = (WeatherForecastMetrics) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$averageTemperatureDay = this.averageTemperatureDay;
        final java.lang.Object other$averageTemperatureDay = other.averageTemperatureDay;
        if (this$averageTemperatureDay == null ? other$averageTemperatureDay != null : !this$averageTemperatureDay.equals(other$averageTemperatureDay))
            return false;
        final java.lang.Object this$averageTemperatureNight = this.averageTemperatureNight;
        final java.lang.Object other$averageTemperatureNight = other.averageTemperatureNight;
        if (this$averageTemperatureNight == null ? other$averageTemperatureNight != null : !this$averageTemperatureNight.equals(other$averageTemperatureNight))
            return false;
        final java.lang.Object this$averagePressure = this.averagePressure;
        final java.lang.Object other$averagePressure = other.averagePressure;
        if (this$averagePressure == null ? other$averagePressure != null : !this$averagePressure.equals(other$averagePressure))
            return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof WeatherForecastMetrics;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $averageTemperatureDay = this.averageTemperatureDay;
        result = result * PRIME + ($averageTemperatureDay == null ? 43 : $averageTemperatureDay.hashCode());
        final java.lang.Object $averageTemperatureNight = this.averageTemperatureNight;
        result = result * PRIME + ($averageTemperatureNight == null ? 43 : $averageTemperatureNight.hashCode());
        final java.lang.Object $averagePressure = this.averagePressure;
        result = result * PRIME + ($averagePressure == null ? 43 : $averagePressure.hashCode());
        return result;
    }

    public java.lang.String toString() {
        return "WeatherForecastMetrics(averageTemperatureDay=" + this.averageTemperatureDay + ", averageTemperatureNight=" + this.averageTemperatureNight + ", averagePressure=" + this.averagePressure + ")";
    }

    public static class WeatherForecastMetricsBuilder {
        private BigDecimal averageTemperatureDay;
        private BigDecimal averageTemperatureNight;
        private BigDecimal averagePressure;

        WeatherForecastMetricsBuilder() {
        }

        public WeatherForecastMetrics.WeatherForecastMetricsBuilder averageTemperatureDay(BigDecimal averageTemperatureDay) {
            this.averageTemperatureDay = averageTemperatureDay;
            return this;
        }

        public WeatherForecastMetrics.WeatherForecastMetricsBuilder averageTemperatureNight(BigDecimal averageTemperatureNight) {
            this.averageTemperatureNight = averageTemperatureNight;
            return this;
        }

        public WeatherForecastMetrics.WeatherForecastMetricsBuilder averagePressure(BigDecimal averagePressure) {
            this.averagePressure = averagePressure;
            return this;
        }

        public WeatherForecastMetrics build() {
            return new WeatherForecastMetrics(averageTemperatureDay, averageTemperatureNight, averagePressure);
        }

        public java.lang.String toString() {
            return "WeatherForecastMetrics.WeatherForecastMetricsBuilder(averageTemperatureDay=" + this.averageTemperatureDay + ", averageTemperatureNight=" + this.averageTemperatureNight + ", averagePressure=" + this.averagePressure + ")";
        }
    }
}
