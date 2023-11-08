package com.company;

import java.io.FileNotFoundException;

public class Main {
    static String[] films = { "interstellar", "terminator", "predator", "ameli" };

    public static void main(String[] args) throws FileNotFoundException {

        Game game = new Game();

        game.filmsHistogram(films); //films from here

        System.out.println(game.isFileCanBeOpened()); // check if file is open

        String[] movies = game.readFromFile(); // films from file

        game.printFilms(movies); // print out the list of films from file

        game.filmsHistogram(movies);

        String xFilm = game.pickRandomFilm(movies); // picking random films from Movies list

        game.guessTheFilmGame(xFilm); // the guessing game

    }
}
