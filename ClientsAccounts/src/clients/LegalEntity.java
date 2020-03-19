package clients;

public class LegalEntity extends Client {
    public LegalEntity (double amount) {
        super(amount);
    }

    public void deposit (double amount) {
        this.setAmount(this.getAmount() + amount);
    }

    public void withdraw (double amount) {
        if (this.getAmount() >= amount * 1.01) {
            this.setAmount(this.getAmount() - amount * 1.01);
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}

