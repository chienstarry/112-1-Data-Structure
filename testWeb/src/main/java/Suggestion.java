import java.util.ArrayList;
import java.util.List;

public class Suggestion {

	private ArrayList<Keyword> keywords;

	public Suggestion(ArrayList<Keyword> k) {
		this.keywords = k;
	}

	public List<String> getSuggestions(String userInput) {
		List<String> suggestions = new ArrayList<>();

		for (Keyword keyword : keywords) {
			int lcsLength = findLCSLength(userInput, keyword.name);
			if (lcsLength > 0) { // 此處可調整閾值
				suggestions.add(keyword.name);
			}
		}
		return suggestions;
	}

	public int findLCSLength(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

}
