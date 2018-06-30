import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    /*
    Selection sort polega na tym, że iterujemy po zbiorze znajdując najmniejszy element i na końcu
    iteracji wstawiamy go na pierwsze miejsce, a element który był na pierwszym miejscu na miejsce
    elementu najmniejszego. Kolejna iteracja następuje już tylko po pozostałych elementach.
    Pierwsza wersja działa tak, że są dwie listy i w każdej iteracji do kopii listy dodawany jest
    kolejny element i zarazem usuwany z nieposortowanej listy aby przy następnej iteracji go już
    nie było. Druga (bardziej popularna) wersja działa na arrayu która iteruje po coraz mniejszej jego części
    zamieniając elementy miejscami.

    Selection sort ma złożoność obliczeniową O(n^2) pomimo że z każdą iteracją sprawdza coraz mniej
    elementów
     */

    /* MOJA WŁASNA IMPLEMENTACJA Z KSIĄŻKĄ */
    // funkcja wykorzystywana w selection sorcie do znajdowania najmniejszego elementu
    public static int findSmallest(ArrayList<Integer> array){
        int smallest = array.get(0);
        int smallestIndex = 0;
        for(int i = 0 ; i < array.size() ; i++){
            if(array.get(i) < smallest){
                smallest =array.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> array){
        ArrayList<Integer> unsortedList = new ArrayList<>(array);
        ArrayList<Integer> sortedList = new ArrayList<>();
        for(int i = 0 ; i<array.size() ; i++){
            int smallestIndex = findSmallest(unsortedList);
            sortedList.add(unsortedList.get(smallestIndex));
            unsortedList.remove(smallestIndex);
        }
        System.out.println(sortedList.toString());
        return sortedList;
    }

    /* IMPLEMENTACJA NAJBARDZIEJ POPULARNA */
    void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int indexOfSmallestElement = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[indexOfSmallestElement])
                    indexOfSmallestElement = j;
            }
            // Swap the found minimum element with the first
            // element
            int temp = arr[indexOfSmallestElement];
            arr[indexOfSmallestElement] = arr[i];
            arr[i] = temp;
        }
    }
}
