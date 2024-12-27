package ru.netology.javaqa.collections;

import javax.management.RuntimeErrorException;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String s) {
        super(s);
    }
}
