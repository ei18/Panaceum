package com.riwi.panaceum.utils.messages;

public class ErrorMessages {
    public static String idNotFound(String entity){
        final String message = "There are no records in the entity %s with the supplied id";
        return String.format(message, entity);
    }
}
