package com.behaviorial.itreator;

import java.util.NoSuchElementException;

public class DinerMenuIterator implements Iterator<MenuItem>{

    private MenuItem[] items;
    private int position = 0;
    private int size;

    public DinerMenuIterator(MenuItem[] items, int size) {
        this.items = items;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public MenuItem next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return items[position++];
    }
}
