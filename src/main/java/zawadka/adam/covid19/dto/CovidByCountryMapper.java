package zawadka.adam.covid19.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zawadka.adam.covid19.service.DataRequest;

@Component
public class CovidByCountryMapper {

    @Autowired
    DataRequest dataRequest;

    public CovidByCountryDto covidByCountryDto() throws JsonProcessingException {

        CovidByCountryDto covidByCountryDto = new CovidByCountryDto();
        covidByCountryDto.covidByCountry = DataRequest.getDataByCoutry();

        return covidByCountryDto;
    }
}
