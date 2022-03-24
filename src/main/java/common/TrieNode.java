package common;


public class TrieNode {
    private Character value;
    private Boolean isWord;
    private TrieNode[] trieNode = new TrieNode[26];

    public TrieNode(Character character) {
        this.isWord = false;
        this.value = character;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public Boolean getWord() {
        return isWord;
    }

    public void setWord(Boolean word) {
        isWord = word;
    }

    public TrieNode[] getTrieNode() {
        return trieNode;
    }

    public void setTrieNode(TrieNode[] trieNode) {
        this.trieNode = trieNode;
    }
}
