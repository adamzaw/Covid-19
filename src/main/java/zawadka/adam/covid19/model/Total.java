package zawadka.adam.covid19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Total {

    @JsonProperty("data")
    private Covid covid;

    public Total() {
    }

    public Total(Covid covid) {
        this.covid = covid;
    }

    public Covid getCovid() {
        return covid;
    }

    public void setCovid(Covid covid) {
        this.covid = covid;
    }
}
