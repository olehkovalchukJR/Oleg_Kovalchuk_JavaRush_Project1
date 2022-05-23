package ru.javarush.olegkovalchuk.Exceptions;

import java.io.IOException;

public class InvalidKeyException extends IOException {
    String err;
    public InvalidKeyException(){
        err = "Значение ключа должно быть в пределах от 1 до 30!";

    }
}
