package interview;

/**
 * @author pengsong
 * @date 18/4/2 下午8:25
 */
public class Mr03 {

    static int num=0;
    public static void dfs(int[]packet,int massX,int curNum,int curMass){
        if(curMass==massX){
            if(curNum>num)num=curNum;
        }
        if(curMass<massX){
            for(int i=0;i<packet.length;i++){
                dfs(packet,massX,curNum+1,curMass+packet[i]);
            }
        }
    }

    public static int findMaxMolecules(int massA,int massB,int massC,int massD,int massX){
        int res=0;
        int[]packet=new int[]{massA,massB,massC*2,massD*2};
        dfs(packet,massX,0,0);
        return num;
    }

    public static void main(String[] args) {
        findMaxMolecules(5,8,5,3,23);
    }
}
