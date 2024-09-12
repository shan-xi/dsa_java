package topic.trie._211_Design_Add_and_Search_Words_Data_Structure;

public class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Main function for testing
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true (matches "bad", "dad", "mad")
        System.out.println(wordDictionary.search("b..")); // true (matches "bad")
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of a valid word
    }

    // Returns if the word is in the data structure. A word could contain the '.' to represent any one letter.
    public boolean search(String word) {
        return searchInNode(word, root, 0);
    }

    // Helper function to search the word with support for '.' wildcard
    private boolean searchInNode(String word, TrieNode node, int index) {
        if (node == null) return false; // Invalid path in Trie

        if (index == word.length()) {
            return node.isEndOfWord; // End of word, check if it's a valid end
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            // Wildcard case, explore all possible children
            for (TrieNode child : node.children) {
                if (searchInNode(word, child, index + 1)) {
                    return true;
                }
            }
            return false; // No match found for any children
        } else {
            // Normal character case, just go to the corresponding child
            int charIndex = ch - 'a';
            return searchInNode(word, node.children[charIndex], index + 1);
        }
    }

    // TrieNode definition
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // 26 letters for each lowercase alphabet
            isEndOfWord = false;
        }
    }
}
