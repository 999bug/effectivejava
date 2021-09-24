package effectivejava.chapter2.item8;

import java.lang.ref.Cleaner;

/**
 * @author Lishiyan
 * @date 2021/9/2210:35
 */
public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {

        int numJunkPies;

        State(int numJunkPies) {
            this.numJunkPies = numJunkPies;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPies = 0;
        }
    }

    private final State state;
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunlPiels) {
        state = new State(numJunlPiels);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
