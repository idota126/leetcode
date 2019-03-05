package leetcode;

import java.util.*;

/**
 * @Description:
 * https://leetcode.com/problems/pascals-triangle-ii/
 * @Author idota
 * @Date 2019/3/1
 */
public class PascalTriangleTwo {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex+1);
        result.add(1);
        if(rowIndex == 0){
            return result;
        }
        //todo

        return result;
    }

}
