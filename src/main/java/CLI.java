package com.sonneveld.ToyRobot;

import java.io.*;
import java.util.Scanner;

public class CLI {
    static public void run(String[] args) {
        if (args.length > 0) {
            try {
                InputStream inputStream = new FileInputStream(args[0]);
                process(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            process(System.in);
        }
    }

    static public void process(InputStream input) {
        Robot robot = new Robot();
        String rawCommand = "";
        String rawCommandArgs = "";

        Scanner scanner = new Scanner(input);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.equals("EXIT")) {
                break;
            }

            String[] rawCommands = line.split(" ");

            if (rawCommands.length > 0) {
                rawCommand = rawCommands[0];

                if (rawCommands.length > 1) {
                    rawCommandArgs = rawCommands[1];
                }
                else {
                    rawCommandArgs = "";
                }
            }
            else {
                rawCommand = "";
            }

            robot.exec(rawCommand, rawCommandArgs);
        }
    }
}
