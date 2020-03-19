package accounts;

public class CardAccount extends BankAccount {
    public CardAccount (double amount) {
        super(amount);
    }

    public void withdraw (double amount) {
        if (this.getAmount() >= amount * 1.01) {
            this.setAmount(this.getAmount() - amount * 1.01);
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}
