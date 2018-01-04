import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 18/1/2 上午10:16
 */
/*
Example 1:
Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Example 2:
Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
 */
public class LC228SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < nums.length; ) {
            temp += nums[i];
            i++;
            while (i < nums.length && nums[i] - nums[i - 1] == 1) i++;
            if (Integer.parseInt(temp) == nums[i - 1]) list.add(temp);
            else list.add(temp + "->" + nums[i - 1]);
            temp = "";
        }
        //for(String s:list) System.out.println(s);
        return list;
    }

    public static void main(String[] args) {
        summaryRanges(new int[]{0,1,2,4,5,7});
    }
}
