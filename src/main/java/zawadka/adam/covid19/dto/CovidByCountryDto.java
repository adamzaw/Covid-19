package zawadka.adam.covid19.dto;

import lombok.Data;
import zawadka.adam.covid19.model.CovidByCountry;

import java.util.List;

@Data
public class CovidByCountryDto {
    public List<CovidByCountry> covidByCountry;
}
