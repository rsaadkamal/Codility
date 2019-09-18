



public class AmicableNumbers{
	
	public static int findAmicablePairs(int N) {


        int count = 0;

        List<Integer> m2 = new ArrayList<>();

        for (int i = N; i >= 1; i--) {

            List<Integer> l1 = divisors(i);

            int sum = 0;

            for (int j = 0; j < l1.size(); j++) {
                sum += l1.get(j);
            }

            List<Integer> l2 = divisors(sum);

            int sum2 = 0;

            for (int j = 0; j < l2.size(); j++) {
                sum2 += l2.get(j);
            }


            // findAmicablePairs(10000) => 5 // plus (6232, 6368)
            if (!m2.contains(i) && i == sum2 && i != sum) {

                m2.add(i);
                m2.add(sum);

                count++;
            }

        }

        return count;
    }


    public static List<Integer> divisors(int N) {

        List<Integer> list = new ArrayList<>();

        int t = N / 2;

        for (int i = 1; i <= t; i++) {

            if (N % i == 0)
                list.add(i);
        }

        return list;
    }

}