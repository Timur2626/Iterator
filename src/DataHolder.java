import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataHolder implements Iterable<Object> {

    private int intValue;
    private double[] doubleArray;
    private ArrayList<String> stringList;
    private boolean flag;
    private String text;

    public DataHolder() {
        this.intValue = 42;
        this.doubleArray = new double[]{3.14, 2.71, 1.41};
        this.stringList = new ArrayList<>();
        this.stringList.add("Java");
        this.stringList.add("Iterator");
        this.stringList.add("Pattern");
        this.flag = true;
        this.text = "Hello, World!";
    }

    @Override
    public Iterator<Object> iterator() {
        return new MyDataIterator();
    }

    private class MyDataIterator implements Iterator<Object> {

        private int currentField = 0;
        private int innerIndex = 0;

        @Override
        public boolean hasNext() {
            while (currentField < 5) {
                switch (currentField) {
                    case 0:
                        return true;
                    case 1:
                        if (innerIndex < doubleArray.length) return true;
                        break;
                    case 2:
                        if (innerIndex < stringList.size()) return true;
                        break;
                    case 3:
                        return true;
                    case 4:
                        return true;
                }
                currentField++;
                innerIndex = 0;
            }
            return false;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Элементов больше нет!");
            }

            Object result = null;

            switch (currentField) {
                case 0:
                    result = intValue;
                    currentField++;
                    break;
                case 1:
                    result = doubleArray[innerIndex];
                    innerIndex++;
                    break;
                case 2:
                    result = stringList.get(innerIndex);
                    innerIndex++;
                    break;
                case 3:
                    result = flag;
                    currentField++;
                    break;
                case 4:
                    result = text;
                    currentField++;
                    break;
            }
            return result;
        }
    }
}