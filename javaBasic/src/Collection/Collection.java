package Collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Collection {

    @Test
    public void testIterator() {
        LinkedHashSet<Integer> integerHashSet = new LinkedHashSet<>();

        integerHashSet.add(10);
        integerHashSet.add(5);
        integerHashSet.add(6);
        integerHashSet.add(8);
        integerHashSet.add(2);
        integerHashSet.add(4);
        integerHashSet.add(5);
        integerHashSet.add(1);

        Iterator<Integer> iterator = integerHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
