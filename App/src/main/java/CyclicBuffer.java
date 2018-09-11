import java.util.Arrays;

public class CyclicBuffer {
    private int[] buffer;
    private int size;
    private int readPointer;
    private int writePointer;

    public CyclicBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.readPointer = 0;
        this.writePointer = 0;
    }

    public void write(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            int bufferIndex = (this.writePointer + i) % this.size;
            this.buffer[bufferIndex] = tab[i];
        }
        this.writePointer = (this.writePointer + tab.length) % this.size;
    }

    public int[] read(int amount) {
        int[] result = new int[amount];
        for (int i = 0; i < amount; i++) {
            int bufferIndex = (this.readPointer + i) % this.size;
            result[i] = buffer[bufferIndex];
        }
        this.readPointer = (this.readPointer + amount) % this.size;
        return result;
    }

    public int[] getBuffer() {
        return this.buffer;
    }

    public static void main(String[] args) {
        CyclicBuffer cyclicBuffer = new CyclicBuffer(5);

        cyclicBuffer.write(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(cyclicBuffer.buffer));

        cyclicBuffer.write(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(cyclicBuffer.buffer));

        int[] result = cyclicBuffer.read(3);
        System.out.println(Arrays.toString(result));
    }
}
