package topic.graph._399_Evaluate_Division;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private final Map<String, String> parent = new HashMap<>();
    private final Map<String, Double> ratio = new HashMap<>();

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test case 1
        List<List<String>> equations1 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        double[] results1 = solver.calcEquation(equations1, values1, queries1);
        System.out.println(Arrays.toString(results1));
        // Expected output: [6.0, 0.5, -1.0, 1.0, -1.0]

        // Test case 2
//        List<List<String>> equations2 = Arrays.asList(
//                Arrays.asList("x1", "x2"),
//                Arrays.asList("x2", "x3"),
//                Arrays.asList("x3", "x4"),
//                Arrays.asList("x4", "x5")
//        );
//        double[] values2 = {3.0, 4.0, 5.0, 6.0};
//        List<List<String>> queries2 = Arrays.asList(
//                Arrays.asList("x1", "x5"),
//                Arrays.asList("x5", "x2"),
//                Arrays.asList("x2", "x4"),
//                Arrays.asList("x2", "x2"),
//                Arrays.asList("x2", "x9"),
//                Arrays.asList("x9", "x9")
//        );
//        double[] results2 = solver.calcEquation(equations2, values2, queries2);
//        System.out.println(Arrays.toString(results2));
        // Expected output: [360.0, 0.008333333333333333, 20.0, 1.0, -1.0, -1.0]
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            double value = values[i];
            union(var1, var2, value);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            if (!parent.containsKey(var1) || !parent.containsKey(var2)) {
                results[i] = -1.0;
            } else {
                String root1 = find(var1);
                String root2 = find(var2);

                if (!root1.equals(root2)) {
                    results[i] = -1.0;
                } else {
                    results[i] = ratio.get(var1) / ratio.get(var2);
                }
            }
        }

        return results;
    }

    private void union(String var1, String var2, double value) {
        if (!parent.containsKey(var1)) {
            parent.put(var1, var1);
            ratio.put(var1, 1.0);
        }
        if (!parent.containsKey(var2)) {
            parent.put(var2, var2);
            ratio.put(var2, 1.0);
        }

        String root1 = find(var1);
        String root2 = find(var2);

        if (!root1.equals(root2)) {
            parent.put(root1, root2);
            ratio.put(root1, value * ratio.get(var2) / ratio.get(var1));
        }
    }

    private String find(String var) {
        if (!var.equals(parent.get(var))) {
            String originalParent = parent.get(var);
            parent.put(var, find(originalParent));
            ratio.put(var, ratio.get(var) * ratio.get(originalParent));
        }
        return parent.get(var);
    }

}
