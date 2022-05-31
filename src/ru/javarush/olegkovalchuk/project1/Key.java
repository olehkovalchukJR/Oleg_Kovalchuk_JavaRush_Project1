package ru.javarush.olegkovalchuk.project1;

import javax.management.openmbean.InvalidKeyException;
import java.util.Scanner;


public class Key {
    public static int KEY;

    Alphabet alphabet = new Alphabet();


    public void inputKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        KEY = scanner.nextInt();
        if (KEY < 1 || KEY >= alphabet.ALPHABET.length){
            throw new InvalidKeyException("Значение ключа должно быть от 1 до " + alphabet.ALPHABET.length);
        }
    }
}
