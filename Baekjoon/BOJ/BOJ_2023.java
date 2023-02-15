import java.util.*;
import java.io.*;

public class BOJ_2023 {
    static int[] first = {2, 3, 5, 7};
    static int[] odd = {1, 3, 5, 7, 9};
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int num : first) {
            makePrime(1, num);
        }
        System.out.println(sb);
    }

    static void makePrime(int depth, int number) {
        if(depth == N) {
            if(isPrime(number)) {
                sb.append(number).append("\n");
            }
            return;
        }
        for(int i = 0; i < 5; i++) {
            int newNumber = number * 10 + odd[i];
            if(isPrime(newNumber)) {
                makePrime(depth + 1, newNumber);
            }
        }
    }
    static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}