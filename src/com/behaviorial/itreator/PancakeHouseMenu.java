package com.behaviorial.itreator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu implements Menu{
    private List<MenuItem> menuItems = new ArrayList<>();

    public PancakeHouseMenu() {

        menuItems.add(new MenuItem("Pancake Breakfast", 2.99));
        menuItems.add(new MenuItem("Blueberry Pancakes", 3.49));
        menuItems.add(new MenuItem("Waffles", 3.59));
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}
