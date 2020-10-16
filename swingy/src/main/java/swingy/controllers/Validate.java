package swingy.controllers;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import swingy.models.Player;

public class Validate {
    private  Validator validator;
    public Validate(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public boolean validateClass(Player player){
        Set<ConstraintViolation<Player>> validationErrors = validator.validate(player);
        if (validationErrors.isEmpty()){
            return true;
        }
        else {
            for (ConstraintViolation<Player> error : validationErrors) {
                System.out.println(String.format("%s - %s [%s]", error.getPropertyPath().toString(), error.getMessage(), player.getPlayerName()));
            }
            validationErrors.clear();
        }
        return false;
    }
}