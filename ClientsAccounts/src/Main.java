import clients.Individual;
import clients.IndividualEnterpreneur;
import clients.LegalEntity;

public class Main {

    public static void main(String[] args) {
        Individual individual = new Individual(-100);
        LegalEntity legalEntity = new LegalEntity(500);
        IndividualEnterpreneur individualEnterpreneur = new IndividualEnterpreneur(800);

        System.out.println(individual.getAmount());
        System.out.println(legalEntity.getAmount());
        System.out.println(individualEnterpreneur.getAmount());

        legalEntity.withdraw(100);
        System.out.println(legalEntity.getAmount());
        individualEnterpreneur.deposit(1000);
        System.out.println(individualEnterpreneur.getAmount());
    }
}
