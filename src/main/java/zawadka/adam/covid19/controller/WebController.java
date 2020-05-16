package zawadka.adam.covid19.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import zawadka.adam.covid19.dto.CovidByCountryMapper;
import zawadka.adam.covid19.dto.CovidTotalMapper;
import zawadka.adam.covid19.service.DataRequest;

@Controller
public class WebController {

    CovidTotalMapper covidTotalMapper = new CovidTotalMapper();
    CovidByCountryMapper covidByCountryMapper = new CovidByCountryMapper();

    @GetMapping("/www/total/")
    public String home(ModelMap map) throws JsonProcessingException {

        map.put("total",covidTotalMapper.covidTotalDto().covid);
        return "home";
    }
    @GetMapping("/www/list/")
    public String list(ModelMap map) throws JsonProcessingException {

        map.put("list",covidByCountryMapper.covidByCountryDto().covidByCountry);
        return "list";
    }

}
