//Problem: Sort the colors 0,1,2
//link: https://leetcode.com/problems/sort-colors/
//Source: LeetCode (75)
//Topics: Arrays
//Diff: med

public class SortColors {
    //0ms, best;
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int i : nums) {
            if (i == 0) {
                red++;
            }
            if (i == 1) {
                white++;
            }
            if (i == 2) {
                blue++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red) {
                nums[i] = 0;
            }
            else if (i < red+white) {
                nums[i] = 1;
            }
            else{
                nums[i] = 2;
            }
        }
    }
}
