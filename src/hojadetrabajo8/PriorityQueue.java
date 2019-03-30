/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hojadetrabajo8;

/**
 *
 * @author Martin Ortega Yung 18020
 * REFERENCIAS: TODO FUE SACADO DEL LIBRO JAVA STRUCTURES (2007) de DUANE A. BAILEY. 
 * 13.1 The Interface, pagina 315
 * 
 */
public interface PriorityQueue<E extends Comparable<E>> {
    public E getFirst();
    public E remove();
    public void add(E value);
    public boolean isEmpty();
    public int size();
}
