import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args){
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0 ; i<100 ; i++){
//            list.add(i);
//        }
//        System.out.println(binarySearchAlgo(list,98 ));

//        soldierCount(5, 3);
//        System.out.println(reverseString("hello"));
//        System.out.println(factoralizeNumber(5));
//        System.out.println(isPalindrome("race Car"));
//        System.out.println(toUpperCase("The quick brown fox jumped over the lazy dog"));
//        int[][] array = {{5,6,7,8},{4,7,435,765,13,1243,6}};
//        System.out.println(maxInArrays(array));
//        System.out.println(confirmEnding("jajajakberety","ety" ));
//        System.out.println(repeatString("dufssdsds", 7));
//        System.out.println(truncateString("ale jajca, jak berety normalnie", 3));
        int[] arrayToTest = {9,4,6,2,7,1,3,5};
//        chunkArray(arrayToTest,5 );
//        slasherFlick(arrayToTest,3 );
//        ArrayList<Integer> listToTest = new ArrayList<>(Arrays.asList(5,6,8,3,2,7,9,1,4,6));
//        seekAndDestroy(listToTest,5,6,8);
//        System.out.println(whereDoIBelong(arrayToTest, 5));
//        System.out.println(ROT13("SERR PBQR PNZC"));
//        SelectionSort.selectionSort(listToTest);
//        BubbleSort.bubbleSort(arrayToTest);
//        System.out.println(ArabicConverter.arabicToRoman(3888));
//        System.out.println(ArabicConverter.romanToArabic("LXXXI"));
//        System.out.println(PairFinder.pairFinder(arrayToTest,11 ));
//        System.out.println(recursive(4));
//        System.out.println(recursiveAdding(arrayToTest,0 ));
//        System.out.println(adding(arrayToTest));
        QuickSort.sort(arrayToTest);
//        MergeSort.mergeSort(arrayToTest);
        for(int number : arrayToTest){
            System.out.println(number);
        }
    }


//    public static int[] quickSort(int[] numbers){
//
//        if(numbers.length<2){
//            return numbers;
//        }
//        else{
//            int pivot = numbers[0];
//
//        }
//    }


    public static int adding(int[] array){
        int sum = 0;
        for(int number : array){
            sum+=number;
        }
        return sum;
    }

    public static int recursiveAdding(int[] array, int indexToAdd){
        if(indexToAdd==(array.length-1)){
            return array[indexToAdd];
        }
        else return (array[indexToAdd]+recursiveAdding(array,indexToAdd+1 ));
    }

    public static int recursive(int number){
        if(number==1){
            return 1;
        }
        else return (number*recursive(number-1));
    }

    // Binary search czyli algorytm który eliminuje połowe opcji jedną operacją
    // O(log(n))

    public static boolean binarySearchAlgo(List<Integer> list, int searchValue){
        Collections.sort(list);
        boolean found = false;

        int beggining = 0;
        int end = list.size()-1;
        int iterationNumber = 0;
        while(beggining<=end){
            int mid = (end+beggining)/2;
            int guess = list.get(mid);
            if(searchValue == guess){
                System.out.println(iterationNumber);
                found = true;
                return found;
            }
            else if(searchValue<guess){
                end = mid-1;
                iterationNumber++;
            }
            else{
                beggining = mid+1;
                iterationNumber++;
            }
        }
        System.out.println(iterationNumber);
        return found;
    }

    /* Wyliczanka w której ostatnia osoba odpada, po przeliczeniu zaczynamy od kolejnej osoby
     * (coś jak wpadła bomba do piwnicy) */

    public static int soldierCount(int numberOfPlayers, int countNumber){
        ArrayList<Integer> players = new ArrayList<>();
        for(int i = 1 ; i <= numberOfPlayers ; i++){
            players.add(i);
        }

        int indexNumber = 1;
        while(players.size()!=1){
            for(int i = 0 ; i < players.size() ; i++){
                if(indexNumber==countNumber){
                    System.out.println(players.get(i));
                    players.remove(i);
                    --i;
                    indexNumber=0;
                }
                if(i==(players.size()-1)){
                    i=-1;
                    indexNumber++;
                }
                else indexNumber++;
            }
        }
        System.out.println("Player with number" + players.get(0) + "won a game");
        return 0;
    }

    public static String reverseString(String wordToReverse){
        StringBuilder newWord = new StringBuilder();
        for(int i = wordToReverse.length()-1 ; i >= 0 ; i--){
            newWord.append(wordToReverse.charAt(i));
            System.out.println(wordToReverse.charAt(i));
        }
        return newWord.toString();
    }

    public static long factoralizeNumber(int numberToFactorize){
        long result = 1;
        for(long i = 1 ; i <= numberToFactorize ; i++){
            result = (i*result);
        }
        return result;
    }


    public static boolean isPalindrome(String wordToCheck){
        String toUpper = wordToCheck.toUpperCase(); // wszystko do dużej litery
        String splitted = toUpper.replaceAll(" ",""); // usuwamy białe znaki
        boolean isPalindrome = true;
        for(int i = 0; i <((splitted.length()/2)) ; i++){
            System.out.println(i);
            if(splitted.charAt(i) == splitted.charAt(((splitted.length()-1)-i))){
                continue;
            }
            else isPalindrome = false;
        }
        return isPalindrome;
    }

    // zwróć w incie długość najdłuższego stringa w zdaniu
    public static int longestString(String sentence){
        String[] words = sentence.split(" ");
        int longestString = 0;
        for(String word : words){
            if(word.length() > longestString){
                longestString = word.length();
            }
        }
        return longestString;
    }


    // w danym zdaniu każdy wyraz zaczynać ma sie duża literą a reszta wyrazu ma być z małej
    public static String toUpperCase(String sentence){
        String toLower = sentence.toLowerCase();
        String[] words = toLower.split(" ");
        for(int i = 0 ; i<words.length ; i++){
            String temp = (words[i].substring(0,1).toUpperCase())+(words[i].substring(1));
            words[i] = temp;
        }
        StringBuilder newSentence = new StringBuilder();
        for(int i = 0 ; i<words.length ; i++){
            if(i==words.length-1){
                newSentence.append(words[i]);
            }
            else newSentence.append(words[i]+" ");
        }
        return newSentence.toString();
    }

    // znajdź maxa w zagnieżdzonym arrayu
    public static int maxInArrays(int[][] arrays){
        int max = arrays[0][0];
        for(int[] array : arrays){
            for(int x : array){
                if(x>max){
                    max = x;
                }
            }
        }
        return max;
    }

        // sprawdź czy słowo kończy sie w dany sposób
    public static boolean confirmEnding(String word, String ending){
        boolean endsLikeThat = false;

        StringBuilder wordEnding = new StringBuilder();
        for(int i = (word.length()-ending.length()) ; i < word.length(); i++){
            wordEnding.append(word.charAt(i));
        }
        if(wordEnding.toString().equals(ending)){
            endsLikeThat = true;
        }
        return endsLikeThat;
    }

    public static String repeatString(String toRepeat, int number){
        StringBuilder repeatedWord = new StringBuilder();
        for(int i = 1 ; i <= number ; i++){
            repeatedWord.append(toRepeat);
        }
        return repeatedWord.toString();
    }

    // musimy zachować jedynie n znaków w zdaniu i zastąpić końcówke trzema kropkami
    // (kropki wliczają sie w 3 ostatnie znaki chyba, że chcemy zostawić 3 lub mniej znaków
    // wtedy kropki nie wliczają sie
    public static String truncateString(String toTruncate, int amountOfLettersToLeave){
        StringBuilder newString = new StringBuilder();
        if(amountOfLettersToLeave<toTruncate.length() && amountOfLettersToLeave>3){
            for(int i = 0 ; i<(amountOfLettersToLeave-3) ; i++){
                newString.append(toTruncate.charAt(i));
            }
            newString.append("...");
        }
        else if(amountOfLettersToLeave<=3){
            for(int i = 0 ; i<(amountOfLettersToLeave) ; i++){
                newString.append(toTruncate.charAt(i));
            }
            newString.append("...");
        }
        return newString.toString();
    }

    public static int[][] chunkArray(int[] arrayToChunk, int sizeOfArrays){
        int numberOfArrays = arrayToChunk.length/sizeOfArrays;
        int[][] arrays = new int[numberOfArrays][sizeOfArrays];

        int indexNumberOfNominalArray=0;
        int arrayToFullfil = 0;
        for(int i = 0; i < sizeOfArrays ; i++){
            arrays[arrayToFullfil][i] = arrayToChunk[indexNumberOfNominalArray];
            indexNumberOfNominalArray++;
            if(i==sizeOfArrays-1){
                i=-1;
                arrayToFullfil++;
            }
            if(indexNumberOfNominalArray==(arrayToChunk.length-1)){
                break;
            }
        }

        System.out.println(arrays.toString());
        return arrays;
    }

    // mamy usunąć pewną liczbe intów z POCZĄTKU arraya
    public static int[] slasherFlick(int[] array, int numberToChop){
        int[] newArray = new int[array.length-numberToChop];
        System.arraycopy(array,numberToChop ,newArray ,0 ,array.length-numberToChop);
        for(int number : newArray){
            System.out.println(number);
        }
        return newArray;
    }

    public static ArrayList<Integer> seekAndDestroy(ArrayList<Integer> array, int... args){
        for(int number : args){
            for(int i = 0 ; i < array.size() ; i++){
                if(array.get(i).equals(number)){
                    array.remove(i);
                }
            }
        }

        System.out.println(array.toString());
        return array;
    }

    public static int whereDoIBelong(int[] array , int numberToAdd){
        Arrays.sort(array);
        int placeToInsert = 0;
        for(int number : array){
            if(number < numberToAdd){
                placeToInsert++;
            }
        }
        return placeToInsert;
    }

    public static String ROT13(String toUncipher){
        StringBuilder newString = new StringBuilder();
        for(int i = 0 ; i < toUncipher.length() ; i++){
            if(toUncipher.charAt(i) == ' '){
                newString.append(' ');
                continue;
            }
            char c = toUncipher.charAt(i);
            int placesToShift = -13;
            if(((int)c-13) < 65){
                placesToShift = 13;
            }
            newString.append(c+=placesToShift);
        }
        return newString.toString();
    }
}

