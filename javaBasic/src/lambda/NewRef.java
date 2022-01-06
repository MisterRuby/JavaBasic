package lambda;

import org.junit.Test;

@FunctionalInterface
interface ArrayInterface {
    int[] getArray(int len);
}

@FunctionalInterface
interface RefInterface {
    NewRef getRef();
}

public class NewRef {

    public NewRef() { };

    @Test
    public void testRefOfArrayConstructor() {
//        ArrayInterface ai = len -> {return new int[len];};

        // 람다식을 통해 구현한 메서드의 내용은 매개변수로 입력받은 크기를 가진 대상 타입의 배열을 생성하여 반환
        ArrayInterface ai = int[]::new;
        int[] arr = ai.getArray(17);
        System.out.println(arr.length);
    }

    @Test
    public void testRefOfConstructor() {
//        RefInterface ri = () -> {return new NewRef();};

        // 람다식을 통해 구현한 메서드의 내용은 대상 타입의 객체를 생성하여 반환
        // 생성자는 여러개일 수 있으므로 인터페이스에 정의된 추상메서드의 매개변수에 따라 어떤 생성자를 호출할지 결정된다.
        RefInterface ri = NewRef::new;
    }
}
