package zawadka.adam.covid19.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zawadka.adam.covid19.dto.CovidByCountryDto;
import zawadka.adam.covid19.dto.CovidByCountryMapper;
import zawadka.adam.covid19.dto.CovidTotalDto;
import zawadka.adam.covid19.dto.CovidTotalMapper;
import zawadka.adam.covid19.model.Activity;
import zawadka.adam.covid19.repository.ActivityRepository;
import zawadka.adam.covid19.service.DataService;

@RestController
public class ApiController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    CovidTotalMapper covidTotalMapper;
    @Autowired
    CovidByCountryMapper covidByCountryMapper;

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping("/api/list")
    public CovidByCountryDto byCountry() throws JsonProcessingException {

        activityRepository.save(new Activity("/api/list"));
        return covidByCountryMapper.covidByCountryDto();

    }
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping("/api/total")
    public CovidTotalDto total() throws JsonProcessingException {

        activityRepository.save(new Activity("/api/total"));
        return covidTotalMapper.covidTotalDto();
    }
}
