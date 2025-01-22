class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        else {
            return pad("", digits);
        }
    }

    static List<String> pad(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0'; // this will convert '2' into 2

        List<String> ans = new ArrayList<>();

        if (digit == 7) {
            for (int i = 15; i < 19; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(p + ch, up.substring(1)));
            }
        } else if (digit == 9) {
            for (int i = 22; i < 26; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(p + ch, up.substring(1)));
            }
        } else if (digit == 8) {
            for (int i = 19; i < 22; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(p + ch, up.substring(1)));
            }
        } else {
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(p + ch, up.substring(1)));
            }
        }

        return ans;
    }
}