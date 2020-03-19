package clients;

abstract public class Client {

    private double amount;
    //общий конструктор для всех наследующих классов
    protected Client (double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Сумма на счете не может быть отрицательной, сумма на счете выставлена в ноль");
            this.amount = 0;
        }
    }
    //паблик-геттер, чтобы можно было из main-класса узнавать текущую сумму
    public double getAmount() {
        return amount;
    }
    //протектед-сеттер, чтобы только подклассы могли менять сумму, а пользователь только через снятие или внесение
    protected void setAmount(double amount) {
        this.amount = amount;
    }

    protected abstract void deposit (double amount);
    protected abstract void withdraw (double amount);
}
