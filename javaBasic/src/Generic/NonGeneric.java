package Generic;

import org.junit.Test;

public class NonGeneric {

    class NonGeneric1 {
        Object data;

        NonGeneric1 (Object data) {
            this.data = data;
        }
    }

    class NonGeneric2 {
        Object data;

        NonGeneric2 (Object data) {
            this.data = data;
        }
    }

    /**
     * 약한 타입 체크 (Weak Type Checking)
     *      - 잘못된 타입 캐스팅에도 문법 오류를 발생시키지 않는 타입 체크
     *      - 모든 타입을 받기 위해 Object 타입으로 설정하고 다운캐스팅을 수행하면 runtime 중에 ClassCastException이 발생할 위험이 있다.
     *          - ClassCastException 은 RuntimeException 을 상속받은 예외
     */
    @Test
    public void checkWeakType() {
        NonGeneric1 nonGeneric = new NonGeneric1("String");

        Integer num = (Integer) nonGeneric.data;    // Object 타입에서 다운 캐스팅으로 처리하는 것을 컴파일 단계에서 잡을 수 없다.

        System.out.println(num);

    }
}
