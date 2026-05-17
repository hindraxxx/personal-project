package leetcode_session;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringConcatenation {
  public void main(){
    Deque<String> stack = new ArrayDeque<>();
    System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
  }


  public List<Integer> findSubstring(String s, String[] words) {
    HashMap<String, Integer> map = new HashMap<>();

    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    List<Integer> ans = new ArrayList<>();

    int numberOfWords = words.length;
    int wordsLength = words[0].length();
    int n = wordsLength * numberOfWords;

    for (int i = 0; i <= s.length() - n; i++) {
      String substring = s.substring(i, i + n);

      HashMap<String, Integer> currentMap = new HashMap<>();

      for (int j = 0; j < substring.length(); j += wordsLength) {
        String wordChunk = substring.substring(j, j + wordsLength);

        currentMap.put(
            wordChunk,
            currentMap.getOrDefault(wordChunk, 0) + 1
        );
      }

      if (currentMap.equals(map)) {
        ans.add(i);
      }
    }

    return ans;
  }
}
