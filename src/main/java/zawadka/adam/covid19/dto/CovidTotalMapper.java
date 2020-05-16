package zawadka.adam.covid19.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zawadka.adam.covid19.service.DataRequest;

@Component
public class CovidTotalMapper {

    @Autowired
    DataRequest dataRequest;

    public CovidTotalDto covidTotalDto() throws JsonProcessingException {

        CovidTotalDto covidTotalDto = new CovidTotalDto();
        covidTotalDto.covid = DataRequest.getTotal();

        return covidTotalDto;
    }
}
