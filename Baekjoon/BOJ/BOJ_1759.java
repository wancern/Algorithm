import java.util.*;
import java.io.*;

public class BOJ_1759 {
    static int L, C;
    static int[] alphabet, pwd;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabet = new int[C];
        pwd = new int[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0) - 'a';
        }
        Arrays.sort(alphabet);

        password(0, 0, 0);
        System.out.println(sb);
    }

    static void password(int last, int depth, int vowel) {
        if (depth == L) {
            if (vowel >= 1 && L - vowel >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append((char)(pwd[i] + 'a'));
                }
                sb.append('\n');
            }
            return;
        }
        for (int i = last; i < C; i++) {
            pwd[depth] = alphabet[i];

            if (alphabet[i] == 0 || alphabet[i] == 4 || alphabet[i] == 8 || alphabet[i] == 14
                    || alphabet[i] == 20)
                password(i + 1, depth + 1, vowel + 1);
            else
                password(i + 1, depth + 1, vowel);
        }
    }
}