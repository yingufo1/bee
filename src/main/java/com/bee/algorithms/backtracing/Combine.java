package com.bee.algorithms.backtracing;import java.util.ArrayList;import java.util.LinkedList;import java.util.List;/** * 剑指 Offer II 080. 含有 k 个元素的组合:https://leetcode.cn/problems/uUsW3B/ * * @author yangying * @version 1.0 * @since 2022/5/31 **/public class Combine {    public List<List<Integer>> combine(int n, int k) {        List<List<Integer>> result = new ArrayList<>();        combine(n, k, 1, result, new LinkedList<>());        return result;    }    private void combine(int n, int k, int index, List<List<Integer>> result, List<Integer> combine) {        /*if(k == combine.size()){            result.add(new ArrayList<>(combine));        }else if(index<=n){            //并不选中当前            combine(n,k,index+1,result,combine);            //选中当前            combine.add(index);            combine(n,k,index+1,result,combine);            combine.remove(combine.size()-1);        }*/        if (index > n) {            return;        }        if (k == 0) {            result.add(new ArrayList<>(combine));            return;        }        combine(n, k, index + 1, result, combine);        //选中当前        combine.add(index);        combine(n, k-1, index + 1, result, combine);        combine.remove(combine.size() - 1);    }}