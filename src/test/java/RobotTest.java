package com.sonneveld.ToyRobot;

import org.junit.Test;
import static org.junit.Assert.*;

public class RobotTest {
    @Test public void testConstructorNoArguments() {
        Robot subject = new Robot();
        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("NORTH", subject.facing);
    }

    @Test public void testConstructorOneArguments() {
        Robot subject = new Robot(1);
        assertEquals(1, subject.x);
        assertEquals(0, subject.y);
        assertEquals("NORTH", subject.facing);
    }

    @Test public void testConstructorTwoArguments() {
        Robot subject = new Robot(1, 2);
        assertEquals(1, subject.x);
        assertEquals(2, subject.y);
        assertEquals("NORTH", subject.facing);
    }

    @Test public void testConstructorThreeArguments() {
        Robot subject = new Robot(1, 2, "SOUTH");
        assertEquals(1, subject.x);
        assertEquals(2, subject.y);
        assertEquals("SOUTH", subject.facing);
    }
}
