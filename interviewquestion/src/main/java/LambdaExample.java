public class LambdaExample {
    public static void main(String[] args) {
        SampleFunction sf1 = s -> s + "!";
        SampleFunction sf2 = s -> s + "?";
        print("Hello", sf1);
        print("Hello", sf2);
    }

    static void print(String s, SampleFunction sf) {
        String r = sf.run(s);
        System.out.println(r);
    }
}

@FunctionalInterface
interface SampleFunction {
    String run(String s);
}