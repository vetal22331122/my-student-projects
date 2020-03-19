package clients;

public class Individual extends Client {
    public Individual (double amount) {
        super(amount);
    }

    public void deposit (double amount) {
        this.setAmount(this.getAmount() + amount);
    }

    public void withdraw (double amount) {
        if (this.getAmount() >= amount) {
            this.setAmount(this.getAmount() - amount);
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}
