import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumberSolution {
  private static final String[] MAP = {
      "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
  };

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.isEmpty()) return result;

    result.add("");

    for (int i = 0; i < digits.length(); i++) {
      String letters = MAP[digits.charAt(i) - '0'];
      List<String> next = new ArrayList<>();

      for (String current : result) {
        for (int j = 0; j < letters.length(); j++) {
          next.add(current + letters.charAt(j));
        }
      }

      result = next;
    }

    return result;
  }
}
