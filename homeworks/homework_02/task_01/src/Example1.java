import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Example1 {
    public static int sortDigitsDescending(int number) {
        /// Ваша задача — создать функцию, которая может принимать любое неотрицательное целое число в качестве
        /// аргумента и возвращать его с его цифрами в порядке убывания.
        /// По сути, переставить цифры, чтобы создать максимально возможное число.

        // 1. Преобразуем число в строку, чтобы получить доступ к цифрам
        String numberStr = Integer.toString(number);

        // Преобразуем строку в массив символов
        char[] digits = numberStr.toCharArray();

        // Сортируем цифры в порядке возрастания
        Arrays.sort(digits);

        // Инвертируем порядок массива, чтобы получить убывание
        StringBuilder sortedDescending = new StringBuilder(new String(digits)).reverse();

        // Преобразуем обратно в число
        return Integer.parseInt(sortedDescending.toString());
    }

    public static void main(String[] args) {
        int number = 123456789; // Пример числа
        int result = sortDigitsDescending(number);
        System.out.println("Максимальное число из цифр: " + result);
    }
}
