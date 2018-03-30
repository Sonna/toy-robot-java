package com.sonneveld.ToyRobot;

import java.util.*;
// import java.util.Map;

public class Robot {
    private static final Map<String, Map<String, String>> TURN;
    static {
        Map<String, String> north = new HashMap();
        north.put("LEFT", "WEST");
        north.put("RIGHT", "EAST");
        Map<String, String> west = new HashMap();
        west.put("LEFT", "SOUTH");
        west.put("RIGHT", "NORTH");
        Map<String, String> south = new HashMap();
        south.put("LEFT", "EAST");
        south.put("RIGHT", "WEST");
        Map<String, String> east = new HashMap();
        east.put("LEFT", "NORTH");
        east.put("RIGHT", "SOUTH");

        Map<String, Map<String, String>> turnMap = new HashMap();
        turnMap.put("NORTH", north);
        turnMap.put("WEST", west);
        turnMap.put("SOUTH", south);
        turnMap.put("EAST", east);
        TURN = Collections.unmodifiableMap(turnMap);
    }

    private static final Map<String, Map<String, Integer>> MOVE;
    static {
        Map<String, Integer> north = new HashMap();
        north.put("x", 0);
        north.put("y", 1);
        Map<String, Integer> west = new HashMap();
        west.put("x", -1);
        west.put("y", 0);
        Map<String, Integer> south = new HashMap();
        south.put("x", 0);
        south.put("y", -1);
        Map<String, Integer> east = new HashMap();
        east.put("x", 1);
        east.put("y", 0);

        Map<String, Map<String, Integer>> moveMap = new HashMap();
        moveMap.put("NORTH", north);
        moveMap.put("WEST", west);
        moveMap.put("SOUTH", south);
        moveMap.put("EAST", east);
        MOVE = Collections.unmodifiableMap(moveMap);
    }

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
        System.out.format("%d,%d,%s\n", this.x, this.y, this.facing);
    }

    public void left() {
        this.facing = TURN.get(this.facing).get("LEFT");
    }

    public void right() {
        this.facing = TURN.get(this.facing).get("RIGHT");
    }

    public void move() {
        this.x += MOVE.get(this.facing).get("x");
        this.y += MOVE.get(this.facing).get("y");

        if (this.x < 0 || this.x > 4) {
            this.x -= MOVE.get(this.facing).get("x");
        }

        if (this.y < 0 || this.y > 4) {
            this.y -= MOVE.get(this.facing).get("y");
        }
    }

    public void place(String rawCoordinates) {
        String[] coordinates = rawCoordinates.split(",");
        this.x = Integer.parseInt(coordinates[0]);
        this.y = Integer.parseInt(coordinates[1]);
        this.facing = coordinates[2];
    }
}
