import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    //1. Two Sum:
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tracker = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (tracker.get(c) != null) {
                return new int[] { tracker.get(c), i };
            }
            tracker.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    //387. First Unique Character in a String
    public static int firstUniqChar(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for(int i=0;i<s.length();i++){
            result.put(s.charAt(i), result.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(result.get(s.charAt(i))==1) return i;
        }
        return -1;
    }

    //258. Add Digits
    public static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }

    //9. Palindrome Number
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int original = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }
        return original == reversed;
    }

    //26. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
