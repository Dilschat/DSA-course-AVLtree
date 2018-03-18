import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by 1 on 22.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        FileWriter out = new FileWriter(new File("output.txt"));
        long seed = in.nextLong();
        MyRandom myRandom = new MyRandom(seed);
        AVLTree<Double, Integer> avlTree = new AVLTree<>();
        double next;
        int counter;
        counter = 0;
        int result;
        while (true) {

            next = myRandom.nextDouble();
            counter++;
            if (!avlTree.contain(next)) {
                avlTree.put(next, counter);
            } else if (avlTree.contain(next)) {
                result = counter - avlTree.get(next);
                break;
            }


        }

        out.write(Integer.toString(result));
        out.close();

    }
}
