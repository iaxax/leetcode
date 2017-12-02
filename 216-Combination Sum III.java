public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> selected = new LinkedList<>();
        combinationSum(result, selected, 1, n, k);
        return result;
    }
    
    private void combinationSum(List<List<Integer>> result, LinkedList<Integer> selected,
                                int start, int remain, int numToSelect) {
        if (numToSelect == 0 && remain == 0) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addAll(selected);
            result.add(list);
            return;
        }
        
        if (numToSelect > 0 && start <= 9 && start <= remain) {
            selected.addLast(start);
            combinationSum(result, selected, start + 1, remain - start, numToSelect - 1);
            selected.removeLast();
            combinationSum(result, selected, start + 1, remain, numToSelect);
        }
    }
}

