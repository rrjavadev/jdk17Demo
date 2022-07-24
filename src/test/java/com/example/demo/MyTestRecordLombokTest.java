package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class MyTestRecordLombokTest {
    @Test
    void shouldValidateInputsInDefaultConstructor() {
        Throwable t = catchThrowable(() -> new MyTestRecordLombok(null, null));
        assertThat(t).isInstanceOf(NullPointerException.class);
    }
}