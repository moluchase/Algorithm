/**
 * @author pengsong
 * @date 18/1/2 上午8:48
 */
/*
Find the total area covered by two rectilinear rectangles in a 2D plane.
 */
public class LC223RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int bottom,left,top,right;
        int area1=(C-A)*(D-B);
        int area2=(G-E)*(H-F);
        System.out.println(area1+","+area2);
        bottom=B>F?B:F;
        left=A>E?A:E;
        right=C>G?G:C;
        top=D>H?H:D;
        System.out.println(bottom+","+left+","+top+","+right);
        return area1+area2-(!(top<0&&bottom>0)&&!(right<0&&left>0)&&top-bottom>0&&right-left>0?(top-bottom)*(right-left):0);
    }

    public static void main(String[] args) {
        computeArea(-1500000001,0,-1500000000,1,1500000000,0,1500000001,1);
        //System.out.println(-1500000000-1500000000);
    }
}
