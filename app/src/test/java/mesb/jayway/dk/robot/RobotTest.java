package mesb.jayway.dk.robot;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import mesb.jayway.dk.robot.robot.Direction;
import mesb.jayway.dk.robot.robot.Grid;
import mesb.jayway.dk.robot.robot.Instruction;
import mesb.jayway.dk.robot.robot.Robot;
import mesb.jayway.dk.robot.robot.util.InstructionParser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Morten on 29/06/2017.
 */

public class RobotTest {

    @Test
    public void parseInput() {
        String input = "LRF";
        List<Instruction> ins = Arrays.asList(Instruction.L, Instruction.R, Instruction.F);
        assertThat(InstructionParser.parseInstructionString(input), is(ins));
    }

    @Test
    public void processIntructions() {
        Grid grid = new Grid(5, 5);
        Robot r = new Robot(1, 2, Direction.N, grid);
        List<Instruction> ins = Arrays.asList(Instruction.R, Instruction.F, Instruction.F);
        r.processInstructions(ins);
        String finalPosition = "3 2 E";
        assertThat(r.getPosition().toString(), is(finalPosition));
    }

    @Test
    public void moveRobot() {
        Grid grid = new Grid(2, 2);
        Robot r = new Robot(0, 0, Direction.E, grid);
        Instruction i = Instruction.F;
        r.doMove(i);
        String position = "1 0 E";
        assertThat(r.getPosition().toString(), is(position));
    }
}
