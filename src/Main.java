import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        DataHolder holder = new DataHolder();

        for (Object item : holder) {
            System.out.println(item);
        }

        Iterator<Object> it = holder.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}