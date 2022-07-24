package com.example.demo.validator;

import com.example.demo.LegacyProxy;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class NullValidator {
    public static void validate(String name, String houseNumber) {
        if (Objects.isNull(name) || Objects.isNull(houseNumber)) {
            throw new IllegalArgumentException("Null not accepted!");
        }
    }
}
