package ArrayBase;

import java.util.*;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/28.
 */
public class T126_WordLadderII {

    HashMap<String, Integer> path = new HashMap<>();
    ArrayList<String> results = new ArrayList<>();
    List<List<String>> all_list = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        bfs(beginWord, endWord, wordSet);
        dfs(endWord, beginWord, path, path.getOrDefault(endWord, -1));

        return all_list;
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

    public void dfs(String start, String end, HashMap<String, Integer> path, int step){
        if (step < 0)
            return;
        if (start.equals(end)){
            results.add(end);
            ArrayList<String> newList = new ArrayList<>(results);
            results.remove(results.lastIndexOf(end));
            Collections.reverse(newList);
            all_list.add(newList);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        results.add(start);
        while (queue.peek()!=null){
            String ele = queue.poll();
            for (int i=0; i < ele.length(); ++i){
                StringBuilder sb = new StringBuilder(ele);
                for (char ch='a'; ch <= 'z'; ++ch){
                    sb.setCharAt(i, ch);
                    if (sb.charAt(i) == ele.charAt(i))
                        continue;
                    if (path.getOrDefault(sb.toString(), -1)==step-1){
                        dfs(sb.toString(), end, path, step-1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        T126_WordLadderII t_126WordLadderII = new T126_WordLadderII();
        String begin = "qa";
        String end = "sw";

        String[] wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        };
        List<String> list = new ArrayList<>();
        for (String ele: wordList)
            list.add(ele);
        List<List<String>> result = t_126WordLadderII.findLadders(begin, end, list);
    }
}
