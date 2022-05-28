package ru.javarush.olegkovalchuk.project1;

import java.util.ArrayList;
import java.util.List;

public class DecryptTextWithKey{
    Alphabet alphabet = new Alphabet();
    public ArrayList<String> listDecryptionResult = new ArrayList<>();


    public List<String> fileDecryption(List<String> list){
        for (int k = 0; k < list.size(); k++) {
            StringBuilder builder = new StringBuilder(list.get(k));
            for (int i = 0; i < builder.length(); i++) {
                int index = alphabet.alphabetCharacterIndex(builder.charAt(i));
                if (index - Key.KEY < 0) {
                    index = alphabet.alphabetSize - index;
                    builder.setCharAt(i, alphabet.ALPHABET[index - 1]);
                    continue;
                }
                builder.setCharAt(i, alphabet.ALPHABET[index - Key.KEY]);
            }
            String result = builder.toString();
            listDecryptionResult.add(result);
        }
        return listDecryptionResult;
    }

    public void printEncryptedText(){
        for (String str: listDecryptionResult){
            System.out.println(str);
        }
    }
}
