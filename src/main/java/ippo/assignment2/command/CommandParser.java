package ippo.assignment2.command;

import java.util.StringTokenizer;

/**
 * A CommandParser class which parsers the command work to a corresponding Command object with given second word.
 * This class is inspired by the textbook "Objects First with Java", Chapter 8.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class CommandParser {

    private CommandWords commandWords;

    /**
     * Init a CommandParser object with all available command words.
     */
    public CommandParser() {

        this.commandWords = new CommandWords();
    }

    /**
     * Get a Command object of the given command word.
     * Set the second word properly first.
     *
     * @param commandWord a String of a given command
     * @return a Command class of the corresponding command word. Null means the command word is not supported yet
     */
    public Command getCommand(String commandWord) {

        String word1;
        String word2;

        StringTokenizer tokenizer = new StringTokenizer(commandWord);

        if (tokenizer.hasMoreTokens()) {
            word1 = tokenizer.nextToken();
        } else {
            word1 = null;
        }

        if (tokenizer.hasMoreTokens()) {
            word2 = tokenizer.nextToken();
        } else {
            word2 = null;
        }

        Command command = commandWords.get(word1);
        if (command != null) {
            command.setSecondWord(word2);
        }
        return command;
    }
}
