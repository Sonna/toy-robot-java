package com.sonneveld.ToyRobot;

public class Robot {
    int x;
    int y;
    String facing;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.facing = "NORTH";
    }

    public Robot(int x) {
        this.x = x;
        this.y = 0;
        this.facing = "NORTH";
    }

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
        this.facing = "NORTH";
    }

    public Robot(int x, int y, String facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public void report() {
        System.out.println("0,0,NORTH");
    }
}
