import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<SuperHero> superHeroes = new ArrayList<>();

    public static void readFile(String fileName) throws IOException {
        // TODO read data from the text file
    }

    public static void writeFile(String fileName, String name, String result) throws IOException {
        // TODO write to a text file
    }

    public static void playGame() {
        // TODO write the code so the user can play the game
    }

    public static void main(String[] args) {
        try {
            readFile("input.txt");
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }

        // sanity check
        for (int i = 0; i < superHeroes.size(); i++) {
            System.out.println(superHeroes.get(i).getSuperheroName());
        }

        playGame();
    }
}
