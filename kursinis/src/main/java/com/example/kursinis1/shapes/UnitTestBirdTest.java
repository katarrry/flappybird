package com.example.kursinis1.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestBirdTest {

    Bird birdTest =  new Bird(60,1000,70,0);

    @Test
    void getX() {
        assertEquals(60, birdTest.getX());
    }

    @Test
    void getY() {
        assertEquals(1000, birdTest.getY());
    }

    @Test
    void getWidth() {
        assertEquals(70, birdTest.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(0, birdTest.getHeight());
    }
}