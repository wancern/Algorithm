import java.util.*;
import java.io.*;

public class Main_16934 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> duplicate = new HashMap<>();
        Map<String, List<String>> nickname = new HashMap<>();

        for(int t = 0; t < N; t++){
            String str = br.readLine();

            if(duplicate.containsKey(str)){
                duplicate.put(str, duplicate.get(str)+ 1);
                sb.append(str).append(duplicate.get(str)).append("\n");
                continue;
            }

            int tmp = str.length();
            for(int i = tmp - 1; i > 0; i--){
                String s = str.substring(0, i);
                if(nickname.containsKey(s)){
                    int index = 0;

                    for(String now : nickname.get(s)){
                        int min = Math.min(now.length(), str.length());
                        int len;

                        for(len = 0; len < min; len++){
                            if(now.charAt(len) != str.charAt(len)){
                                len++;
                                break;
                            }
                        }
                        index = Math.max(index, --len);
                    }

                }
            }
            duplicate.put(str, 1);
        }
        System.out.println(sb);
    }
}



//import java.util.*;
//import java.io.*;
//
//public class Main_16934 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//        Map<String, Integer> hm = new HashMap<>();
//
//        for(int i = 0; i < N; i++){
//            String str = br.readLine();
//
//            if(hm.containsKey(str)){
//                hm.put(str, hm.get(str)+ 1);
//                sb.append(str).append(hm.get(str)).append("\n");
//                continue;
//            }
//
//            int index = 0;
//
//            for(String s : hm.keySet()){
//                int min = Math.min(s.length(), str.length());
//                int len;
//
//                for(len = 0; len < min; len++){
//                    if(s.charAt(len) != str.charAt(len)){
//                        len++;
//                        break;
//                    }
//                }
//                index = Math.max(index, --len);
//            }
//
//            sb.append(str.substring(0, index + 1)).append("\n");
//            hm.put(str, 1);
//        }
//        System.out.println(sb);
//    }
//}
