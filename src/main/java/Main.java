import java.util.*;

import static java.lang.System.*;

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
//        int[] nums ={0,1,0,3,12};
//        moveZeroes(nums);
//        String s = "IceCreAm";
//        System.out.println(reverseVowels(s));
//        String s = "ABAB";
//        System.out.println(characterReplacement(s,2));

//        String s = "aababcabc";
//        System.out.println(countGoodSubstring(s));
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};
//
//        System.out.println((intersect(nums1,nums2)).toString());

//        String s = "abcdefg";
//        System.out.println(reverseStr(s,2));

//        String s = "loveleetcode";
//        System.out.println(shortestToChar(s, 'e'));

//        int[] nums ={3,5,4,2,4,6};
//        System.out.println(minPairSum(nums));

//        int[] nums = {1,1,1,2,2,3};
//        removeDuplicates2(nums);


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

    //345. Reverse Vowels of a String
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i =0; int j= s.length()-1;
        while(i<=j){
            if(Character.toLowerCase(arr[i])!='a' && Character.toLowerCase(arr[i])!='e' && Character.toLowerCase(arr[i])!='i' && Character.toLowerCase(arr[i])!='o' && Character.toLowerCase(arr[i])!='u') i++;
            else if(Character.toLowerCase(arr[j])!='a' && Character.toLowerCase(arr[j])!='e' && Character.toLowerCase(arr[j])!='i' && Character.toLowerCase(arr[j])!='o' && Character.toLowerCase(arr[j])!='u') j--;

            else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }
        return new String(arr);
    }

    //557. Reverse Words in a String III
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int left = 0;

        for (int right = 0; right <= arr.length; right++) {

            if (right == arr.length || arr[right] == ' ') {
                reverse(arr, left, right - 1);
                left = right + 1;
            }
        }

        return new String(arr);
    }

    private static void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c - 'A']++;

            // Track max frequency in current window
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            // If more than k replacements needed → shrink
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    //594. Longest Harmonious Subsequence
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet()){
            if(map.containsKey(key+1)){
                maxFreq = Math.max(maxFreq, map.get(key+1)+map.get(key));
            }
        }
        return maxFreq;
    }

    //1876. Substrings of Size Three with Distinct Characters
    public static int countGoodSubstrings(String s) {
        int count = 0;

        for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && a != c && b != c) {
                count++;
            }
        }

        return count;
    }

    //349. Intersection of Two Arrays
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }

        return res;
    }

    public static int countGoodSubstring(String s) {
        Set<Character> tracker = new HashSet<>();
        int i=0;
        int count=0;

        tracker.add(s.charAt(i));
        for(int j=1;j<3;j++){
            if(!tracker.contains(s.charAt(j))) tracker.add(s.charAt(j));
        }
        if(tracker.size()==3) count++;
        for(int j=3;j<s.length();j++){
            tracker.remove(s.charAt(i));
            i++;
            tracker.add(s.charAt(i));
            tracker.add(s.charAt(j));
            if(tracker.size()==3) count++;
        }
        return count;
    }

    //350. Intersection of Two Arrays II
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num: nums2){
            if(map.get(num)!=null && map.get(num)!=0){
                list.add(num);
                map.put(num, map.getOrDefault(num,0)-1);
            }
        }
        int[] result = new int[list.size()];
        int i= 0;
        for(int num: list){
            result[i++] = num;
        }
        return result;
    }

    //392. Is Subsequence
    public static boolean isSubsequence(String s, String t) {
        int i=0; int j=0;

        if(s.equals("")) return true;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;j++;
                if(i==s.length()) return true;
            } else j++;
        }
        return false;
    }

    //541. Reverse String II
    public static String reverseStr(String s, int k) {
//        int numOfChars = s.length();
//        char[] arr = s.toCharArray();
//
//        for(int i = 0; i<s.length(); i++){
//            if(numOfChars<k){
//                reverseArr(arr,0, numOfChars);
//            } else if(numOfChars<2*k){
//
//            } else{
//
//            }
//        }
//        while(i<length) {
//            if (length < k) {
//                reverse(s, k);
//                i=length;
//            } else if (length >= k && length < 2 * k) {
//                reverse(s.substring(i, k + 1), k);
//                length = length-k;
//                i=k;
//            } else {
//                s = reverse(s.substring(i, 2 * k), k);
//                length = length-2 * k;
//                i=2*k;
//            }
//        }
        return s;
    }

    public static char[] reverseArr(char[] arr, int start, int end){
        int i=start;int j=end;
        while(i<=j){
            char temp = arr[i];
            arr[i] =arr[j];
            arr[j]=temp;
            i++;j--;
        }
        return arr;
    }

    //821. Shortest Distance to a Character
    public static int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        int i=0;int j=0;
        while(i<s.length() && j<s.length()){
            if(s.charAt(j)==c){
                answer[i]=Math.abs(i-j);
                i++;
            }  else j++;
            if(i<s.length() && s.charAt(i)==c && j!=i) j=i;
        }

        i=s.length()-1;j=s.length()-1;
        while(i>=0 && j>=0){
            if(s.charAt(j)==c){
                answer[i]=Math.min(answer[i],Math.abs(i-j));
                i--;
            }  else j--;
            if(i>=0 && s.charAt(i)==c && j!=i) j=i;
        }
        return answer;
    }

    //832. Flipping an Image
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int k = image[0].length-1;
            for(int j=0;j<image[0].length/2;j++){
                int temp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = temp;
                k--;
            }
        }
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]==0) image[i][j]=1;
                else image[i][j]=0;
            }
        }
        return image;
    }

    //1877. Minimize Maximum Pair Sum in Array
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int[] pair = new int[nums.length/2];
        int j=nums.length-1;
        for(int i=0;i<nums.length/2;i++){
            pair[i] = nums[i]+nums[j];
            j--;
        }
        int res =pair[0];
        for(int i=1;i<pair.length;i++){
            res = Math.max(pair[i], res);
        }
        return res;
    }

    public static int removeDuplicates2(int[] nums) {
        int i=0;int j=1;
        int count =1;
        while(i<=j){
            if(nums[i]==nums[j]){
//                if(nums[j]!=nums[j-1]){
//                    int temp = nums[j-1];
//                    nums[j-1] = nums[j];
//                    nums[j] = temp;
//                }
                count++;j++;i++;
            }
            if(count>=2){
                int j1=j;
                for(int j2=i;j2<nums.length-1;j2++){
                    int temp = nums[j2];
                    nums[j2] = nums[j1];
                    nums[j1] = temp;
                    j1++;
                }
            }
            if(count>=2) {
                count = 1;
                i++;
                j++;
            }
        }
        return i;
    }

    //151. Reverse Words in a String
    public static String reverseWord(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) result.append(" ");
        }

        return result.toString();
    }

    //189. Rotate Array
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    //217. Contains Duplicate
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    //121. Best Time to Buy and Sell Stock
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    //485. Max Consecutive Ones
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}
