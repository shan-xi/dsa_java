package ransom_note;

// 383. Ransom Note
// https://leetcode.com/problems/ransom-note/?envType=study-plan&id=data-structure-i
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] indices = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, indices[c - 'a']);
            if (index == -1) {
                return false;
            }
            indices[c - 'a'] = index + 1;
        }
        return true;


//        if (ransomNote.length() > magazine.length()) {
//            return false;
//        }
//        int[] charCount = new int[26];
//
//        for (int i = 0; i < magazine.length(); i++) {
//            charCount[magazine.charAt(i) - 'a']++;
//        }
//
//        for (int i = 0; i < ransomNote.length(); i++) {
//            charCount[ransomNote.charAt(i) - 'a']--;
//            if (charCount[ransomNote.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//
//        return true;

//        int[] countA = new int[26];
//        int[] countB = new int[26];
//        for (int i = 0; i < ransomNote.length(); i++) {
//            countA[ransomNote.charAt(i) - 'a'] += 1;
//        }
//        for (int i = 0; i < magazine.length(); i++) {
//            countB[magazine.charAt(i) - 'a'] += 1;
//        }
//        for (int i = 0; i < countA.length; i++) {
//            if (countA[i] != 0 && countB[i] < countA[i]) {
//                return false;
//            }
//        }
//        return true;
    }
}
