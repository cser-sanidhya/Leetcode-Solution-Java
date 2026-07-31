class Solution {
    public boolean wordPattern(String pattern, String s) {
         HashMap<Character, String> charToWord = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {

                if (!charToWord.get(c).equals(word)) {
                    return false;
                }

            } else {

                if (charToWord.containsValue(word)) {
                    return false;
                }

                charToWord.put(c, word);
            }
        }

        return true;
        
    }
}
