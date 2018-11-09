package com.lasiqueira.weatherforecast.api.validator.v1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lasiqueira.weatherforecast.api.dto.v1.CityDTO;
import com.lasiqueira.weatherforecast.api.exception.v1.CityNotFoundException;
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
import java.util.Optional;


@Component
public class WeatherForecastValidator {
    private final Logger logger;
    private final Map<String, CityDTO> cityMap;

    public WeatherForecastValidator() throws URISyntaxException, IOException {
        this.logger = LoggerFactory.getLogger(WeatherForecastValidator.class);
        this.cityMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        Path path = Paths.get(getClass().getClassLoader().getResource("json/city.list.json").toURI());
        List<CityDTO> cityDTOList = objectMapper.readValue(Files.readAllBytes(path), new TypeReference<List<CityDTO>>() {});
        cityDTOList.forEach(cityDTO -> cityMap.put((cityDTO.getName()+cityDTO.getCountry()).toLowerCase(), cityDTO));
    }

    public Integer validateCityAndCountry(String city, Optional<String> countryCode) throws CityNotFoundException {
        logger.debug("Validating city: {} and country {}", city, countryCode.orElse(""));
        String key = "";
        CityDTO cityDTO = null;
        if(countryCode.isPresent()){
            key = (city + countryCode.get()).toLowerCase();
            if(cityMap.containsKey(key)){
                cityDTO = cityMap.get(key);
            }
        } else{
            cityDTO = validateByCityOnly(city);
        }
        if(cityDTO == null){
            throw new CityNotFoundException("City not found.");
        } else {
            return cityDTO.getId();
        }
    }

    private CityDTO validateByCityOnly(String city) throws CityNotFoundException{
        String key = city.toLowerCase();
        if(!key.isEmpty()) {
           return cityMap.values()
                   .stream()
                   .filter(cityDTO1 -> cityDTO1.getName().toLowerCase().equals(key))
                   .findFirst()
                   .orElse(null);
        }
        return null;
    }


}
