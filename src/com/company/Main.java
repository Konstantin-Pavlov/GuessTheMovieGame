package com.company;
import java.io.FileNotFoundException;

public class Main {
    static String[] films = {"interstellar", "terminator", "predator", "ameli"};

    public static void main(String[] args) throws FileNotFoundException {


        Game game = new Game();

        //game.filmsHistogram(films); //films from here


        System.out.println(game.isFileCanBeOpened()); //check if file is open

        String[] Movies = game.readFromFile(); //films from file

        game.printFilms(Movies); //print out the list of films from file

        game.filmsHistogram(Movies);

        String xFilm = game.pickRandomFilm(Movies); //picking random films from Movies list

        game.guessTheFilmGame(xFilm); //the guessing game




    }
}
