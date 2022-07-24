package com.example.demo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LegacyClassTest {

    @Test
    void testSerialization() throws IOException, ClassNotFoundException {

        LegacyClass legacyClass = new LegacyClass(null, null);
        var outputStream = Files.newOutputStream(Path.of("legacy-class-null-check.class"));
        var oos = new ObjectOutputStream(outputStream);
        oos.writeObject(legacyClass);
        System.out.println(oos);
//
//        var is = Files.newInputStream(Path.of("legacy-class-null-check.class"));
//        var ois = new ObjectInputStream(is);
//        System.out.println("Reading legacy");
//        var legacyClassRead = ois.readObject();
//        System.out.println("legacy = " + legacyClassRead);
    }
}