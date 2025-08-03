public class NumSmallThanCurr {
    //7ms, 70.27;
    //44.72 MB, 23.68;
    static int[] naive(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    
}
