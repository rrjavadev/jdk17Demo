package com.example.demo;

import com.example.demo.validator.NullValidator;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import static com.example.demo.validator.NullValidator.validate;

public class LegacyClass implements Serializable {

    private final String name;
    private final String houseNumber;

    public LegacyClass(String name, String houseNumber) {
//        validate(name, houseNumber);
        this.name = name;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "RangeLegacy{" +
                "name=" + name +
                ", houseNumber=" + houseNumber +
                '}';
    }

    @Serial
    private Object writeReplace() throws ObjectStreamException {
        System.out.println("I am serializing a record proxy");
        return new LegacyProxy(name, houseNumber);
    }
}
