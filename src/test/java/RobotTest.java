package com.sonneveld.ToyRobot;

import java.io.*;

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

    @Test public void testReport() {
        Robot subject = new Robot();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        subject.report();

        assertEquals("0,0,NORTH\n", baos.toString());
        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("NORTH", subject.facing);
    }

    @Test public void testReportOnNonDefaultRobot() {
        Robot subject = new Robot(3, 2, "EAST");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        subject.report();

        assertEquals("3,2,EAST\n", baos.toString());
        assertEquals(3, subject.x);
        assertEquals(2, subject.y);
        assertEquals("EAST", subject.facing);
    }

    @Test public void testLeft() {
        Robot subject = new Robot();
        subject.left();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("WEST", subject.facing);
    }

    @Test public void testLeftFromWEST() {
        Robot subject = new Robot(0, 0, "WEST");
        subject.left();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("SOUTH", subject.facing);
    }

    @Test public void testLeftFromSOUTH() {
        Robot subject = new Robot(0, 0, "SOUTH");
        subject.left();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("EAST", subject.facing);
    }

    @Test public void testLeftFromEAST() {
        Robot subject = new Robot(0, 0, "EAST");
        subject.left();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("NORTH", subject.facing);
    }
    @Test public void testRight() {
        Robot subject = new Robot();
        subject.right();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("EAST", subject.facing);
    }

    @Test public void testRightFromEAST() {
        Robot subject = new Robot(0, 0, "EAST");
        subject.right();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("SOUTH", subject.facing);
    }

    @Test public void testRightFromSOUTH() {
        Robot subject = new Robot(0, 0, "SOUTH");
        subject.right();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("WEST", subject.facing);
    }

    @Test public void testRightFromWEST() {
        Robot subject = new Robot(0, 0, "WEST");
        subject.right();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("NORTH", subject.facing);
    }
}
