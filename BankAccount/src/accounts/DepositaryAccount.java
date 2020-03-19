package accounts;

public class DepositaryAccount extends BankAccount {
    private long lastDepositTime;

    public DepositaryAccount(double amount) {
        super(amount);
    }

    public void deposit (double amount) {
        this.setAmount(this.getAmount() + amount);
        this.lastDepositTime = System.currentTimeMillis();
    }

    public void withdraw (double amount) {
        if ((System.currentTimeMillis() - this.lastDepositTime) >= 2628002880L) {
            if (this.getAmount() >= amount) {
                this.setAmount(this.getAmount() - amount);
            } else {
                System.out.println("Недостаточно средств");
            }
        } else {
            System.out.println("Месяц еще не прошел");
        }
    }
}
