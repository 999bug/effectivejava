package effectivejava.chapter3.item14;
import java.util.*;

// The benefits of implementing Comparable (Page 66)
public class WordList implements Cloneable{
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        int[] a =new int[]{1,2,2,};
        int[] clone = a.clone();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
