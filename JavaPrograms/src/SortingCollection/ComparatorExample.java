package SortingCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {

    private int id ;
    private String name ;
    private int age;
    private String phoneNumber;

    public User(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

public class ComparatorExample
{
    public static void main(String args[])
    {
        List<User>  userList = new ArrayList<User>();
        userList.add(new User(1,"tanu",34,"9901251871"));
        userList.add(new User(6,"bhanum",33,"9945900211"));
        userList.add(new User(3,"priya",33,"000000000"));
        userList.add(new User(9,"nimisha",31,"8884651777"));
        System.out.println("Sort by name");
        userList.sort(Comparator.comparing(User::getName).reversed());
        userList.forEach(System.out::println);

        Comparator<User> grpSort = Comparator.comparing(User::getName).reversed()
                                    .thenComparing(User::getAge)
                                    .thenComparing(User::getPhoneNumber);
        System.out.println("GroupSort By User");
        userList.sort(grpSort);
        userList.forEach(System.out::println);

    }
}
