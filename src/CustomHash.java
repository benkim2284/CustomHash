import java.util.HashMap;
import java.util.Scanner;

public class CustomHash{
    private HashMap<Character, Integer> vowelMap;
    public CustomHash(){
        vowelMap = new HashMap<>();
        vowelMap.put('a',100);
        vowelMap.put('e',200);
        vowelMap.put('i',300);
        vowelMap.put('o',400);
        vowelMap.put('u',500);
    }
    public long createHash(String word){
        //We are initializing some variables
        String usableWord = word.toLowerCase();
        long hashCode=0;
        //creating for-loop to iterate through String
        for (int count=0; count<usableWord.length(); count++){
            //checks if the character is a vowel.
            char tempChar = usableWord.charAt(count);
            //Conditional Statements
            if (vowelMap.containsKey(tempChar)){
                hashCode+=vowelMap.get(tempChar);
            }else if (Character.isLetter(tempChar)){
                //this is "actual" position of the character in the String.
                int charPosition = count+1;
                //We are converting the letter to its value on the ASCII
                hashCode+=((int)tempChar-96)*charPosition;
            }
        }
        return hashCode;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter any text");
        String input = keyboard.nextLine();
        keyboard.close();
        
        CustomHash test = new CustomHash();
        System.out.println("The CS112 hashcode for that string is " + test.createHash(input));

    }

}