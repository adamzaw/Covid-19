package zawadka.adam.covid19.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zawadka.adam.covid19.service.DataService;

@Component
public class CovidTotalMapper {

    @Autowired
    private DataService dataService;

    public CovidTotalDto covidTotalDto() throws JsonProcessingException {

        CovidTotalDto covidTotalDto = new CovidTotalDto();
        covidTotalDto.covid = dataService.getTotal();

        return covidTotalDto;
    }
}
