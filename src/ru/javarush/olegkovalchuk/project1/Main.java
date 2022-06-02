package ru.javarush.olegkovalchuk.project1;

import ru.javarush.olegkovalchuk.files.EncryptedFile;
import ru.javarush.olegkovalchuk.files.FileToEncrypt;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Main menu = new Main();
        menu.mainMenu();

        //        /Users/olehkovalchuk/Desktop/TextForProject.txt
        //        /Users/olehkovalchuk/Desktop/TextAgata.txt
    }


    FileToEncrypt fileToEncrypt = new FileToEncrypt();
    Key key = new Key();
    EncryptText encryptText = new EncryptText();
    EncryptedFile encryptedFile = new EncryptedFile();
    Decryption decryption = new Decryption();


    public void mainMenu() {
        switch (printMainMenu()) {
            case 1:
                optionsForEncryption();
                break;
            case 2:
                optionsForDecryptionWithKey();
                break;
            case 3:
                optionsForDecryptionWithBruteForce();
            case 0:
                break;
        }
    }


    public int printMainMenu() {
        Scanner scanner = new Scanner(System.in);
        //TODO дописать красивый вывод

            System.out.println("1.Зашифровать текст");
            System.out.println("2.Расшифровать текст с помощью ключа");
            System.out.println("3.Расшифровать текста с помощью brute force (перебор всех вариантов)");
            System.out.println("0.Выход");
        return scanner.nextInt();
    }


    public void optionsForEncryption() {
        fileToEncrypt.inputFileName();
        fileToEncrypt.firstLineForGuessingKey();
        key.inputKey();
        encryptText.fileEncryption(fileToEncrypt.getFileContent());
        encryptText.printEncryptedText();
    }


    public void optionsForDecryptionWithKey() {
        System.out.println("Расшифровка текста с помощью ключа");
        key.inputKey();
        decryption.decryptionWithKey(encryptedFile.getFileContent());
        decryption.printDecryptedText();
    }

    public void optionsForDecryptionWithBruteForce(){
        System.out.println("Расшифровка методом brute force");
        decryption.decryptionWithBruteForce(encryptedFile.getFileContent());
        decryption.printDecryptedText();
    }
}
