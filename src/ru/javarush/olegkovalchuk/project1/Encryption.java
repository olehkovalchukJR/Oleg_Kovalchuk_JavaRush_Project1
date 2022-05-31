package ru.javarush.olegkovalchuk.project1;

import ru.javarush.olegkovalchuk.files.EncryptedFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class Encryption {
    public ArrayList<String> listEncryptionResult = new ArrayList<>();

    Alphabet alphabet = new Alphabet();


    public List<String> fileEncryption(List<String> list){
        for (int k = 0; k < list.size(); k++) {
            StringBuilder builder = new StringBuilder(list.get(k));
            for (int i = 0; i < builder.length(); i++) {
                int index = alphabet.alphabetCharacterIndex(builder.charAt(i));
                if (index + Key.KEY >= alphabet.ALPHABET.length) {
                    index = (index + Key.KEY) - (alphabet.ALPHABET.length);
                    builder.setCharAt(i, alphabet.ALPHABET[index]);
                    continue;
                }
                builder.setCharAt(i, alphabet.ALPHABET[index + Key.KEY]);
            }
            String result = builder.toString();
            listEncryptionResult.add(result);
        }
        printEncryptedText();
        writeEncryptedTextToFile();
        return listEncryptionResult;
    }


    private void printEncryptedText(){
        for (String str: listEncryptionResult){
            System.out.println(str);
        }
    }


    private void writeEncryptedTextToFile(){
        Path file = Path.of(EncryptedFile.nameOfEncryptedFile).toAbsolutePath();
        try {
            Files.writeString(file,"");
        } catch (IOException e) {
        }

        for (int i = 0; i < listEncryptionResult.size(); i++) {
            try {
                Files.writeString(file,listEncryptionResult.get(i) + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
            }
        }
    }
}
