package com.behaviorial.itreator;

import java.util.List;

public class PancakeHouseMenuIterator implements Iterator<MenuItem>{

    private final List<MenuItem> items;
    private int position = 0;

    public PancakeHouseMenuIterator(List<MenuItem> items) {
        this.items = items;
    }


    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public MenuItem next() {
        return items.get(position++);
    }
}
