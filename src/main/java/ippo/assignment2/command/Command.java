package ippo.assignment2.command;

import ippo.assignment2.world.Model;

/**
 * An abstract Command class represents the superclass of all commands.
 * An optional secondWord is saved for each command to support specific actions.
 * If not defined, the value is null.
 * This class is inspired by the textbook "Objects First with Java", Chapter 8.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public abstract class Command {

    private String secondWord;

    /**
     * Init a command object. The object should have a corresponding command word.
     */
    public Command() {

        this.secondWord = null;
    }

    /**
     * Define the second word of this command. Null represents the command doesn't support second work.
     *
     * @param word2 a String represents a specific task
     */
    public void setSecondWord(String word2) {
        this.secondWord = word2;
    }

    /**
     * Get the second work of the command.
     *
     * @return a String of the second word. If not set, return null.
     */
    public String getSecondWord() {
        return this.secondWord;
    }

    /**
     * Check if the command has a second word or not.
     *
     * @return if the command has a second word, return true, else return false
     */
    public boolean hasSecondWord() {
        return this.secondWord != null;
    }

    /**
     * Execute this command.
     *
     * @param model a Model object which delegates the command
     * @return return a flag represents whether the command is executed successfully
     */
    public abstract boolean execute(Model model);
}
