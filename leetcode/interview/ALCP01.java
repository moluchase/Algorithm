package interview;

import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/31 上午8:48
 */
public class ALCP01 {

    public static int getNumF(int n,int m){
        int r;
        if (n == 1) r = m;
        else if (n == 2) r = m * (m - 1);
        else if (n == 3) r = m * (m - 1)*(m - 2);
        else {
            r = getNumF(n - 1, m)*(m - 2) + getNumF(n - 2, m)*(m - 1);
        }
        return r;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        n=scanner.nextInt();
        m=scanner.nextInt();
        scanner.close();
        System.out.println(getNumF(n,m));
    }
}
