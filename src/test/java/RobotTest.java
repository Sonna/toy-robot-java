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

    @Test public void testMove() {
        Robot subject = new Robot();
        subject.move();

        assertEquals(0, subject.x);
        assertEquals(1, subject.y);
        assertEquals("NORTH", subject.facing);
    }

    @Test public void testMoveEAST() {
        Robot subject = new Robot(0, 0, "EAST");
        subject.move();

        assertEquals(1, subject.x);
        assertEquals(0, subject.y);
        assertEquals("EAST", subject.facing);
    }

    @Test public void testMoveWESTfrom11() {
        Robot subject = new Robot(1, 1, "WEST");
        subject.move();

        assertEquals(0, subject.x);
        assertEquals(1, subject.y);
        assertEquals("WEST", subject.facing);
    }

    @Test public void testMoveSOUTHfrom11() {
        Robot subject = new Robot(1, 1, "SOUTH");
        subject.move();

        assertEquals(1, subject.x);
        assertEquals(0, subject.y);
        assertEquals("SOUTH", subject.facing);
    }

    @Test public void testMoveDoesNotFallOffTableFrom00SOUTH() {
        Robot subject = new Robot(0, 0, "SOUTH");
        subject.move();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("SOUTH", subject.facing);
    }

    @Test public void testMoveDoesNotFallOffTableFrom00WEST() {
        Robot subject = new Robot(0, 0, "WEST");
        subject.move();

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("WEST", subject.facing);
    }

    @Test public void testMoveDoesNotFallOffTableFrom04WEST() {
        Robot subject = new Robot(0, 4, "WEST");
        subject.move();

        assertEquals(0, subject.x);
        assertEquals(4, subject.y);
        assertEquals("WEST", subject.facing);
    }

    @Test public void testMoveDoesNotFallOffTableFrom04NORTH() {
        Robot subject = new Robot(0, 4, "NORTH");
        subject.move();

        assertEquals(0, subject.x);
        assertEquals(4, subject.y);
        assertEquals("NORTH", subject.facing);
    }

    @Test public void testMoveDoesNotFallOffTableFrom44NORTH() {
        Robot subject = new Robot(4, 4, "NORTH");
        subject.move();

        assertEquals(4, subject.x);
        assertEquals(4, subject.y);
        assertEquals("NORTH", subject.facing);
    }

    @Test public void testMoveDoesNotFallOffTableFrom44EAST() {
        Robot subject = new Robot(4, 4, "EAST");
        subject.move();

        assertEquals(4, subject.x);
        assertEquals(4, subject.y);
        assertEquals("EAST", subject.facing);
    }

    @Test public void testMoveDoesNotFallOffTableFrom04EAST() {
        Robot subject = new Robot(4, 0, "EAST");
        subject.move();

        assertEquals(4, subject.x);
        assertEquals(0, subject.y);
        assertEquals("EAST", subject.facing);
    }

    @Test public void testMoveDoesNotFallOffTableFrom04SOUTH() {
        Robot subject = new Robot(4, 0, "SOUTH");
        subject.move();

        assertEquals(4, subject.x);
        assertEquals(0, subject.y);
        assertEquals("SOUTH", subject.facing);
    }

    @Test public void testPlace() {
        Robot subject = new Robot();
        subject.place("3,3,EAST");

        assertEquals(3, subject.x);
        assertEquals(3, subject.y);
        assertEquals("EAST", subject.facing);
    }

    @Test public void testPlace42WEST() {
        Robot subject = new Robot();
        subject.place("4,2,WEST");

        assertEquals(4, subject.x);
        assertEquals(2, subject.y);
        assertEquals("WEST", subject.facing);
    }

    @Test public void testExecPlace() {
        Robot subject = new Robot();
        subject.exec("PLACE", "3,1,SOUTH");

        assertEquals(3, subject.x);
        assertEquals(1, subject.y);
        assertEquals("SOUTH", subject.facing);
    }

    @Test public void testExecMove() {
        Robot subject = new Robot();
        subject.exec("MOVE", "");

        assertEquals(0, subject.x);
        assertEquals(1, subject.y);
        assertEquals("NORTH", subject.facing);
    }

    @Test public void testExecLeft() {
        Robot subject = new Robot();
        subject.exec("LEFT", "");

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("WEST", subject.facing);
    }

    @Test public void testExecRight() {
        Robot subject = new Robot();
        subject.exec("RIGHT", "");

        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("EAST", subject.facing);
    }

    @Test public void testExecReport() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        Robot subject = new Robot();
        subject.exec("REPORT", "");

        assertEquals("0,0,NORTH\n", baos.toString());
        assertEquals(0, subject.x);
        assertEquals(0, subject.y);
        assertEquals("NORTH", subject.facing);
    }
}
