package lambda;

import org.junit.Test;

/**
 * FunctionalInterface (함수형 인터페이스)
 *  - 단 하나의 추상메서드만을 포함하는 인터페이스
 */
@FunctionalInterface
interface FuncInterface {
    String function(String str);
}

/**
 * Lambda (람다식)
 *  - 함수형 인터페이스의 호출 및 기능을 구현하는 방법을 새롭게 정의한 문법
 *  - 기존의 객체 지향 프로그램 체계 안에서 함수형 프로그래밍을 가능하게 하는 기법
 *  - 익명 이너 클래스의 축약된 형태
 *  - 메서드에 필요한 매개변수 정의는 인터페이스, 메서드의 기능은 람다식을 통해 정의
 */
public class Lambda {

    @Test
    public void callFuncInterface() {
        String str = "callFuncInterface";
        FuncInterface fi = (s) -> {
            System.out.println(s);
            return s;
        };

        fi.function(str);
    }

    /**
     * 람다식의 표현
     */
    public void expressLambda() {
        FuncInterface fi1 = (String s) -> {return s;};

        // 매개변수의 타입 생략 가능
        FuncInterface fi2 = (s) -> {return s;};

        // 매개변수가 1개일 때 소괄호 생략 가능
        FuncInterface fi3 = s -> {return s;};

        // 메서드가 return 부분만 있을 때에는 return 예약어와 중괄호를 함께 생략 가능
        FuncInterface fi4 = s -> s;
    }
}