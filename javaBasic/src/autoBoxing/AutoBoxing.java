package autoBoxing;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxing {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//		List<int> list2 = new ArrayList<>();	// List 는 기본적으로 <> 안에 객체 타입만 설정할 수 있다.

        list.add(10);		// Auto-Boxing : 객체 타입이 아닌 int 형을 넣었지만 이 때 오토박싱 되어 래퍼클래스인 Integer 로 변환되어 들어간다.

        int result = list.get(0);		// Auto-Unboxing  : 반대로 기본타입에 저장할 때에는 Integer 값이었던 내부의 값이 자동으로 int 로 형변환된다.

    }
}
