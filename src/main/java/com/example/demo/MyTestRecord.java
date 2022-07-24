package com.example.demo;

import lombok.NonNull;

import java.io.Serializable;
import java.util.Objects;

 record MyTestRecord(String name, String houseNumber) implements Serializable {
    MyTestRecord {
//        if (Objects.isNull(name) || Objects.isNull(houseNumber)) {
//            throw new IllegalArgumentException("Null not accepted!");
//        }
    }
}
