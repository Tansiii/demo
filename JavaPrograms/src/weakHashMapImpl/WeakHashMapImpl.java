package weakHashMapImpl;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapImpl {

    public static void main(String args[]) {
        Map<Key, Project> map = new WeakHashMap<>();
        Key k1 = new Key("K1");
        Key k2 = new Key("K2");

        map.put(k1,new Project(1,"ProjectJAVA"));
        map.put(k2,new Project(2,"ProjectCOBRA"));

        for(Map.Entry<Key,Project> entry : map.entrySet())
        {
            System.out.println("Entry="+ entry.getKey() +"and" + "Value=" + entry.getValue());
        }
        k1 = null;
        System.gc();

        for(Map.Entry<Key,Project> entry : map.entrySet())
        {
            System.out.println("Entry="+ entry.getKey() +"and" + "Value=" + entry.getValue());
        }


    }

}

class Key
{
    String key ;

    public Key(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

class Project
{
    int projectId ;
    String projectName ;

    public Project(int projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}