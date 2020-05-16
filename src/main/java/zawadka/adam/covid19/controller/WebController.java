package zawadka.adam.covid19.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import zawadka.adam.covid19.dto.CovidByCountryMapper;
import zawadka.adam.covid19.dto.CovidTotalMapper;
import zawadka.adam.covid19.model.Activity;
import zawadka.adam.covid19.repository.ActivityRepository;


@Controller
public class WebController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    CovidTotalMapper covidTotalMapper;
    @Autowired
    CovidByCountryMapper covidByCountryMapper;

    @GetMapping("/www/total")
    public String home(ModelMap map) throws JsonProcessingException {

        activityRepository.save(new Activity("/www/total"));
        map.put("total",covidTotalMapper.covidTotalDto().covid);
        return "home";
    }
    @GetMapping("/www/list")
    public String list(ModelMap map) throws JsonProcessingException {

        activityRepository.save(new Activity("/www/list"));
        map.put("list",covidByCountryMapper.covidByCountryDto().covidByCountry);
        return "list";
    }

}
