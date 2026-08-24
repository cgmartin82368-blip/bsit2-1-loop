package atm;

public class InsufficientFundsException extends Exception {

    private final double shortfall;

    public InsufficientFundsException(double shortfall) {
        super("Insufficient funds. You are short by PHP "
                + String.format("%.2f", shortfall));

        // TODO 1: store the shortfall value in the field above
    }

    // TODO 2: add a public getter named getShortfall()
}
