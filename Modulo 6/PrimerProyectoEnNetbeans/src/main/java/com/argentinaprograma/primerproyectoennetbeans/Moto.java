package com.argentinaprograma.primerproyectoennetbeans;

/**
 * @author noelia
 * creación de la clase Moto, hereda de Vehiculo, 
 * declaración y encapsulamiento del atributo propio de la clase Moto, 
 */

public class Moto extends Vehiculo {
    
    private int cilindrada;
    
    /**
 * constructor vacío y constructor con parámetros
 */

    public Moto() {
    }

    public Moto(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Moto(int cilindrada, int num_registro, int cant_ruedas, String marca, String modelo) {
        super(num_registro, cant_ruedas, marca, modelo);
        this.cilindrada = cilindrada;
    }
    
/**
 * métodos get y set que permiten acceder a los atributos de la clase 
 */

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}


