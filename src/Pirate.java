/**
 * Created by Тим on 08.06.2017.
 */
public class Pirate implements Comparable<Pirate> {
    String name;
    int gold;
    public Pirate(String name, int gold) {
        this.name = name;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    @Override
    public String toString() {
        return "Pirate{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }

    @Override
    public int compareTo(Pirate o) {
        return gold - o.getGold();
    }
}