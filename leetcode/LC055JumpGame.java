public class LC055JumpGame {
    public static boolean canJump(int[] nums) {
        if(nums==null||nums.length<=1)return true;
        return jumpDfs(0,nums);
    }

    private static boolean jumpDfs(int i, int[] nums) {
        if(i>=nums.length-1)return true;
        boolean flag=false;
//        for(int j=nums[i];j>0;j--){
//            flag=flag||jumpDfs(i+j,nums);
//        }
        int j=nums[i];
        if(j>0){
            flag=jumpDfs(i+j,nums);
            j--;
            while (!flag&&j>0)flag=jumpDfs(i+(j--),nums);
            return flag;
        }else return false;

    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
