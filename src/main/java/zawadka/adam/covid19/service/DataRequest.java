package zawadka.adam.covid19.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import zawadka.adam.covid19.model.Covid;
import zawadka.adam.covid19.model.CovidByCountry;
import zawadka.adam.covid19.model.ListByCountry;
import zawadka.adam.covid19.model.Total;

import java.util.List;

public class DataRequest {

    public static List<CovidByCountry> getDataByCoutry() throws JsonProcessingException {
        List<CovidByCountry> covidsList;

        RestTemplate restTemplate = new RestTemplate();
        String jsonStr = restTemplate.getForObject("https://covid2019-api.herokuapp.com/v2/current", String.class);

        ObjectMapper mapper = new ObjectMapper();
        covidsList = mapper.readValue(jsonStr, ListByCountry.class).getCovidList();

        return covidsList;
    }

    public static Covid getTotal() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String jsonStr = restTemplate.getForObject("https://covid2019-api.herokuapp.com/v2/total", String.class);

        ObjectMapper mapper = new ObjectMapper();
        Covid result = mapper.readValue(jsonStr, Total.class).getCovid();

        return result;
    }
}
