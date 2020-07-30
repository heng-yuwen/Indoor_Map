package ippo.assignment2.command;

import ippo.assignment2.world.Model;

/**
 * A PickItemCommand class which implements the pickup command which the second command word represents the item name.
 * This class is inspired by the textbook "Objects First with Java", Chapter 8.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class PickItemCommand extends Command {

    /**
     * Execute the pickup command.
     *
     * @param model a Model object which delegates the command
     * @return true if the command executes successfully
     */
    @Override
    public boolean execute(Model model) {

        if (!this.hasSecondWord()) {
            return false;
        }

        model.playerPickItem(this.getSecondWord());
        return true;
    }
}
