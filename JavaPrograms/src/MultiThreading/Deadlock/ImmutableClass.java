package MultiThreading.Deadlock;

import java.util.HashMap;
import java.util.Iterator;

class Entity {

    private final int id;
    private final String name;
    private final HashMap<String , String> testMap;

    public Entity(int id, String name, HashMap<String, String> testMap) {
        this.id = id;
        this.name = name;
        HashMap<String , String> hm = new HashMap<String , String>();
        String key;
        Iterator<String> it = testMap.keySet().iterator();
        while(it.hasNext())
        {
            key = it.next();
            hm.put(key,hm.get(key));
        }
        this.testMap = hm;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTestMap() {
        return (HashMap<String , String>)testMap.clone();
    }
}

public class ImmutableClass
{
    public static void main(String args[])
    {
        HashMap<String , String> hm = new HashMap<String , String>();
        hm.put("1","first");
        hm.put("2" , "second");
        Entity immutableClass = new Entity(10 , "original" , hm);

    }
}
