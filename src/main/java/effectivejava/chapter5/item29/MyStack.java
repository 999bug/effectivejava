package effectivejava.chapter5.item29;

import effectivejava.chapter5.item29.technqiue1.Stack;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lishiyan
 * @date 2021/9/2410:55
 */
public class MyStack<E> {
    private static final int INIT_CAPACITY = 16;
    private int size = 0;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public MyStack() {
        elements = (E[]) new Object[INIT_CAPACITY];
    }

    public E pop() {
        if (size <= 0) {
            throw new RuntimeException("stack is null");
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        List<String> atc = List.of("ATC", "dsf", "Apple");
        for (String arg : atc) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
