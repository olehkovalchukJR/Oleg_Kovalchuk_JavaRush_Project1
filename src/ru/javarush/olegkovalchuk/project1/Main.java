package ru.javarush.olegkovalchuk.project1;

import ru.javarush.olegkovalchuk.files.EncryptedFile;
import ru.javarush.olegkovalchuk.files.FileToEncrypt;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Main menu = new Main();
        menu.mainMenu();

        //TODO дописать проветку на пустоту файлов
        //

        //        /Users/olehkovalchuk/Desktop/TextForProject.txt
        //        /Users/olehkovalchuk/Desktop/TextAgata.txt
    }


    FileToEncrypt fileToEncrypt = new FileToEncrypt();
    Key key = new Key();
    Encryption encryptText = new Encryption();
    EncryptedFile encryptedFile = new EncryptedFile();
    Decryption decryption = new Decryption();


    public void mainMenu() {
        boolean exit = false;
        while (!exit) {
            switch (printMainMenu()) {
                case 1:
                    optionsForEncryption();
                    System.out.println();
                    break;
                case 2:
                    optionsForDecryptionWithKey();
                    System.out.println();
                    break;
                case 3:
                    optionsForDecryptionWithBruteForce();
                    System.out.println();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }


    public int printMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(".........................................");
        System.out.println(".................Меню....................");
        System.out.println(".........................................");
        System.out.println("1.Зашифровать текст");
        System.out.println("2.Расшифровать текст с помощью ключа");
        System.out.println("3.Расшифровать текста с помощью brute force (перебор всех вариантов)");
        System.out.println("0.Выход");
        System.out.print(": ");
        return scanner.nextInt();
    }


    public void optionsForEncryption() {
        fileToEncrypt.inputFileNameToEncrypt();
        fileToEncrypt.firstLineForGuessingKey();
        key.inputKey();
        encryptText.fileEncryption(fileToEncrypt.getFileContent());
    }


    public void optionsForDecryptionWithKey() {
        System.out.println("Расшифровка текста с помощью ключа");
        key.inputKey();
        decryption.decryptionWithKey(encryptedFile.getFileContent());
    }


    public void optionsForDecryptionWithBruteForce() {
        System.out.println("Расшифровка методом brute force");
        decryption.decryptionWithBruteForce(encryptedFile.getFileContent());
    }
}
