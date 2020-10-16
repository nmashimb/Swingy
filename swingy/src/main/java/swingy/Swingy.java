package swingy;
import swingy.controllers.*;
import swingy.views.*;
import swingy.models.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class Swingy
{
    public static void main( String[] args )
    {
        Validate v = new Validate();
        Player playerr = new Player();
        playerr.setPlayerName(null);
        v.validateClass(playerr);
      /*  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Player>> validationErrors = validator.validate(playerr);
        if (!validationErrors.isEmpty()) {
            for (ConstraintViolation<Player> error : validationErrors) {
                System.out.println(String.format("%s - %s [%s]", error.getPropertyPath().toString(), error.getMessage(), playerr.getPlayerName()));
            }
            validationErrors.clear();
        }*/


        if (args[0].trim().matches("console")){
            Player player = new Player();
            ConsoleView consoleView = new ConsoleView();
            ConsoleController consoleController = new ConsoleController(player, consoleView);
        }
        else if (args[0].trim().matches("gui")){
            Player player = new Player();
            GuiView gui = new GuiView();
            GuiController guiController = new GuiController(player, gui);
        }
        else{
            return;
        }
    }
}
