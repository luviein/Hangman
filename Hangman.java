import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Hangman {

    public static void main(String[] args) {
        String[] word = Alphabets.getRandomWords().split("");
        System.out.println("Answer: " + Arrays.toString(word));

        int guess = 5;

        System.out.println("Welcome to the Hangman Game~");
        System.out.println("You have 5 guesses. The game begins now...");

        List<String> guessArray = new ArrayList<>();
        int i = 0;
        while (i < word.length) {
            guessArray.add("_ ");
            i++;
        }

        while (guess <= 5 && guess > 0) {

            // System.out.println(guessArray);

            Scanner scanner = new Scanner(System.in);

            // loop through first character and see if it matches any of the char in the
            // random word
            // List<String> userAns = new ArrayList<>();

            for (int x = 0; x < word.length; x++) {

                System.out.println("Your guess: ");
                String userInput = scanner.nextLine().toLowerCase().trim();
                if (guess == 0) {
                    System.out.println("You lost the game, bye.");
                    System.exit(0);
                
                }
                if (userInput.equals(word[x])) {
                    System.out.println("Correct");
                    guessArray.set(x, userInput);
                    System.out.println(guessArray);

                } else {
                    System.out.println("Wrong");
                    guess -= 1;
                    System.out.println("Lives left: " + guess);
                }

            }
            if(guessArray.equals(Arrays.asList(word))){
                System.out.println("You win!");
                System.exit(0);
            }

            

        }   

    }
}
