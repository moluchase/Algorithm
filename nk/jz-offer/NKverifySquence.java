public class NKverifySquence {


    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return false;
        return judgeBST(sequence,0,sequence.length-1);
    }

    private boolean judgeBST(int[] sequence, int s, int e) {
        int mid=e-1;
        int j;
        if(s>=e){
            return true;
        }else {
            while (mid>=s&&sequence[mid]>sequence[e]) mid--;
            j=mid;
                while (j>=s){
                    if(sequence[j]>sequence[e]){
                        return false;
                    }
                    j--;
                }
            return judgeBST(sequence,s,mid)&&judgeBST(sequence,mid+1,e-1);
        }
    }
}
