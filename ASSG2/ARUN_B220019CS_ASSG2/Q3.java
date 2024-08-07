import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {
        String[][] strArray = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"interview", "interrupt", "integrate", "interval"},
            {"arun", "arunmm", "arunnats", "arunagain"}
        };

        Solution S = new Solution();

        for (String[] row : strArray) {
            String lcs = S.findLCS(row);
            if (!lcs.isEmpty()) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = row[i].replace(lcs, lcs.toUpperCase());
                }
            }
        }

        for (String[] row : strArray) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution{
  String findLCS(String[] strs) {
    if (strs == null || strs.length == 0) return "";
        String reference = strs[0];
        int n = reference.length();
        String longestCommonSubstring = "";

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String candidate = reference.substring(i, j);
                boolean isCommon = true;
                for (int k = 1; k < strs.length; k++) {
                    if (!strs[k].contains(candidate)) {
                        isCommon = false;
                        break;
                    }
                }
                if (isCommon && candidate.length() > longestCommonSubstring.length()) {
                    longestCommonSubstring = candidate;
                }
            }
        }
      return longestCommonSubstring;
  }
}
