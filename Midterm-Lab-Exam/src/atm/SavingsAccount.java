package atm;

public class SavingsAccount extends Account {
    private double balance;// hidden
    public double getBalance() {               // controlled read
        return balance;
    }


    public static final double MAINTAINING_BALANCE = 500.0;

    private double interestRate;   // example: 0.02 means 2% per year

    public SavingsAccount(String accountNumber, String ownerName,
                          double openingBalance, double interestRate) {
        // TODO 1: call the parent constructor FIRST
           super(accountNumber, ownerName, openingBalance);

        // TODO 2: then store interestRate in this object
        super(monthlyInterest);
    }


    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // TODO 3: compute what the balance WOULD become:
        //   double remaining = getBalance() - amount;

        // If remaining < MAINTAINING_BALANCE, throw a new
        // InsufficientFundsException with the shortfall as the argument.
        if (amount <= 0){
            throw new IllegalArgumentException("Cannot be zero.");
        }
        if (amount > balance){
            throw new InsufficientFundsException(amount - balance);
        }
        else{
            balance = balance - amount;
        }
    }
    if (remaining < MAINTAINING_BALANCE){
        throw new InsufficientFundsException("remaing is lower than maintaining balance");
    }

            // Otherwise reuse the parent logic:
    else{
    super.withdraw(amount);
    }

    public double monthlyInterest() {
        // TODO 4: return getBalance() * interestRate / 12;
        balance = interestRate / 12;
        return Balance;
    }
}
