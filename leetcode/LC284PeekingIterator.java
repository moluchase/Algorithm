import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author pengsong
 * @date 18/1/6 上午8:47
 */
/*
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 */
public class LC284PeekingIterator {
    List<Integer> list;
    Iterator<Integer> iter;
    public LC284PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list=new ArrayList<>();
        iter=iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!list.isEmpty())return list.get(0);
        else if(iter.hasNext()){
            list.add(iter.next());
            return list.get(0);
        }
        return -1;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    //@Override
    public Integer next() {
        if(!list.isEmpty()){
            int temp=list.get(0);
            list.remove(0);
            return temp;
        }else return iter.next();
    }

    //@Override
    public boolean hasNext() {
        if(!list.isEmpty())return true;
        return iter.hasNext();
    }
}
