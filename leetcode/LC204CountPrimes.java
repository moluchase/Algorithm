/**
 * @author pengsong
 * @date 17/12/21 上午9:47
 */
/*
Description:

Count the number of prime numbers less than a non-negative number, n.
 */

/*
素数问题。。。计算素数的个数
 */
public class LC204CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;

    }
}
