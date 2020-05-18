package zawadka.adam.covid19.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.SpringDocUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import zawadka.adam.covid19.dto.CovidByCountryMapper;
import zawadka.adam.covid19.dto.CovidTotalMapper;
import zawadka.adam.covid19.model.Activity;
import zawadka.adam.covid19.repository.ActivityRepository;


@Tag(name = "Webservice", description = "Website with Covid-19 Statistics")
@Controller
public class WebController {
    static {
        SpringDocUtils.getConfig().addRestControllers(WebController.class);
    }

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    CovidTotalMapper covidTotalMapper;
    @Autowired
    CovidByCountryMapper covidByCountryMapper;

    @Operation(summary = "Show statistics of whole world")
    @GetMapping("/www/total")
    public String home(ModelMap map) throws JsonProcessingException {

        activityRepository.save(new Activity("/www/total"));
        map.put("total",covidTotalMapper.covidTotalDto().covid);
        return "home";
    }
    @Operation(summary = "Show statistics of each country")
    @GetMapping("/www/list")
    public String list(ModelMap map) throws JsonProcessingException {

        activityRepository.save(new Activity("/www/list"));
        map.put("list",covidByCountryMapper.covidByCountryDto().covidByCountry);
        return "list";
    }

}
