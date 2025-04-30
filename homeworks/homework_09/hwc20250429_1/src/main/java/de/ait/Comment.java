package de.ait;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
