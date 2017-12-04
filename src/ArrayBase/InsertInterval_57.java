package ArrayBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/4.
 */
public class InsertInterval_57 {

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<>();
        int i=0;
        while (i < intervals.size() && newInterval.start > intervals.get(i).end)
            results.add(intervals.get(i++));
        int left=newInterval.start, right=newInterval.end;
        while (i < intervals.size() && newInterval.end >= intervals.get(i).start){
            left = Math.min(left, intervals.get(i).start);
            right = Math.max(right, intervals.get(i).end);
            ++i;
        }

        results.add(new Interval(left, right));
        while (i < intervals.size())
            results.add(intervals.get(i++));
        return results;

    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(4, 5);
        Interval i3 = new Interval(7, 8);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        InsertInterval_57 ii = new InsertInterval_57();
        List<Interval> a = ii.insert(intervals, new Interval(3, 6));
        System.out.println(a);
    }
}
