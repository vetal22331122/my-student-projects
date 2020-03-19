package accounts;

public class BankAccount {
    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    protected void setAmount(double amount) {
        this.amount = amount;
    }

    public void deposit (double deposit) {
        this.amount += deposit;
    }

    public void withdraw (double withdraw) {
        if (this.amount >= withdraw) {
            this.amount -= withdraw;
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}
