public class SelectionSort {

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public int[] sort(int[] array, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (array[j] < array[min])
                    min = j;
            if (min != i)
                swap(array, min, i);
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {5, 4, 1, 22, 89, 500, 3, 6};
        SelectionSort selectionSort = new SelectionSort();
        for (int a : selectionSort.sort(array, array.length)) {
            System.out.println(a);
        }
    }
}
