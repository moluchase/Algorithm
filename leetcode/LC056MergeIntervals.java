import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class LC056MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start>o2.start)return 1;
                else if(o1.start==o2.start)return 0;
                else return -1;
            }
        });
        List<Interval> list=new ArrayList<>();
        int start,end,i;
        i=0;
        while (i<intervals.size()){
            Interval interval=intervals.get(i);
            start=interval.start;
            end=interval.end;
            while (i+1<intervals.size()&&end>=intervals.get(i+1).start){
                interval=intervals.get(i+1);
                if(end<interval.end)end=interval.end;
                i++;
            }
            list.add(new Interval(start,end));
            i++;
        }
        return list;
    }
}
