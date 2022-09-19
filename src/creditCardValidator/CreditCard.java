package creditCardValidator;


public class CreditCard {
    public static boolean isValidLength(String cardNumber) {
        boolean isValid = cardNumber.length() >= 13 && cardNumber.length() <= 16;
        if (isValid) return true;
        throw new CreditCardLengthException("Credit care length must be between 13 to 16 digit");

    }

    public static boolean isValidNumber(String cardNumber) {
        boolean isValidNumber = false;
        for (int i = 0; i < cardNumber.length() ; i++) {
            if (cardNumber.startsWith("4") || cardNumber.startsWith("5")
                    || cardNumber.startsWith("6") || cardNumber.startsWith("37")){
                isValidNumber = true;
                break;
            }
        }
        return isValidNumber;
    }
}
