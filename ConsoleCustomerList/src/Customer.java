import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer
{
    private String name;
    private String phone;
    private String eMail;

    public Customer (String name, String phone, String eMail)
    {
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
    }

    public String toString()
    {
        return name + " - " + eMail + " - " + phone;
    }

    public static boolean validatePhone (String phone) {
        Pattern correctPhone = Pattern.compile("\\+7\\d{10}");
        Matcher phoneMatcher = correctPhone.matcher(phone);
        if (!phoneMatcher.matches()) {
            return false;
        }
        return true;
    }

    public static boolean validateMail (String eMail) {
        Pattern correctEMail = Pattern.compile("\\w+\\@\\w+\\.\\w{2,4}");
        Matcher mailMatcher = correctEMail.matcher(eMail);
        if (!mailMatcher.matches()) {
            return false;
        }
        return true;
    }

}
