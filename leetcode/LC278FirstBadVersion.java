/**
 * @author pengsong
 * @date 18/1/5 上午9:25
 */
/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
You should minimize the number of calls to the API.
 */
/*
二分查找，但是有一点需要注意，坏的不前进，好的+1
 */
public class LC278FirstBadVersion {
    public int firstBadVersion(int n) {
        int s,m,e;
        s=1;
        e=n;
        m=s+(e-s)/2;
        while (true){
            if(isBadVersion(m)){
                e=m;
                m=s+(m-s)/2;
            } else {
                s=m+1;
                m=s+(e-s)/2;
            }
            if(s==e)return e;
        }
    }

    private boolean isBadVersion(Object p0) {
        return false;
    }
}
