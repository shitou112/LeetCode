package ArrayBase;

import java.util.*;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/29.
 */
public class T127_WordLadder_Ref {
    public int ladderLength(String start, String end, Set<String> dict) {
        // Use queue to help BFS
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add(null);

        // Mark visited word
        Set<String> visited = new HashSet<String>();
        visited.add(start);

        int level = 1;

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str != null) {
                // Modify str's each character (so word distance is 1)
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;

                        String word = new String(chars);

                        // Found the end word
                        if (word.equals(end)) return level + 1;

                        // Put it to the queue
                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        T127_WordLadder_Ref wordLadderII_126 = new T127_WordLadder_Ref();
        String begin = "hit";
        String end = "cow";

        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        HashSet<String> list = new HashSet<>();
        for (String ele: wordList)
            list.add(ele);
        int result = wordLadderII_126.ladderLength(begin, end, list);
        System.out.println(result);
    }
}
