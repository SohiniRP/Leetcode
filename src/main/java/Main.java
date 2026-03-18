import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {1,1,2};
//        removeDuplicate(arr);
//        int[] arr = {3,2,2,3};
//        System.out.println(removeElement(arr,2));
//        int[] nums1 ={0};
//        int[] nums2 ={1};
//
//        merge(nums1, 0, nums2, 1);
//        int[] nums = {0,1,1,3,3};
//        System.out.println(findMaxAverage(nums, 4));
//        int[] nums = {1,2,3,1,2,3};
//        System.out.println(containsNearbyDuplicate(nums, 2));
//        String s = "abciiidef";
//        System.out.println(maxVowels(s,3));
//        String s = "A man, a plan, a canal: Panama";
//        isPalindrome(s);
        int[] nums ={0,1,0,3,12};
        moveZeroes(nums);
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

    public static int removeDuplicate(int[] nums) {
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }
            else{
                i++;
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return i;
    }

    //27. Remove Element
    public static int removeElement(int[] nums, int val) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(nums[j]==val){
                j--;
            }
            else{
                if(nums[i]!=val){
                    i++;
                }
                else if(nums[i]==val) {
                    nums[i]=nums[j];
                    nums[j]=val;
                    j--;
                    i++;
                }
            }
        }
        return j+1;
    }

    //28. Find the Index of the First Occurrence in a String
    public static int strStr(String haystack, String needle) {
        int i=0; int j=0;

        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()){
                    return i-j;
                }
            } else{
                i = i-j+1;
                j=0;
            }
        }
        return -1;
    }

    //88. Merge Sorted Array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i= m-1;int j = n-1;

        for(int k=nums1.length-1;k>=0;k--){
            if(i>=0 && j>=0 && nums1[i]>=nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else if( i>=0 && j>=0 && nums1[i]<nums2[j]){
                nums1[k] = nums2[j];
                j--;
            } else{
                if(i>=0){
                    while(i>=0) nums1[k--] = nums1[i--];
                }else{
                    while(j>=0) nums1[k--] = nums2[j--];
                }
            }
        }
    }

    //643. Maximum Average Subarray I
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxSum = sum;
        for(int i=k;i<nums.length;i++){
            sum-=nums[i-k];
            sum+=nums[i];
            maxSum=Math.max(maxSum, sum);
        }
        return (double)maxSum/k;
    }

    //219. Contains Duplicate II
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> temp = new HashSet<>();
        int left = 0;
        for(int right=0;right<nums.length;right++){
            if(temp.contains(nums[right])) return true;

            temp.add(nums[right]);

            if(right-left>=k) {
                temp.remove(nums[left]);
                left++;
            }
        }
        return false;
    }

    //1456. Maximum Number of Vowels in a Substring of Given Length
    public static int maxVowels(String s, int k) {
        int length = 0;
        int left = 0;
        int maxLength = 0;
        for(int right=0;right<k;right++){
            if(s.charAt(right)=='a'|| s.charAt(right)=='e'|| s.charAt(right)=='i'
                    || s.charAt(right)=='o' || s.charAt(right)=='u') {
                length++;
            }
        }
        maxLength = length;
        for(int i =k;i<s.length();i++){
            if(s.charAt(left)=='a'|| s.charAt(left)=='e'|| s.charAt(left)=='i'
                    || s.charAt(left)=='o' || s.charAt(left)=='u') {
                length--;
            }
            left++;
            if(s.charAt(i)=='a'|| s.charAt(i)=='e'|| s.charAt(i)=='i'
                    || s.charAt(i)=='o' || s.charAt(i)=='u'){
                length++;
            }
            maxLength=Math.max(maxLength, length);
        }

        return maxLength;
    }

    //125. Valid Palindrome
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");

        int left =0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;right--;
            } else return false;
        }
        return true;
    }

    //283. Move Zeroes
    public static void moveZeroes(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]==0 && nums[i]==0) continue;
            else if(nums[j]!=0 && nums[i]==0){
                nums[i] = nums[j];
                nums[j]=0;
                i++;
            } else if(nums[i]!=0)i++;
        }
    }
}
