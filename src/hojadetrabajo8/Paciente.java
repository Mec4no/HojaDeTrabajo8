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
 */
public class Paciente implements Comparable<Paciente>{
    public String nombre;
    public String sintoma;
    public int codigo;
    
    public Paciente(String nom, String sin, int cod){
        this.nombre = nom;
        this.sintoma = sin;
        this.codigo = cod;
    }

    @Override
    public int compareTo(Paciente otro){
            return Integer.compare(this.codigo, otro.codigo);
    }
}
