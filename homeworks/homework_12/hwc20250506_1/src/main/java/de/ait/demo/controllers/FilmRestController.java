package de.ait.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmRestController {

    @GetMapping("/films")
    public List<Film> getFilm(){
        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("The Shawshank Redemption", "Drama", 1994));
        filmList.add(new Film("Interstellar", "Fantasy", 2014));
        filmList.add(new Film("The Gentlemen", "Fantasy, Drama, Adventure", 2019));
        filmList.add(new Film("The Green Mile", "Drama, Fantasy, Crime", 1999));
        filmList.add(new Film("Forrest Gump", "Drama, Comedy, Melodrama, History, War", 1994));

        return filmList;

    }

}
