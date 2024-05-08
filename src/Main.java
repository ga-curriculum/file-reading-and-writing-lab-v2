import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            readFile("src/input.txt");
            System.out.println(playGame());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String playGame() throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<SuperHero> heroes = SuperHero.getHeroesList();
        Random random = new Random();
        int rightAnswers = 0;
        int wrongAnswers = 0;

        System.out.println("Welcome to Superhero Super Trivia! Who's playing today? ");
        System.out.println("****** Answers are case and space sensitive ******");
        System.out.println("Please enter your name:");
        String name = userInput.readLine();
        System.out.println("Hello " + name + "!\r\n");

        for (int i = 1; i <= 3; i++) {
            System.out.println("Question " + i + "!");
            SuperHero chosenHero = heroes.get(random.nextInt(heroes.size()));

            switch (i) {
                case 1:
                    System.out.println("What is " + chosenHero.getSuperIdentity() + "'s birthplace?");
                    break;
                case 2:
                    System.out.println("Who is " + chosenHero.getName() + "?");
                    break;
                case 3:
                    System.out.println("What is " + chosenHero.getSuperIdentity() + "'s full name?");
                    break;
            }

            String userAnswer = userInput.readLine();
            if (checkAnswer(userAnswer, chosenHero.getCorrectAnswer(i))) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
            showStats(rightAnswers, wrongAnswers, i == 3);
        }

        userInput.close();
        writeStatsToFile(name, rightAnswers, wrongAnswers);
        return ("Thank you for playing " + name + "! Your stats have been updated in the Superhero Super Trivia txt file.");
    }

    private static boolean checkAnswer(String userAnswer, String correctAnswer) {
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        }
        System.out.println("Sorry, the answer I was looking for was " + correctAnswer);
        return false;
    }

    private static void showStats(int rightAnswers, int wrongAnswers, boolean finalQuestion) {
        System.out.println("---------STATS----------");
        System.out.println("Right Answers: " + rightAnswers);
        System.out.println("Wrong Answers: " + wrongAnswers + "\r\n");

        if (finalQuestion) {
            if (rightAnswers > wrongAnswers) {
                System.out.println("Congratulations! You won!\r\n");
            } else {
                System.out.println("Sorry, you lost!\r\n");
            }
        }
    }

    public static void readFile(String fileName) throws IOException {
        ArrayList<SuperHero> heroes = new ArrayList<>();
        try (Scanner scan = new Scanner(new FileReader(fileName))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] lineArray = line.split(",");
                SuperHero hero = new SuperHero(lineArray[0], lineArray[1], lineArray[2]);
                heroes.add(hero);
            }
        }
        SuperHero.setHeroesList(heroes);
    }

    private static void writeStatsToFile(String name, int rightAnswers, int wrongAnswers) throws IOException {
        File triviaStats = new File("superHeroTriviaStats.txt");
        boolean append = triviaStats.exists();
        try (FileWriter update = new FileWriter(triviaStats, append)) {
            update.write("---------" + name + "'s STATS----------" + "\r\n");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
            update.write(LocalDate.now().format(dateFormatter) + "\r\n");
            update.write("Right Answers: " + rightAnswers + "\r\n");
            update.write("Wrong Answers: " + wrongAnswers + "\r\n");
        }
    }
}