package ru.javarush.olegkovalchuk.project1;

import javax.management.openmbean.InvalidKeyException;
import java.util.Scanner;


public class Key {
    public static int KEY = getKEY();
    Alphabet alphabet = new Alphabet();


    public static int getKEY() {
        return KEY;
    }


    public void inputKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        KEY = scanner.nextInt();
        if (KEY < 1 || KEY >= alphabet.alphabetSize){
            throw new InvalidKeyException("Неправильное значение ключа!");
        }
    }
}
