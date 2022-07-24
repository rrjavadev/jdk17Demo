package com.example.demo;

import lombok.NonNull;

import java.util.Objects;

public record MyTestRecordLombok(@NonNull String name, @NonNull String houseNumber) {
    public MyTestRecordLombok {
       if (Objects.isNull(name) || Objects.isNull(houseNumber)) {
           throw new IllegalArgumentException("Null not accepted!");
       }
    }
}
