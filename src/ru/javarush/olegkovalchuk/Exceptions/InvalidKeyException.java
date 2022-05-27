package ru.javarush.olegkovalchuk.Exceptions;

import java.io.IOException;

public class InvalidKeyException extends RuntimeException {
    public InvalidKeyException() {
    }

    public InvalidKeyException(String message) {
        super(message);
    }
}
