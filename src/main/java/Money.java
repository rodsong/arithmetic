import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>money</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年01月22日
 * <p>
 * <p>
 * 阿拉伯数字中间有“0”时，中文大写金额中间可以只写一个“零”字。如￥1，409.50，应写成人民币壹仟肆佰零玖元伍角。
 * 阿拉伯数字中间连续有几个“0”，中文大写金额中间可以只写一个“零”字，如￥6，007.14，应写成人民币陆仟零柒元壹角肆分。
 * 阿拉伯金额数字万位或元位是“0”，或者数字中间连续有几个“0”，万位、元位也是“0”，但仟位、角位不是“0”时，中文大写金额中可以只写一个零字，也可以不写“零”字，如￥1，680.32，应写成人民币壹仟陆佰捌拾元零三角贰分，或者写成人民币壹仟陆佰捌拾元三角贰分；又如￥107，000.53，应写成人民币壹拾万柒仟元零伍角叁分，或者写成人民币壹拾万柒仟元伍角叁分。
 * 阿拉伯金额数字角位是“0”，而分位不是“0”时，中文大写金额“元”后面应写“零”字。如￥16，409.02，应写成人民币壹万陆仟肆佰零玖元零贰分；又如￥325.04，应写成人民币叁佰贰拾元零肆分。
 * 大写金额到“元”为止的，在“元”之后应写上“整”或“正”字，在“角”之后可以不写“整”或“正”字，在“分”之后的不写”整“或”正“字
 */
public class Money {

    public static String moneyToChinese(BigDecimal i_money) {
        if(i_money.equals(BigDecimal.ZERO)){
            return "零圆整";
        }
        if (i_money.doubleValue() >= 100000000 || i_money.doubleValue() < 0.01) {
            return "";
        }

        i_money = i_money.setScale(2, RoundingMode.HALF_UP);
        String numStr = i_money.toString();
        int pointPos = numStr.indexOf('.');
        String s_int = null; //整数部分
        String s_point = null; //小数部分
        if (pointPos >= 0) {
            s_int = numStr.substring(0, pointPos);
            s_point = numStr.substring(pointPos + 1);
        } else {
            s_int = numStr;
        }

        StringBuilder sb = new StringBuilder();
        if(!"0".equals(s_int)){
            int groupCount = (int) Math.ceil(s_int.length() / 4.0);
            for (int group = 0; group < groupCount; group++) {
                boolean zeroFlag = true;
                boolean noZeroFlag = false;
                int start = (s_int.length() % 4 == 0 ? 0 : (s_int.length() % 4 - 4)) + 4 * group;
                for (int i = 0; i < 4; i++) {
                    if (i + start >= 0) {
                        int value = s_int.charAt(i + start) - '0';
                        if (value > 0) {
                            sb.append(CN_UPPER_NUMBER[value]);
                            if (i < 3) {
                                sb.append(CN_UPPER_UNIT[i]);
                            }
                            zeroFlag = true;
                            noZeroFlag = true;
                        } else if (zeroFlag) {
                            sb.append('零');
                            zeroFlag = false;
                        }
                    }
                }
                if(sb.charAt(sb.length() - 1) == '零'){
                    sb.deleteCharAt(sb.length() - 1);
                }
                if(noZeroFlag || groupCount - group == 1){
                    sb.append(CN_GROUP[groupCount - group - 1]);
                }
            }
        }
        if (s_point == null || "00".equals(s_point)) {
            sb.append('整');
        }else{
            int j = s_point.charAt(0) - '0';
            int f = s_point.charAt(1) - '0';
            if(j > 0){
                sb.append(CN_UPPER_NUMBER[j]).append('角');
                if(f != 0){
                    sb.append(CN_UPPER_NUMBER[f]).append('分');
                }
            }else if("0".equals(s_int)){
                sb.append(CN_UPPER_NUMBER[f]).append('分');
            }else {
                sb.append('零').append(CN_UPPER_NUMBER[f]).append('分');
            }
        }
        return sb.toString();
    }


    private static final char[] CN_UPPER_NUMBER = "零壹贰叁肆伍陆柒捌玖".toCharArray();
    private static final char[] CN_UPPER_UNIT = "仟佰拾".toCharArray();
    private static final char[] CN_GROUP = "圆万亿".toCharArray();

    public static void main(String[] args) {
       System.out.println( moneyToChinese(new BigDecimal(16007.14)));
    }
}
