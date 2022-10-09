import java.util.HashMap;
import java.util.Map;

public class DistinctSubstring {

    public static int countSubstring(String s, int k) {
        int count = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            for (int j = i + k; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (checkIfKDistinctChars(substring, k)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean checkIfKDistinctChars(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map.size() == k;
    }

    public static void main(String[] args) {
        String input = "stristr";
        int k = 4;
        System.out.println(countSubstring(input, k));
    }
}