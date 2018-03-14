package exercise;

import java.util.*;

public class Main {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    int orderNums = Integer.MAX_VALUE;
    Map<String, Integer> maps = new HashMap<>();
    Map<String, Integer> results;

    public static void main(String[] args) {
        Main Main = new Main();
        Main.getMinNum();
    }

    public void getMinNum(){
        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for(int i = 0; i < n ; i++){
            order.add(Integer.parseInt(itemCnt[i]));
        }

        for(int i = 0; i < m; i++){
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();

            for(int j = 1; j <= n; j++ ){
                bomDetail.add(Integer.parseInt(bomInput[j]));
            }
            boms.put(bomInput[0], bomDetail);
        }
        in.close();

        Map<String, Integer> res = resolve(order, boms);

        System.out.println("match result:");
        for(String key : res.keySet()){
            System.out.println(key+"*"+res.get(key));
        }
    }

    // write your code here
    public Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
        List<String> keys = new ArrayList<>(boms.keySet());
        recursive(order, boms, 0, keys);

        return  results;
    }

    public void recursive(List<Integer> order, Map<String, List<Integer>> boms, int index, List<String> keys){
        int counts = 0;
        for (int i=0; i < order.size(); ++i){
            if (order.get(i) < 0)
                return;
            if (order.get(i)>0)
                counts++;

        }

        if (counts < orderNums){
            orderNums = counts;
            results = new HashMap<>(maps);

        }
        else if (counts == orderNums){
            if (results != null)
                results = maps.size() < results.size()? new HashMap<>(maps): results;
        }

        for (int i=index; i < keys.size(); ++i){
            String bomName = keys.get(i);
            List<Integer> values = boms.get(bomName);
            if (maps.get(bomName) == null){
                maps.put(bomName, 1);
            }
            else {
                maps.put(bomName, maps.get(bomName)+1);
            }

            for (int j=0; j < order.size(); ++j){
                order.set(j, order.get(j)-values.get(j));

            }
            recursive(order, boms, index, keys);
            for (int j=0; j < order.size(); ++j){
                order.set(j, order.get(j)+values.get(j));

            }

            maps.put(bomName, maps.get(bomName)-1);
        }
    }
}
