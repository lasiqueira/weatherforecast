package com.lasiqueira.weatherforecast.api.external.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ExternalAPIDTO {
    public BigDecimal getTemperature();
    public BigDecimal getPressure();
    public LocalDateTime getTimeStamp();
}
