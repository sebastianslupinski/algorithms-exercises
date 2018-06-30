// Java program for implementation of QuickSort
class QuickSort {

    /* cały quicksort działa tak, że dla danego zbioru wybieramy tzw. pivot
    który jest punktem odniesienia dla innych elementów. Następnie dokonywana jest iteracja
    w której to elementy porównywane są do pivota od początku i od końca. Jeśli elementy
    na prawo od pivota są większe to idziemy ciągle w lewo aż natrafimy na element który jest
    po jego prawej stronie a jest mniejszy, zostawiamy wskaźnik 'right' na jego miejscu po czym
    z kolei sprawdzamy od lewej strony od pivota czy element może jest większy od pivota
    jeśli nie jest to zwiększamy wzkaźnik left aż znajdziemy element który jest większy od
    pivota a jest po jego lewej stronie, wtedy zostawiamy wskaźnik left na nim. W tym momencie
    mamy pewność że wskaźnik left i right są na elementach które powinny zostać zamienione i
    dokonujemy takiej zamiany. Po czym o ile wskaźnik left nie minął sie już z right wykonujemy
    kolejną pętle schodząc coraz bardziej do środka. Następnie na końcu metody partition
    zwracamy wskaźnik left który będzie punktem dzielącym do wykonania takiego samego sortowania
    na dwóch mniejszych arrayach.
     */

    public static void sort(int[] array){
        quickSort(array,0 ,array.length-1 );
    }

    public static void quickSort(int[] array, int left, int right){
        if(left>=right){return;}
        int pivot = array[(left+right)/2];
        int index = partition(array, left, right,pivot);
        quickSort(array,left ,index-1 );    // PAMIĘTAĆ O TYM , MA BYĆ DOKŁADNIE TAK!!!!!
        quickSort(array,index ,right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while(left<=right){
            while (array[left]<pivot){
                left++;
            }
            while (array[right]>pivot){
                right--;
            }
            if(left<=right){
                //dokonujemy zamiany
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
