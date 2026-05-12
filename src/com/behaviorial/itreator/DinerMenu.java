package com.behaviorial.itreator;

public class DinerMenu implements Menu{
    private static final int MAX_ITEMS = 6;

    private final MenuItem[] menuItems = new MenuItem[MAX_ITEMS];
    private int numberOfItems = 0;

    public DinerMenu() {
        addItem("Vegetarian BLT", 2.99);
        addItem("BLT", 3.49);
        addItem("Soup of the Day", 3.29);
    }

    public void addItem(String name, double price) {
        if (numberOfItems < MAX_ITEMS) {
            menuItems[numberOfItems++] = new MenuItem(name, price);
        }
    }
    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems, numberOfItems);
    }
}
