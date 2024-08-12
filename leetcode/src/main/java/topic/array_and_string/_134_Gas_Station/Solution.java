package topic.array_and_string._134_Gas_Station;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Expected output is 3
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Starting station: " + solution.canCompleteCircuit(gas1, cost1));  // Output: 3

        // Test Case 2: Expected output is -1 (No solution)
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Starting station: " + solution.canCompleteCircuit(gas2, cost2));  // Output: -1

        // Test Case 3: Expected output is 4
        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};
        System.out.println("Starting station: " + solution.canCompleteCircuit(gas3, cost3));  // Output: 4

        // Test Case 4: Expected output is 0
        int[] gas4 = {3, 1, 1};
        int[] cost4 = {1, 2, 2};
        System.out.println("Starting station: " + solution.canCompleteCircuit(gas4, cost4));  // Output: 0

        // Test Case 5: Expected output is 2
        int[] gas5 = {4, 6, 7, 4};
        int[] cost5 = {6, 5, 3, 5};
        System.out.println("Starting station: " + solution.canCompleteCircuit(gas5, cost5));  // Output: 2
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;

        for (int i = 0; i < gas.length; i++) {
            int net_gas = gas[i] - cost[i];
            total_tank += net_gas;
            curr_tank += net_gas;

            // If at any point the current tank is negative, reset starting station
            if (curr_tank < 0) {
                starting_station = i + 1;
                curr_tank = 0;
            }
        }

        // If total gas is less than total cost, it's impossible to complete the circuit
        return total_tank >= 0 ? starting_station : -1;
    }
}
