package ippo.assignment2.command;

import ippo.assignment2.world.Model;

/**
 * A TurnCommand class which implements the turn command which the second command word represents the direction.
 * This class is inspired by the textbook "Objects First with Java", Chapter 8.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class TurnCommand extends Command {

    /**
     * Execute the turn command.
     *
     * @param model a Model object which delegates the command
     * @return true if the command executes successfully
     */
    @Override
    public boolean execute(Model model) {

        if (!this.hasSecondWord()) {
            return false;
        }
        switch (this.getSecondWord()) {
            case "Left":
                model.turnLeft();
                break;
            case "Right":
                model.turnRight();
                break;
        }
        return true;
    }
}