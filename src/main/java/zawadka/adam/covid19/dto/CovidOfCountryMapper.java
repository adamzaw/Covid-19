package zawadka.adam.covid19.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zawadka.adam.covid19.exceptions.NoSuchCountryExemption;
import zawadka.adam.covid19.model.CovidByCountry;
import zawadka.adam.covid19.service.DataService;

import java.util.Optional;

@Component
public class CovidOfCountryMapper {

    @Autowired
    private DataService dataService;

    public CovidOfCountryDto covidOfCountryDto(String value) throws JsonProcessingException, NoSuchCountryExemption {

        CovidOfCountryDto covidOfCountryDto = new CovidOfCountryDto();
                Optional result= dataService.getDataByCountry().stream()
                .filter(c -> c.equals(value)).findFirst();
        if (result.isPresent()) {
            covidOfCountryDto.covidOfCountry = (CovidByCountry) result.get();
        } else throw new NoSuchCountryExemption(value);
        return covidOfCountryDto;
    }
}
