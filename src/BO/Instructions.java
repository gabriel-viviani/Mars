package BO;

import Entity.Plateau;
import Entity.Robot;

/**
 * Created by gabriel on 6/27/17.
 */
public class Instructions {

    public void processInstructions(String instructions, Plateau plateau, Robot robot){
        for(int i=0; i<instructions.length(); i++){
            execInstructions(instructions.charAt(i), plateau, robot);
        }
    }

    private void execInstructions(char instruction, Plateau plateau, Robot robot){
        switch (instruction){
            case 'L': TurnLeft(robot);
                break;
            case 'R': TurnRigth(robot);
                break;
            case 'M': Move(plateau, robot);
                break;
            default: break;

        }
    }

    private void TurnLeft(Robot robot){
        char direction = robot.getDirection();
        switch (direction){
            case 'N':
                robot.setDirection('W');
                break;
            case 'W':
                robot.setDirection('S');
                break;
            case 'S':
                robot.setDirection('E');
                break;
            case 'E':
                robot.setDirection('N');
                break;
            default: break;
        }
    }

    private void TurnRigth(Robot robot){
        char direction = robot.getDirection();
        switch (direction){
            case 'N':
                robot.setDirection('E');
                break;
            case 'W':
                robot.setDirection('N');
                break;
            case 'S':
                robot.setDirection('W');
                break;
            case 'E':
                robot.setDirection('S');
                break;
            default: break;
        }
    }

    private void Move(Plateau plateau, Robot robot){
        char direction = robot.getDirection();
        int x = robot.getX();
        int y = robot.getY();

        switch (direction){
            case 'N':
                if(y < plateau.getY()) {
                    robot.setY(y + 1);
                }
                break;
            case 'S':
                if(y>0) {
                    robot.setY(y - 1);
                }
                break;
            case 'E':
                if(x < plateau.getX()) {
                    robot.setX(x + 1);
                }
                break;
            case 'W':
                if(x>0) {
                    robot.setX(x - 1);
                }
                break;
            default: break;
        }
        robot.setTragetoryLog(robot);
    }
}
