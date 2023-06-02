/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package sou1.algoritmos;
import others.PlanificacionPrioridades;
import java.awt.List;
import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author will_
 */
public class AlgoritmosPlanificacionSOU1 {
    
    public int datos;
    public int[]info_tllegada = new int[datos];
    public int[]info_tejecucion = new int[datos];
    public int[]info_prioridad = new int[datos];
    public int info_quantum;    
    
    public static void main(String[] args) {
        /*
        int dato;
        int[] tiemposLlegada = {1,2,3,4};
        int[] tiemposEjecucion = {10,1,2,1};
        int[] prioridad = {3,1,3,4};
        int quantum= 2;*/
        Scanner scanner = new Scanner(System.in);
        for(int m=0;m<=10;m++){
        
            System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////");
            System.out.println("1.	FCFS (First-Come, First-Served)");
            System.out.println("2.	SJF (Shortest Job First) - El trabajo más corto primero.");
            System.out.println("3.	RR (Round Robin) - Ronda de turnos.");
            System.out.println("4.      SRTF (Shortest Remaining Time First) - El tiempo restante más corto primero.");
            System.out.println("5.	Planificación prioritaria con Round-Robin");
            //System.out.println("5.	Priority Scheduling - Planificación por prioridad(fija-dinamica)");
            //System.out.println("7.	Planificación PorPrioridades Con desalojo");
            //System.out.println("8.	Planificación PorPrioridades Con desalojo");
            //System.out.println("9.	Planificación por turnos");
            
            System.out.println("6.      Salir");
            System.out.println("0.      Mostrar Todo");
            System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////");
            
            System.out.print("INGRESA UN OPCION: ");
            int opcion = scanner.nextInt();
            
            int dato;
            if(opcion>=0 && opcion<6){
                    System.out.print("Ingresa el Numero de DATOS: ");
                    dato = scanner.nextInt();
                    
                    int[] tiemposLlegada = new int[dato];
                    int[] tiemposEjecucion = new int[dato];
                    int[] prioridad = new int[dato];
                    int quantum;
                    if(opcion>0 && opcion<5 && opcion!=3){
                        for (int i = 0; i < dato; i++) {
                            tiemposLlegada[i]=i+1;
                            prioridad[i]=i;
                            System.out.print("Ingrese el valor para el Proceso " + i + ": ");
                            tiemposEjecucion[i]=scanner.nextInt();
                            //array[i] = scanner.nextInt();
                        }
                        if(opcion==3){
                            System.out.print("Quantum: ");
                            quantum=scanner.nextInt();
                        }else
                            quantum=2;
                    }else if(opcion>4 || opcion==0){
                        for (int i = 0; i < dato; i++) {
                            tiemposLlegada[i]=i+1;
                            prioridad[i]=i;
                            System.out.print("Ingrese Rafaga del Proceso " + (i+1) + ": ");
                            tiemposEjecucion[i]=scanner.nextInt();
                            
                            System.out.print("Prioridad " + i + ": ");
                            prioridad[i]=scanner.nextInt();
                        }
                        System.out.print("Quantum: ");
                        quantum=scanner.nextInt();
                    }else{
                        for (int i = 0; i < dato; i++) {
                            tiemposLlegada[i]=i+1;
                            prioridad[i]=i;
                            System.out.print("Ingrese Rafaga del Proceso " + (i+1) + ": ");
                            tiemposEjecucion[i]=scanner.nextInt();
                        }
                        System.out.print("Quantum: ");
                        quantum=scanner.nextInt();
                    }
                AlgoritmosPlanificacionSOU1 a = new AlgoritmosPlanificacionSOU1(tiemposLlegada,tiemposEjecucion,prioridad,quantum);
                if(opcion>0){
                  a.mostrar(opcion);
                }else{
                   System.out.println("\n\n*****************************************************************************************************************");
                   a.mostrar(1);
                   System.out.println("\n\n*****************************************************************************************************************");
                   a.mostrar(2);
                   System.out.println("\n\n*****************************************************************************************************************");
                   a.mostrar(3);
                   System.out.println("\n\n*****************************************************************************************************************");
                   a.mostrar(4);
                   System.out.println("\n\n*****************************************************************************************************************");
                   a.mostrar(5);
                   break;
                }
            }else if(opcion==6){
                break;
            }
        }
        scanner.close();
    }   
    public void set_datos(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el Numero de DATOS");
            this.datos = scanner.nextInt();

            for (int i = 0; i < this.datos; i++) {
                this.info_tllegada[i]=i;
                System.out.print("Ingrese el valor para el Proceso " + i + ": ");
                this.info_tejecucion[i]=scanner.nextInt();
                //array[i] = scanner.nextInt();
            }
    }
    public void mostrar(int opcion){
        switch(opcion){
            case 1:
                System.out.println("1.	FCFS (First-Come, First-Served)\n");
                algoritmo_fsfc();break;
            case 2: 
                System.out.println("2.	SJF (Shortest Job First) - El trabajo más corto primero.\n");
                algoritmo_sjf();
            break;
            case 3: 
                System.out.println("3.	RR (Round Robin) - Ronda de turnos.\n");
                algoritmo_rr();
            break;
            case 4: 
                System.out.println("5.  SRTF (Shortest Remaining Time First) - El tiempo restante más corto primero.\n");
                algoritmo_srtf();
            break;
            case 10: 
                System.out.println(".	Priority Scheduling - Planificación por prioridad(fija-dinamica)\n");
                algoritmo_Priority_Schedulingint();
            break;
            case 5: 
                System.out.println("6.	Planificación prioritaria con Round-Robin\n");
                algoritmo_PrioridadRoundRobin();
            break;
            case 7: 
                System.out.println("7.	Planificación PorPrioridades Con desalojo\n");
                algoritmo_PlanificacionPorPrioridades_sindesalojo();
            break;
            case 8: 
                System.out.println("8.	Planificación PorPrioridades Con desalojo\n");
                algoritmo_PlanificacionPrioridades_Desalojo();
            break;
            case 9: 
                System.out.println("9.	Planificación por turnos\n");
                PlanificacionPorTurnos();
            break;
        }
    }
    private double calculateAverage(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }
    public AlgoritmosPlanificacionSOU1(int[] tllegada,int[]tejecucion, int[] prioridad, int q){
        this.info_tllegada=tllegada;
        this.info_tejecucion=tejecucion;
        this.info_prioridad=prioridad;
        this.info_quantum=q;
    }
    AlgoritmosPlanificacionSOU1(){

    }
   
    /*1.	FCFS (First-Come, First-Served) - Primero en llegar, primero en ser servido.*/
    public void algoritmo_fsfc(){
        int n = this.info_tllegada.length;
        int[] tiemposEspera = new int[n];
        int[] tiemposRetorno = new int[n];
        int[] tiemposFinalizacion = new int[n];
        int[] tiemposInicio = new int[n];

        // Calcular los tiempos de espera, tiempos de retorno y tiempos de finalización
        int tiempoTotal = 0;
        for (int i = 0; i < n; i++) {
            if (this.info_tllegada[i] > tiempoTotal) {
                tiempoTotal = this.info_tllegada[i];
            }
            tiemposInicio[i] = tiempoTotal;
            tiemposEspera[i] = tiempoTotal - this.info_tllegada[i];
            tiempoTotal += this.info_tejecucion[i];
            tiemposFinalizacion[i] = tiempoTotal;
            tiemposRetorno[i] = tiemposFinalizacion[i] - this.info_tllegada[i];
        }
        // Calcular el tiempo de espera promedio
        double tiempoEsperaPromedio = Arrays.stream(tiemposEspera).average().orElse(0);
        System.out.println("Proceso\t\tLlegada\t\tRáfaga\t\tEspera\t\tRetorno\t\tFinalización");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", i + 1, this.info_tllegada[i], this.info_tejecucion[i],
                    tiemposEspera[i], tiemposRetorno[i], tiemposFinalizacion[i]);
        }

        System.out.println("\nDiagrama de Gantt:");
        for (int i = 0; i < n; i++) {
            System.out.print("| P" + (i + 1) + " ");
        }
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            System.out.print(tiemposInicio[i] + "\t");
        }
        System.out.println(tiemposFinalizacion[n - 1]);
        System.out.println("\nTiempo de espera promedio: " + tiempoEsperaPromedio);
    }
    /*2.	SJF (Shortest Job First) - El trabajo más corto primero.*/
    public void algoritmo_sjf() {
        int n = this.info_tllegada.length;
        int[] tiempoInicio = new int[n];
        int[] tiempoFinalizacion = new int[n];
        int[] tiempoEspera = new int[n];
        int[] tiempoRetorno = new int[n];
        int[] tiempoRespuesta = new int[n];
        
        int tiempoTotalEspera = 0;
        int tiempoTotalRespuesta = 0;
        
        // Ordenar los procesos por tiempo de ráfaga de menor a mayor
        int[] orden = new int[n];
        for (int i = 0; i < n; i++) {
            orden[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (this.info_tejecucion[j] > this.info_tejecucion[j + 1]) {
                    int temp = this.info_tejecucion[j];
                    this.info_tejecucion[j] = this.info_tejecucion[j + 1];
                    this.info_tejecucion[j + 1] = temp;
                    temp = this.info_tllegada[j];
                    this.info_tllegada[j] = this.info_tllegada[j + 1];
                    this.info_tllegada[j + 1] = temp;
                    temp = orden[j];
                    orden[j] = orden[j + 1];
                    orden[j + 1] = temp;
                }
            }
        }
        
        tiempoInicio[0] = this.info_tllegada[0];
        tiempoFinalizacion[0] = tiempoInicio[0] + this.info_tejecucion[0];
        tiempoEspera[0] = 0;
        tiempoRetorno[0] = this.info_tejecucion[0];
        tiempoRespuesta[0] = tiempoEspera[0];
        tiempoTotalEspera += tiempoEspera[0];
        tiempoTotalRespuesta += tiempoRespuesta[0];
        
        for (int i = 1; i < n; i++) {
            tiempoInicio[i] = tiempoFinalizacion[i - 1];
            tiempoFinalizacion[i] = tiempoInicio[i] + this.info_tejecucion[i];
            tiempoEspera[i] = tiempoInicio[i] - this.info_tllegada[i];
            tiempoRetorno[i] = tiempoFinalizacion[i] - this.info_tllegada[i];
            tiempoRespuesta[i] = tiempoEspera[i];
            tiempoTotalEspera += tiempoEspera[i];
            tiempoTotalRespuesta += tiempoRespuesta[i];
        }
        
        double tiempoPromedioEspera = (double) tiempoTotalEspera / n;
        double tiempoPromedioRespuesta = (double) tiempoTotalRespuesta / n;

        System.out.println("Proceso\t\tLlegada\t\tRáfaga\t\tInicio\t\tFinalización\\ttEspera\\ttRetorno\t\tRespuesta");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + this.info_tllegada[i] + "\t\t" + this.info_tejecucion[i] + "\t\t" + tiempoInicio[i]
                    + "\t\t" + tiempoFinalizacion[i] + "\t\t" + tiempoEspera[i] + "\t\t" + tiempoRetorno[i] + "\t\t" + tiempoRespuesta[i]);
        }
        
        System.out.println("\nTiempo promedio de espera: " + tiempoPromedioEspera);
        System.out.println("Tiempo promedio de respuesta: " + tiempoPromedioRespuesta);
        
        System.out.println("\nDiagrama de Gantt:");
        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print("| P" + (orden[i] + 1) + "\t");
        }
        System.out.println("|");
        System.out.print(tiempoInicio[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < this.info_tejecucion[i]; j++) {
                System.out.print(" ");
            }
            System.out.print(tiempoFinalizacion[i]);
        }
        System.out.println();
    }
    /*3.	RR (Round Robin) - Ronda de turnos.*/
    public void algoritmo_rr() {
        //int[] this.info_tllegada = tllegada; // Tiempos de llegada de los procesos
        //int[] this.info_tejecucion = tejecucion; // Tiempos de ráfaga de los procesos
        //int this.info_quantum = q; // Quantum del algoritmo Round Robin

        int n = this.info_tllegada.length;
        java.util.List<Proceso> colaProcesos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Proceso proceso = new Proceso(i + 1, this.info_tllegada[i], this.info_tejecucion[i]);
            colaProcesos.add(proceso);
        }

        int tiempoTotal = 0;
        int procesosCompletados = 0;

        while (procesosCompletados < n) {
            for (int i = 0; i < colaProcesos.size(); i++) {
                Proceso proceso = colaProcesos.get(i);

                if (proceso.getTiempoRestante() > 0) {
                    int tiempoEjecucion = Math.min(this.info_quantum, proceso.getTiempoRestante());
                    proceso.setTiempoRestante(proceso.getTiempoRestante() - tiempoEjecucion);
                    tiempoTotal += tiempoEjecucion;

                    if (proceso.getTiempoRestante() == 0) {
                        proceso.setTiempoFinalizacion(tiempoTotal);
                        proceso.setTiempoRetorno(proceso.getTiempoFinalizacion() - proceso.getTiempoLlegada());
                        proceso.setTiempoEspera(proceso.getTiempoRetorno() - proceso.getTiempoRafaga());
                        proceso.setTiempoRespuesta(proceso.getTiempoEspera() + proceso.getTiempoRafaga());
                        procesosCompletados++;
                    }
                }
            }
        }

        // Calcular los tiempos promedio
        double tiempoEsperaPromedio = 0;
        double tiempoRespuestaPromedio = 0;

        for (Proceso proceso : colaProcesos) {
            tiempoEsperaPromedio += proceso.getTiempoEspera();
            tiempoRespuestaPromedio += proceso.getTiempoRespuesta();
        }

        tiempoEsperaPromedio /= n;
        tiempoRespuestaPromedio /= n;

        // Mostrar los resultados
        System.out.println("Proceso\t\tLlegada\t\tRáfaga\t\tEspera\t\tRetorno\t\tFinalización\tRespuesta");
        for (Proceso proceso : colaProcesos) {
            System.out.printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", proceso.getId(), proceso.getTiempoLlegada(),
                    proceso.getTiempoRafaga(), proceso.getTiempoEspera(), proceso.getTiempoRetorno(),
                    proceso.getTiempoFinalizacion(), proceso.getTiempoRespuesta());
        }

        System.out.println("\nDiagrama de Gantt:");
        for (Proceso proceso : colaProcesos) {
            System.out.print("| P" + proceso.getId() + " ");
        }
        System.out.println("|");
        for (Proceso proceso : colaProcesos) {
            System.out.print(proceso.getTiempoInicio() + "\t");
        }
        System.out.println(colaProcesos.get(colaProcesos.size() - 1).getTiempoFinalizacion());

        System.out.println("\nTiempo promedio de espera: " + tiempoEsperaPromedio);
        System.out.println("Tiempo promedio de respuesta: " + tiempoRespuestaPromedio);
    }
    static class Proceso {
        private int id;
        private int tiempoLlegada;
        private int tiempoRafaga;
        private int tiempoEspera;
        private int tiempoRetorno;
        private int tiempoFinalizacion;
        private int tiempoRespuesta;
        private int tiempoInicio;
        private int tiempoRestante;

        public Proceso(int id, int tiempoLlegada, int tiempoRafaga) {
            this.id = id;
            this.tiempoLlegada = tiempoLlegada;
            this.tiempoRafaga = tiempoRafaga;
            this.tiempoEspera = 0;
            this.tiempoRetorno = 0;
            this.tiempoFinalizacion = 0;
            this.tiempoRespuesta = 0;
            this.tiempoInicio = 0;
            this.tiempoRestante = tiempoRafaga;
        }

        public int getId() {
            return id;
        }

        public int getTiempoLlegada() {
            return tiempoLlegada;
        }

        public int getTiempoRafaga() {
            return tiempoRafaga;
        }

        public int getTiempoEspera() {
            return tiempoEspera;
        }

        public void setTiempoEspera(int tiempoEspera) {
            this.tiempoEspera = tiempoEspera;
        }

        public int getTiempoRetorno() {
            return tiempoRetorno;
        }

        public void setTiempoRetorno(int tiempoRetorno) {
            this.tiempoRetorno = tiempoRetorno;
        }

        public int getTiempoFinalizacion() {
            return tiempoFinalizacion;
        }

        public void setTiempoFinalizacion(int tiempoFinalizacion) {
            this.tiempoFinalizacion = tiempoFinalizacion;
        }

        public int getTiempoRespuesta() {
            return tiempoRespuesta;
        }

        public void setTiempoRespuesta(int tiempoRespuesta) {
            this.tiempoRespuesta = tiempoRespuesta;
        }

        public int getTiempoInicio() {
            return tiempoInicio;
        }

        public void setTiempoInicio(int tiempoInicio) {
            this.tiempoInicio = tiempoInicio;
        }

        public int getTiempoRestante() {
            return tiempoRestante;
        }

        public void setTiempoRestante(int tiempoRestante) {
            this.tiempoRestante = tiempoRestante;
        }
    }
    /*4.	SRTF (Shortest Remaining Time First) - El tiempo restante más corto primero.*/
    public void algoritmo_srtf(){
        //int[] this.info_tllegada = tllegada; // Tiempos de llegada de los procesos
        //int[] this.info_tejecucion = tejecucion; // Tiempos de ráfaga de los procesos

        int n = this.info_tllegada.length;
        int[] tiemposEspera = new int[n];
        int[] tiemposRetorno = new int[n];
        int[] tiemposFinalizacion = new int[n];
        int[] tiemposInicio = new int[n];
        int[] tiemposRespuesta = new int[n];

        // Copiar los tiempos de ráfaga a un nuevo array para no modificar el original
        int[] tiempos_Rafaga_Copia = Arrays.copyOf(this.info_tejecucion, n);

        boolean[] procesosCompletados = new boolean[n];
        int tiempoTotal = 0;
        int procesosCompletadosCount = 0;

        while (procesosCompletadosCount < n) {
            int procesoActual = -1;
            int rafagaMinima = Integer.MAX_VALUE;

            // Buscar el proceso con la ráfaga más corta que no haya sido completado
            for (int i = 0; i < n; i++) {
                if (!procesosCompletados[i] && this.info_tllegada[i] <= tiempoTotal && tiempos_Rafaga_Copia[i] < rafagaMinima) {
                    rafagaMinima = tiempos_Rafaga_Copia[i];
                    procesoActual = i;
                }
            }

            // Si no se encontró ningún proceso válido, incrementar el tiempo total
            if (procesoActual == -1) {
                tiempoTotal++;
                continue;
            }

            // Calcular el tiempo de inicio del proceso
            if (tiemposInicio[procesoActual] == 0) {
                tiemposInicio[procesoActual] = tiempoTotal;
            }

            // Ejecutar el proceso durante un tiempo unitario
            tiempos_Rafaga_Copia[procesoActual]--;
            tiempoTotal++;

            // Verificar si el proceso ha finalizado
            if (tiempos_Rafaga_Copia[procesoActual] == 0) {
                tiemposFinalizacion[procesoActual] = tiempoTotal;
                tiemposRetorno[procesoActual] = tiemposFinalizacion[procesoActual] - this.info_tllegada[procesoActual];
                tiemposEspera[procesoActual] = tiemposRetorno[procesoActual] - this.info_tejecucion[procesoActual];
                tiemposRespuesta[procesoActual] = tiemposEspera[procesoActual] + tiemposInicio[procesoActual];
                procesosCompletados[procesoActual] = true;
                procesosCompletadosCount++;
            }
        }

        // Calcular los tiempos promedio
        double tiempoEsperaPromedio = Arrays.stream(tiemposEspera).average().orElse(0);
        double tiempoRespuestaPromedio = Arrays.stream(tiemposRespuesta).average().orElse(0);

        // Mostrar los resultados
        System.out.println("Proceso\tLlegada\tRáfaga\tEspera\tRetorno\tFinalización\tRespuesta");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%d\t%d\t%d\t%d\t%d\t%d\t\t%d\n", i + 1, this.info_tllegada[i], this.info_tejecucion[i],
                    tiemposEspera[i], tiemposRetorno[i], tiemposFinalizacion[i], tiemposRespuesta[i]);
        }

        System.out.println("\nDiagrama de Gantt:");
        for (int i = 0; i < n; i++) {
            System.out.print("| P" + (i + 1) + " ");
        }
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            System.out.print(tiemposInicio[i] + "\t");
        }
        System.out.println(tiemposFinalizacion[n - 1]);

        System.out.println("\nTiempo promedio de espera: " + tiempoEsperaPromedio);
        System.out.println("Tiempo promedio de respuesta: " + tiempoRespuestaPromedio);
    
    }
    /*5.	Priority Scheduling - Planificación por prioridad(fija-dinamica)*/
    public void algoritmo_Priority_Schedulingint() {
        int n = this.info_tllegada.length;
        int[] tiemposEspera = new int[n];
        int[] tiemposRetorno = new int[n];
        int[] tiemposFinalizacion = new int[n];
        int[] tiemposInicio = new int[n];
        int[] tiemposRespuesta = new int[n];

        // Copiar los tiempos de ráfaga a un nuevo array para no modificar el original
        int[] tiempos_Rafaga_Copia = Arrays.copyOf(this.info_tejecucion, n);

        boolean[] procesosCompletados = new boolean[n];
        int tiempoTotal = 0;
        int procesosCompletadosCount = 0;

        while (procesosCompletadosCount < n) {
            int procesoPrioridadMinima = -1;
            int prioridadMinima = Integer.MAX_VALUE;

            // Buscar el proceso con la prioridad más baja que no haya sido completado
            for (int i = 0; i < n; i++) {
                if (!procesosCompletados[i] && this.info_tllegada[i] <= tiempoTotal && this.info_prioridad[i] < prioridadMinima) {
                    prioridadMinima = this.info_prioridad[i];
                    procesoPrioridadMinima = i;
                }
            }

            // Si no se encontró ningún proceso válido, incrementar el tiempo total
            if (procesoPrioridadMinima == -1) {
                tiempoTotal++;
                continue;
            }

            // Actualizar el tiempo de inicio si el proceso es diferente al anterior
            if (tiemposInicio[procesoPrioridadMinima] == 0) {
                tiemposInicio[procesoPrioridadMinima] = tiempoTotal;
            }

            // Ejecutar el proceso durante un ciclo
            tiempos_Rafaga_Copia[procesoPrioridadMinima]--;
            tiempoTotal++;

            // Verificar si el proceso ha finalizado
            if (tiempos_Rafaga_Copia[procesoPrioridadMinima] == 0) {
                tiemposFinalizacion[procesoPrioridadMinima] = tiempoTotal;
                tiemposRetorno[procesoPrioridadMinima] = tiemposFinalizacion[procesoPrioridadMinima] - this.info_tllegada[procesoPrioridadMinima];
                tiemposEspera[procesoPrioridadMinima] = tiemposRetorno[procesoPrioridadMinima] - this.info_tejecucion[procesoPrioridadMinima];
                tiemposRespuesta[procesoPrioridadMinima] = tiemposEspera[procesoPrioridadMinima] + tiemposInicio[procesoPrioridadMinima];
                procesosCompletados[procesoPrioridadMinima] = true;
                procesosCompletadosCount++;
            }
        }

        // Calcular los tiempos promedio
        double tiempoEsperaPromedio = calculateAverage(tiemposEspera);
        double tiempoRespuestaPromedio = calculateAverage(tiemposRespuesta);

        // Mostrar los resultados
        System.out.println("Proceso\t\tLlegada\t\tRáfaga\t\tPrioridad\tEspera\t\tRetorno\t\tFinalización\tRespuesta");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", i + 1, this.info_tllegada[i], this.info_tejecucion[i],
                    this.info_prioridad[i], tiemposEspera[i], tiemposRetorno[i], tiemposFinalizacion[i], tiemposRespuesta[i]);
        }

        System.out.println("\nDiagrama de Gantt:");
        for (int i = 0; i < n; i++) {
            System.out.print("| P" + (i + 1) + " ");
        }
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            System.out.print(tiemposInicio[i] + "\t");
        }
        System.out.println(tiemposFinalizacion[n - 1]);

        System.out.println("\nTiempo promedio de espera: " + tiempoEsperaPromedio);
        System.out.println("Tiempo promedio de respuesta: " + tiempoRespuestaPromedio);
    }
    /*6.	Planificación prioritaria con Round-Robin*/
    public void algoritmo_PrioridadRoundRobin(){
        int n = this.info_tllegada.length;
        int[] tiemposEspera = new int[n];
        int[] tiemposRetorno = new int[n];
        int[] tiemposFinalizacion = new int[n];
        int[] tiemposInicio = new int[n];
        int[] tiemposRespuesta = new int[n];

        // Copiar los tiempos de ráfaga y this.info_prioridad a nuevos arrays para no modificar los originales
        int[] tiempos_Rafaga_Copia = Arrays.copyOf(this.info_tejecucion, n);
        int[] prioridad_Copia = Arrays.copyOf(this.info_prioridad, n);

        int tiempoTotal = 0;
        int procesosCompletadosCount = 0;
        boolean[] procesosCompletados = new boolean[n];

        Queue<Integer> colaProcesos = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            colaProcesos.add(i);
        }

        while (procesosCompletadosCount < n) {
            int procesoActual = colaProcesos.poll();

            // Ejecutar el proceso durante el Quantum o hasta que se complete su ráfaga
            int tiempoEjecucion = Math.min(this.info_quantum, tiempos_Rafaga_Copia[procesoActual]);
            tiempos_Rafaga_Copia[procesoActual] -= tiempoEjecucion;
            tiempoTotal += tiempoEjecucion;

            // Actualizar el tiempo de inicio si es el primer ciclo del proceso
            if (tiemposInicio[procesoActual] == 0) {
                tiemposInicio[procesoActual] = tiempoTotal - tiempoEjecucion;
            }

            // Verificar si el proceso ha finalizado
            if (tiempos_Rafaga_Copia[procesoActual] == 0) {
                tiemposFinalizacion[procesoActual] = tiempoTotal;
                tiemposRetorno[procesoActual] = tiemposFinalizacion[procesoActual] - this.info_tllegada[procesoActual];
                tiemposEspera[procesoActual] = tiemposRetorno[procesoActual] - this.info_tejecucion[procesoActual];
                tiemposRespuesta[procesoActual] = tiemposEspera[procesoActual] + tiemposInicio[procesoActual];
                procesosCompletados[procesoActual] = true;
                procesosCompletadosCount++;
            } else {
                // Si el proceso no ha finalizado, se vuelve a agregar a la cola de procesos
                colaProcesos.add(procesoActual);
            }

            // Actualizar las this.info_prioridad de los procesos que llegan mientras se ejecuta el proceso actual
            for (int i = 0; i < n; i++) {
                if (!procesosCompletados[i] && this.info_tllegada[i] <= tiempoTotal && i != procesoActual && prioridad_Copia[i] < prioridad_Copia[procesoActual]) {
                    prioridad_Copia[i]++;
                }
            }
        }

        // Calcular los tiempos promedio
        double tiempoEsperaPromedio = calculateAverage(tiemposEspera);
        double tiempoRespuestaPromedio = calculateAverage(tiemposRespuesta);

        // Mostrar los resultados
        System.out.println("Proceso\t\tLlegada\t\tRáfaga\t\tPrioridad\tEspera\t\tRetorno\t\tFinalización\tRespuesta");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", i + 1, this.info_tllegada[i], this.info_tejecucion[i],
                    this.info_prioridad[i], tiemposEspera[i], tiemposRetorno[i], tiemposFinalizacion[i], tiemposRespuesta[i]);
        }

        System.out.println("\nDiagrama de Gantt:");
        for (int i = 0; i < n; i++) {
            System.out.print("| P" + (i + 1) + " ");
        }
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            System.out.print(tiemposInicio[i] + "\t");
        }
        System.out.println(tiemposFinalizacion[n - 1]);

        System.out.println("\nTiempo promedio de espera: " + tiempoEsperaPromedio);
        System.out.println("Tiempo promedio de respuesta: " + tiempoRespuestaPromedio);
    }
    /*7.	Planificación PorPrioridades Sin Desalojo*/
    public void algoritmo_PlanificacionPorPrioridades_sindesalojo() {
        int n = this.info_tllegada.length;
        int[] tiemposEspera = new int[n];
        int[] tiemposRetorno = new int[n];
        int[] tiemposFinalizacion = new int[n];
        int[] tiemposInicio = new int[n];
        int[] tiemposRespuesta = new int[n];

        boolean[] procesosCompletados = new boolean[n];
        int tiempoTotal = 0;
        int procesosCompletadosCount = 0;

        while (procesosCompletadosCount < n) {
            int procesoActual = -1;
            int maxPrioridad = Integer.MIN_VALUE;

            // Encontrar el proceso de mayor prioridad no completado
            for (int i = 0; i < n; i++) {
                if (!procesosCompletados[i] && this.info_prioridad[i] > maxPrioridad) {
                    maxPrioridad = this.info_prioridad[i];
                    procesoActual = i;
                }
            }

            // Actualizar el tiempo de inicio si es el primer proceso en ejecutarse
            if (tiemposInicio[procesoActual] == 0) {
                tiemposInicio[procesoActual] = tiempoTotal;
            }

            try {
                Thread.sleep(this.info_tejecucion[procesoActual]); // Simulación de la ejecución del proceso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tiempoTotal += this.info_tejecucion[procesoActual];

            // Asignar los tiempos de finalización, retorno y respuesta
            tiemposFinalizacion[procesoActual] = tiempoTotal;
            tiemposRetorno[procesoActual] = tiemposFinalizacion[procesoActual] - this.info_tllegada[procesoActual];
            tiemposEspera[procesoActual] = tiemposRetorno[procesoActual] - this.info_tejecucion[procesoActual];
            tiemposRespuesta[procesoActual] = tiemposEspera[procesoActual] + tiemposInicio[procesoActual];

            procesosCompletados[procesoActual] = true;
            procesosCompletadosCount++;

            // Mostrar el estado actual de la planificación
            System.out.println("Estado actual:");
            for (int i = 0; i < n; i++) {
                System.out.printf("Proceso %d - Estado: %s\n", i + 1, procesosCompletados[i] ? "Completado" : "Pendiente");
            }
            System.out.println("----------------------");
        }

        // Calcular los tiempos promedio
        double tiempoEsperaPromedio = calculateAverage(tiemposEspera);
        double tiempoRespuestaPromedio = calculateAverage(tiemposRespuesta);

        // Mostrar los resultados
        System.out.println("\nResultados:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Proceso %d - Tiempo de llegada: %d, Tiempo de ráfaga: %d, Tiempo de espera: %d, Tiempo de retorno: %d, Tiempo de finalización: %d, Tiempo de inicio: %d, Tiempo de respuesta: %d\n",
                    i + 1, this.info_tllegada[i], this.info_tejecucion[i], tiemposEspera[i], tiemposRetorno[i], tiemposFinalizacion[i], tiemposInicio[i], tiemposRespuesta[i]);
        }

        System.out.println("\nDiagrama de Gantt:");
        for (int i = 0; i < n; i++) {
            System.out.print("| Proceso " + (i + 1) + " ");
        }
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            System.out.print(tiemposInicio[i] + "\t");
        }
        System.out.println(tiemposFinalizacion[n - 1]);

        System.out.println("\nTiempo promedio de espera: " + tiempoEsperaPromedio);
        System.out.println("Tiempo promedio de respuesta: " + tiempoRespuestaPromedio);
    }
    /*8.	Planificación PorPrioridades Con Desalojo*/
    public void algoritmo_PlanificacionPrioridades_Desalojo() {
        int n = this.info_tllegada.length;
        int[] tiemposEspera = new int[n];
        int[] tiemposRetorno = new int[n];
        int[] tiemposFinalizacion = new int[n];
        int[] tiemposInicio = new int[n];
        int[] tiemposRespuesta = new int[n];

        boolean[] procesosCompletados = new boolean[n];
        int tiempoTotal = 0;
        int procesosCompletadosCount = 0;

        while (procesosCompletadosCount < n) {
            int procesoActual = -1;
            int mayorPrioridad = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                if (!procesosCompletados[i] && this.info_prioridad[i] > mayorPrioridad && this.info_tllegada[i] <= tiempoTotal) {
                    procesoActual = i;
                    mayorPrioridad = this.info_prioridad[i];
                }
            }

            if (procesoActual == -1) {
                tiempoTotal++;
                continue;
            }

            // Actualizar el tiempo de inicio si es el primer proceso en ejecutarse
            if (tiemposInicio[procesoActual] == 0) {
                tiemposInicio[procesoActual] = tiempoTotal;
            }

            try {
                Thread.sleep(1); // Simulación de la ejecución del proceso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.info_tejecucion[procesoActual]--;
            tiempoTotal++;

            if (this.info_tejecucion[procesoActual] == 0) {
                procesosCompletados[procesoActual] = true;
                procesosCompletadosCount++;

                // Asignar los tiempos de finalización, retorno y respuesta
                tiemposFinalizacion[procesoActual] = tiempoTotal;
                tiemposRetorno[procesoActual] = tiemposFinalizacion[procesoActual] - this.info_tllegada[procesoActual];
                tiemposEspera[procesoActual] = tiemposRetorno[procesoActual] - this.info_tejecucion[procesoActual];
                tiemposRespuesta[procesoActual] = tiemposEspera[procesoActual] + tiemposInicio[procesoActual];
            }

            // Mostrar el estado actual de la planificación
            System.out.println("Estado actual:");
            for (int i = 0; i < n; i++) {
                System.out.printf("Proceso %d - Estado: %s\n", i + 1, procesosCompletados[i] ? "Completado" : "Pendiente");
            }
            System.out.println("----------------------");
        }

        // Calcular los tiempos promedio de espera y respuesta
        double tiempoEsperaPromedio = calculateAverage(tiemposEspera);
        double tiempoRespuestaPromedio = calculateAverage(tiemposRespuesta);

        // Mostrar los resultados
        System.out.println("\nResultados:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Proceso %d:\n", i + 1);
            System.out.printf("Tiempo de llegada: %d\n", this.info_tllegada[i]);
            System.out.printf("Tiempo de ráfaga: %d\n", this.info_tejecucion[i]);
            System.out.printf("Tiempo de espera: %d\n", tiemposEspera[i]);
            System.out.printf("Tiempo de retorno: %d\n", tiemposRetorno[i]);
            System.out.printf("Tiempo de finalización: %d\n", tiemposFinalizacion[i]);
            System.out.printf("Tiempo de respuesta: %d\n", tiemposRespuesta[i]);
            System.out.println("----------------------");
        }

        System.out.println("\nDiagrama de Gantt:");
        for (int i = 0; i < n; i++) {
            System.out.print("| Proceso " + (i + 1) + " ");
        }
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            System.out.print(tiemposInicio[i] + "\t");
        }
        System.out.println(tiemposFinalizacion[n - 1]);

        System.out.println("\nTiempo promedio de espera: " + tiempoEsperaPromedio);
        System.out.println("Tiempo promedio de respuesta: " + tiempoRespuestaPromedio);
    }
    /*9.	Planificación por turnos*/
    public void algoritmo_PlanificacionTurnos(){
        int n = this.info_tllegada.length;
        int[] tiemposEspera = new int[n];
        int[] tiemposRetorno = new int[n];
        int[] tiemposFinalizacion = new int[n];
        int[] tiemposInicio = new int[n];
        int[] tiemposRespuesta = new int[n];

        boolean[] procesosCompletados = new boolean[n];
        int tiempoTotal = 0;
        int procesosCompletadosCount = 0;

        while (procesosCompletadosCount < n) {
            for (int i = 0; i < n; i++) {
                if (!procesosCompletados[i] && this.info_tllegada[i] <= tiempoTotal) {
                    // Actualizar el tiempo de inicio si es el primer turno del proceso
                    if (tiemposInicio[i] == 0) {
                        tiemposInicio[i] = tiempoTotal;
                    }

                    int tiempoEjecucion = Math.min(this.info_tejecucion[i], this.info_quantum);

                    try {
                        Thread.sleep(1); // Simulación de la ejecución del proceso
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    this.info_tejecucion[i] -= tiempoEjecucion;
                    tiempoTotal += tiempoEjecucion;

                    if (this.info_tejecucion[i] == 0) {
                        procesosCompletados[i] = true;
                        procesosCompletadosCount++;

                        // Asignar los tiempos de finalización, retorno y respuesta
                        tiemposFinalizacion[i] = tiempoTotal;
                        tiemposRetorno[i] = tiemposFinalizacion[i] - this.info_tllegada[i];
                        tiemposEspera[i] = tiemposRetorno[i] - this.info_tejecucion[i];
                        tiemposRespuesta[i] = tiemposEspera[i] + tiemposInicio[i];
                    }
                }
            }
        }

        // Calcular los tiempos promedio de espera y respuesta
        double tiempoEsperaPromedio = calculateAverage(tiemposEspera);
        double tiempoRespuestaPromedio = calculateAverage(tiemposRespuesta);

        // Mostrar los resultados
        System.out.println("\nResultados:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Proceso %d:\n", i + 1);
            System.out.printf("Tiempo de llegada: %d\n", this.info_tllegada[i]);
            System.out.printf("Tiempo de ráfaga: %d\n", this.info_tejecucion[i]);
            System.out.printf("Tiempo de espera: %d\n", tiemposEspera[i]);
            System.out.printf("Tiempo de retorno: %d\n", tiemposRetorno[i]);
            System.out.printf("Tiempo de finalización: %d\n", tiemposFinalizacion[i]);
            System.out.printf("Tiempo de respuesta: %d\n", tiemposRespuesta[i]);
            System.out.println("----------------------");
        }

        System.out.println("\nDiagrama de Gantt:");
        for (int i = 0; i < n; i++) {
            System.out.print("| Proceso " + (i + 1) + " ");
        }
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            System.out.print(tiemposInicio[i] + "\t");
        }
        System.out.println(tiemposFinalizacion[n - 1]);

        System.out.println("\nTiempo promedio de espera: " + tiempoEsperaPromedio);
        System.out.println("Tiempo promedio de respuesta: " + tiempoRespuestaPromedio);
    }
    public void PlanificacionPorTurnos() {
        int n = this.info_tllegada.length;
        int[] tiemposEspera = new int[n];
        int[] tiemposRetorno = new int[n];
        int[] tiemposFinalizacion = new int[n];
        int[] tiemposInicio = new int[n];
        int[] tiemposRespuesta = new int[n];

        int tiempoTotal = 0;
        int procesosCompletadosCount = 0;

        Queue<Integer> colaProcesos = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            colaProcesos.add(i);
        }

        while (!colaProcesos.isEmpty()) {
            int procesoActual = colaProcesos.poll();

            // Actualizar el tiempo de inicio si es el primer proceso en ejecutarse
            if (tiemposInicio[procesoActual] == 0) {
                tiemposInicio[procesoActual] = tiempoTotal;
            }

            int tiempoEjecucion = Math.min( this.info_quantum, this.info_tejecucion[procesoActual]);

            try {
                Thread.sleep(1); // Simulación de la ejecución del proceso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.info_tejecucion[procesoActual] -= tiempoEjecucion;
            tiempoTotal += tiempoEjecucion;

            if (this.info_tejecucion[procesoActual] > 0) {
                colaProcesos.add(procesoActual);
            } else {
                procesosCompletadosCount++;

                // Asignar los tiempos de finalización, retorno y respuesta
                tiemposFinalizacion[procesoActual] = tiempoTotal;
                tiemposRetorno[procesoActual] = tiemposFinalizacion[procesoActual] - this.info_tllegada[procesoActual];
                tiemposEspera[procesoActual] = tiemposRetorno[procesoActual] - this.info_tejecucion[procesoActual];
                tiemposRespuesta[procesoActual] = tiemposEspera[procesoActual] + tiemposInicio[procesoActual];
            }

            // Mostrar el estado actual de la planificación
            System.out.println("Estado actual:");
            for (int i = 0; i < n; i++) {
                if (i == procesoActual) {
                    System.out.printf("Proceso %d - Estado: Ejecutando\n", i + 1);
                } else if (colaProcesos.contains(i)) {
                    System.out.printf("Proceso %d - Estado: Pendiente\n", i + 1);
                } else {
                    System.out.printf("Proceso %d - Estado: Completado\n", i + 1);
                }
            }
            System.out.println("----------------------");
        }

        // Calcular los tiempos promedio de espera y respuesta
        double tiempoEsperaPromedio = calculateAverage(tiemposEspera);
        double tiempoRespuestaPromedio = calculateAverage(tiemposRespuesta);

        // Mostrar los resultados
        System.out.println("\nResultados:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Proceso %d:\n", i + 1);
            System.out.printf("Tiempo de llegada: %d\n", this.info_tllegada[i]);
            System.out.printf("Tiempo de ráfaga: %d\n", this.info_tejecucion[i]);
            System.out.printf("Tiempo de espera: %d\n", tiemposEspera[i]);
            System.out.printf("Tiempo de retorno: %d\n", tiemposRetorno[i]);
            System.out.printf("Tiempo de finalización: %d\n", tiemposFinalizacion[i]);
            System.out.printf("Tiempo de respuesta: %d\n", tiemposRespuesta[i]);
            System.out.println("----------------------");
        }

        System.out.println("\nDiagrama de Gantt:");
        for (int i = 0; i < n; i++) {
            System.out.print("| Proceso " + (i + 1) + " ");
        }
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            System.out.print(tiemposInicio[i] + "\t");
        }
        System.out.println(tiemposFinalizacion[n - 1]);

        System.out.println("\nTiempo promedio de espera: " + tiempoEsperaPromedio);
        System.out.println("Tiempo promedio de respuesta: " + tiempoRespuestaPromedio);
    }
    /*10.   */
    

  
    
}
