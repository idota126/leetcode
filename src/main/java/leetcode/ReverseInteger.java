package leetcode;


import java.util.ArrayList;
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

    //优化版本
    public int reverse_perfect(int x){
        long res = 0;
        while(x != 0){
           res = res * 10 +  x % 10;
           x = x / 10;
        }
        return res == (int) res ? (int)res : 0;

    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new ReverseInteger().reverse(1563847412));
        System.out.println(new ReverseInteger().reverse(122));
        System.out.println(new ReverseInteger().reverse(100));
    }

}
