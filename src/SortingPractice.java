public class SortingPractice {
    public static void main(String[] args) {
        int[] arr = {10, 6, 12, 8, 1, 2, 90, 7};
        SortingPractice ob = new SortingPractice();
        ob.mergeSort(arr, 0, arr.length - 1);
        ob.display(arr);

        ob.quickSort(arr, 0, arr.length - 1);
        ob.display(arr);

        ob.selectionSort(arr);
        ob.display(arr);

        ob.bubbleSort(arr);
        ob.display(arr);

        ob.insertionSort(arr);
        ob.display(arr);

        arr = ob.countingSort(arr);
        ob.display(arr);
    }

    private void display(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    private int[] countingSort(int[] arr) {                     //O(n+max), Space: O(n)
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        int[] count = new int[max + 1];
        for (int i : arr)
            count[i]++;
        int[] sorted = new int[arr.length];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            int cnt = count[i];
            for (int occurrence = 0; occurrence < cnt; occurrence++)
                sorted[index++] = i;
        }
        return sorted;
    }

    private void insertionSort(int[] arr) {                     //O(n^2)
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
                arr[j + 1] = arr[j--];
            arr[j + 1] = key;
        }
    }

    private void bubbleSort(int[] arr) {                        //O(n^2)
        for (int k = 0; k < arr.length - 1; k++)
            for (int j = k + 1; j < arr.length; j++)
                if (arr[j] < arr[k])
                    arr[j] = (arr[j] + arr[k]) - (arr[k] = arr[j]);
    }

    private void selectionSort(int[] arr) {                     //O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int sel = i + 1; sel < arr.length; sel++) {
                if (arr[sel] < arr[index])
                    index = sel;
            }
            arr[index] = (arr[index] + arr[i]) - (arr[i] = arr[index]);
        }
    }

    private void quickSort(int[] arr, int l, int r) {           //O(n^2) / Average: O(nlogn)
        if (l < r) {
            int m = partition(arr, l, r);
            quickSort(arr, l, m);
            quickSort(arr, m + 1, r);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= pivot)
                r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot)
                l++;
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int mid, int r) {          //O(nlogn)
        int j = l, k = mid + 1;
        int[] temp = new int[r - l + 1];
        for (int i = 0; i < temp.length; i++) {
            if (k > r || ((arr[k] > arr[j]) && (j < (mid + 1))))
                temp[i] = arr[j++];
            else
                temp[i] = arr[k++];
        }
        for(int i = 0; i < temp.length; i++)
            arr[i + l] = temp[i];
    }
}