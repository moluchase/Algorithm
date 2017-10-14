import java.util.ArrayList;

public class NKprintMatrix {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arr=new ArrayList<>();
        int len1s,len2s,len1e,len2e;
        len1s=len2s=0;
        len1e=matrix.length-1;
        len2e=matrix[0].length-1;
        int i,j;
        i=j=0;
        while (true){
            switch (1){
                case 1:
                    if(j<=len2e){
                        while (j<=len2e){
                            arr.add(matrix[i][j]);
                            j++;
                        }
                        j--;
                        i++;
                        len1s++;
                    }else {
                        return arr;
                    }
                case 2:
                    if(i<=len1e){
                        while (i<=len1e){
                            arr.add(matrix[i][j]);
                            i++;
                        }
                        i--;
                        j--;
                        len2e--;
                    }else {
                        return arr;
                    }
                case 3:
                    if(j>=len2s){
                        while (j>=len2s){
                            arr.add(matrix[i][j]);
                            j--;
                        }
                        j++;
                        i--;
                        len1e--;
                    }else {
                        return arr;
                    }
                case 4:
                    if(i>=len1s){
                        while (i>=len1s){
                            arr.add(matrix[i][j]);
                            i--;
                        }
                        i++;
                        j++;
                        len2s++;
                    }else {
                        return arr;
                    }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> arrlist;
        arrlist=printMatrix(arr);
        for(int i=0;i<arrlist.size();i++){
            System.out.print(arrlist.get(i)+",");
        }
    }
}
