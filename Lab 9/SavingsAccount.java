public class SavingsAccount extends BankAccount {

    private double rate = 0.025;
    private int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String name, double amount) {
        super(name, amount);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount);
        this.savingsNumber = oldAccount.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public void postInterest() {
        double interestAmount = getBalance() * rate / 12;
        double finalAmount = getBalance() + interestAmount;
        setBalance(finalAmount);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}
