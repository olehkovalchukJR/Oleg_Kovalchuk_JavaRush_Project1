package ru.javarush.olegkovalchuk.project1;

import ru.javarush.olegkovalchuk.files.EncryptedFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class EncryptText {
    public ArrayList<String> listEncryptionResult = new ArrayList<>();

    Alphabet alphabet = new Alphabet();
    Key key = new Key();
    EncryptedFile encryptedFile = new EncryptedFile();


    public List<String> fileEncryption(List<String> list){
        for (int k = 0; k < list.size(); k++) {
            StringBuilder builder = new StringBuilder(list.get(k));
            for (int i = 0; i < builder.length(); i++) {
                int index = alphabet.alphabetCharacterIndex(builder.charAt(i));
                if (index + Key.KEY >= alphabet.alphabetSize) {
                    index = (index + Key.KEY) - (alphabet.alphabetSize);
                    builder.setCharAt(i, alphabet.ALPHABET[index]);
                    continue;
                }
                builder.setCharAt(i, alphabet.ALPHABET[index + Key.KEY]);
            }
            String result = builder.toString();
            listEncryptionResult.add(result);
        }
        return listEncryptionResult;
    }


    public void printEncryptedText(){
        for (String str: listEncryptionResult){
            System.out.println(str);
        }
    }
    public void writeEncryptedTextToFile(){
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
