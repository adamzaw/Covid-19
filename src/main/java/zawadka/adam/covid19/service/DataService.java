package zawadka.adam.covid19.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zawadka.adam.covid19.model.*;
import zawadka.adam.covid19.repository.ActivityRepository;


import java.util.List;


@Service
public class DataService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<CovidByCountry> getDataByCountry() throws JsonProcessingException {

        String url = "https://covid2019-api.herokuapp.com/v2/current";
        RestTemplate restTemplate = new RestTemplate();
        String jsonStr = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        activityRepository.save(new Activity(url));
        return mapper.readValue(jsonStr, ListByCountry.class).getCovidList();
    }

    public Covid getTotal() throws JsonProcessingException {
        String url = "https://covid2019-api.herokuapp.com/v2/total";
        RestTemplate restTemplate = new RestTemplate();
        String jsonStr = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        activityRepository.save(new Activity(url));
        return mapper.readValue(jsonStr, Total.class).getCovid();
    }
}
