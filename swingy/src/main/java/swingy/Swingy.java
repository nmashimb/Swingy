package swingy;
import swingy.controllers.*;
import swingy.views.*;
import swingy.models.*;

public class Swingy
{
    public static void main( String[] args )
    {
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