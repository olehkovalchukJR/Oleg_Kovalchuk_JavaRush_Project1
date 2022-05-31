package ru.javarush.olegkovalchuk.files;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class FileToEncrypt {
    public List<String> fileContent;
    private String firstStringForBruteForce;

    public Path fileName;


    public void inputFileNameToEncrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу: ");
        System.out.println("Пример: /Users/yourUsername/Desktop/tex.txt");
        System.out.println("Или: C:\\\\Users\\\\User\\\\Documents\\\\MyFile.txt");
        String name = scanner.nextLine();
        this.fileName = Path.of(name).toAbsolutePath();
        isFileExists(fileName);
    }


    private boolean isFileExists(Path fileName) {
        try {
            if (Files.isDirectory(fileName)) {
                throw new IllegalArgumentException("Введенные данные являются директорией!");
            }
            if (!Files.exists(fileName)) {
                throw new IllegalArgumentException("Указаный файл не существует!");
            }
        } catch (InvalidPathException ipe) {
        }
        return true;
    }


    public List<String> getFileContent() {
        try {
            fileContent = Files.readAllLines(Paths.get(String.valueOf(fileName)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }


    public void firstLineForGuessingKey(){
        Path file = Path.of("../Oleg_Kovalchuk_JavaRush_Project1/src/ru/javarush/olegkovalchuk/files/firstLineForBruteForce.txt");
        try {
            Files.writeString(file,getFileContent().get(0));
        } catch (IOException e) {
        }
    }


    public String getFirstLineToCheckTheKey(){
        Path file = Path.of("../Oleg_Kovalchuk_JavaRush_Project1/src/ru/javarush/olegkovalchuk/files/firstLineForBruteForce.txt");
        try {
            firstStringForBruteForce = Files.readString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstStringForBruteForce;
    }
}
