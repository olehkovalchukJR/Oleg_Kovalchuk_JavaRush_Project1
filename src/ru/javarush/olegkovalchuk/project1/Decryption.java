package ru.javarush.olegkovalchuk.project1;

import ru.javarush.olegkovalchuk.files.FileToEncrypt;

import java.util.ArrayList;
import java.util.List;

public class Decryption {
    public ArrayList<String> listDecryptionResult = new ArrayList<>();

    FileToEncrypt fileToEncrypt = new FileToEncrypt();
    Alphabet alphabet = new Alphabet();


    public String textDecryptionProcess(StringBuilder builder){
        for (int i = 0; i < builder.length(); i++) {
            int index = alphabet.alphabetCharacterIndex(builder.charAt(i));
            if (index - Key.KEY < 0) {
                index = alphabet.alphabetSize - (Key.KEY - index);
                builder.setCharAt(i, alphabet.ALPHABET[index]);
                continue;
            }
            builder.setCharAt(i, alphabet.ALPHABET[index - Key.KEY]);
        }
        return builder.toString();
    }


    public List<String> decryptionWithKey(List<String> list){
        for (int k = 0; k < list.size(); k++) {
            StringBuilder builder = new StringBuilder(list.get(k));
            listDecryptionResult.add(textDecryptionProcess(builder));
        }
        return listDecryptionResult;
    }


    public List<String> decryptionWithBruteForce(List<String> list){
        for (int possibleKey = 1; possibleKey < alphabet.alphabetSize; possibleKey++) {
            Key.KEY = possibleKey;
            StringBuilder builder = new StringBuilder(list.get(0));
            if (fileToEncrypt.getFirstLine().equals(textDecryptionProcess(builder))){
                for (int k = 0; k < list.size(); k++) {
                    builder = new StringBuilder(list.get(k));
                    listDecryptionResult.add(textDecryptionProcess(builder));
                }
            }
        }
        return listDecryptionResult;
    }



    public void printDecryptedText(){
        System.out.println();
        System.out.println("Результат:");
        for (String str: listDecryptionResult){
            System.out.println(str);
        }
    }
}
