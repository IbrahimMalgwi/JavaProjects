package TddArray;

import java.util.AbstractList;
@SuppressWarnings("unchecked")
public class TddArrayList<E> extends AbstractList {
    private final E[] backingArray;
    private int size = 0;

    public TddArrayList() {
        this.backingArray = (E[]) new Object[10];
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        return backingArray[index];
    }

    @Override
    public int size() {
        return size ;
    }

    @Override
    public void add(int index, Object element) {
        for (int i = size - 1; i > index; i--) {
            backingArray[i +1 ] = backingArray[i];
        }
        backingArray[index] = (E) element;
        size++;
    }


}
