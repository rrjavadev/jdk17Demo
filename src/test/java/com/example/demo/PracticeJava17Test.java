package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PracticeJava17Test {

    private PracticeJava17 unit;

    @BeforeEach
    public void setUp() {
        unit = new PracticeJava17();
    }

    @Test
    public void testTextBlocks() {
        unit.testTestBlocks();
    }

    @Test
    public void testNull() {
        unit.testNulls();
    }
    @Test
    public void testSwitchExpressions() {
        assertThat(unit.testSwitchExpressions("MONDAY")).isZero();
    }

    @Test
    public void testSwitchStatement() {
        assertThat(unit.testSwitchStatement("MONDAY")).isZero();
    }
}