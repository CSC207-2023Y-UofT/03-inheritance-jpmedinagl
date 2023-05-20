/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */

    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;

    /*
     * TODO: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */

    /**
     * Creates a new Bag with the given color and capacity.
     *
     * @param color the color of this bag
     * @param capacity the capacity of the bag
     */
    public Bag(String color, int capacity) {
        this.color = color;
        this.numberOfContents = 0;
        this.capacity = capacity;
        this.contents = new String[capacity];
    }


    /*
     * TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */

    /**
     * Returns the color of the bag.
     *
     * @return string with the color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Returns an integer of the number of items in the bag.
     *
     * @return an integer of the number of contents
     */
    public int getNumberOfContents() {
        return this.numberOfContents;
    }

    public int getCapacity() {
        return this.capacity;
    }

    /*
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */

    /**
     * Change the color of the bag with the new color.
     *
     * @param color the new color of the bag
     */
    public void setColor(String color) {
        this.color = color;
    }

    /*
     * TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */

    /**
     * Takes in an item and adds it to the bag if there is enough
     * space to add the item to the bag.
     *
     * @param item the string to be added to the bag
     * @return boolean whether the item was added or not
     */
    public boolean addItem(String item) {
        if (this.numberOfContents < this.capacity) {
            this.contents[numberOfContents] = item;
            this.numberOfContents += 1;
            return true;
        }
        return false;
    }

    /**
     * TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     * If there are no items in this Bag, return null.
     *
     * @return the last item added in the bad or null if no items.
     */

    public String popItem() {
        if (this.numberOfContents != 0) {
            String item = this.contents[numberOfContents - 1];
            this.contents[numberOfContents - 1] = null;
            this.numberOfContents -= 1;
            return item;
        }
        return null;
    }

    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        int oldCapacity = this.capacity;
        this.capacity += n;

        if (oldCapacity > 0) {
            String[] newContents = new String[this.capacity];
            for (int j = 0; j < oldCapacity; j++) {
                newContents[j] = this.contents[j];
            }
            this.contents = newContents;
        }
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return string of number of contents and capacity of the bag
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}