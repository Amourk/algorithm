package LeetCode;

public class LC18 {
    /**
     * 实现字典树(前缀数)
     *
     * */
}

class Trie {
    class TrieNode {
        public Character value;
        public Boolean isWord;
        public TrieNode[] trieNode = new TrieNode[26];

        TrieNode(Character character) {
            this.isWord = false;
            this.value = character;
        }
    }

    public TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode ws = root;
        char[] chars = word.toCharArray();
        for (Character cha : chars) {
            if (ws.trieNode[cha - 'a'] == null) {
                ws.trieNode[cha - 'a'] = new TrieNode(cha);
            }
            ws = ws.trieNode[cha - 'a'];

        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode ws = root;
        char[] chars = word.toCharArray();
        for (Character cha : chars) {
            if (ws.trieNode[cha - 'a'] == null) {
                return false;
            }
            ws = ws.trieNode[cha - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        char[] chars = prefix.toCharArray();
        for (Character cha : chars) {
            if (ws.trieNode[cha - 'a'] == null) {
                return false;
            }
            ws = ws.trieNode[cha - 'a'];
        }
        return true;
    }
}
