package eqaulshashcode;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        MyClass first = new MyClass("a", "first");
        MyClass second = new MyClass("a", "first");
        var m = new HashMap<MyClass, String>();
        var m2 = new HashMap<MyClass, String>();

        // try to comment hashCode()
        if (first.equals(second)) {
            System.out.println(first.hashCode());
            System.out.println(second.hashCode());
            m.put(first, "testa");
            m.put(second, "testb");
            System.out.println(m.size());
            m.forEach((k, v) -> {
                System.out.println(k + " " + v);
            });
            System.out.println(m.containsKey(first));
            System.out.println(m.containsKey(second));
        }

        // try to comment equals()
        if (first.hashCode() == second.hashCode()) {
            m2.put(first, "testa");
            m2.put(second, "testb");
            System.out.println(m2.size());
            m2.forEach((k, v) -> {
                System.out.println(k.hashCode() + " " + v);
            });
            System.out.println(m2.get(first));
            System.out.println(m2.get(second));
        }
    }
}
