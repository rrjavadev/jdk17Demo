package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class MyTestRecordTest {

    @Test
    void shouldCreateARecord() {
        assertThat(new MyTestRecord("Roshini",
                """
                        103, BFC, Sutton
                        """)).isExactlyInstanceOf(MyTestRecord.class);
    }

    @Test
    void shouldTestEqual() {
        assertThat(new MyTestRecord("Roshini",
                """
                        103, BFC, Sutton
                        """)).isEqualTo(new MyTestRecord("Roshini",
                """
                        103, BFC, Sutton
                        """));
    }

    @Test
    void toStringTest() {
        assertThat(new MyTestRecord("Roshini",
                """
                        103, BFC, Sutton
                        """).toString())
                .isEqualTo("""
                MyTestRecord[name=Roshini, houseNumber=103, BFC, Sutton
                ]""");
    }

    @Test
    void shouldValidateInputsInDefaultConstructor() {
        Throwable t = catchThrowable(() -> new MyTestRecord(null, null));
        assertThat(t).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testSerialization() throws IOException, ClassNotFoundException {
//
//        MyTestRecord myTestRecord = new MyTestRecord(null, null);
//        var outputStream = Files.newOutputStream(Path.of("record-null-check.class"));
//        var oos = new ObjectOutputStream(outputStream);
//        oos.writeObject(myTestRecord);
//
        var is = Files.newInputStream(Path.of("record-null-check.class"));
        var ois = new ObjectInputStream(is);
        System.out.println("Reading record");
        var recordRead = ois.readObject();
        System.out.println("record = " + recordRead);
    }
}