package Entity;

import java.util.ArrayList;
/**
 * Created by gabriel on 6/26/17.
 */
public class Robot {
    private int x;
    private int y;
    private char Direction;

    public Robot(int x, int y, char Direction){
        this.x = x;
        this.y = y;
        this.Direction = Direction;
    }

    ArrayList<Robot> tragetoryLog = new ArrayList<Robot>();

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setDirection(char direction) {
        Direction = direction;
    }

    public char getDirection() {
        return Direction;
    }

    public ArrayList<Robot> getTragetoryLog() {
        return tragetoryLog;
    }

    public void setTragetoryLog(Robot robo) {
        this.tragetoryLog.add(robo);
    }

    public String parseString() {
        return "" + x + " " + y + " " + Direction;
    }
}
