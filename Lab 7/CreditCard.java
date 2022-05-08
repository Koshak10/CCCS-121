public class CreditCard {

    private Person owner;
    private Money balance;
    private Money creditLimit;

    public CreditCard(Person newCardHolder, Money limit) {
        owner = newCardHolder;
        creditLimit = new Money(limit);
        balance = new Money(0);
    }

    public Money getBalance() {
        return new Money(balance);
    }

    public Money getCreditLimit() {
        return new Money(creditLimit);
    }

    public String getPersonals() {
        return owner.toString();
    }

    public void charge(Money amount) {
        Money total = amount.add(balance);
        if (total.compareTo(creditLimit) == -1) {
            balance = balance.add(amount);
            System.out.println("Charge: " + amount);
        } else {
            System.out.println("Exceeds credit limit");
        }
    }

    public void payment(Money amount) {
        balance = balance.subtract(amount);
        System.out.println("Payment: " + amount);
    }
}
