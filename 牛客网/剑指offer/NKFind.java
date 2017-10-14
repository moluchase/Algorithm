public class NKFind {


    public static boolean Find2(int target,int[][] array,int si,int sj,int ei,int ej){
        int index=0;
        int lengthi=ei-si+1;
        int lengthj=ej-sj+1;
        int minlength=lengthi>lengthj?lengthj:lengthi;
        //System.out.println("si="+si+",sj="+sj+",ei="+ei+",ej="+ej);
        while (index<minlength){
            //System.out.println(minlength);
            if(target>array[si+index][sj+index]){
                index++;
            }else if(target==array[si+index][sj+index]) {
                return true;
            }else {

                //System.out.println(array[si+index][sj+index]+",index="+index);
                break;
            }
        }
        //如果第0行第0列的元素都大于target，则返回false
        if(index==0){
            return false;
        }
        return Find2(target,array,si+index,sj,ei,sj+index-1)||Find2(target,array,si,sj+index,ei+index-1,ej);
    }

    public static boolean Find(int target, int [][] array) {
        //return Find2(target,array,0,0,array.length-1,array[0].length-1);
        int len=array.length-1;
        int i=0;
        while (len>=0&&i<array[0].length){
            if(target>array[len][i]){
                i++;
            }else if(target<array[len][i]){
                len--;
            }else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int [][]arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        //arr=new int[4][4];
        System.out.println(Find(5,arr));
    }
}
