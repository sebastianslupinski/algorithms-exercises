public class BubbleSort {

    // bubble sort czyli sprawdzanie sąsiadujących ze sobą elementów, i zamienianie ich miejscami
    // o ile są w złej kolejnośći O(n^2)
    
    public static int[] bubbleSort(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            for(int x = 0 ; x < (array.length-1) ; x++){
                if(array[x]>array[x+1]){
                    int temp = array[x];
                    array[x] = array[x+1];
                    array[x+1] = temp;
                }
            }
        }

        for(int number : array){
            System.out.println(number);
        }
        return array;
    }
}
