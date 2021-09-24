package effectivejava.chapter2.item8;

// Well-behaved client of resource with cleaner safety-net (Page 33)
public class Teenager {
    public static void main(String[] args) throws Exception {
        new Room(7);
        System.out.println("Peace out");
        System.gc();

    }
}
