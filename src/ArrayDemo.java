import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Тим on 08.06.2017.
 */
public class ArrayDemo {
    public static void main(String[] args) {
        ArrayList<Pirate> Pirates = new ArrayList<>();
        Pirates.add(new Pirate("Silver",200));
        Pirates.add(new Pirate("Jack",100));
        Pirates.add(new Pirate("BlackBeard",250));
        Pirates.add(new Pirate("Cook",50));
        Pirates.add(new Pirate("Hook",5));
        System.out.println(Pirates);
        /*Pirates.sort(new Comparator<Pirate>() {
            @Override
            public int compare(Pirate o1, Pirate o2) {
                if(o1.getGold()==o2.getGold())return 0;
                else{return (o1.getGold()>o2.getGold())?1:-1;
                }
                //return o1.getGold()-o2.getGold();
            }
        });*/
        Collections.sort(Pirates,(((o1, o2) -> o1.getGold() - o2.getGold())));
        System.out.println(Pirates);
    }
}