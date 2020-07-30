package ippo.assignment2.command;

import ippo.assignment2.world.Model;

public class SwitchPlayerCommand extends Command {

    /**
     * Switch the player that we are playing with.
     *
     * @param model a Model object which delegates the command
     * @return true if the command executes successfully
     */
    @Override
    public boolean execute(Model model) {

        model.switchPlayer(this.getSecondWord());
        return true;
    }
}
