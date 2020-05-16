package zawadka.adam.covid19.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zawadka.adam.covid19.dto.CovidByCountryDto;
import zawadka.adam.covid19.dto.CovidByCountryMapper;
import zawadka.adam.covid19.dto.CovidTotalDto;
import zawadka.adam.covid19.dto.CovidTotalMapper;
import zawadka.adam.covid19.service.DataRequest;

@RestController
public class ApiController {

    DataRequest dataRequest = new DataRequest();
    CovidTotalMapper covidTotalMapper = new CovidTotalMapper();
    CovidByCountryMapper covidByCountryMapper = new CovidByCountryMapper();

    @GetMapping("/api/list/")
    public CovidByCountryDto byCountry() throws JsonProcessingException {

        return covidByCountryMapper.covidByCountryDto();

    }

    @GetMapping("/api/total/")
    public CovidTotalDto total() throws JsonProcessingException {

        return covidTotalMapper.covidTotalDto();
    }
}
