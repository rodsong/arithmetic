package lc.demo;

/**
 * <p>EO_test</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月07日
 * <p>
 * <p>
 * 数组中只出现一次的数字
 */
public class EO_test {

    public static void main(String[] args) {
        int[] test = {3, 4, 5, 4, 5};

        int result = test[0];
        for (int x = 1; x < test.length; x++) {
            result  ^= test[x];
        }
        System.out.println(3^3^4);
    }
}
