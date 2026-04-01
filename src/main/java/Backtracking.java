import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    static int total = 0;

    public static void main(String[] args) {
//        int[] nums = {5,1,6};
//        subsetXORSum(nums);

        int[] nums = {1,2,3,4};
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, current, result);
    }

    public static int subsetXORSum(int[] nums) {
        recursor(nums, 0, 0);
        return total;
    }

    private static void recursor(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            total += currentXor;
            return;
        }

        recursor(nums, index + 1, currentXor ^ nums[index]);

        recursor(nums, index + 1, currentXor);
    }

    public static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1); // backtrack
        }
    }

    //797. All Paths From Source to Target
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        current.add(0); // start from source
        backtrackAllPath(graph, 0, current, result);

        return result;

    }

    public static void backtrackAllPath(int[][] graph, int node, List<Integer> current, List<List<Integer>> result) {

        if (node == graph.length - 1) {
            result.add(new ArrayList<>(current)); // copy
            return;
        }

        for (int next : graph[node]) {
            current.add(next);                 // choose
            backtrackAllPath(graph, next, current, result); // explore
            current.remove(current.size() - 1); // undo (backtrack)
        }
    }
}
