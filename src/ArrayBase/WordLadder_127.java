package ArrayBase;

import java.util.*;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/28.
 */
public class WordLadder_127 {
    public int ladderLength(String start, String end, Set<String> dict) {
        int dist = calDistance(start, end);
        if (dist == 1) {
            return 2;
        }

        return bfsDict(dict, start, end);
    }

    private int calDistance(String word1, String word2) {
        int dist = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                dist += 1;
            }
        }

        return dist;
    }

    private void enQueue(Set<String> dict, LinkedList<String> queue, String target, Map<String, Integer> map, int step) {
        if (dict == null || dict.isEmpty()) {
            return;
        }

        for (int i = 0; i < target.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sBuilder = new StringBuilder(target);
                if (sBuilder.charAt(i) == c) {
                    continue;
                }
                sBuilder.setCharAt(i, c);
                if (dict.contains(sBuilder.toString())) {
                    queue.addLast(sBuilder.toString());
                    dict.remove(sBuilder.toString());
                    map.put(sBuilder.toString(), step + 1);
                }
            }
        }
    }

    private int bfsDict(Set<String> dict, String start, String end) {
        LinkedList<String> queue = new LinkedList<String>();
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        enQueue(dict, queue, start, hashMap, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = hashMap.get(word);
            if (calDistance(word, end) == 1) {
                return step + 1;
            }

            enQueue(dict, queue, word, hashMap, step);
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder_127 wordLadder = new WordLadder_127();
        String begin = "qa";
        String end = "sq";

        String[] wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        };
        Set<String> list = new HashSet<>();
        for (String ele: wordList)
            list.add(ele);
        wordLadder.ladderLength(begin, end, list);
    }
}
