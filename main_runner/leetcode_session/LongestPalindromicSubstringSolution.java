public class LongestPalindromicSubstringSolution {
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) return s;

    int bestStart = 0;
    int bestLength = 1;

    for (int i = 0; i < s.length(); i++) {
      int odd = expand(s, i, i);
      int even = expand(s, i, i + 1);
      int length = Math.max(odd, even);

      if (length > bestLength) {
        bestLength = length;
        bestStart = i - (length - 1) / 2;
      }
    }

    return s.substring(bestStart, bestStart + bestLength);
  }

  private int expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }

    return right - left - 1;
  }
}
