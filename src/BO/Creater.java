package BO;

import Entity.Plateau;
import Entity.Robot;

/**
 * Created by gabriel on 6/27/17.
 */
public class Creater {
    public Plateau newPlateau(int x, int y){
        return new Plateau(x, y);
    }

    public Robot createRobot(String coord){
        String [] values = coord.split(" ", 3);
        return new Robot(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2].charAt(0));
    }

}
