package ru.javarush.olegkovalchuk.project1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class EncryptText {
    private static final char[] ALPHABET = {'а','б','в','г','д','е','ж','з','и','й','к','л','м','н','о',
            'п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я',' '};
    private int KEY; //TODO сделать KEY final


    public void inputParameters(){
        inputFileName();
        inputKey();
    }

    private Path inputFileName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();
        return Path.of(fileName).toAbsolutePath();
        //TODO: сделать проверку файла
        // TODO: если файла не существует, вывести ошибку
    }

    private void inputKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        KEY = scanner.nextInt();
        //TODO дописать проверку ключа (от 1 до 32)
    }

    private List<String> textToEncrypt(){
        //TODO переделать этот метод
        try {
            return Files.readAllLines(inputFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
