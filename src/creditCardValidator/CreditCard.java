package creditCardValidator;


public class CreditCard {
    public static boolean isValidLength(String cardNumber) {
        boolean isValid = cardNumber.length() >= 13 && cardNumber.length() <= 16;
        if (isValid) return true;
        throw new CreditCardLengthException("Credit care length must be between 13 to 16 digit");

    }

    public static boolean isValidNumber(String cardNumber) {
        boolean isValidNumber = false;
        for (int i = 0; i < cardNumber.length(); i++) {
            if (cardNumber.startsWith("4") || cardNumber.startsWith("5")
                    || cardNumber.startsWith("6") || cardNumber.startsWith("37")) {
                isValidNumber = true;
                break;
            }
            throw new InvalidCreditCardNumberException("Credit card must start with 4, 5, 6 or 37");
        }
        return isValidNumber;
    }

    public static long sumOfDoubleEvenDigit(String cardNumber) {
        long sum = 0;
        String value = "";
        for (int i = cardNumber.length() - 2; i >= 0; i -= 2) {
            value = String.valueOf(cardNumber.charAt(i));
            long result = Long.parseLong(value) * 2;
            sum += getResult(result);
        }
        return sum;
    }

    private static long getResult(long result) {
        if (result < 9) return result;
        return addNumber(result);
    }

    private static long addNumber(long number) {
        long decimal = number / 10;
        long modulo = number % 10;
        return decimal + modulo;
    }

    public static long sumOfOddPlaceDigit(String cardNumber) {
        long sum = 0;
        String value = "";
        for (int i = cardNumber.length() - 1; i >= 0; i-=2) {
            value = String.valueOf(cardNumber.charAt(i));
            long result = Long.parseLong(value);
            sum += result;
        }
        return sum;
    }

    public static long add(String cardNumber){
        return sumOfOddPlaceDigit(cardNumber) + sumOfDoubleEvenDigit(cardNumber);
    }

    public static boolean isValidCreditCard(String cardNumber) {
        if (add(cardNumber) % 10 == 0 ) return true;
        throw new InvalidCreditCardNumberException("Credit Card is invalid");
    }
}
