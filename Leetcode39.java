import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {
    public static void main(String[] args) {

        int[] c = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum(c, target));
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        solve2(candidates,new ArrayList<>(),0,target,result);
        return result;
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
    static void solve2(int[] candidates,List<Integer> output, int pos, int target,List<List<Integer>> result){
        if (target == 0) {
            result.add(output);
        }
        if(target <= 0) {
            return;
        }
        for (int i = pos; i < candidates.length ; i++) {
            output.add(candidates[i]);
            solve2(candidates,new ArrayList<>(output),i,target-candidates[i],result);
            output.remove(output.size()-1);
        }
    }
}
