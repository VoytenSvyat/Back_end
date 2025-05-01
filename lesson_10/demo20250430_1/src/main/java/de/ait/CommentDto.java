package de.ait;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
"postId": 1,
        "id": 5,
        "name": "vero eaque aliquid doloribus et culpa",
        "email": "Hayden@althea.biz",
        "body": "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et"
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class CommentDto {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}
