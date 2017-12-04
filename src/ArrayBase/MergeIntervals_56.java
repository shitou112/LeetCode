package ArrayBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/4.
 */
public class MergeIntervals_56 {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return new String("("+start +", "+ end+")");
        }
    }

    List<Interval> results = new ArrayList<>();
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size()==0)
            return results;
        Collections.sort(intervals, new IntervalComparetor());
        recursion(0, intervals);
        return results;
    }

    private void recursion(int index, List<Interval> intervals){
        if (index+1==intervals.size()){
            results.add(intervals.get(index));
            return;
        }
        while (index < intervals.size() &&
                index+1<intervals.size() &&
                intervals.get(index).end < intervals.get(index+1).start){

                results.add(intervals.get(index++));
        }
        if (index >= intervals.size())
            return;

        int left = intervals.get(index).start;
        int end = intervals.get(index).end;
        int right = end;
        ++index;
        while (index < intervals.size() &&
                intervals.get(index).start <= end){
            right = Math.max(right, intervals.get(index++).end);
        }
        results.add(new Interval(left, right));
        recursion(index, intervals);

    }

    private class IntervalComparetor implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start < o2.start)
                return -1;
            else if (o1.start==o2.start){
                if (o1.end < o2.end)
                    return -1;
                else if (o1.end == o2.end)
                    return 0;
                else
                    return 1;
            }
            else
                return 1;
        }
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(8, 10);
        Interval i2 = new Interval(2, 7);
        Interval i3 = new Interval(1, 1);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        MergeIntervals_56 ii = new MergeIntervals_56();
        List<Interval> a = ii.merge(intervals);
        System.out.println(a);
    }
}
