package com.argentinaprograma.primerproyectoennetbeans;

import static java.time.Clock.system;
import static java.time.InstantSource.system;

/**
 * @author noelia
 * creación de la clase Auto que hereda de Vehiculo, 
 * declaración y encapsulamiento de los atrubutos 
 */
public class Auto extends Vehiculo {
    private int id;
    private String patente; 
    private int cant_puertas;
    private String color;
    private boolean caja_manual;
    
    /**
 * constructor vacío y constructor con parámetros
 */

    public Auto() {
    }

    public Auto(int id, String patente, 
            int cant_puertas, 
            String color, boolean caja_manual, int num_registro, int cant_ruedas, String marca, String modelo) {
        super(num_registro, cant_ruedas, marca, modelo);
        this.id = id;
        this.patente = patente;
        this.cant_puertas = cant_puertas;
        this.color = color;
        this.caja_manual = caja_manual;
    }

/**
 * métodos get y set que permiten acceder a los atributos de la clase Auto
 */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCant_puertas() {
        return cant_puertas;
    }

    public void setCant_puertas(int cant_puertas) {
        this.cant_puertas = cant_puertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCaja_manual() {
        return caja_manual;
    }

    public void setCaja_manual(boolean caja_manual) {
        this.caja_manual = caja_manual;
    }
    
    /**
 * método toString cadena de texto de todos los atributos creados con su correspondiente valor 
 */

    @Override
    public String toString() {
        return "Auto{" + "id=" + id + ", patente=" + patente + ", cant_puertas=" + cant_puertas + ", color=" + color + ", caja_manual=" + caja_manual + '}';
    }
    
    /**
 * métodos de la clase
 */
             
    public void encender() {
        System.out.println("Estoy encendiendo");
    }
    
    public void apagar() {
        System.out.println("Estoy apagando");
    }
    
    public void acelerar (double km) {
        System.out.println("Estoy acelerando " + km + "kms");
    }
      
    public void frenar (double km) {
        System.out.println("Estoy frenando " + km + "kms");
    }
}
        