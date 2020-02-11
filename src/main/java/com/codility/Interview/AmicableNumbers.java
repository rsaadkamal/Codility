

/*
find the amicable numbers like 220 and 284


solution(6000)  ->  4
solution(10000) ->  5
*/

// 220
// 284 

public class AmicableNumbers{





	/*
	* solution - a
	*/
	public static int solution(int N) {


        List<Integer> check = new ArrayList<>();
        int count = 0;

        for (int i = 1; i <= N; i++) {

            int u = findDivisors(i);

            if (u == i) {
                continue;
            }

            int v = findDivisors(u);

            if (!check.contains(i) && i == v) {

                check.add(u);
                count++;
            }
        }

        return count;
    }

    public static int findDivisors(int N) {

        List<Integer> res = new ArrayList<>();

        for (int i = 1; i * i <= N; i++) {

            if (N % i == 0) {
                res.add(i);
                res.add(N / i);
            }
        }

        Collections.sort(res);
        res.remove(res.size() - 1);

        int sum = res.stream().distinct().reduce(0, Integer::sum);

        return sum;
    }


}