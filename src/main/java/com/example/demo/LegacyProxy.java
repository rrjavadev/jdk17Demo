package com.example.demo;

import com.example.demo.validator.NullValidator;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

import static com.example.demo.validator.NullValidator.validate;

public record LegacyProxy(String name, String houseNumber) implements Serializable {

    public LegacyProxy {
//        validate(name, houseNumber);
    }

    @Serial
    private Object readResolve() throws ObjectStreamException {
        System.out.println("I am creating the real object");
        return new LegacyProxy(name, houseNumber);
    }
}
