class Solution {
    public void phone(int idx, String[] phone, String digits, List<String> ans, StringBuilder sb) {
		int n = digits.length();
		if(sb.length() == n) {
			ans.add(sb.toString());
			return;
		}
		for(int i = idx; i < n; i++) {
			int digit = digits.charAt(i) - '0';
			String t = phone[digit];
			for(int j = 0; j < t.length(); j++) {
				sb.append(t.charAt(j));
				phone(i+1, phone, digits, ans, sb);
				sb.deleteCharAt(sb.length()-1); // backtracking
			}
		}
	}
    public List<String> letterCombinations(String digits) {
        String[] phone = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
		phone(0, phone, digits, ans, sb);
        return ans;
    }
}