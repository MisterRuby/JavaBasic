package Collection;

import org.junit.Test;

import java.util.*;

public class IteratorClass {

    class WeightClass implements Comparable<WeightClass> {
        int weight;

        public WeightClass(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(WeightClass o) {

            return this.weight - o.weight;
        }
    }

    @Test
    public void testComparable() {
        WeightClass weightClass1 = new WeightClass(80);
        WeightClass weightClass2 = new WeightClass(75);
        WeightClass weightClass3 = new WeightClass(90);
        WeightClass weightClass4 = new WeightClass(60);

        List<WeightClass> list = new ArrayList<>();
        list.add(weightClass1);
        list.add(weightClass2);
        list.add(weightClass3);
        list.add(weightClass4);

        Collections.sort(list);

        for (WeightClass weightClass : list) {
            System.out.println(weightClass.weight);
        }
    }

    class HeightClass{
        int height;

        public HeightClass(int height) {
            this.height = height;
        }
    }

    @Test
    public void testComparator() {
        HeightClass heightClass1 = new HeightClass(180);
        HeightClass heightClass2 = new HeightClass(175);
        HeightClass heightClass3 = new HeightClass(190);
        HeightClass heightClass4 = new HeightClass(160);

        List<HeightClass> list = new ArrayList<>();
        list.add(heightClass1);
        list.add(heightClass2);
        list.add(heightClass3);
        list.add(heightClass4);

//        Comparator<HeightClass> heightClassComparator = new Comparator<>() {
//            @Override
//            public int compare(HeightClass o1, HeightClass o2) {
//                return o1.height - o2.height;
//            }
//        };
        Comparator<HeightClass> heightClassComparator = Comparator.comparingInt(o -> o.height);

        list.sort(heightClassComparator);

        for (HeightClass heightClass : list) {
            System.out.println(heightClass.height);
        }
    }

}
