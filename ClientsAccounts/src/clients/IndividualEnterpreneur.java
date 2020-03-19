package clients;

public class IndividualEnterpreneur extends Client {
    public IndividualEnterpreneur (double amount) {
        super(amount);
    }

    public void deposit (double amount) {
        if (amount < 1000) {
            this.setAmount(this.getAmount() + amount * 0.99);
        } else if (amount >= 1000) {
            this.setAmount(this.getAmount() + amount * 0.995);
        }
    }

    public void withdraw (double amount) {
        if (this.getAmount() >= amount) {
            this.setAmount(this.getAmount() - amount);
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}
