package com.lasiqueira.weatherforecast.api.external.converter;

import com.lasiqueira.weatherforecast.api.external.dto.ExternalAPIDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecast;

public interface ExternalAPIModelConverter {

    public WeatherForecast convert(ExternalAPIDTO externalAPIDTO);


}
