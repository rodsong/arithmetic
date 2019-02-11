/**
 * <p>Numberof1</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月07日
 *
 *
 * 输入一个整数n，求1~n个整数中1出现的次数
 * 例如输入12，1~12中（1，10，11，12）其中1共出现5次
 */
public class Numberof1 {

    private int numberof1(int x) {
        int count = 0;
        while (x > 0) {
            if (x % 10 == 1) {
                count++;
            }
            x = x / 10;
        }
        return count;
    }

    public int total(int target) {
        int total = 0;
        for (int i = 1; i <= target; i++) {
            total += numberof1(i);
        }

        return total;
    }


    public static void main(String[] args) {
        Numberof1 test = new Numberof1();
        //System.out.println(test.numberof1(111));
        System.out.println(test.total(21345));
        Math.max(1,2);
    }
}
