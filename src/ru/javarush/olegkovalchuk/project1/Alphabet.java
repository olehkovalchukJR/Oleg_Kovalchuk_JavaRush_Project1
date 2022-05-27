package ru.javarush.olegkovalchuk.project1;

public class Alphabet {
    public final char[] ALPHABET = {'А','Б','В','Г','Д','Е','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т',
            'У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я','а','б','в','г','д','е','ж','з','и','й','к', 'л','м','н',
            'о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я',' ',',','.','!','?','"',':',';'};
    public int alphabetSize = ALPHABET.length;


    public int alphabetCharacterIndex(char symbol){
        int index = 0;
        for (int i = 0; i < ALPHABET.length; i++) {
            if (symbol == ALPHABET[i]){
                index = i;
                break;
            }
        }
        return index;
    }
}
