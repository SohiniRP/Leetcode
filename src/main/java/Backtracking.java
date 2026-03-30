public class Backtracking {
    int total = 0;

    public int subsetXORSum(int[] nums) {
        recursor(nums, 0, 0);
        return total;
    }

    private void recursor(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            total += currentXor;
            return;
        }

        recursor(nums, index + 1, currentXor ^ nums[index]);

        recursor(nums, index + 1, currentXor);
    }
}
