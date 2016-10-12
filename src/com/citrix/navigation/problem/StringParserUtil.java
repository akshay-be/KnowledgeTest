package com.citrix.navigation.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The given string will be parsed here.
 * @author AkshayB1
 *
 */
public class StringParserUtil {

	private static Map<Character, Command> charCommandMap = null;
	
	private String commandStr;

	static {
		charCommandMap = new HashMap<Character, Command>();
		charCommandMap.put('L', new RotateLeftCommand());
		charCommandMap.put('R', new RotateRightCommand());
		charCommandMap.put('M', new MoveCommand());
	}
	
	
	public StringParserUtil(String commandString) {
        this.commandStr = commandString;
    }
	
	/**
	 * Converts the String into the command map by reading character by
	 * character.
	 * 
	 * @return
	 */
	public List<Command> toCommands() {
		List<Command> commadList = new ArrayList<Command>();
		if (commandStr != null && !commandStr.isEmpty()) {
			for (int i = 0; i < commandStr.length(); i++) {
				Character commandCharacter = commandStr.charAt(i);
				Command mappedCommand = charCommandMap.get(Character.toUpperCase(commandCharacter));
				if(mappedCommand!=null){
					commadList.add(mappedCommand);
				}else{
					System.out.println("In-Valid Character is ignored....");
				}
			}
		} 
		return commadList;
	}
}
