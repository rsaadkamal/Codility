package com.codility.L11_Sieve_Of_Eratosthenes.CountSemiprimes1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, Boolean> semiPrimes;

    public int[] solution(int N, int[] P, int[] Q) {
        if (N == 1) {
            return new int[P.length];
        }
        initSemiprimes(N);
        int[] result = new int[P.length];
        int[] df = new int[N + 1];
        df[0] = 0;
        for (int i = 1; i < df.length; i++) {
            if (semiPrimes.get(i)) {
                df[i] = df[i - 1] + 1;
            } else {
                df[i] = df[i - 1];
            }
        }
        for (int i = 0; i < Q.length; i++) {
            int secondIndex = P[i] == 0 ? 0 : P[i] - 1;
            result[i] = df[Q[i]] - df[secondIndex];
        }
        return result;
    }

    private void initSemiprimes(int N) {
        semiPrimes = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            semiPrimes.put(i, false);
        }
        int[] primes = getPrimes(N);
        int i = 0;
        while (primes[i] <= N / 2) {
            int j = i;
            while (primes[j] * primes[i] <= N) {
                semiPrimes.put(primes[i] * primes[j], true);
                j++;
            }
            i++;
        }
    }

    private int[] getPrimes(int N) {
        boolean[] sieve = new boolean[N + 1];
        Arrays.fill(sieve, Boolean.TRUE);
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i < (int) (Math.sqrt(N) + 1); i++) {
            if (sieve[i]) {
                for (int j = i + i; j < N; j += i) {
                    sieve[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        return primes.stream().mapToInt(i -> i).toArray();
    }
}