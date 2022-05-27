package ru.javarush.olegkovalchuk.project1;

import java.util.ArrayList;
import java.util.List;


public class EncryptText {
    Alphabet alphabet = new Alphabet();
    Key key = new Key();
    public ArrayList<String> listEncryptionResult = new ArrayList<>();


    public List<String> fileEncryption(List<String> list){
        for (int k = 0; k < list.size(); k++) {
            StringBuilder builder = new StringBuilder(list.get(k));
            for (int i = 0; i < builder.length(); i++) {
                int index = alphabet.alphabetCharacterIndex(builder.charAt(i));
                if (index + key.KEY >= alphabet.alphabetSize) {
                    index = (index + key.KEY) - (alphabet.alphabetSize);
                    builder.setCharAt(i, alphabet.ALPHABET[index]);
                    continue;
                }
                builder.setCharAt(i, alphabet.ALPHABET[index + key.KEY]);
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
}
