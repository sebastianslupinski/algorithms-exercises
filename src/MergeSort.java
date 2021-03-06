public class MergeSort {

    /* merge sort to rekurencyjny algorytm polegający najpierw na dzieleniu zbioru aż do
    uzyskania n zbiorów jednoelementowych które można uznać za posortowane. To jest base case.
    Gdy już dojdziemy do takiego stanu rzeczy wywoływana jest metoda merge której zadaniem jest
    wypełnianie nowego zbioru elementami z dwóch mniejszych połówek. Działa to w ten sposób,
    że porównane są pierwsze elementy z dwóch połówek i do tymczasowego zbioru wsadzany najpierw
    jest mniejszy element a następnie większy. Po tym kroku następuje chyba najważniejsza
    część algorytmu która scala tymczasowy zbiór elementów z pozostałą częścią oryginalnego
    zbioru. Krok ten wywoływany jest na kolejnych częściach podzielonego zbioru i z każdym
    tym krokiem algorytm tymczasowy "mergowany" jest z oryginalnym przez co nasz oryginalny
    z końcem jest posortowany.
     */

    public static void mergeSort(int[] array){
        int[] temp = new int[array.length];
        sort(array, temp, 0, array.length-1);
    }

    public static void sort(int[] array, int[] temp, int leftStart, int rightEnd){
        if(leftStart>=rightEnd){
            return;
        }
        int middle = (leftStart+rightEnd)/2;
        sort(array, temp, leftStart, middle);
        sort(array,temp ,middle+1 ,rightEnd );
        merge(array, temp, leftStart, rightEnd);
    }

    private static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd+leftStart)/2;
        int rightStart = leftEnd + 1;
        int size = rightEnd-leftStart+1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left<=leftEnd && right<=rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array,left,temp,index ,leftEnd-left+1);
        System.arraycopy(array,right ,temp ,index ,rightEnd-right+1);
        System.arraycopy(temp,leftStart ,array ,leftStart,size);
        }
    }
