import accounts.BankAccount;
import accounts.CardAccount;
import accounts.DepositaryAccount;

public class Main {
    public static void main(String[] args) {
        //обычный счет
        BankAccount account = new BankAccount(100);
        account.deposit(100);
        System.out.println("Сумма после внесения - " + account.getAmount());
        account.withdraw(150);
        System.out.println("Сумма после снятия - " + account.getAmount());
        //депозитарный счет
        DepositaryAccount depAccount = new DepositaryAccount(50);
        depAccount.deposit(100);
        System.out.println("Сумма после внесения - " + depAccount.getAmount());
        depAccount.withdraw(50);
        //карточный счет
        CardAccount cardAccount = new CardAccount(100);
        cardAccount.deposit(100);
        System.out.println("Сумма после внесения - " + cardAccount.getAmount());
        cardAccount.withdraw(150);
        System.out.println("Сумма после снятия - " + cardAccount.getAmount());
    }
}
