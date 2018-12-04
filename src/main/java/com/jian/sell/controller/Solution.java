package com.jian.sell.controller;

import org.springframework.stereotype.Controller;

import java.util.*;

@Controller

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(J.contains(S.substring(i, i + 1))){
                count ++;
            }
        }
        return count;
    }
}

class Solution1 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set set = new HashSet();
        for (Character character : J.toCharArray()){
            set.add(character);
        }
        for (Character character : S.toCharArray()){
            if(set.contains(character)){
                count ++;
            }
        }
        return count;
    }
}

class LRUCache {

    private List<Integer> list;

    private HashMap<Integer, Integer> map;

    private int size;

    public LRUCache(int capacity) {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.size = capacity;
    }

    public int get(int key) {
        int res = map.getOrDefault(key, -1);
        if (res != -1){
            int first = list.remove(list.indexOf(key));
            list.add(first);
        }
        return res;
    }

    public void put(int key, int value) {
        if (list.contains(key)){
            int temp = list.remove(list.indexOf(key));
        } else if (list.size() >= size) {
            int first = list.remove(0);
            map.remove(first);
        }
        list.add(key);
        map.put(key, value);
    }
}

class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {


        if (map.containsKey(val)){
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        } else {
            int pos = map.get(val);
            if (pos < list.size() - 1){
                int newval = list.get(list.size() - 1);
                list.set(pos, newval);
                map.put(newval, pos);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        Integer number = random.nextInt(list.size() - 1);
        return list.get(number);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

class Solution2 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        /*for (int i = 0; i < S.length(); i++){
            if (!map.containsKey(S.charAt(i))){

            }
        }*/

        return res;
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution3 {
    private Integer min = Integer.MAX_VALUE;;
    private Integer prev = null;
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return min;
    }
    private void helper(TreeNode root){
        if (root == null) {
            return;
        }
        helper(root.left);

        prev = root.val;
        helper(root.right);
    }
}

class Solution4 {
    public int[] dailyTemperatures(int[] T) {
        int res[] = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            res[i] = T[i + 1] - T[i];
        }
        res[res.length - 1] = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                res[i] = 1;
            } else if (res[i] <= 0) {
                int count = 0;
                int temp = i;
                while (temp < T.length - 1 && res[temp] < 0) {
                    res[temp] += res[temp + 1];
                    count += 1;
                }
                //if (temp == )
            }
        }

        return res;
    }
}

class Solution5 {
    int count = 1;
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            checkPalindrome(s, i , i);
            checkPalindrome(s, i, i + 1);
        }
        return count;
    }

    private void checkPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count ++;
            i--;
            j++;
        }
    }
}

class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution6 {
    private class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            //return o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1;
            return Integer.compare(o1.start, o2.start);
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<>();

        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
}

class Solution7 {
    public boolean checkValidString(String s) {
        Stack<Character> parenthesis = new Stack<>();
        Stack<Character> star = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                parenthesis.push(c);
            }
            if (c == '*') {
                star.push(c);
            }
            if (c == ')') {
                if (star.empty() && parenthesis.empty()) {
                    return false;
                }
                if (!star.empty()) {
                    star.pop();
                } else {
                    parenthesis.pop();
                }
            }
        }
        return parenthesis.size() <= star.size();
    }
}