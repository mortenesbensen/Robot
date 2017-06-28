package mesb.jayway.dk.robot.robot;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {

	public static List<Instruction> parseInstructionString(String is) {
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();

		for (char c : is.toCharArray()) {
			instructions.add(Instruction.valueOf(Character.toString(c)));
		}
		return instructions;
	}
}
