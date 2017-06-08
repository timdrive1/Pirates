import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Тим on 08.06.2017.
 */
public class PirateList implements List<Pirate> {
    int capacity = 100;
    int cnt = 0;
    Pirate[] pirates = new Pirate[capacity];

    @Override
    public int size() {
        return pirates.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Pirate p : pirates
                ) {
            if (p.equals(o)) ;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Pirate> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return pirates;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Pirate pirate) {
        if (cnt < capacity) {
            pirates[cnt] = pirate;
            cnt++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < cnt; i++) {
            if (pirates[i].equals(o)) {
                pirates[i] = null;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (int i = 0; i < c.size() ; i++) {
            int found = 0;
            if (found == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Pirate> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Pirate> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Pirate get(int index) {
        return null;
    }

    @Override
    public Pirate set(int index, Pirate element) {
        return null;
    }

    @Override
    public void add(int index, Pirate element) {

    }

    @Override
    public Pirate remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Pirate> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Pirate> listIterator(int index) {
        return null;
    }

    @Override
    public List<Pirate> subList(int fromIndex, int toIndex) {
        return null;
    }
}
