import java.util.Arrays;

/**
 * @author pengsong
 * @date 18/1/5 上午9:01
 */
/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
/*
H指数（参考维基百科）
H指数的计算基于其研究者的论文数量及其论文被引用的次数。赫希认为：一个人在其所有学术文章中有N篇论文分别被引用了至少N次，他的H指数就是N。
如美国耶鲁大学免疫学家理查德·弗来沃发表的900篇文章中，有107篇被引用了107次以上，他的H指数是107。
可以按照如下方法确定某人的H指数：
将其发表的所有SCI论文按被引次数从高到低排序；
从前往后查找排序后的列表，直到某篇论文的序号大于该论文被引次数。所得序号减一即为H指数。
 */
public class LC274H_index {
    public static int hIndex(int[] citations) {
        if(citations==null||citations.length==0)return 0;
        Arrays.sort(citations);
        for(int i=1;i<=citations.length;i++){
            if(i>citations[citations.length-i])return i-1;
        }
        return citations.length;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1}));
    }
}
