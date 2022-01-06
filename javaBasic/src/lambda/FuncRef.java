package lambda;

import org.junit.Test;

@FunctionalInterface
interface FuncRefInterface {
    void function();
}

public class FuncRef {
    void function() {
        System.out.println(this);
    }

    @Test
    public void refInstanceMethod() {
        FuncRef fr = new FuncRef();

        // 람다식으로 구현한 메서드 내부에서 해당 객체의 메서드를 호출한다는 의미.
        // 이 때, fi 추상메서드와 fr 메서드의 매개변수의 개수와 타입은 동일해야 한다.
        // 리턴타입은 fi의 리턴타입이 void 이거나 fi와 fr의 리턴타입이 동일해야한다.
        // 다만 fi의 리턴타입이 void 일때는 fr의 리턴값이 활용되지 못하므로 fi와 fr의 리턴타입은 동일해야 의미가 있다.
        FuncRefInterface fi = fr::function;     // 람다식을 통해 fi의 추상메서드를 구현할 내용은 fr 객체의 function 을 호출하는 것!

        fr.function();

        // fr 객체의 메서드를 호출함으로 System.out.println(this); 으로 출력되는 참조값은 위의 코드와 동일하다.
        fi.function();
    }


    public static void staticFunc() {
        System.out.println("staticFunc");
    }

    @Test
    public void callStaticFunc() {

        // 클래스::정적 메서드
        FuncRefInterface fiStatic = FuncRef::staticFunc;    // 람다식을 통해 구현할 내용은 FuncRef 클래스의 정적메서드 staticFunc 을 호출하는 것!

        fiStatic.function();
    }

    void callFirstParamInstanceMethod(String str1, String str2) {
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testCallFirstParamInstanceMethod() {
        FuncRef funcRef = new FuncRef();
        FuncFirstParamInstance fi = FuncRef::callFirstParamInstanceMethod;
        fi.function(funcRef, "test1", "test2");
    }

}
@FunctionalInterface
interface FuncFirstParamInstance {

    /**
     * 람다식을 통해 해당 추상메서드를 구현할 시 구현 메서드는 funcRef 객체의 메서드를 호출
     *  - funcRef 객체의 메서드의 파라미터는 다음 파라미터들의 순서, 개수, 타입이 동일해야한다.
     * @param funcRef   호출할 메서드가 속한 객체
     * @param str1      호출할 메서드의 파라미터 1
     * @param str2      호출할 메서드의 파라미터 2
     */
    void function(FuncRef funcRef, String str1, String str2);
}