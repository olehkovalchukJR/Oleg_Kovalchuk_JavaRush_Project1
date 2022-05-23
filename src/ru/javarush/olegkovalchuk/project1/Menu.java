package ru.javarush.olegkovalchuk.project1;

import java.util.Scanner;

public class Menu {
    EncryptText encryptText = new EncryptText();

    public void chose(){
        switch (printMainMenu()){
            case 1 : encryptText.inputParameters();
        }
    }

    public int printMainMenu(){
        //TODO дописать красивый вывод
        System.out.println("1.Зашифровать текст");
        System.out.println("2.Расшифровать текст с помощью ключа");
        System.out.println("3.Расшифровать текста с помощью brute force (перебор всех вариантов)");
        System.out.println("0.Выход");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
