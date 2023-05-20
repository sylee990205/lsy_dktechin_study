package springrest.exam.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.domain.ComicActor;
import springrest.exam.domain.ComicActorModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class HateoasRestController {
    @GetMapping("/all")
    public CollectionModel<ComicActorModel> allActor() {
        List<ComicActorModel> comicList = new ArrayList<>();
        comicList.add(new ComicActorModel("둘리").add(Link.of("http://localhost:8088/dooly").withRel("detail")));
        comicList.add(new ComicActorModel("또치").add(Link.of("http://localhost:8088/ddochi").withRel("detail")));
        comicList.add(new ComicActorModel("도우너").add(Link.of("http://localhost:8088/dauner").withRel("detail")));
        CollectionModel<ComicActorModel> result = CollectionModel.of(comicList);
        return result;
    }

    @GetMapping("/dooly")
    public ResponseEntity<ComicActor> getDooly() {
        ComicActor actor = ComicActor.builder()
                .name("둘리")
                .addr("쌍문동")
                .image("dooly.jpg")
                .build();
        return ResponseEntity.ok().body(actor);
    }

    @GetMapping("ddochi")
    public ResponseEntity<ComicActor> getDdochi() {
        ComicActor actor = ComicActor.builder()
                .name("또치")
                .addr("아프리카")
                .image("ddochi.jpg")
                .build();
        return ResponseEntity.ok().body(actor);
    }

    @GetMapping("/dauner")
    public ResponseEntity<ComicActor> getDauner() {
        ComicActor actor = ComicActor.builder()
                .name("도우너")
                .addr("깐따삐아")
                .image("dauner.png")
                .build();
        return ResponseEntity.ok().body(actor);
    }
}
