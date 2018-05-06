import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author pengsong
 * @date 18/1/8 上午8:21
 */
/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
 */
/*
主要考察优先队列
 */
public class LC295FindMedianfromDataStream {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap,maxHeap;
    public LC295FindMedianfromDataStream() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<Integer>(20, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public void addNum(int num) {
        if(maxHeap.size()==0)maxHeap.add(num);
        else if(num>maxHeap.peek())minHeap.add(num);
        else maxHeap.add(num);
        if(maxHeap.size()>minHeap.size()+1)minHeap.add(maxHeap.poll());
        else if(minHeap.size()>maxHeap.size()+1)maxHeap.add(minHeap.poll());
    }

    public double findMedian() {

        if((minHeap.size()+maxHeap.size())%2==0)return ((double)minHeap.peek()+(double)maxHeap.peek())/2;
        else if(minHeap.size()>maxHeap.size())return minHeap.peek();
        else return maxHeap.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(2);
        queue.add(3);
        queue.add(4);
    }
}
