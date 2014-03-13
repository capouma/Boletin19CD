/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boletin19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author findag
 */
public class Metodos implements Comparable
{
    private String nombre;
    private int nota;
    static ArrayList <Metodos> alumnos = new ArrayList<Metodos>();
    
    public Metodos()
    {
        
    }
    public Metodos(String nombre, int nota)
    {
        this.nombre = nombre;
        this.nota = nota;
    }
    public String getNombre() {
        return nombre;
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public ArrayList insertarDatos()
    {
        Scanner teclado = new Scanner(System.in);
        
        int verifica = 0;
        do
        {
            Metodos alumno = new Metodos();
            System.out.println("Porfavor introduza nome do alumno.");
            alumno.setNombre(teclado.next());
            System.out.println("nota: ");
            alumno.setNota(teclado.nextInt());
            alumnos.add(alumno);
            System.out.println("Para continuar insertando datos pulse cualquier tecla, para salir pulse 0");
            verifica = teclado.nextInt();
        }while(verifica !=0);
        return alumnos;
    }
    public void visualizarLista(ArrayList alumnos)
    {
        Iterator <Metodos> iteracion = alumnos.iterator();
        System.out.println("En la lista hay en estos momentos: " + alumnos.size());
        System.out.println("La lista contiene los siguientes datos: ");
        while(iteracion.hasNext())
        {
             Metodos alumno = iteracion.next();
            System.out.println(alumno.getNombre() + " ten un " + alumno.getNota());
        }
    }
    public void especifico(ArrayList alumnos)
    {
        Iterator <Metodos> iteracion = alumnos.iterator();
        System.out.println("Porfavor indique o nome do alumno para visualizar a sua nota");
        Scanner teclado = new Scanner(System.in);
        String opcion= teclado.next();
        while(iteracion.hasNext())
        {
            Metodos alumno = iteracion.next();
            if(alumno.getNombre().compareToIgnoreCase(opcion) == 0)
            {
                System.out.println("a nota de este alumno e: " + alumno.getNota());
            }
        }
    }
    public void insertarNuevo()
    {
        this.insertarDatos();
           System.out.println("En la lista hay en estos momentos: " + alumnos.size());
    }
    public void verificarAlumno(ArrayList alumnos)
    {
        Iterator <Metodos> iteracion = alumnos.iterator();
        System.out.println("Porfavor indique o nome do alumno a verificar");
        Scanner teclado = new Scanner(System.in);
        String opcion= teclado.next();
        int i = 0;
        while(iteracion.hasNext())
        {
            i = i+1;
            Metodos alumno = iteracion.next();
            if(alumno.getNombre().compareToIgnoreCase(opcion) == 0)
            {
                System.out.println("O alumno esta na lista.");
            }
            else
            {
                i = 0;
            }
        }
        if (i == 0)
        {
            System.out.println("O alumno non existe na lista");
        }
    }
    public void ordenar(ArrayList alumnos)
    {
       Collections.sort(alumnos);
    }
    public void menu()
    {
        System.out.println("Porfavor elixa unha das opcions:");
        int i = 1;
        do
        {
            
            System.out.println("Pulse 1 para crear unha lista de alumnos\nPulse 2 para visualizar a nota dun alumno en concreto\nPulse 3 para insertar novos alumnos\nPulse 4 para consultar se un alumno esta dado de alta\nPulse 5 para visualizar a lista\nPulse 6 para ordenar\nPulse calquer outro numero para sair");
            Scanner teclado = new Scanner(System.in);
            switch(teclado.nextInt())
            {
                case 1:
                    this.insertarDatos();
                    break;
                case 2:
                    this.especifico(alumnos);
                    break;
                case 3:
                    this.insertarNuevo();
                    break;
                case 4:
                    this.verificarAlumno(alumnos);
                    break;
                case 5:
                    this.visualizarLista(alumnos);
                    break;
                case 6:
                    this.ordenar(alumnos);
                    break;
                default:
                    System.out.println("Grazas por usar o noso servizo");
                    i = 0;
            }
        }while(i!=0);
    }

    @Override
    public int compareTo(Object t) {
         Metodos alumno =(Metodos)t;
      if(this.nombre.compareToIgnoreCase(alumno.nombre)== 0)
          return 0;
      else if(this.nombre.compareToIgnoreCase(alumno.nombre)> 0)
               return 1;
           else
              return -1;
    }
    public void darDeBaixa()
    {
         Iterator <Metodos> iteracion = alumnos.iterator();
        System.out.println("Porfavor indique o nome do alumno que quere dar de baixa");
        Scanner teclado = new Scanner(System.in);
        String opcion= teclado.next();
        iteracion = alumnos.iterator();
        while(iteracion.hasNext())
        {
            Metodos alumno = iteracion.next();
            if(alumno.nombre.equals(opcion))
            iteracion.remove();
    
        }
    }
}
    