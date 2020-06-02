package Serialization;

import java.io.*;

class Employee implements Serializable {

    private int age ;
    private static int salary;
    private transient  String experience;
    private String name ;

    public Employee(int age,int salary, String experience, String name) {
        this.age = age;
        this.experience = experience;
        this.name = name;
        Employee.salary = salary;
    }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public static int getSalary() {
         return salary;
     }

     public static void setSalary(int salary) {
         Employee.salary = salary;
     }

     public String getExperience() {
         return experience;
     }

     public void setExperience(String experience) {
         this.experience = experience;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }
 }

public class SerialExample {

     public void print(Employee employee)
     {
        System.out.println("Employee Details :::");
         System.out.println("name = " + employee.getName());
         System.out.println("age = " + employee.getAge());
         System.out.println("a = " + Employee.getSalary());
         System.out.println("b = " + employee.getExperience());

     }

     public static void main(String args[])
     {
         //serialization
        Employee e1 = new Employee(34,25000, "three" , "tanushri");
        String fileName = "tanu.txt";
        FileOutputStream fos  = null;
         ObjectOutputStream oos = null;
         try {
             System.out.println("Printing Data before Serialization");
             new SerialExample().print(e1);
              fos = new FileOutputStream(fileName);
              oos = new ObjectOutputStream(fos);
              oos.writeObject(e1);
              Employee.setSalary(30000);
              e1.setExperience("4");
              e1.setName("tanu");
              e1.setAge(35);

         } catch (IOException e) {
             e.printStackTrace();
         }
         finally
         {
             try {
                 oos.close();
                 fos.close();
                 e1 = null;
             } catch (IOException e) {
                 e.printStackTrace();
             }

         }

         FileInputStream fileInputStreams  = null;
         ObjectInputStream objectInputStream = null;
         Employee deserialEmployee = null;
         try {
             fileInputStreams = new FileInputStream(fileName);
             objectInputStream = new ObjectInputStream(fileInputStreams);
             deserialEmployee  = (Employee)objectInputStream.readObject();
             System.out.println("Printing Data after Serialization");
             new SerialExample().print(deserialEmployee);


         } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
         }
         finally
         {
             try {
                 fileInputStreams.close();
                 objectInputStream.close();
                 deserialEmployee = null;
             } catch (IOException e) {
                 e.printStackTrace();
             }

         }

     }

}
