/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hojadetrabajo8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.PriorityQueue;
/**
 *
 * @author Martin Ortega Yung 18020
 * REFERENCIAS: TODO FUE SACADO DEL LIBRO JAVA STRUCTURES (2007) de DUANE A. BAILEY.
 */
public class HojaDeTrabajo8 {

    /**
     * @param args the command line 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName = "pacientes.txt";
        String line;
        VectorHeap<Paciente> heap = new VectorHeap<Paciente>();
        PriorityQueue<Paciente> queue = new PriorityQueue<Paciente>();
        Scanner scan = new Scanner(System.in);
        String op = "";
        boolean NUKE = true;
        try{
            FileReader fileReader = new FileReader(fileName); // Se crea el lector de documento

            BufferedReader bufferedReader = new BufferedReader(fileReader);//Secrea bufferedReader

            while(NUKE){
                System.out.println("1. VectorHeap");
                System.out.println("2. PriorityQueue de Java");
                op = scan.next();
                if(op.equals("1") || op.equals("2")){
                    NUKE = false;
                }else{
                    System.out.println("Eso no se puede hacer.");
                }
            }
            
            if(op.equals("1")){
            //Ciclo que corre mientras se pueda leer el documento
                while((line = bufferedReader.readLine()) != null) {
                        String[] palabras = line.split(", ");
                        if(palabras[2].equals("A")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 1);
                            heap.add(pac);
                        }else if(palabras[2].equals("B")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 2);
                            heap.add(pac);
                        }
                        else if(palabras[2].equals("C")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 3);
                            heap.add(pac);
                        }
                        else if(palabras[2].equals("D")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 4);
                            heap.add(pac);
                        }
                        else if(palabras[2].equals("E")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 5);
                            heap.add(pac);
                        }  
                }
                NUKE = true;
                while(NUKE){
                    System.out.println("1. Atender al siguiente paciente.");
                    System.out.println("2. Terminar.");
                    op = scan.next();
                    if(op.equals("1") || op.equals("2")){
                        Paciente temporal = heap.remove();
                        if(op.equals("1") && heap.size() +1 != 0){
                            System.out.println("El paciente " + temporal.nombre + " tiene la condición: " + temporal.sintoma + " y tiene la prioridad " + temporal.codigo);
                        } else{
                            NUKE = false;
                        }
                    }else{
                        System.out.println("Eso no se puede hacer.");
                    }
                    if(heap.size() == 0){
                            System.out.println("Ya no hay pacientes que tratar.");
                            NUKE = false;
                    }
                }
                bufferedReader.close(); 
            }else{
                while((line = bufferedReader.readLine()) != null) {
                        String[] palabras = line.split(", ");
                        if(palabras[2].equals("A")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 1);
                            queue.add(pac);
                        }else if(palabras[2].equals("B")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 2);
                            queue.add(pac);
                        }
                        else if(palabras[2].equals("C")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 3);
                            queue.add(pac);
                        }
                        else if(palabras[2].equals("D")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 4);
                            queue.add(pac);
                        }
                        else if(palabras[2].equals("E")){
                            Paciente pac = new Paciente(palabras[0], palabras[1], 5);
                            queue.add(pac);
                        }  
                }
                NUKE = true;
                while(NUKE){
                    System.out.println("1. Atender al siguiente paciente.");
                    System.out.println("2. Terminar.");
                    op = scan.next();
                    if(op.equals("1") || op.equals("2")){
                        Paciente temporal = queue.remove();
                        if(op.equals("1") && queue.size() +1 != 0){
                            System.out.println("El paciente " + temporal.nombre + " tiene la condición: " + temporal.sintoma + " y tiene la prioridad " + temporal.codigo);
                        }
                        else{
                            NUKE = false;
                        }
                    }else{
                        System.out.println("Eso no se puede hacer.");
                    }
                    if(queue.size() == 0){
                            System.out.println("Ya no hay pacientes que tratar.");
                            NUKE = false;
                    }
                }
                bufferedReader.close(); 
            }
        } 

        

        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");    
                //Si no se puede abrir o no se encuentra el archivo            
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");
                //Si no se puede abrir o no se encuentra el archivo                      
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
    }
    
}
