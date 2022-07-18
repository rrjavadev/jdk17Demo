package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void shouldValidateInputsInDefaultConstructor() {
        Throwable t = catchThrowable(() -> new MyTestRecord(null, null));
        assertThat(t).isInstanceOf(NullPointerException.class);
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
}