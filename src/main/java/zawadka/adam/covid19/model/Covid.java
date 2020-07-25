package zawadka.adam.covid19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Covid {
    @JsonProperty("confirmed")
    private int confirmed;
    @JsonProperty("deaths")
    private int deaths;
    @JsonProperty("recovered")
    private int recovered;
    @JsonProperty("active")
    private int active;

    public abstract boolean equals(String o);
}
