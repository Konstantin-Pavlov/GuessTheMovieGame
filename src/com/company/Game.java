package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Random random = new Random(); 
    public void filmsHistogram(String films[]) {
        for (String i : films) {
            String film = i;
            System.out.print("\n" + i + " " + i.length() + " ");
            for (int j = 0; j < film.length(); j++) {
                if (j == film.length() - 1) {
                    System.out.print("_");
                    continue;
                }
                System.out.print("_" + " ");
            }
        }
    }

    public void printFilms(String films[]) {
        System.out.println("\n");
        for (String i : films) {
            System.out.println(i);
        }

    }

    public String wordToUnderscore(String word) {
        StringBuilder film = new StringBuilder(word);
        for (int i = 0; i < film.length(); i++) {
            if (film.charAt(i) == ' ')
                continue;
            film.setCharAt(i, '_');
        }
        word = film.toString();
        return word;
    }

    public String pickRandomFilm(String films[]) {
        return films[random.nextInt(films.length)];

    }

    public void guessTheFilmGame(String film) {
        String originalFilm = film;
        char[] wrongLetters = new char[30];
        int wrongGuesses = 0, tries = 0;

        film = wordToUnderscore(film);

        Scanner scanner = new Scanner(System.in);
        StringBuilder tempFilm = new StringBuilder(film);
        System.out.println("\n\n\t\t\t*** LET THE FILM GUESSING GAME BEGIN!!! ***\n");
        System.out.print("enter the letter: ");
        String c = scanner.nextLine();
        char q = c.charAt(0);

        while (true) {
            tries++;
            if (originalFilm.indexOf(q) == -1) {
                wrongGuesses++;
                System.out.println("Title of the film does not contain the letter \"" + q + "\"");

                boolean b = true;
                for (int i = 0; i < wrongLetters.length; i++) {
                    if (wrongLetters[i] == q) {
                        System.out.println("you have already entered this letter: " + q);
                        --wrongGuesses;
                        b = false;
                        break;
                    }
                }

                if (b)
                    wrongLetters[wrongGuesses - 1] = q;

                System.out.print("wrong letters: ");
                for (int i = 0; i < wrongLetters.length; i++) {
                    System.out.print(wrongLetters[i] + " ");
                }

            } else {
                byte printOnce = 0;
                for (int i = 0; i < tempFilm.length(); i++) {
                    if (originalFilm.charAt(i) == q) {
                        printOnce++;
                        if (printOnce == 1)
                            System.out.print("Right guess! ");
                        tempFilm.setCharAt(i, q);
                    }
                }
            }

            String strTempFilm = tempFilm.toString();
            if (strTempFilm.equals(originalFilm)) {
                System.out.println("it's \"" + strTempFilm + "\"");
                System.out.println("correct!");
                System.out.println("wrong guesses: " + wrongGuesses);
                System.out.println("tries total: " + tries);
                break;
            }

            System.out.println("\nwrong guesses: " + wrongGuesses);
            System.out.println("tries total: " + tries);
            System.out.println(tempFilm);

            System.out.print("\nenter the letter: ");
            c = scanner.nextLine();
            q = c.charAt(0);

        }
    }

    public boolean isFileCanBeOpened() {
        try {
            File file = new File("films.txt");
            Scanner scanner = new Scanner(file);
            System.out.println("\n\nfile is opened!");
            return true;
        } catch (FileNotFoundException exception) {
            // Handle the situation by letting the user know what happened
            System.out.println("Cannot find this file!");
            return false;
        }
    }

    public String[] readFromFile() throws FileNotFoundException {

        File file = new File("films.txt");
        Scanner scanner = new Scanner(file);
        int numberOfFilms = howManyFilmsInFile();
        String[] films = new String[numberOfFilms];
        int i = 0;
        while (scanner.hasNextLine()) { // return true or false
            String line = scanner.nextLine(); // return every string
            films[i] = line;
            i++;

            // printFilms(films);
            /*
             * for (i=0; i<films.length; i++){
             * System.out.println(i+1 + ". " + films[i]);
             * }
             */
        }
        return films;
    }

    public static int howManyFilmsInFile() throws FileNotFoundException {
        File file = new File("films.txt");
        Scanner scanner = new Scanner(file);
        int films = 0;
        while (scanner.hasNextLine()) { // returns true or false
            String line = scanner.nextLine(); // returns every string
            films += line.split("\n").length;
        }
        return films;
    }
}
