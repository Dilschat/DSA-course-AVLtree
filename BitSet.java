
/**
 * This class represent BitSet data structure
 *
 * @author Dilshat Salikhov
 * @version 1.0
 * @name BitSet
 */
public class BitSet {
    static long[] bits;
    //constructor
    public BitSet(double capacity) {
        bits = new long[(int) Math.floor(capacity / 64) + 1];
        for (int i = 0; i < Math.floor(capacity / 64) + 1; i++) {
            bits[i] = 0;
        }
    }
    /** adds bits on bit set*/
    public void setBit(int element) {
        int position = element / 64;
        int shift = element % 64;
        long newBit = 1;
        newBit = newBit << shift - 1;
        bits[position] = bits[position] | newBit;
    }
    /**check on bit fullness */
    public boolean hasElement(int element) {
        int position = element / 64;
        int shift = element % 64;
        long currentBits = bits[position];
        long newBits = 1;
        currentBits = currentBits >>> shift - 1;
        currentBits = currentBits << shift - 1;
        currentBits = currentBits << 64 - shift;
        currentBits = currentBits >>> 64 - shift;
        newBits = newBits << shift - 1;
        return newBits == currentBits;


    }
}
