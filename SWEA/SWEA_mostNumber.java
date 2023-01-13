import java.io.*;
import java.util.*;

class SWEA_mostNumber
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i<1000; i++){
                arr[Integer.parseInt(st.nextToken())]++ ;
            }

            int max = 0;
            int max_idx = -1;
            for(int i = 0; i<101;  i++){
                if(arr[i] >= max){
                    max_idx = i;
                    max = arr[i];
                }
            }
            System.out.println("#" + N + " " + max_idx);
        }
    }
}