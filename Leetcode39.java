import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {
    public static void main(String[] args) {

        int[] c = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSumm(c, target));
    }

    static List<List<Integer>> combinationSumm(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        solve(candidates, new ArrayList<>(), target, 0, res);
        return res;
    }

    static void solve(int[] candidates, List<Integer> output, int target, int index, List<List<Integer>> result) {
        if (target == 0) {
            result.add(output);
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }

        output.add(candidates[index]);
        solve(candidates, new ArrayList<>(output), target - candidates[index], index + 1, result);
        output.remove(output.size() - 1);
        solve(candidates, new ArrayList<>(output), target, index + 1, result);
    }
}
