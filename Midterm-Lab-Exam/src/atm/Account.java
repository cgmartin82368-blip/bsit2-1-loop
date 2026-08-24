package atm;

}public abstract class Account {

    // TODO 1: change these three fields to private
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double openingBalance) {
        // TODO 2: validate before assigning. Example:
          if (ownerName == null || ownerName.isBlank()) {
               throw new IllegalArgumentException("Owner name is required");
          }
        //   Do the same for accountNumber, and reject openingBalance < 0.
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number is required");
        }

        if (openingBalance < 0 ) {
            throw new IllegalArgumentException("Account number is required");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    // TODO 3: write the three getters here.
    //         Remember: NO setBalance().
    public String getaccountNumber{
        return accountNumber;

    }
    public String getownerName{
        return ownerName;

    }
    public int openingBalance{
        return openingBalance;

    }
}

    public void deposit(double amount) {
        // TODO 4: if amount <= 0 -> throw new IllegalArgumentException("...")
        //         otherwise      -> balance = balance + amount;
        if (amount <= 0){
            throw new IllegalArgumentException("Cannot be zero.");
        }
        else{
            double balance = balance + amount;
        }
    }

    public void withdraw(double amount, double balance) throws InsufficientFundsException {
        // TODO 5: if amount <= 0     -> throw new IllegalArgumentException("...")
        //         if amount > balance -> throw new InsufficientFundsException(amount - balance)
        //         otherwise           -> balance = balance - amount;
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

    // TODO 6: leave this abstract. Each child class will answer it differently.
    public abstract String getAccountType();

    // TODO 7: this helper is for your subclasses only.
    //         protected means: visible to child classes, hidden from everyone else.
    protected void applyWithdrawal(double amount) {
        // balance = balance - amount;
    }

    @Override
    public String toString() {
        return getAccountType() + " " + accountNumber + " (" + ownerName + ")";
    }


