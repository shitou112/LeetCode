package AlgorithmsAndDataStructure.chapter5;

import AlgorithmsAndDataStructure.utils.TrieNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/22.
 */
public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public boolean search(String word){
        if (word==null)
            return false;

        char[] chs = word.toCharArray();
        TrieNode cur = root;
        int index;
        for (int i=0; i < chs.length; ++i){
            index = chs[i] - 'a';
            if (cur.map[index] == null){
                return false;
            }

            cur = cur.map[index];
        }

        return cur.end>0;
    }

    public void insert(String word){
        if (word==null)
            return;

        char[] chs = word.toCharArray();
        TrieNode cur = root;
        int index;
        for (int i=0; i < chs.length; ++i){
            index = chs[i] - 'a';
            if (cur.map[index] == null){
                cur.map[index] = new TrieNode();
            }

            cur = cur.map[index];
            ++cur.path;
        }

        ++cur.end;
    }

    public void delete(String word){
        if (word==null)
            return;

        char[] chs = word.toCharArray();
        TrieNode cur = root;
        int index;
        if (search(word)){
            for (int i=0; i < chs.length; ++i){
                index = chs[i] - 'a';
                cur = cur.map[index];
                --cur.path;
            }
            --cur.end;
        }
    }

    public int prefixNumber(String word){
        if (word==null)
            return 0;

        char[] chs = word.toCharArray();
        TrieNode cur = root;
        int index;
        for (int i=0; i < chs.length; ++i){
            index = chs[i] - 'a';
            if (cur.map[index]==null)
                return 0;
            cur = cur.map[index];
        }

        return cur.path;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abaad");
        System.out.println(trie.search("abaad"));
        System.out.println(trie.prefixNumber("abaad"));
        trie.delete("abaad");
        System.out.println();
    }
}
