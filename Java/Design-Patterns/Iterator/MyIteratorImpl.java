import java.util.List;

public class MyIteratorImpl<T> implements MyIterator {

    List<T> list;
    int currPosition;

    public MyIteratorImpl(List<T> list) {
        this.list = list;
        this.currPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currPosition < list.size() - 1; // Simplified the logic
    }

    @Override
    public T next() {
        if (hasNext()) {
            currPosition += 1;
        }
        return list.get(currPosition);
    }
}
