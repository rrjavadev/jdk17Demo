package com.example.demo;

import lombok.NonNull;

import java.util.Objects;

public record MyTestRecord(@NonNull String name, @NonNull String houseNumber) {
//    public MyTestRecord{
//       if (Objects.isNull(name) ||
//        Objects.isNull(houseNumber)) {
//           throw new NullPointerException();
//       }
//    }
}
