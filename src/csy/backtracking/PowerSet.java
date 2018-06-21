package csy.backtracking;

import java.util.ArrayList;

/**
 * 给定一个集合(用ArrayList表示),返回这个集合的所有子集
 *
 */
public class PowerSet {
    public ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        int max = 1 << set.size();
        for(int i = 0; i < max; i ++) {
            ArrayList<Integer> subset = convertIntToSet(i, set);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    private ArrayList<Integer> convertIntToSet(int i, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for(int k = i; k > 0; k >>= 1) {
            if((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index += 1;
        }
        return subset;
    }

    public static void main(String[] args) {
        PowerSet so = new PowerSet();
        Integer[] tarry = {1, 2, 3};
        ArrayList<Integer> test1 = new ArrayList<>();
        for (Integer integer : tarry) {
            test1.add(integer);
        }
        System.out.println(so.getSubset(test1));
    }
}
