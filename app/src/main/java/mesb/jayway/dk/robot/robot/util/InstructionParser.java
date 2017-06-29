package mesb.jayway.dk.robot.robot.util;

import java.util.ArrayList;
import java.util.List;

import mesb.jayway.dk.robot.robot.Instruction;

/**
 * Takes a string of instructions and parses them
 */
public class InstructionParser {

    public static List<Instruction> parseInstructionString(String is) {
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();

        for (char c : is.toCharArray()) {
            instructions.add(Instruction.valueOf(Character.toString(c)));
        }
        return instructions;
    }
}
