package br.edu.ifsp.graphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;

@Controller
public class StarWarController {

    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return new Human(
                "1001",
                "Luke Skywalker",
                List.of(episode != null ? episode : Episode.NEWHOPE),
                List.of(),
                1.75);
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return new Droid(
                id,
                "R2-D2",
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
                List.of(),
                "Astromech");
    }

    @QueryMapping
    public List<Object> search(@Argument String text) {
        return List.of(
                new Droid("2001", "R2-D2", List.of(), List.of(), "Astromech"),
                new Human("1001", "Luke Skywalker", List.of(), List.of(), 1.72f),
                new Starship("3000", "Millennium Falcon", 1000f)
        );
    }


    @QueryMapping
    public List<Human> humans() {
        return List.of(
                new Human("1001", "Luke Skywalker", List.of(), List.of(), 1.75f),
                new Human("1002", "Leia Organa", List.of(), List.of(), 1.65f)
        );
    }

    @QueryMapping
    public List<Starship> starships() {
        return List.of(
                new Starship("3001", "Millennium Falcon", 34.75f),
                new Starship("3002", "X-Wing", 12.5f)
        );
    }

    @QueryMapping
    public Character character(@Argument String id) {
        if (id.equals("1001")) {
            return new Human("1001", "Luke Skywalker", List.of(), List.of(), 1.75f);
        } else {
            return new Droid("2001", "R2-D2", List.of(), List.of(), "Astromech");
        }
    }

   

    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return new Review(review.getStars(), review.getCommentary());
    }


    @MutationMapping
    public Human createHuman(@Argument String id,
                             @Argument String name,
                             @Argument Float height) {
        return new Human(id, name, List.of(), List.of(), height);
    }

    @MutationMapping
    public Droid createDroid(@Argument String id,
                             @Argument String name,
                             @Argument String primaryFunction) {
        return new Droid(id, name, List.of(), List.of(), primaryFunction);
    }

    @MutationMapping
    public Starship createStarship(@Argument String id,
                                   @Argument String name,
                                   @Argument Float length) {
        return new Starship(id, name, length);
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId,
                               @Argument String friendId) {

        return new Human(characterId, "Luke Skywalker", List.of(), List.of(), 1.75f);
    }
}