package Calculator;
import java.util.Scanner;

import static Calculator.Roman.convertIntToRoman;
import static Calculator.Roman.convertRomanToInt;

public class Program {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение с арабскими или римскими цифрами от 1 до 10 ");
        String input = in.nextLine(); // считали строку
        String[] strings = input.split(" ");  // разбили строку в массив

        int num1;
        int num2;
        String operator;


        if (checkString(strings[0]) && checkString(strings[2])) {       //если на входе арабские цифры
            num1 = Integer.parseInt(strings[0]);
            operator = strings[1];
            num2 = Integer.parseInt(strings[2]);

            if (num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10) {

                int result = calc(num1, num2, operator);
                System.out.println(result);

            } else {
                System.out.println("Повторите ввод");

            }
        } else if (checkString(strings[0]) != checkString(strings[2])) {
            System.out.println("Вы ошиблись");
        } else {                                                               // если на входе римские цифры
            num1 = convertRomanToInt(strings[0]);
            num2 = convertRomanToInt(strings[2]);
            operator = strings[1];
            int result = calc(num1, num2, operator);
            System.out.println(convertIntToRoman(result));

        }


    }
// проверка на число
    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

// калькулятор
    public static int calc(int num1, int num2, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Вы ввели неправильный символ");

        }
        return result;
    }

}