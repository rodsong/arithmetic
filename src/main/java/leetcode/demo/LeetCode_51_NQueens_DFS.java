package leetcode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>leetcode.demo.LeetCode_51_NQueens</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月12日
 * <p>
 * <p>
 * <p>
 * 8皇后问题
 */
public class LeetCode_51_NQueens_DFS {

    //用row区分行数每行只存放一个皇后，以不需要对行在进行符合条件的校验
    //归存放皇后queens存放皇后所在列数；
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        helper(res, new int[n], 0);
        return res;
    }

    public void helper(List<List<String>> res, int[] queens, int row) {
        if (row == queens.length) {
            addSolution(res, queens);
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            queens[row] = i;
            if (isValid(queens, row)) {
                helper(res, queens, row + 1);
            }
        }
    }

    public boolean isValid(int[] queens, int row) {

        for (int i = 0; i < row; i++) {
            //同在一列返回false
            if (queens[i] == queens[row]) {
                return false;
            } else if (Math.abs(queens[i] - queens[row]) == Math.abs(row - i)) {//在同一斜行返回false；
                return false;
            }
        }
        return true;

    }

    public void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {//外层循环表示每一行
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {//内层循环表示每一列
                if (queens[i] == j) {//如果列数和已存储皇后位置相同则放Q
                    sb.append("Q");
                } else {//此位置没有皇后存放
                    sb.append(".");
                }

            }
            list.add(sb.toString());
        }
        res.add(list);
    }


    public static void main(String[] args) {
        LeetCode_51_NQueens_DFS test = new LeetCode_51_NQueens_DFS();
        List<List<String>> result = test.solveNQueens(4);

        for(List<String> temp:result){
            for(String row :temp){
                System.out.println(row);
            }
            System.out.println("");
            System.out.println("====");
        }
    }
}
