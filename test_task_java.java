import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test_task_java {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

                while (true) {
                    System.out.print("Введите текст: ");
                    String text = reader.readLine();
                    System.out.println(textModifier(text));
                }
    }


    public static String textModifier(String str) {
        String result = "";
        result = replaceSpaces(str);
        result = replaceByMinus(result);
        result = replacePlus(result);
        result = findNumbers(result);
        return result;
    } 


    public static String replaceSpaces(String str) {
        char[] charArray = str.toCharArray();
        String result = "";

        for (int i = 0; i < charArray.length; i++){
            if (charArray[i] == ' '){
                if (i+1 < charArray.length && charArray[i+1] == ' '){
                    continue;
                }
                result += charArray[i];
            } else {
                result += charArray[i];
            }
        }

        return result;
    }


    public static String replaceByMinus(String str) {
        char[] charArray = str.toCharArray();
        String result = "";
        char next = '\u0000';

        for (int i = 0; i < charArray.length; i++) {
            if (i+1 < charArray.length){
                if (charArray[i+1] == '-'){
                    next = charArray[i+2];
                    result += next;
                    result += charArray[i];
                    continue;
                }

                if (charArray[i] == '-'){
                    continue;
                }
                
                if (charArray[i] == next){
                    next = '\u0000';
                    continue;
                }
            }
            result += charArray[i];
        }

        return result;
    }


    public static String replacePlus(String str) {
        char[] charArray = str.toCharArray();
        String result = "";

        for (int i = 0; i < charArray.length; i++){
            if (charArray[i] == '+'){
                result += "!";
                continue;
            }
            result += charArray[i];
        }

        return result;
    }


    public static String findNumbers(String str) {
        char[] charArray = str.toCharArray();
        String result = "";
        int sum = 0;

        for (int i = 0; i<charArray.length; i++) {
            if ( Character.isDigit(charArray[i]) ){
                int num = Character.getNumericValue(charArray[i]);
                if (num >= 0 && num <= 9){
                    sum += num;
                }
                continue;
            }
            result += charArray[i];
        }

        if (sum != 0) {
            return result + " " + sum;
        }


        return result;
    }

}
