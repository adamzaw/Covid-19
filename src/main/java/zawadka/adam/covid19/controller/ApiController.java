package zawadka.adam.covid19.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zawadka.adam.covid19.dto.CovidByCountryDto;
import zawadka.adam.covid19.dto.CovidByCountryMapper;
import zawadka.adam.covid19.dto.CovidTotalDto;
import zawadka.adam.covid19.dto.CovidTotalMapper;
import zawadka.adam.covid19.model.Activity;
import zawadka.adam.covid19.repository.ActivityRepository;


@Tag(name = "API", description = "API Statistics of Covid19")
@RestController
public class ApiController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    CovidTotalMapper covidTotalMapper;
    @Autowired
    CovidByCountryMapper covidByCountryMapper;

    @Operation(summary = "Covid19 statistic of each country ", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/api/list")
    public CovidByCountryDto byCountry() throws JsonProcessingException {

        activityRepository.save(new Activity("/api/list"));
        return covidByCountryMapper.covidByCountryDto();

    }
    @Operation(summary = "Covid19 statistics global", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/api/total")
    public CovidTotalDto total() throws JsonProcessingException {

        activityRepository.save(new Activity("/api/total"));
        return covidTotalMapper.covidTotalDto();
    }
}
