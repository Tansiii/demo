package MethodReference;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


interface SMRInterface {


    public static String  printdata1() {
        return "message with FI";
    }

    default void printdata2(String s)
    {
        System.out.print("printing " +s);
    }

    public void abc();

}
public class StaticMethodReference implements SMRInterface
{

    public static void main (String args[]) {


        Supplier<String> s = SMRInterface::printdata1;
        System.out.println("supplier =" +s.get());

        SMRInterface smr = StaticMethodReference::new;
        Consumer<String>  c = smr::printdata2;
        c.accept("Default Method Reference from Interface");

    }


    @Override
    public void abc() {
        System.out.println("Instance Method Reference");
    }
}

