package springrest.exam.domain;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person  {
    private String firstname, lastname;
}
