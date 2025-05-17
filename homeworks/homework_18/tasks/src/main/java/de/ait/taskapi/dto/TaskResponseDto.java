package de.ait.taskapi.dto;

import de.ait.taskapi.model.Priority;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
public class TaskResponseDto {
    private Long id;
    private String description;
    private Priority priority;
}
