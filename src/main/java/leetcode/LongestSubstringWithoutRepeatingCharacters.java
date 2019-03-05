package leetcode;

import java.util.*;

/**
 * @Description: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author idota
 * @Date 2019/1/16
 */
public class LongestSubstringWithoutRepeatingCharacters {

    //比较耗时的方法。。。。 找下标 重新构造不重复的子字符串
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        int maxlimit = set.size();
        Map<Character,Integer> charPositionMap = new LinkedHashMap<>();
        List<Character> characterList = new ArrayList<>();

        int maxSize = 0;
        for (int i = 0; i < chars.length; i++) {
            if (charPositionMap.get(chars[i])!=null) {
                Integer firstPositionIndex = charPositionMap.get(chars[i]);
                if(firstPositionIndex == null){
                    charPositionMap.put(chars[i],characterList.size());
                }
                firstPositionIndex = charPositionMap.get(chars[i]);
                characterList = characterList.subList(firstPositionIndex+1,characterList.size());
                characterList.add(chars[i]);
                charPositionMap.clear();
                for(int j = 0 ;j<characterList.size();j++){
                    charPositionMap.put(characterList.get(j),j);
                }
            } else {
                charPositionMap.put(chars[i],characterList.size());
                characterList.add(chars[i]);

            }
            int currentSize = characterList.size();
            if(currentSize == maxlimit){
                maxSize = maxlimit;
                break;
            }
            if (currentSize > maxSize) {
                maxSize = currentSize;
            }
        }
        return maxSize;
    }


    //优化方法  出现重复字符串删除至重复的char  来构造 不重复子字符串
//    public static int lengthOfLongestSubstring2(String s) {
//        if(s == null || s.length() == 0 ){
//            return 0;
//        }
//
//
//
//
//
//    }



    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
