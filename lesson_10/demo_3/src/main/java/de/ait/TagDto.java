package de.ait;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@NoArgsConstructor
@Getter
@ToString

public class TagDto {
    private double confidence;
    private Map<String, String> tag;
}
