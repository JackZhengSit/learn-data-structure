package com.jack.leetcode;

class Solution33 {
  public static void main(String[] args) {
    int[] nums = {2, 3, 4, 5, 1};
    int target = 1;
    Solution s = new Solution();
    System.out.println(s.search(nums, target));
  }
}

class Solution {
  public int search(int[] nums, int target) {

    //    if(nums[nums.length-1]==target)
    //         return nums.length-1;
    //    else if(nums[0]==target){
    //         return 0;
    //    }else if(nums[0]<nums[nums.length-1])
    //         return bSearchC(nums,0,nums.length-1,target);
    //    else if(nums[nums.length-1]<target&&target<nums[0]){
    //         return -1;
    //    }else if(target>nums[0]){
    //         int low=0;
    //         int high=nums.length-1-nums[nums.length-1];
    //         return bSearchC(nums,low,high,target);
    //    }
    //    else{
    //         int low=nums.length-1-nums[0];
    //         low=low<0?0:low;
    //         int high=nums.length-1;
    //         return bSearchC(nums,low,high,target);
    //    }

    // k=0时
    if (nums[0] <= nums[nums.length - 1]) {
      return bSearchC(nums, 0, nums.length - 1, target);
    }
    // k!=0时
    else {
      int k = findK(nums, 0, nums.length - 1);
      // 当target在第一段有序数组中时
      if (target >= nums[0]) {
        return bSearchC(nums, 0, k, target);
      } else {
        return bSearchC(nums, k, nums.length - 1, target);
      }
    }
  }

  int findK(int[] a, int low, int high) {
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[0] < a[mid]) {
        if (mid != a.length - 1 && a[mid + 1] < a[0]) return mid + 1;

        low = mid + 1;
      } else {
        if (mid != 0 && a[mid - 1] > a[0]) return mid;
        high = mid - 1;
      }
    }
    return 1;
  }

  int bSearchC(int[] a, int low, int high, int val) {
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[mid] == val) return mid;
      if (a[mid] > val) high = mid - 1;
      if (a[mid] < val) low = mid + 1;
    }
    return -1;
  }
}
