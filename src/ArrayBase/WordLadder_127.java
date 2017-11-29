package ArrayBase;

import java.util.*;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/28.
 */
public class WordLadder_127 {
    HashMap<String, Integer> path = new HashMap<>();
    public int ladderLength(String start, String end, List<String> dict) {
        HashSet<String> wordSet = new HashSet<>(dict);
        bfs(start, end, wordSet);
        int length = path.getOrDefault(end, -1);

        return length+1;

    }

    public void bfs(String start, String end, HashSet<String> wordSet){
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        path.put(start, 0);
        while (queue.peek() != null){
            String ele = queue.poll();
            for (int i=0; i < ele.length(); ++i){
                StringBuilder sb = new StringBuilder(ele);
                for (char ch='a'; ch <= 'z'; ++ch){
                    sb.setCharAt(i, ch);
                    if (sb.charAt(i) == ele.charAt(i))
                        continue;

                    if (wordSet.contains(sb.toString())){
                        if (!path.containsKey(sb.toString())){
                            int value = path.get(ele);
                            queue.add(sb.toString());
                            path.put(sb.toString(), value + 1);
                        }
                    }
                }
                sb.setCharAt(i, ele.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        WordLadder_127 wordLadderII_126 = new WordLadder_127();
        String begin = "hit";
        String end = "cow";

        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        ArrayList<String> list = new ArrayList<>();
        for (String ele: wordList)
            list.add(ele);
        int result = wordLadderII_126.ladderLength(begin, end, list);
        System.out.println(result);
    }


}
