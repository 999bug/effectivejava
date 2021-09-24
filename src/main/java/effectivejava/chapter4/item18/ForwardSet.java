package effectivejava.chapter4.item18;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 包装类 - 使用组合代替继承 (Page 90)
public class ForwardSet<E> {

    private ForwardingSet<E> set;
    private int addCount = 0;

    public ForwardSet(ForwardingSet<E> objects) {
        this.set = objects;
    }


    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        ForwardSet<String> s = new ForwardSet<>(new ForwardingSet<>() {
            @Override
            protected Set<String> delegate() {
                return new HashSet<>();
            }
        });
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}
