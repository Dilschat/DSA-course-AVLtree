import net.webeggs.juzzle.vocabulary.LowercaseTrieVocabulary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The main class
 *
 * @author Dilshat Salikhov
 * @version 1.0
 * @name Main
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BitSet set = new BitSet(100000);
        LowercaseTrieVocabulary trie = new LowercaseTrieVocabulary();
        Scanner scanner = new Scanner(new File("input.txt"));
        FileWriter writer = new FileWriter(new File("output.txt"));
        String[] insertedNum = scanner.nextLine().split(" ");

        for (int i = 0; i < insertedNum.length; i++) {
            if (!insertedNum[i].isEmpty()) {
                set.setBit(Integer.parseInt(insertedNum[i]));
            }


        }
        String[] testedNum = scanner.nextLine().split(" ");
        for (int i = 0; i < testedNum.length; i++) {
            if (!testedNum[i].isEmpty()) {
                writer.write(set.hasElement(Integer.parseInt(testedNum[i])) + " ");
            }
        }
        writer.close();


    }

}
