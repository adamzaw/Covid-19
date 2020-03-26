package zawadka.adam.covid19.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zawadka.adam.covid19.model.CovidByCountry;
import zawadka.adam.covid19.model.ListByCountry;
import zawadka.adam.covid19.model.Covid;
import zawadka.adam.covid19.model.Total;
import zawadka.adam.covid19.service.DataRequest;

import java.util.List;

@RestController
public class ApiController {

    DataRequest dataRequest = new DataRequest();

    @GetMapping("/api/list/")
    public List<CovidByCountry> byCountry() throws JsonProcessingException {

        return DataRequest.getDataByCoutry();

    }

    @GetMapping("/api/total/")
    public Covid total() throws JsonProcessingException {

        return DataRequest.getTotal();
    }
}
