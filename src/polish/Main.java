package polish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque deque = new ArrayDeque<Character>();
        StringBuilder builder = new StringBuilder();
        System.out.println("Введите математическое выражение:");
        try {
            builder.append(reader.readLine());
            for (int i=0; i < builder.length(); i++ ) {
                Character symbol = builder.charAt(i);
                if (symbol.compareTo(' ') != 0) deque.offer(builder.charAt(i));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        Converter polishNotation = new Converter(deque);
        System.out.println("Выражение в формате обратной польской записи:");
        System.out.println(polishNotation.parse());

    }
}
