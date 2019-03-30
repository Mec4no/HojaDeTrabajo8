/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hojadetrabajo8;
import java.util.Vector;
/**
 *
 * @author Martin Ortega Yung 18020
 * REFERENCIAS: TODO FUE SACADO DEL LIBRO JAVA STRUCTURES (2007) de DUANE A. BAILEY.
 * 13.4.1 Vector-Based Heaps, pagina 320
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{
    Vector<E> vec;
    
    public VectorHeap(){
        vec = new Vector<E>();
    }
    
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i-1)/2;
    }
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }
    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return 2*(i+1);
    }

    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = vec.get(leaf);
        while (leaf > 0 && (value.compareTo(vec.get(parent)) < 0))
        {
            vec.set(leaf,vec.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        vec.set(leaf,value);
    }
    
    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        vec.add(value);
        percolateUp(vec.size()-1);
    }

    
    
    public E getFirst(){
        return vec.get(0);
    }
    
    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        vec.set(0,vec.get(vec.size()-1));
        vec.setSize(vec.size()-1);
        if (vec.size() > 1) pushDownRoot(0);
        return minVal;
    }

    
    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = vec.size();
        E value = vec.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) && ((vec.get(childpos+1)).compareTo(vec.get(childpos)) < 0))
                {
                    childpos++;
                }
            // Assert: childpos indexes smaller of two children
            if ((vec.get(childpos)).compareTo(value) < 0)
            {
                vec.set(root,vec.get(childpos));
                root = childpos; // keep moving down
            } else { // found right location
                vec.set(root,value);
                return;
            }
            } else { // at a leaf! insert and halt
                vec.set(root,value);
                return;
            }
    }
    }
    
    public boolean isEmpty(){
        if(vec.isEmpty())
            return true;
        else
            return false;
    }
    
    public int size(){
       return vec.size();
    }
    
}
