package springrest.exam.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class ComicActor {
    String name;
    String addr;
    String image;
}
