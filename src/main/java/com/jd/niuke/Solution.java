package com.jd.niuke;


/**
 * @author FM
 * @Description
 * @create 2020-10-10 22:56
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int minIndex = 0;
        int maxIndex = nums.length - 1;
        while (minIndex<maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            if (nums[midIndex] < target) {
                minIndex = midIndex + 1;
            } else if (nums[midIndex] > target) {
                maxIndex = midIndex - 1;
            } else {
                maxIndex=midIndex;
            }
        }
        if(nums[minIndex]==target){
            return minIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        //[1,2,4,4,5],4
        int[] num={1,2,4,4,5};
        int target=4;
        int search = new Solution().search(num, target);
        System.out.println(search);
    }

}
