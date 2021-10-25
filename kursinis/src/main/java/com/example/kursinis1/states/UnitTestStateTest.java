package com.example.kursinis1.states;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestStateTest {
    int score = 0;

    @Test
    void getScore() {
        assertEquals(score, State.getScore());
    }

}