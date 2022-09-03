package serialization_deserialization;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.OptionalInt;

import static java.util.Objects.isNull;
import static org.hibernate.internal.util.StringHelper.isBlank;

public class neetcode {

    public static void main(String[] args) {
//        System.out.println(isAnagram("aacc","ccac"));
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
//        findMax(new int[]{1, 6, 9, 3, 6, 1, 0});
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));

    }

//    public static boolean isAnagram(String s, String t) {
//
//        String[] sArr = s.split("");
//        String[] tArr = t.split("");
//
//        for (int i = 0; i < sArr.length; i++) {
//            for (int j = 0; j < tArr.length; j++) {
//                if (sArr[i].equals(tArr[j])) {
//                    sArr[i] = "";
//                    tArr[j] = "";
//                }
//            }
//        }
//
//        String s1 = "";
//        for (String letter : sArr
//        ) {
//            s1 += letter;
//        }
//        if (s1.isEmpty() && sArr.length == tArr.length) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static boolean isPalindrome(String s) {
//        String sReverse = "";
//
//        String sWithoutSpecial = s.replaceAll("[^a-zA-Z\\d]", "");
//        String sWithoutAnything = sWithoutSpecial.replaceAll("\\s", "").toLowerCase();
//
//
//        for (int i = sWithoutAnything.length() - 1; i > -1; i--) {
//            sReverse += sWithoutAnything.charAt(i);
//        }
//
//        System.out.println(sReverse);
//        System.out.println(sWithoutAnything);
//
//        return sWithoutAnything.equals(sReverse);
//    }
//
//    public static int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                int res = prices[j] - prices[i];
//                if (res > max) {
//                    max = res;
//                }
//            }
//        }
//        return max;
//    }
//
//
//    //find max element of an non-sorted array without using any loop.
//    public static void findMax(int[] arr) {
////       int max = Arrays.stream(arr).max().getAsInt();
////        System.out.println(max);
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < min) {
//                min = arr[i];
//            }
//        }
//        return min;
//    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}


