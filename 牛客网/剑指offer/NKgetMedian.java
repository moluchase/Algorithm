import java.util.Comparator;
import java.util.PriorityQueue;

public class NKgetMedian {
    private int count=0;
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void Insert(Integer num){
        if(count%2==0){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }
    public Double GetMedian(){
        if(count%2==0){
            return (minHeap.peek()+maxHeap.peek())*1.0/2;
        }else {
            return minHeap.peek()*1.0;
        }
    }
}
