package ArrayBase;

import java.util.*;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/28.
 */
public class WordLadderII_126 {

    List<List<String>> all_list = new ArrayList<>();
    int minNum = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordlists = new HashSet<>(wordList);
        List<List<String>> minLists = new ArrayList<>();
        HashMap<String, Integer> word2Index = new HashMap<>();
        int index = 0;
        word2Index.put(beginWord, index++);
        for (String ele: wordlists){
            word2Index.put(ele, index++);
        }
        boolean[][] visited = new boolean[index][index];

        ArrayList<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        search(beginWord, endWord, wordlists, visited, word2Index, beginList);

        for (List<String> ele: all_list){
            if (ele.size() == minNum){
                minLists.add(ele);
            }
        }

        return minLists;
    }

    public void search(String beginWord, String endWord, HashSet<String> wordList, boolean[][] visited, HashMap<String, Integer> word2Index, List<String> result){

        List<String> changeList = findWord(beginWord, wordList, visited, word2Index);
        String tmpWord;

        for (int i=0; i < changeList.size(); ++i){
            String ele = changeList.get(i);
            tmpWord = ele;
            result.add(ele);

            visited[word2Index.get(ele)][word2Index.get(beginWord)] = true;
            visited[word2Index.get(beginWord)][word2Index.get(ele)] = true;

            if (tmpWord.equals(endWord) && result.size() > 1) {
                if (result.size() <= minNum){
                    minNum = result.size();
                    all_list.add(new ArrayList<String>(result));
                }


            }
            search(ele, endWord, wordList, visited, word2Index, result);

            visited[word2Index.get(ele)][word2Index.get(beginWord)] = false;
            visited[word2Index.get(beginWord)][word2Index.get(ele)] = false;


            result.remove(result.lastIndexOf(ele));
        }


    }

    public List<String> findWord(String word, HashSet<String> wordList, boolean[][] visited, HashMap<String, Integer> word2Index){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for (int i=0; i < word.length(); ++i){
            for (char j='a';j <= 'z'; ++j){
                sb.setCharAt(i, j);
                if (wordList.contains(sb.toString()) && !visited[word2Index.get(word)][word2Index.get(sb.toString())])
                    list.add(sb.toString());
            }
            sb.setCharAt(i, word.charAt(i));
        }

        return list;
    }

    public static void main(String[] args) {
        WordLadderII_126 wordLadderII_126 = new WordLadderII_126();
        String begin = "qa";
        String end = "sq";

        String[] wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        };
        List<String> list = new ArrayList<>();
        for (String ele: wordList)
            list.add(ele);
        List<List<String>> result = wordLadderII_126.findLadders(begin, end, list);
    }
}
