package ru.javarush.olegkovalchuk.files;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EncryptedFile {
    public static String nameOfEncryptedFile = "../Oleg_Kovalchuk_JavaRush_Project1/src/ru/javarush/olegkovalchuk/files/encryptedFile.txt";
    public List<String> fileContent;


    public List<String> getFileContent() {
        try {
            fileContent = Files.readAllLines(Paths.get(String.valueOf(nameOfEncryptedFile)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
