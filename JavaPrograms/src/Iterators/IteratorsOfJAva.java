package Iterators;

import java.util.*;
import java.util.stream.Stream;

public class IteratorsOfJAva {
   public static void main(String args[]) {
       Vector<String> vector = new Vector<String>();
       Set<Integer> lists = new HashSet<Integer>();
       List<Integer> lists1 = new LinkedList<Integer>();
       int i =0 ;
       while(i<10)
       {
           vector.add("String" +i);
           i++;
       }

        for(int k =0; k<10; k++)
        {
            lists.add(k);
            lists1.add(k);
        }

       Enumeration<String> e = vector.elements();
       while(e.hasMoreElements())
       {
           String s = e.nextElement();
           System.out.println("Printing via Enumeration" +s);
       }

       Iterator itr = lists.iterator();
       while(itr.hasNext())
       {
           Integer val = (Integer) itr.next();
           System.out.println(" via Iterator" +val);
       }

       Stream<Integer> stream = lists.stream();
       Spliterator<Integer> spItr1 = stream.spliterator();
       Spliterator<Integer> spItr2 = spItr1.trySplit();

       System.out.println("Characteristics of spItr1 ="+spItr1.characteristics() + "   and " + Spliterator.DISTINCT);

       spItr1.forEachRemaining((n) -> System.out.println(n));
       spItr2.forEachRemaining((n) -> System.out.println(n));


       ListIterator<Integer> litr1 = lists1.listIterator();
       while(litr1.hasNext())
       {
           Integer val = (Integer) litr1.next();
           System.out.println(" via  List Iterator" +val);
           if(litr1.hasPrevious())
           {
               litr1.add(42);
           }

       }
       litr1.forEachRemaining((n) -> System.out.println(n));







   }


}

