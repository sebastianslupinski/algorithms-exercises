import java.util.HashMap;
import java.util.Map;

public class PairFinder {

    public static boolean pairFinder(int[] array, int sumToCheck){
        boolean isSumable = false;
        for(int i = 0 ; i < array.length ; i++){
            for(int x = 0 ; x < array.length ;x++){
                if(i==x){
                    continue;
                }
                if(array[i]+array[x]==sumToCheck){
                    isSumable = true;
                }
            }
        }
        return isSumable;
    }


    public static boolean betterPairFinder(int[] array , int sumToCheck){
        boolean isSumable = false;
        Map<Integer, Integer> mapa = new HashMap<>();
        for(int i = 0 ; i < array.length ; i++){
            if((mapa.containsKey(sumToCheck-array[i]))){
                isSumable = true;
            }
            else {
                mapa.put(array[i],array[i] );
            }
        }
        return isSumable;
    }
}
