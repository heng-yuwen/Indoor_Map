package ippo.assignment2.command;

import java.util.HashMap;

/**
 * A CommandWords class which relates the command word with actual Command objects.
 * This class is inspired by the textbook "Objects First with Java", Chapter 8.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class CommandWords {

    private HashMap<String, Command> stringToCommand;

    /**
     * Init a CommandWords object with all pre-defined first command strings.
     */
    public CommandWords() {
        this.stringToCommand = new HashMap<>();
        this.stringToCommand.put("Turn", new TurnCommand());
        this.stringToCommand.put("Forward", new ForwardCommand());
        this.stringToCommand.put("Pickup", new PickItemCommand());
        this.stringToCommand.put("Put", new PutItemCommand());
        this.stringToCommand.put("Switch", new SwitchPlayerCommand());
    }

    /**
     * Get the corresponding Command object with given first command word
     *
     * @param word1 a String represents the first command word
     * @return a Command object corresponding to the first command word, null means the command is not supported
     */
    public Command get(String word1) {

        return this.stringToCommand.get(word1);
    }
}
