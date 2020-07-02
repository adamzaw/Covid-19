package zawadka.adam.covid19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ListByCountry {

    @JsonProperty("data")
    private List<CovidByCountry> covidList;

    public ListByCountry() {
    }

    public ListByCountry(List<CovidByCountry> covidList) {
        this.covidList = covidList;
    }

    public List<CovidByCountry> getCovidList() {
        return covidList;
    }

    public void setCovidList(List<CovidByCountry> covidList) {
        this.covidList = covidList;
    }
}
