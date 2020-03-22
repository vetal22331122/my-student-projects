public class Main {
    public static void main(String[] args) {
        int[] a = {2, 2, 8, 2, 5, 1, 5, 2, 10002, 3, 6, 7};
        int p = 1;
        int r = a.length;
        for (int z : sort(a, p, r)) {
            System.out.print(z + " ");
        }
    }

    public static int[] sort(int[] arrayA, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            arrayA = sort(arrayA, p, q);
            arrayA = sort(arrayA, q + 1, r);
            arrayA = merge(arrayA, p, q, r);
        }
        return arrayA;
    }

    public static int[] merge(int[] arrayA, int p, int q, int r) {
        int[] a = new int[q];
        int[] b = new int[arrayA.length - q];
        System.arraycopy(arrayA, 0, a, 0, q);
        System.arraycopy(arrayA, q, b, 0, arrayA.length - q);

        int i = 0;
        int j = 0;
        int k = 0;

        int[] c = new int[a.length + b.length];
        while (k < c.length) {
            if (i == a.length) {
                c[k] = b[j];
                j++;
                k++;
                continue;
            }
            if (j == b.length) {
                c[k] = a[i];
                i++;
                k++;
                continue;
            }
            if (a[i] <= b[j]) {
                c[k] = a[i];
                i++;
                k++;
            } else {
                c[k] = b[j];
                k++;
                j++;
            }
        }
        return c;
    }
}
