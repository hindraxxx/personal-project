import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingSolution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> seen = new HashSet<>();
    int left = 0;
    int best = 0;

    for (int right = 0; right < s.length(); right++) {
      char current = s.charAt(right);

      while (seen.contains(current)) {
        seen.remove(s.charAt(left));
        left++;
      }

      seen.add(current);
      best = Math.max(best, right - left + 1);
    }

    return best;
  }
}
