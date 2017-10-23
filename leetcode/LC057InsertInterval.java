import java.util.ArrayList;
import java.util.List;

public class LC057InsertInterval {
    /*
    分下面几种情况：
    newInterval在intervals的最前面
    newInterval在intervals的最后面
    newInterval既不在最前面，也不在最后面，而且不与intervals中的任何线段相交
    newInterval与intervals中的线段相交
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null){
            List<Interval> list=new ArrayList<>();
            list.add(newInterval);
            return intervals;
        }
        if (intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        for(int i=0;i<intervals.size();i++){
            Interval interval=intervals.get(i);
            if(i==0&&newInterval.end<interval.start){
                intervals.add(0,newInterval);
                return intervals;
            }else if(i==intervals.size()-1&&interval.end<newInterval.start){
                intervals.add(newInterval);
                return intervals;
            }else if(interval.end<newInterval.start&&intervals.get(i+1).start>newInterval.end){
                intervals.add(i+1,newInterval);
                return intervals;
            } else {
                if(interval.end>=newInterval.start){
                    newInterval.start=Math.min(newInterval.start,interval.start);
                    newInterval.end=Math.max(newInterval.end,interval.end);
                    intervals.remove(i);
                    while (i<intervals.size()&&newInterval.end>=intervals.get(i).start){
                        newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
                        intervals.remove(i);
                    }
                    if(i==intervals.size())intervals.add(newInterval);
                    else intervals.add(i,newInterval);
                    return intervals;
                }
            }
        }
        return intervals;
    }
}
