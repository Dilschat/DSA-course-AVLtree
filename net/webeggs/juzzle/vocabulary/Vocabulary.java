package net.webeggs.juzzle.vocabulary;

/**
 * Created by 1 on 27.02.2017.
 */

public interface Vocabulary {
    boolean add(String word);
    boolean isPrefix(String prefix);
    boolean contains(String word);
    String getName();
}