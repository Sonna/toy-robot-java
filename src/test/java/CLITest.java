package com.sonneveld.ToyRobot;

import java.io.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class CLITest {
    @Test public void testRunExampleA() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String[] subject = {"examples/example_a.txt"};

        CLI.run(subject);
        assertEquals("0,0,NORTH\n", baos.toString());
    }

    @Test public void testRunExampleB() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String[] subject = {"examples/example_b.txt"};

        CLI.run(subject);
        assertEquals("0,0,WEST\n", baos.toString());
    }

    @Test public void testRunExampleC() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String[] subject = {"examples/example_c.txt"};

        CLI.run(subject);
        assertEquals("3,3,NORTH\n", baos.toString());
    }

    @Test public void testProcessExampleA() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String filename = "examples/example_a.txt";

        try {
            InputStream subject = new FileInputStream(filename);
            CLI.process(subject);
            assertEquals("0,0,NORTH\n", baos.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test public void testProcessExampleB() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String filename = "examples/example_b.txt";

        try {
            InputStream subject = new FileInputStream(filename);
            CLI.process(subject);
            assertEquals("0,0,WEST\n", baos.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test public void testProcessExampleC() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String filename = "examples/example_c.txt";

        try {
            InputStream subject = new FileInputStream(filename);
            CLI.process(subject);
            assertEquals("3,3,NORTH\n", baos.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test public void testProcessEXIT() {
        String subject = "EXIT\n";
        ByteArrayInputStream bais =
          new ByteArrayInputStream(subject.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        CLI.process(System.in);
        // CLI.process(bais);
        // CLI.run();
        assertEquals("", baos.toString());
    }

    @Test public void testRunREPORT() {
        String subject = "REPORT\nEXIT\n";
        ByteArrayInputStream bais =
          new ByteArrayInputStream(subject.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String[] emptyArgs = {};
        CLI.run(emptyArgs);

        assertEquals("0,0,NORTH\n", baos.toString());
    }

    @Test public void testRunComplexCommands() {
        String subject = "MOVE\nREPORT\nRIGHT\nMOVE\nREPORT\nPLACE 3,3,SOUTH" +
            "\nREPORT\nRIGHT\nREPORT\nEXIT\n";
        ByteArrayInputStream bais =
            new ByteArrayInputStream(subject.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String[] emptyArgs = {};
        CLI.run(emptyArgs);

        assertEquals(
            "0,1,NORTH\n1,1,EAST\n3,3,SOUTH\n3,3,WEST\n", baos.toString()
        );
    }
}
