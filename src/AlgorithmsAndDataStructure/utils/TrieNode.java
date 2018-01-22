package AlgorithmsAndDataStructure.utils;

/**
 * @author Qian Shaofeng
 * created on 2018/1/22.
 */
public class TrieNode {

    public int path;

    public int end;

    public TrieNode[] map;

    public TrieNode(){
        map = new TrieNode[26];
    }
}
