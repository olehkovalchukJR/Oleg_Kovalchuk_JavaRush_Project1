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
    public Path fileName;
    public List<String> fileContent;


    public void inputFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
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
}
