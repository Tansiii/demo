import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class Customer
{
    private int accountNo;
    private String name;
    private int balance ;
    private String  phoneNo;

    public Customer()
    {

    }
    public Customer(int accountNo, String name, int balance, String phoneNo) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.phoneNo = phoneNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}


 class CustomException extends RuntimeException {

    public CustomException() {
    }

    public CustomException(String str)
    {
        super(str);
        System.out.println(str);
    }
}

public class CustomExceptionImpl
{
    public static void main (String args[]) {
        Customer c1 = new Customer(1 ,"tanushri",25000 , "9901251871");
        Customer c2 = new Customer(2 ,"tanu",26000 , "9901251872");
        Customer c3 = new Customer(3 ,"shri",260000 , "9901251873");
        Customer c4 = new Customer(4 ,"biswas",980000 , "9901251874");
        Customer c5 = new Customer(5 ,"tanusbis",119000 , "9901251875");

        List<Customer> list = new ArrayList<Customer>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);


        list.stream()
                .filter(e->e.getBalance()>25000)
                .map(Customer::getName)
                .forEach(System.out::println);


         list.stream()
                 .filter(x ->x.getBalance()<25000 )
                .findAny()
                .orElseThrow(() -> new CustomException("Balance  is low"));

    }
}
