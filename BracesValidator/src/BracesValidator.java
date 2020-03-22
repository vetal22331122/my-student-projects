import java.util.ArrayList;
import java.util.Scanner;

public class BracesValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение для проверки. Для выхода из программы введите \"STOP\".");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("STOP")) {
                break;
            }
            try {
                System.out.println(bracesValidator(input));
            } catch (StringIndexOutOfBoundsException ex) {
                System.out.println("Неверный ввод, повторите");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static boolean bracesValidator(String input) throws StringIndexOutOfBoundsException, IllegalArgumentException {
        ArrayList<Character> counter = new ArrayList<>();

        input = input.replaceAll("[^()\\[\\]{}]", "");
        if (input.length() == 0) throw new IllegalArgumentException("Выражение не содержит скобок");
        if (input.charAt(0) != '(' && input.charAt(0) != '{' && input.charAt(0) != '[') {
            return false;
        }
        counter.add(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if ((input.charAt(i) == '(') || (input.charAt(i) == '{') || (input.charAt(i) == '[')) {
                counter.add(input.charAt(i));
            } else if (input.charAt(i) == braceMirror(counter.get(counter.size() - 1))) {
                counter.remove(counter.size() - 1);
            } else break;
        }
        return counter.size() == 0;
    }

    private static char braceMirror(char brace) {
        char mirror = 0;
        switch (brace) {
            case '(':
                mirror = ')';
                break;
            case ')':
                mirror = '(';
                break;
            case '[':
                mirror = ']';
                break;
            case ']':
                mirror = '[';
                break;
            case '{':
                mirror = '}';
                break;
            case '}':
                mirror = '{';
                break;
        }
        return mirror;
    }
}