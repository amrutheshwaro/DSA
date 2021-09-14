public class MergeSort{

    public int[] merge(int[] array, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        int[] b = new int[array.length];
        while(i <= mid && j <= right) {
            if (array[i] <= array[j])
                b[k++] = array[i++];

            else
                b[k++] = array[j++];

        }
        if (i > mid) {
            while(j <= right)
                b[k++] = array[j++];

        } else {
            while(i <= mid)
                b[k++] = array[i++];

        }
        for (int x = left; x <= right; x++)
            array[x] = b[x];
        return array;
    }

    public int[] sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left)/2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 1, 22, 9, 500, 3, 6};
        MergeSort mergeSort = new MergeSort();
        for (int a : mergeSort.sort(array, 0, array.length - 1)) {
            System.out.println(a);
        }
    }
}