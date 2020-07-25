package zawadka.adam.covid19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidByCountry extends Covid {
    @JsonProperty("location")
    private String location;

    @Override
    public boolean equals(String o) {
        return location.equalsIgnoreCase(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
