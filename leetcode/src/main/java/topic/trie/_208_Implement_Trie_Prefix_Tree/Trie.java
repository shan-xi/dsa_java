package topic.trie._208_Implement_Trie_Prefix_Tree;

public class Trie {

    private final TrieNode root;

    // Initialize the Trie
    public Trie() {
        root = new TrieNode();
    }

    // Test function
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true

        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }

    // Returns true if the word is in the Trie
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEndOfWord;
    }

    // Returns true if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    // Helper function to find the node corresponding to the given string
    private TrieNode find(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    // Trie Node definition
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // Only lowercase English letters
            isEndOfWord = false;
        }
    }
}
