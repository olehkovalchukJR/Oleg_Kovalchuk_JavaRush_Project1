package ru.javarush.olegkovalchuk.project1;
import ru.javarush.olegkovalchuk.files.FileToEncrypt;

import java.util.Scanner;


public class Menu {
    FileToEncrypt fileToEncrypt = new FileToEncrypt();
    Key key = new Key();
    EncryptText encryptText = new EncryptText();


    public void mainMenu(){
        switch (printMainMenu()){
            case 1 : optionsForEncryption();
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


    public void optionsForEncryption(){
        fileToEncrypt.inputFileName();
        key.inputKey();
        encryptText.fileEncryption(fileToEncrypt.getFileContent());
        encryptText.printEncryptedText();
    }
}
