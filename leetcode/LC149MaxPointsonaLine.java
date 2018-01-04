import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

/**
 * @author pengsong
 * @date 17/12/11 上午9:15
 */
/*
Given n points on a 2D plane,
 find the maximum number of points that lie on the same straight line.
 */
/*
题目理解错了，哎
 */
class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
public class LC149MaxPointsonaLine {

    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<BigDecimal, Integer> hm = new HashMap<BigDecimal, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    BigDecimal dy=new BigDecimal(points[j].y - points[i].y);
                    BigDecimal dx=new BigDecimal(points[j].x - points[i].x);
                    BigDecimal k =dy.divide(dx, MathContext.DECIMAL128) ;
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }

    public static int maxPoints2(Point[] points) {
        if(points==null||points.length==0)return 0;
        int num,maxNum;
        int minValue,maxValue;
        List<Point> list=new ArrayList<>();
        //minValue=Integer.MAX_VALUE;
        maxValue=Integer.MIN_VALUE;
        maxNum=0;
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x>o2.x) return 1;
                else return -1;
            }
        });
        minValue=points[0].x;
        for(int i=0;i<points.length;i++){
            //if(points[i].x<minValue)minValue=points[i].x;
            if(points[i].y>maxValue)maxValue=points[i].y;
        }
        for(int i=0;i<points.length;i++){
            list.add(points[i]);
        }
        for(int value=minValue;value<=maxValue;value++){
            num=0;
            int i=0;
            while (i<list.size()){
                Point temp=list.get(i);
                if(temp.x<=value&&temp.y>=value)num++;
                if(value>temp.y)list.remove(i);
                else i++;
            }
            if(num>maxNum)maxNum=num;
        }
//        for(int i=0;i<points.length;i++){
//            System.out.println(points[i].x);
//        }
        return maxNum;
    }



    public static void main(String[] args) {
        Point p1=new Point(-1,2);
        Point p2=new Point(-3,6);
        Point p3=new Point(3,5);
        maxPoints2(new Point[]{p1,p2,p3});
    }
}
