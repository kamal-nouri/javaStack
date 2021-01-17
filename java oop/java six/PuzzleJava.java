import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class PuzzleJava {
    // public void greater(){
    // int[] array={3,5,1,2,7,9,8,13,25,32};
    // int sum=0;
    // for(int i=0;i<array.length;i++){
    // sum+=array[i];
    // if (array[i]>10){
    // System.out.println(array[i]);
    // }
    // }
    // System.out.println(sum);
    // }
    // public ArrayList shuffleString(){
    // ArrayList<String> array =new ArrayList<String>();
    // ArrayList<String> array1 =new ArrayList<String>();
    // array.add("Nancy");
    // array.add("kamal");
    // array.add("abd");
    // array.add("yasmeen");
    // Collections.shuffle(array);
    // for (String name:array){
    // System.out.println(name);
    // if (name.length() >5){
    // array1.add(name);
    // }
    // }
    // return array1;
    // }
    // public void letters() {
    //     ArrayList<Character> letter = new ArrayList<Character>();
    //     for (char i = 'a'; i < 'z'; i++) {
    //         letter.add(i);
    //     }
    //     Collections.shuffle(letter);
    //     System.out.println(letter.get(letter.size() - 1));
    //     char[] voil = { 'a', 'e', 'o', 'u', 'i' };
    //     for (int i = 0; i < voil.length; i++) {

    //         if (letter.get(0) == voil[i]) {
    //             System.out.println("its a voel");
    //         } 
    //     }
    //     System.out.println(letter.get(0));
    // }

    // public int[] rands(){
    //     int[] array=new int[10];
    //     Random rand = new Random();
    //     for (int i=0;i<array.length;i++){
    //         array[i]= rand.nextInt(100 - 55) + 55;
    //         // System.out.println((array[i]));
    //     }
    //     Arrays.sort(array);
    //     for (int i=0;i<array.length;i++){
    //         System.out.println((array[i]));
    //     }
    //     return array;
    // }
    public String randomString() {
        String string = "";
        ArrayList<Character> letters = new ArrayList<Character>();
        for (char i = 'a'; i < 'z'; i++) {
            letters.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomResult = random.nextInt(25) + 0;
            char getChar = letters.get(randomResult);
            String getString = Character.toString(getChar);
            string = string.concat(getString);
        }
        return string;
    }

    public String[] arrayOfRandomStrings() {
        String[] array = new String[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomString();
        }
        return array;
    }


}