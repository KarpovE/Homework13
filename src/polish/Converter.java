package polish;

import java.util.ArrayDeque;
import java.util.Deque;

public class Converter {
    private String expression;
    private Deque<Character> deque;

    public Converter (Deque deque){
        this.deque = deque;
        expression = "";
    }


    private boolean checkSign(Character character){
        if((character.compareTo('*') == 0)||(character.compareTo('+') == 0) ||
                (character.compareTo('-') == 0)||(character.compareTo('/') == 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void setExpression(Deque<String> digits, Deque<String> signs){
        String expression ="";
        while (!digits.isEmpty()){
            expression += digits.pollFirst() + " ";
        }
        while (!signs.isEmpty()){
            expression += signs.pollLast() + " ";
        }
        this.expression = expression;
    }


    private String getExpression(){
        return expression;
    }

    public String parse() {
        Deque<String> digits = new ArrayDeque<>();
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
        setExpression(digits, signs);
        return getExpression();
    }
}
