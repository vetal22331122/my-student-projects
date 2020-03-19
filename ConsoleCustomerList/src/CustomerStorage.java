import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws WrongPhoneInputException, WrongMailInputException, WrongInput {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new WrongInput("Неверный формат ввода. Верный формат:\n" + "add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722");
        }
        String name = components[0] + " " + components[1];
        if (!Customer.validatePhone(components[3])) {
            throw new WrongPhoneInputException("неверный формат ввода номера телефона");
        }
        if (!Customer.validateMail(components[2])) {
            throw new WrongMailInputException("неверный формат ввода e-mail");
        }
        storage.put(name, new Customer(name, components[3], components[2]));

    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}