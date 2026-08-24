package atm;

public class CheckingAccount extends Account {

    private double overdraftLimit;   // example: 1000.0

    public CheckingAccount(String accountNumber, String ownerName,
                           double openingBalance, double overdraftLimit) {
        // TODO 1: super(...) first, then store overdraftLimit
        super(accountNumber, ownerName, openingBalance, overdraftLimit);
        this.overdraftLimit = overdraftLimit;

    }

    @Override
    public String getAccountType() {
        // TODO 2: return "CHECKING";
        return "CHECKING";

    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // TODO 3: reject amounts that are zero or negative first.
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0");
            }
            if ((balance - amount) <=  overdraftLimit){
                throw new InsufficientFundsException("Cannot be lesser than overdraft limit");
            }
            balance -= amount;


        // Otherwise call the protected helper you wrote in Task 1:
        //   applyWithdrawal(amount);
        //
        // NOTE: do NOT call super.withdraw(amount) here -- the parent
        // version refuses any negative balance, which is exactly the
        // rule this account is meant to relax.

