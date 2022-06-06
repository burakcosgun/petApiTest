package models.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePetResponse {
    @JsonProperty("category")
    Category category;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("photoUrls")
    public List<String> photoUrls;
    @JsonProperty("tags")
    public List<Tag> tags;
    @JsonProperty("status")
    public String status;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Category {
        @JsonProperty("id")
        public Long id;
        @JsonProperty("name")
        public String name;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Tag {
        @JsonProperty("id")
        public Long id;
        @JsonProperty("name")
        public String name;
    }
}


