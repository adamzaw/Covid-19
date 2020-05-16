package zawadka.adam.covid19.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zawadka.adam.covid19.service.DataService;

@Component
public class CovidByCountryMapper {

    @Autowired
    private DataService dataService;

    public CovidByCountryDto covidByCountryDto() throws JsonProcessingException {

        CovidByCountryDto covidByCountryDto = new CovidByCountryDto();
        covidByCountryDto.covidByCountry = dataService.getDataByCountry();

        return covidByCountryDto;
    }
}
