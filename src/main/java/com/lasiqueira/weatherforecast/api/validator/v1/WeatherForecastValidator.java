package com.lasiqueira.weatherforecast.api.validator.v1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lasiqueira.weatherforecast.api.dto.v1.CityDTO;
import com.lasiqueira.weatherforecast.api.exception.v1.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class WeatherForecastValidator {
    private final Logger logger;
    private final Map<String, Integer> cityMap;

    public WeatherForecastValidator() throws URISyntaxException, IOException {
        this.logger = LoggerFactory.getLogger(WeatherForecastValidator.class);
        this.cityMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        Path path = Paths.get(getClass().getClassLoader().getResource("json/city.list.json").toURI());
        List<CityDTO> cityDTOList = objectMapper.readValue(Files.readAllBytes(path), new TypeReference<List<CityDTO>>() {});
        for(CityDTO cityDTO: cityDTOList){
            cityMap.put((cityDTO.getName()+cityDTO.getCountry()).toLowerCase(), cityDTO.getId());
        }
    }

    public Integer validateCityAndCountry(String city, String countryCode) throws InvalidDataException{
        logger.debug("Validating city: {} and country {}", city, countryCode);
        String key = (city+countryCode).toLowerCase();
        if(cityMap.containsKey(key)){
            return cityMap.get(key);
        } else{
            throw new InvalidDataException("Data not supported.");
        }
    }


}
