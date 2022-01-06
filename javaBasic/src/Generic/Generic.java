package Generic;

import org.junit.Test;

/**
 * Generic Class / Interface (제네릭)
 *      - 클래스, 메소드에서 사용할 데이터 타입을 객체를 생성하는 시점에 지정하는 클래스
 *          ex ) List<E>, Set<E>, Map<K, V>
 *
 *      - 제네릭 타입 변수의 관료적 표기와 의미
 *          - T : Type (타입)
 *          - K : Key (키)
 *          - V : Value (값)
 *          - N : Number (숫자)
 *          - E : Element (원소)
 */
public class Generic {

    class GenericClass<T> {
        T data;

        GenericClass (T data) {
            this.data = data;
        }

        void operateMethod (T className) {
        }
    }

    /**
     * 강한 타입 체크 (Strong Type Check)
     *      - 제네릭 타입을 사용하여 잘못된 타입이 사용될 수 있는 지점을 컴파일 단계에서 체크
     *      - Runtime 시점에 타입 오류 일어나는 것을 방지해준다.
     */
//    @Test
//    public void checkStrongType() {
//        GenericClass<String> genericClass = new GenericClass<String>("String");
//        Integer num = (Integer)genericClass.data;       // T의 타입이 객체 생성 시점에 String 으로 결정되었으므로 캐스팅 불가능
//    }


    /**
     * 제네릭 메서드
     *      - 메서드가 호출되는 시점에 실제 제네릭 타입을 지정하는 메서드
     */

    class GenericMethodClass {
        /**
         * 매개변수에만 제네릭이 사용됐을 때
         *      - 제네릭 메서드에 명시한 타입 파라미터는 제네릭 클래스에 명시한 타입 파라미터와 상관이 없다.
         * @param <T>
         */
        public <T> void callGenericVarMethod(T var) {
            // T 의 타입이 메소드가 호출되는 시점에 결정되기 때문에 어떤 타입이라도 호출할 수 있는 Object 타입의 메소드만 사용할 수 있다.
            var.getClass();
            var.toString();
            var.equals("String");
        }

        /**
         * 리턴타입에 제네릭이 사용됐을 때
         * @param <T>
         */
        public <T> T callReturnGenericMethod(T var) {
            // T t = new T();    T의 기본생성자가 없을 수도 있으므로 불가능

            return var;
        }
    }

    @Test
    public void methodName() {
        GenericMethodClass methodClass = new GenericMethodClass();
//        methodClass.<String>callGenericVarMethod(15);
        methodClass.<Integer>callGenericVarMethod(15);
        methodClass.callGenericVarMethod(15);                   // 타입 파라미터 생략 가능
    }






    interface A {
        void call();
    }

    class B implements A {
        public void call() {
            System.out.println("call!");
        }
    }

    /**
     * 제네틱 클래스의 타입 제한
     * @param <T>
     */
    class LimitGenericClass<T extends A> {
        // T의 타입으로 A / A를 상속받은 클래스 / A의 구현 클래스로만 지정 가능
        // extends 없이 제네릭 타입만 쓰는것은 사실상 <T extends Object> 와 같다.

        /**
         * T의 타입이 A 클래스 또는 A의 자식 클래스로 제한되어 있으므로 A의 메서드를 사용할 수 있다.
         *
         * @param var
         */
        void callLimitGeneric(T var) {
            var.call();
        }

        /**
         * 제네틱 메소드의 타입 제한
         *
         * @param <T>
         */
        public <T extends Number> void callNumberMethod(T var) {
            // Number 클래스의 메소드를 사용할 수 있다.
            var.intValue();
            var.byteValue();
            var.shortValue();
            var.doubleValue();
        }


    }

    class GenericParamClass {
        // 제네릭 클래스를 매개변수로 사용
        /**
         * 타입 파라미터로 A 타입만 가능
         * @param var
         */
        public void callTypeAParamGeneric(LimitGenericClass<A> var) {

        }

        /**
         * 타입 파라미터로 모든 타입 가능
         * @param var
         */
        public void callTypeAllParamGeneric(LimitGenericClass<?> var) {

        }

        /**
         * 타입 파라미터로 A / A의 자식 클래스 가능
         * @param var
         */
        public void callExtendsParamGeneric(LimitGenericClass<? extends A> var) {

        }

        /**
         * 타입 파라미터로 A / A의 부모 클래스 가능
         * @param var
         */
        public void callSuperParamGeneric(LimitGenericClass<? super A> var) {

        }
    }

    class Parent<K, V> {
    }

    /**
     * 자식 클래스의 제네틱 타입 파라미터는 부모 클래스의 제네틱 타입 파라미터를 모두 포함하고 있어야 한다.
     *      - 따라서 자식 클래스의 제네틱 타입 파라미터의 개수는 항상 부모보다 같거나 많다.
     * @param <K>
     * @param <V>
     */
    class Child<K,V,T> extends Parent<K, V> {

    }

    @Test
    void testGenericExtends() {
        Child<String, String, String> child = new Child<>();
    }
}
