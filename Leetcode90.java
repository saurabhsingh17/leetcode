import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode90 {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(subsetsWithDup(nums));
    }

    static List<List<Integer>> subsetsWithDup(int[] nums) {

        int index = 0;
        List<List<Integer>> result = new ArrayList();
        solve(nums, new ArrayList(), result, index);
        return result;
    }

    static void solve(int[] nums, List<Integer> output, List<List<Integer>> result, int index) {
        if (index == nums.length) {

            Collections.sort(output);
            if (!result.contains(output))
                result.add(output);
            return;
        }
        List<Integer> choiceOne = new ArrayList(output);
        List<Integer> choiceTwo = new ArrayList(output);
        choiceOne.add(nums[index++]);
        solve(nums, choiceOne, result, index);
        solve(nums, choiceTwo, result, index);
    }
}
