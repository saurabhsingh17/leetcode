import java.util.Arrays;

public class Leetcode2966 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        int[] arr2 = {1,3,3,2,7,3};
        System.out.println((Arrays.deepToString(divideArray(arr, k))));
    }

    public static int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length / 3][3];
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 3) {

            if (nums[i + 2] - nums[i] <= k) {
                int[] currentArr = new int[3];
                result[count][0] = nums[i];
                result[count][1] = nums[i + 1];
                result[count][2] = nums[i + 2];
                count++;
            } else
                return new int[0][0];
        }
        return result;
    }
}
