package com.company;
/**
 * This is a Container class, that uses to store objects
 *
 * @author George Sapozhkov
 * intArray - our array that we will use
 * size - a variable means the number of elements in intArray
 * capacity - a variable to show an amount of free space in intArray
 */
public class Container {
    int[] intArray;
    int size;
    int capacity;
    /**
     * This is a constructor where we initialize our array
     */
    public Container() {
        int[] intArray = new int[2];
        int size = 0;
        int capacity = 2;
    }
    /**
     * This method is used to add the element to the end
     * @param a uses for getting input the element to add it to array
     */
    public void addElementToArray(int a) {
        if (this.size == this.capacity) {
            this.increaseArraySize();
        }

        this.intArray[this.size] = a;
        ++this.size;
    }
    /**
     * This is a method to add the element to the position following which were set as a parameter
     *
     * @param a is used to transmit the value of the element u want to add
     * @param k is used to transmit the position of the element u want to add
     */
    public void addElementByIndex(int a, int k) {
        if (k <= this.size && k >= 0) {
            if (this.size == this.capacity) {
                this.increaseArraySize();
            }

            for(int i = 0; i < this.size; ++i) {
                if (i == k) {
                    ++this.size;

                    for(int j = this.size - 1; j > i + 1; --j) {
                        this.intArray[j] = this.intArray[j - 1];
                    }

                    this.intArray[i + 1] = a;
                    ++i;
                }
            }
        }

    }
    /**
     * This is a method to increase the capacity of the array, when we want to add some element, but our size is full
     */
    public void increaseArraySize() {
        int[] tempArray = null;
        if (this.size == this.capacity) {
            tempArray = new int[this.capacity * 2];
            if (this.capacity >= 0) {
                System.arraycopy(this.intArray, 0, tempArray, 0, this.capacity);
            }
        }

        this.intArray = tempArray;
        this.capacity *= 2;
    }
    /**
     * This is a method to delete unnecessary space after increasing the array
     */
    public void shrinkSize() {
        if (this.size > 0) {
            int[] temp = new int[this.size];
            System.arraycopy(this.intArray, 0, temp, 0, this.size);
            this.capacity = this.size;
            this.intArray = temp;
        }

    }
    /**
     * This is a method to delete an element standing at the definite position
     *
     * @param posItion is used for needed position of removing
     * @throws Exception indicates that we are trying to delete the nonexistent element or to refer to nonexistent index
     */
    public void removeElement(int posItion) throws Exception {
        if (!this.isEmpty() && posItion < this.size && posItion >= 0) {
            if (this.size > 0 && posItion >= 0 && posItion < this.size) {
                for(int i = posItion; i < this.size - 1; ++i) {
                    this.intArray[i] = this.intArray[i + 1];
                }
            }

            --this.size;
        } else {
            throw new Exception("User has input wrong position    ");
        }
    }
    /**
     * This is a method to pop element needed
     *
     * @param index used for index of the element we want to pop
     * @return element which is located at the desired index
     * @throws Exception indicates that we are trying to pop nonexistent index
     */
    public int PopElement(int index) throws Exception {
        if (index <= this.size - 1 && index >= 0) {
            return this.intArray[index];
        } else {
            System.out.println("Invalid number of Element");
            throw new Exception("User has input wrong position    ");
        }
    }
    /**
     * The method to indicate that our array is empty
     *
     * @return true, when its empty, or false when is full
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    /**
     * The method to convert the elements of our array to String type and to output as a line
     *
     * @return the line, which consists of elements of array
     */
    public String toString() {
        String line = new String("");
        if (this.isEmpty()) {
            return line;
        } else {
            for(int i = 0; i < this.size; ++i) {
                String tmp = Integer.toString(this.intArray[i]);
                line = line + tmp.toString() + " ";
            }

            line = line.substring(0, line.length() - 1);
            return line;
        }
    }
}
