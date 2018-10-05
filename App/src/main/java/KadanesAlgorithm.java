public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] array = {1, -3, 2, 1, -1};
        System.out.println(maxSubarray(array));
    }

    static int maxSubarray(int[] array) {
        int maxSoFar = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i], max + array[i]);
            maxSoFar = Math.max(max, maxSoFar);
        }

        return maxSoFar;
    }
}
