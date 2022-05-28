package ru.javarush.olegkovalchuk.project1;

import ru.javarush.olegkovalchuk.files.EncryptedFile;
import ru.javarush.olegkovalchuk.files.FileToEncrypt;

import java.util.Scanner;


public class Menu {
    FileToEncrypt fileToEncrypt = new FileToEncrypt();
    Key key = new Key();
    EncryptText encryptText = new EncryptText();
    EncryptedFile encryptedFile = new EncryptedFile();
    DecryptTextWithKey decryptTextWithKey = new DecryptTextWithKey();


    public void mainMenu() {
        switch (printMainMenu()) {
            case 1:
                optionsForEncryption();
                break;
            case 2:
                optionsForDecryptionWithKey();
                break;
        }
    }


    public int printMainMenu() {
        //TODO дописать красивый вывод
        System.out.println("1.Зашифровать текст");
        System.out.println("2.Расшифровать текст с помощью ключа");
        System.out.println("3.Расшифровать текста с помощью brute force (перебор всех вариантов)");
        System.out.println("0.Выход");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public void optionsForEncryption() {
        fileToEncrypt.inputFileName();
        key.inputKey();
        encryptText.fileEncryption(fileToEncrypt.getFileContent());
        encryptText.printEncryptedText();
        encryptText.writeEncryptedTextToFile();
    }


    public void optionsForDecryptionWithKey() {
        System.out.println("Расшифровка текста с помощью ключа");
        key.inputKey();
        decryptTextWithKey.fileDecryption(encryptedFile.getFileContent());
        decryptTextWithKey.printEncryptedText();
    }
}
