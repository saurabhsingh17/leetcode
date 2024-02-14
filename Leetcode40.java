import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {

    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));;
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
         solve(candidates,new ArrayList<>(),0,target,result);
         return result;
    }
    static void solve(int[] candidates,List<Integer> output, int pos, int target,List<List<Integer>> result){
        if (target == 0) {
            result.add(output);
        }
        if(target <= 0) {
             return;
        }
        for (int i = pos; i < candidates.length ; i++) {
            if (i> pos && candidates[i] == candidates[i-1]){
                continue;
            }
            output.add(candidates[i]);
            solve(candidates,new ArrayList<>(output),i+1,target-candidates[i],result);
            output.remove(output.size()-1);
        }
    }
}
