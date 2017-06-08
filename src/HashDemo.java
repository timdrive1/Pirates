import java.util.*;

/**
 * Created by Тим on 08.06.2017.
 */
public class HashDemo {
    public static void main(String[] args) {
        HashMap<String,Integer> hashPirates = new HashMap<>();
        hashPirates.put("Jack Sparrow",200);
        hashPirates.put("Silver",250);
        hashPirates.put("Black Beard",225);
        hashPirates.put("John",150);
        System.out.println(hashPirates);
        System.out.println(hashPirates.get("Silver"));
        hashPirates.put("Silver",300);
        System.out.println(hashPirates.get("Silver"));
        System.out.println();

        HashMap<Integer,String>hashP = new HashMap<>();
        hashP.put(200,"Jack Sparrow");
        hashP.put(250,"Silver");
        hashP.put(225,"Black Beard");
        hashP.put(150,"John");
        System.out.println(hashP);
        System.out.println(hashP.get(200));
        System.out.println();

        TreeMap<String,Integer> tm = new TreeMap<>(hashPirates);
        System.out.println(tm);
        System.out.println();

        TreeMap<Integer,String> tm1 = new TreeMap<>(hashP);
        System.out.println(tm1);
        System.out.println();

        List<Integer> sortedKeys = new ArrayList<>(hashP.keySet());
        Collections.sort(sortedKeys);
        for (Integer x: sortedKeys) {
            System.out.println(hashP.get(x) + " " + x);
        }
    }
}