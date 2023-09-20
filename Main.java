import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static char sign;
    static int result;
    static char[] mass = new char[10];
    static Scanner sc = new Scanner(System.in);
    static int number1,number2;
    public static void main(String[] args) {
        System.out.println("Введите выражение:");
        String scan=sc.nextLine();
        op(scan);
        String a=calc(scan);
        System.out.println("Решение:"+a);
    }

    public static void op(String Input){
        for (int i = 0; i < Input.length(); i++) {
            mass[i] = Input.charAt(i);
            if (mass[i] == '+') sign = '+';
            if (mass[i] == '-') sign = '-';
            if (mass[i] == '*') sign = '*';
            if (mass[i] == '/') sign = '/';
    }
}
    public static String calc(String Input) {
        Integer[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String str = String.valueOf(mass);
        String[] splitString = str.split("[+-/*]");
        //try{
        String num1 = splitString[0];
        String num = splitString[1];
        String num2 = num.trim();
        /*catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception: "+e);
        }*/
        boolean flag = false;
        for (int i = 0; i < roman.length; i++) {
            if (roman[i].equals(num1) || roman[i].equals(num)) {
                flag = true;
            }
        }
        try{
            if (flag) {
                number1 = romanToNumber(num1);
                number2 = romanToNumber(num2);
            }
            else{
            number1 = Integer.parseInt(num1);
                number2 = Integer.parseInt(num2);}
        }catch(NumberFormatException e){
            System.out.println("Exception: "+e);
        }
                if (number1 <= 10 && number2 <= 10) {
                    switch (sign) {
                        case '+':
                            result = number1 + number2;
                            break;
                        case '-':
                            result = number1 - number2;
                            break;
                        case '*':
                            result = number1 * number2;
                            break;
                        case '/':
                            try {
                                result = number1 / number2;
                                break;
                            } catch (ArithmeticException | IllegalArgumentException e) {
                                System.out.println("Деление на ноль: " + e);
                            }
                    }
                } else {
                    throw new NumberFormatException("Входные параметры должны быть меньше 10");
                }


                if (result<1 && flag==true){
                   try {
                       String c = convertNumToRoman(result);
                       Input = c;
                   }catch (ArrayIndexOutOfBoundsException e){
                       System.out.println("Exception: "+e);}
                }
                else
                {Input = Integer.toString(result);}
                return Input;
        }



            public static String convertNumToRoman ( int numArabian){
                String[] roman1 = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
                };
                final String s = roman1[numArabian];
                return s;
            }


            public static int romanToNumber (String roman)
            {
                try {
                    if (roman.equals("I")) {
                        return 1;
                    } else if (roman.equals("II")) {
                        return 2;
                    } else if (roman.equals("III")) {
                        return 3;
                    } else if (roman.equals("IV")) {
                        return 4;
                    } else if (roman.equals("V")) {
                        return 5;
                    } else if (roman.equals("VI")) {
                        return 6;
                    } else if (roman.equals("VII")) {
                        return 7;
                    } else if (roman.equals("VIII")) {
                        return 8;
                    } else if (roman.equals("IX")) {
                        return 9;
                    } else if (roman.equals("X")) {
                        return 10;
                    }
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Неверный формат данных");
                }
                return 0;

            }
        }




