package ippo.assignment2.command;

import ippo.assignment2.world.Model;

/**
 * A ForwardCommand class which implements the forward command without support of the second word.
 * This class is inspired by the textbook "Objects First with Java", Chapter 8.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class ForwardCommand extends Command {

    /**
     * Execute the forward command.
     *
     * @param model a Model object which delegates the command
     * @return true if the command executes successfully
     */
    @Override
    public boolean execute(Model model) {

        model.forward();
        return true;
    }
}
