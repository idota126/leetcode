package leetcode01;


import java.beans.IntrospectionException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-integer/
 * Created by idota126 on 2019-03-02.
 */
public class ReverseInteger {

    public int reverse(int x) {
        List<Integer> integerList = new ArrayList<>();
        while (x != 0 ){
            //获取个位
            int y = x%10 ;
            x = x/10;
            integerList.add(y);
        }
        double result = 0;
        for(int i = 0 ,j = integerList.size() ; i < integerList.size()   ; i++ ,j--){

            result =   Math.pow(10, j - 1) * integerList.get(i) +result;
            if(result > Integer.MAX_VALUE ||  result < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new ReverseInteger().reverse(1563847412));
        System.out.println(new ReverseInteger().reverse(122));
        System.out.println(new ReverseInteger().reverse(100));
    }

}
