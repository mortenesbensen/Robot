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

    Grid grid = new Grid(5, 5);

    @Test
    public void parseInput() {
        String input = "LRF";
        List<Instruction> ins = Arrays.asList(Instruction.L, Instruction.R, Instruction.F);
        assertThat(InstructionParser.parseInstructionString(input), is(ins));
    }

    @Test
    public void singleStep() {
        Robot r = new Robot(0, 0, Direction.E, grid);
        List<Instruction> ins = InstructionParser.parseInstructionString("F");
        r.processInstructions(ins);
        String finalPosition = "1 0 E";
        assertThat(r.getPosition().toString(), is(finalPosition));
    }

    @Test
    public void moveToFar() {
        Robot r = new Robot(0, 0, Direction.E, grid);
        List<Instruction> ins = InstructionParser.parseInstructionString("FFFFFFF");
        r.processInstructions(ins);
        String finalPosition = "4 0 E";
        assertThat(r.getPosition().toString(), is(finalPosition));
    }

    @Test
    public void moveDiagonal() {
        Robot r = new Robot(0, 0, Direction.N, grid);
        List<Instruction> ins = InstructionParser.parseInstructionString("RRFLFRFLFRFLFRFLF");
        r.processInstructions(ins);
        String finalPosition = "4 4 E";
        assertThat(r.getPosition().toString(), is(finalPosition));
    }

   @Test
    public void moveAllAround() {
        Robot r = new Robot(0, 0, Direction.N, grid);
        List<Instruction> ins = InstructionParser.parseInstructionString("RFFFFRFFFFRFFFFRFFFF");
        r.processInstructions(ins);
        String finalPosition = "0 0 N";
        assertThat(r.getPosition().toString(), is(finalPosition));

    }
}
