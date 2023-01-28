/**
 물품을 구매한 고객은 하루에 최대 1장의 할인 쿠폰
 고객 한 명당 최대 k 장 까지 할인 쿠폰
 총 발급할 쿠폰의 갯수
 **/
import java.util.*;

class KM_1_2 {
        public int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> hm = new HashMap<>();

        for(int i = 0; i< id_list.length; i++){
            Set<String> hs = new HashSet<>();
            String[] str = id_list[i].split(" ");

            for(int j = 0; j < str.length; j++){
                hs.add(str[j]);
            }

            for(String tmp : hs){
                hm.put(tmp, hm.getOrDefault(tmp, 0 ) + 1);
            }
        }

        for(String str : hm.keySet()){
            int tmp = hm.get(str);
            if(tmp > k){
                answer += k;
            }
            else{
                answer += tmp;
            }
        }
        return answer;
    }
}


