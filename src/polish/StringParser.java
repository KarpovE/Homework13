package polish;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringParser {

    private static boolean checkSign(Character character){
        if((character.compareTo('*') == 0)||(character.compareTo('+') == 0) ||
           (character.compareTo('-') == 0)||(character.compareTo('/') == 0)) {
            return true;
        } else {
            return false;
        }
    }

    private static String getExpression(Deque<String> digits, Deque<String> signs){
        String expression ="";
        while (!digits.isEmpty()){
            expression += digits.pollFirst() + " ";
        }
        while (!signs.isEmpty()){
            expression += signs.pollLast() + " ";
        }
        return expression;
    }

    public static String parse(Deque<Character> deque) {
        Deque<String> digits = new  ArrayDeque<>();
        Deque<String> signs = new ArrayDeque<>();
        String digit = "";
        while (!deque.isEmpty()){
            Character character = deque.pollFirst();
            if(Character.isDigit(character)){
                digit += character;
            } else {
                if(checkSign(character)) {
                    digits.offer(digit);
                    signs.offerLast(Character.toString(character));
                    digit = "";
                }
            }
        }
        digits.offer(digit);
        return getExpression(digits, signs);
    }
}
