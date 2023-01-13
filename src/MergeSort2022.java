public class MergeSort2022 {
    public static void print(int[] data){
        int n = data.length;
        for (int i = 0; i < n; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println(" ");
    }

    public static void merge(int[] data, int left, int mid, int right){
        int n = mid - left + 1;
        int m = right - mid;
        //a is our left sub-array
        int[] a = new int[n];
        //b is our right sub-array
        int[] b = new int[m];
        //copy from data to a
        for (int i = 0; i < n; i++){
            a[i] = data[left + i];
        }
        //copy from data to b
        for (int i = 0; i < m; i++){
            b[i] = data[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n && j < m){
            if (a[i] < b[j]) {
                data[k] = a[i];
                i++;
                k++;
            }else if (b[j] < a[i]){
                data[k] = b[j];
                j++;
                k++;
            }
        }

        while (i < n){
            data[k] = a[i];
            i++;
            k++;
        }
        while (j < m){
            data[k] = b[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] data, int left, int right){
        print(data);
        System.out.println("left = " + left + " right = " + right);
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }

    }

    public static void mergeSort(int[] data){
        int n = data.length;
        mergeSort(data, 0, n - 1);
    }
    public static void main(String[] args) {
        int[] data = {5, 2, 9, 7, 4, 10, 6, 0, 8, 1, 3};
        mergeSort(data);
        print(data);
    }
}
