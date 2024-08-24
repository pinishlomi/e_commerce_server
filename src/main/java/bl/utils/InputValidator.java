package bl.utils;


import bl.general.Message;

public class InputValidator {

    public static Message checkInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            return Message.INVALID_INT;
        }
        return Message.SUCCESS;
    }

    public static Message checkFloat(String input) {
        try {
            Float.parseFloat(input);
        } catch (IllegalArgumentException e) {
            return Message.INVAliD_FLOAT;
        }
        return Message.SUCCESS;
    }

    public static Message checkString(String input) {
        if (!input.isEmpty()) {
            return Message.SUCCESS;
        }
        return Message.INVALID_NAME;
    }

}
