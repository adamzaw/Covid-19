package zawadka.adam.covid19.dto;

import lombok.Data;
import zawadka.adam.covid19.model.CovidByCountry;

@Data
public class CovidOfCountryDto {
    public CovidByCountry covidOfCountry;
}
