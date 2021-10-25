package com.example.kursinis1.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestShapeFactoryTest {

    ShapeFactory shapeFactory = new ShapeFactory();

    @Test
    void getShape() {
        assertNull((shapeFactory.getShape("0")));
    }

}