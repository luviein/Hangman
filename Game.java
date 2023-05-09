import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void initialiseGame(String[] word, List<String> guessArray) {
        word = Alphabets.getRandomWords().split("");
        System.out.println("Answer: " + Arrays.toString(word));

        guessArray = new ArrayList<>();
        int i = 0;
        while (i < word.length) {
            guessArray.add("_ ");
            i++;
        }
        System.out.println("Welcome to the Hangman Game~");
        System.out.println("You have 5 guesses. The game begins now...");
    }

    public static boolean yesNo(Scanner scanner){
        System.out.println("Y or N");
        String yesNo = scanner.nextLine().trim().toLowerCase();
        if (yesNo.equals("y")) {
          return true;  
        } else {
            return false;
           
        }
    }

    public static void gameStart() {
        boolean toContinue = true;
        Scanner scanner = new Scanner(System.in);
        while (toContinue) {
            // for every game
            String[] word = new String[0];
            List<String> guessArray = new ArrayList<>();
            int guess = 5;

            // initialiseGame(word, guessArray);
            word = Alphabets.getRandomWords().split("");
            System.out.println("Answer: " + Arrays.toString(word));

            guessArray = new ArrayList<>();
            int i = 0;
            while (i < word.length) {
                guessArray.add("_ ");
                i++;
            }
            System.out.println("Welcome to the Hangman Game~");
            System.out.println("You have 5 guesses. The game begins now...");

            while (guess <= 5) {
                // 5 rounds
                System.out.println("Your guess: ");
                String userInput = scanner.nextLine().trim().toLowerCase();
                // check for every char that matches the random word
                // j=0
                // j=1
                // j=2
                // j=3
                // j=4
                boolean willMinus = false;
                boolean isCorrect = false;
                for (int j = 0; j < word.length; j++) {

                    if (userInput.equals(word[j])) {
                        isCorrect = true;
                        guessArray.set(j, userInput);
                        
                    } else {
                        willMinus = true;
                    }
                }
                System.out.println(guessArray);
                if (willMinus == true) { //prevent from minus more than once if is wrong
                    guess -= 1;
                }
                if (isCorrect == true) { //when correct once
                    System.out.println("Correct");
                } else { //if none of input is correct then is correct = false
                    System.out.println("Wrong");
                }

                //a,p,p,l,e

                if (guessArray.equals(Arrays.asList(word))) {
                    System.out.println(guessArray);
                    System.out.println(Arrays.asList(word));
                    System.out.println("You win!");
                    
                    if(yesNo(scanner) == true){
                        break;
                    }else{
                        toContinue = false;
                        break;
                    }
                }
                if (guess == 0) {
                    if(yesNo(scanner) == true){
                        break;
                    }else{
                        toContinue = false;
                        break;
                    }
                }
            }
        }
        // initialise the game whenever player type 'y' and game start

        // int guess = 5;
        // Scanner scanner = new Scanner(System.in);

        // while (guess <= 5) {

        // String[] word = new String[0];
        // List<String> guessArray = new ArrayList<>();
        // if (guess == 5) {
        // initialiseGame(word, guessArray);
        // }

        // // loop through first character and see if it matches any of the char in the
        // // random word

        // for (int x = 0; x < word.length; x++) {

        // if (guess == 0) {

        // System.out.println("Y or N");
        // String yesNo = scanner.nextLine().trim().toLowerCase();
        // if (yesNo.equals("y")) {
        // // System.out.println("Welcome to the Hangman Game~");
        // // System.out.println("You have 5 guesses. The game begins now...");

        // // String[] words = Alphabets.getRandomWords().split("");
        // // System.out.println("Answer: " + Arrays.toString(words));
        // // int j = 0;
        // // while (j < words.length) {
        // // guessArray.add("_ ");
        // // j++;
        // // }
        // break;

        // } else if (yesNo.equals("n")) {
        // System.out.println("Goodbye~");
        // System.exit(0);
        // }

        // }
        // System.out.println(guessArray);
        // System.out.println("Your guess: ");
        // String userInput = scanner.nextLine().toLowerCase().trim();

        // if (userInput.equals(word[x])) {
        // System.out.println("Correct");
        // guessArray.set(x, userInput);

        // } else {
        // System.out.println("Wrong");
        // guess -= 1;
        // System.out.println("Lives left: " + guess);
        // }

        // }
        // if (guessArray.equals(Arrays.asList(word))) {
        // System.out.println("You win!");
        // // System.exit(0);
        // guess = 5;
        // guessArray.clear();
        // }

        // }
        scanner.close();
    }
}
