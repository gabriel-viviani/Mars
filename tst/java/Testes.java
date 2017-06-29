/**
 * Created by gabriel on 6/28/17.
 */
import BO.Creater;
import BO.Instructions;
import Entity.Plateau;
import Entity.Robot;
import org.junit.Test;
import org.junit.Assert;

public class Testes {
    Instructions instructions = new Instructions();
    Creater create = new Creater();

    @Test
    public void createPlateau(){
        Plateau plateau = create.newPlateau(7, 8);
        Assert.assertEquals(7, plateau.getX());
        Assert.assertEquals(8, plateau.getY());
    }

    @Test
    public void setRobot(){
        Robot robo = create.createRobot("3 5 W");
        Assert.assertEquals(3, robo.getX());
        Assert.assertEquals(5, robo.getY());
        Assert.assertEquals('W', robo.getDirection());
    }

    @Test
    public void Moving() {
        Plateau plateau = create.newPlateau(6, 9);
        Robot robo = create.createRobot("1 5 N");
        instructions.processInstructions("RM", plateau, robo);
        Assert.assertEquals("2 5 E", robo.parseString());
        instructions.processInstructions("RM", plateau, robo);
        Assert.assertEquals("2 4 S", robo.parseString());
        instructions.processInstructions("RM", plateau, robo);
        Assert.assertEquals("1 4 W", robo.parseString());
        instructions.processInstructions("RM", plateau, robo);
        Assert.assertEquals("1 5 N", robo.parseString());
        instructions.processInstructions("LLMMMM", plateau, robo);
        Assert.assertEquals("1 1 S", robo.parseString());
    }

    @Test
    public void MoveOutside() {
        Plateau plateau = create.newPlateau(3, 3);
        Robot robo = create.createRobot("3 2 N");
        instructions.processInstructions("MMM", plateau, robo);
        Assert.assertEquals("3 3 N", robo.parseString());
        instructions.processInstructions("LLMMMM", plateau, robo);
        Assert.assertEquals("3 0 S", robo.parseString());
        instructions.processInstructions("RMMMM", plateau, robo);
        Assert.assertEquals("0 0 W", robo.parseString());
        instructions.processInstructions("RMMMMLMMM", plateau, robo);
        Assert.assertEquals("0 3 W", robo.parseString());
    }
}
