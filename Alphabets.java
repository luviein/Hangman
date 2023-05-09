import java.util.Arrays;
import java.util.Random;

import javax.sound.sampled.SourceDataLine;

public class Alphabets {
    static String[] words = {"apple", "banana", "cherry", "orange", "grape", "lemon", "lime", "peach", "pear", "plum"};
    
    public static String getRandomWords(){
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }
    
    


}

