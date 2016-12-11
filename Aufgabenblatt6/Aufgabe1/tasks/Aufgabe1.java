/*******************************************************************************

 AUFGABENBLATT 6 - Allgemeine Informationen

 Achten Sie bei der Implementierung auf folgende Punkte:

 - Ihr Programm sollte den dazugehörenden Test (z.B. enthält Aufgabe1Test den
 Test zu Aufgabe1) bestehen.

 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich
 thematisch auf das erstellte Programm.  Sie müssen diese Zusatzfragen in der
 Übung beantworten können.

 - Verwenden Sie bei allen Ausgaben immer System.out.println().

 - Verwenden Sie für die Lösung der Aufgaben keine speziellen Aufrufe aus der
 Java-API, die die Aufgaben verkürzen würden.

 Abgabe: Die Abgabe erfolgt in TUWEL. Bitte laden Sie Ihr IntelliJ-Projekt
 bis spätestens Montag 12.12.2016 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/
/*
    Aufgabe 1) Sortieren & Suchen

    Implementieren Sie in dieser Aufgabe in der gegebenen Klasse Aufgabe1
    folgende statische Methoden:

    - sort:       Diese Methode soll den Sortieralgorihtmus "QuickSort"
                  implementieren. Sie müssen den Sortieralgorithmus selbst
                  ausimplementieren und dürfen keinen entsprechenden Aufruf aus
                  der Java-API verwenden.

    - binSearch:  Dieser Methode wird ein sortiertes Array übergeben.
                  Zusätzlich erhält die Methode einen Wert nach dem gesucht
                  werden soll. Es soll eine binäre Suche implementiert werden,
                  die true zurückliefert falls das Element enthalten ist,
                  ansonsten false.
                  
    Hinweis: Sie dürfen zusätzliche Hilfsmethoden implementieren und verwenden!

    Zusatzfragen:
    1. Welche API-Aufrufe bietet Java für das Sortieren von Arrays an?
    2. Welcher Sortieralgorithmus wird in der Java (1.8) für das Sortieren von
       Arrays verwendet?
    3. Warum ist die Wahl des Pivot-Elements entscheidend für die Performance
       des Quicksort Algorithmus?
    4. Warum muss das Array für die binäre Suche sortiert sein?
    5. Wie geht man vor wenn man in einem absteigend sortierten Array die
       Binärsuche anwenden will?
*/
public class Aufgabe1 {

    private static int[] arr;

    /**
     * Sorts the array.
     *
     * @param array
     */
    public static void sort(int[] array) {
        /* if array is invalid, just return. */
        if (array == null || array.length == 0) {
            return;
        }

        arr = array;
        quicksort(0, arr.length-1);
    }

    /**
     * Implementation of recursive quicksort algorithm.
     *
     * (pivot => middle element)
     * @param leftPointer
     * @param rightPointer
     */
    public static void quicksort(int leftPointer, int rightPointer) {
        int i = leftPointer;
        int j = rightPointer;
        int pivot = arr[leftPointer + (rightPointer-leftPointer)/2];

        while(i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        /* recursive part of method */
        if (leftPointer < j) {
            quicksort(leftPointer, j);
        }
        if (i < rightPointer) {
            quicksort(i, rightPointer);
        }
    }

    /**
     * Swap to elements to "their" sides.
     *
     * @param i
     * @param j
     */
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    public static boolean binSearch(int[] array, int elem) {
        /* test if array is valid */
        if (array == null || array.length == 0) {
            return false;
        }

        /* call recursive binarySearch method TODO */
        if (binarySearch(array, elem, 0, array.length)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param array
     * @param element
     * @param pointer
     * @return
     */
    public static boolean binarySearch(int[] array, int element, int start, int end) {
        /* if pivot < elem, then elem must be on the left side of the array...
           ...and vice versa */
        int currElement;
        int pointer;

        if (start < end) {
            pointer = start + (end - start) / 2;
            currElement = array[pointer];
            System.out.printf("pointer: %d, value: %d, start: %d, end: %d, element: %d\n", pointer, array[pointer], start, end, element);

            if (currElement == element) {
                System.out.printf("Element found on position %d!", pointer);
                return true;
            } else if (currElement < element) {
                return binarySearch(array, element, pointer++, end);
            } else {
                return binarySearch(array, element, start, pointer--);
            }
        } else {
            return false;
        }
    }

    /**
     * Returns an array of length (@param length),
     * filled with random numbers.
     *
     * @param length
     * @return
     */
    public static int[] generateRandomArray(int length) {
        int[] randomArray = new int[length];
        int randNum;

        /* fill array with numbers between [0, 100] */
        for (int i = 0; i < length; i++) {
            randNum = (int)(Math.random() * 100) + 1;
            randomArray[i] = randNum;
        }

        return randomArray;
    }

    /**
     *
     * @param integerArray
     */
    public static void printArray(int[] integerArray) {
        System.out.print("[");
        for (int i = 0; i < integerArray.length; i++) {
            if (i != integerArray.length-1) {
                System.out.printf("%d,", integerArray[i]);
            } else {
                System.out.printf("%d", integerArray[i]);
            }
        }
        System.out.print("]\n");
    }
    
    
    public static void main(String[] args) {
        int[] testArray = generateRandomArray(10);

        /* print out testArray before sorting  */
        System.out.println("Generated Array:");
        printArray(testArray);

        /* ...after sorting */
        System.out.println("\nSorted Array:");
        sort(testArray);
        printArray(testArray);

        /* Search element in array */
        int randomElement = (int)(Math.random() * 100) + 1;
        int pseudoRandElement = (int)(Math.random() * 10);
        int el = testArray[pseudoRandElement];
        System.out.printf("\nSearching for '%d' in array: \n", el);
        boolean search = binSearch(testArray, el);
    }
}



