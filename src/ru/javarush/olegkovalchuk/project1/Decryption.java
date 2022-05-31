package ru.javarush.olegkovalchuk.project1;

import ru.javarush.olegkovalchuk.files.FileToEncrypt;

import java.util.ArrayList;
import java.util.List;


public class Decryption {
    public ArrayList<String> listDecryptionResult = new ArrayList<>();

    FileToEncrypt fileToEncrypt = new FileToEncrypt();
    Alphabet alphabet = new Alphabet();


    private String textDecryptionProcess(StringBuilder builder){
        for (int i = 0; i < builder.length(); i++) {
            int index = alphabet.alphabetCharacterIndex(builder.charAt(i));
            if (index - Key.KEY < 0) {
                index = alphabet.ALPHABET.length - (Key.KEY - index);
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
            listDecryptionResult.add(k,textDecryptionProcess(builder));
        }
        printDecryptedText();
        return listDecryptionResult;
    }


    public List<String> decryptionWithBruteForce(List<String> list){
        for (int possibleKey = 1; possibleKey < alphabet.ALPHABET.length; possibleKey++) {
            Key.KEY = possibleKey;
            StringBuilder builder = new StringBuilder(list.get(0));
            if (fileToEncrypt.getFirstLineToCheckTheKey().equals(textDecryptionProcess(builder))){
                for (int k = 0; k < list.size(); k++) {
                    builder = new StringBuilder(list.get(k));
                    listDecryptionResult.add(k,textDecryptionProcess(builder));
                }
            }
        }
        printDecryptedText();
        return listDecryptionResult;
    }


    private void printDecryptedText(){
        System.out.println();
        System.out.println("Результат:");
        for (String str: listDecryptionResult){
            System.out.println(str);
        }
        listDecryptionResult.clear();
    }
}
