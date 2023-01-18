package leecode;

import java.util.*;

/**
 * @author luofan
 */
public class 字母异位词分组_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            List<String> orDefault = map.getOrDefault(string, new ArrayList<>());
            orDefault.add(str);
            map.put(string, orDefault);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }
}
