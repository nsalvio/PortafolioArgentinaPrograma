package com.argentinaprograma.primerproyectoennetbeans;

/**
 * @author noelia
 * creación de la clase Camión que hereda de Vehiculo, 
 * declaración, inicialización y encapsulamiento de los atrubutos de la clase
 */

public class Camion extends Vehiculo {
  
    private int cant_ejes;
    private boolean acoplado;
    
    /**
 * constructor vacío y constructor con parámetros
 */
    
    public Camion() {
    }

    public Camion(int cant_ejes, boolean acoplado, int num_registro, int cant_ruedas, String marca, String modelo) {
        super(num_registro, cant_ruedas, marca, modelo);
        this.cant_ejes = cant_ejes;
        this.acoplado = acoplado;
    }
 
/**
 * métodos get y set que permiten acceder a los atributos de la clase Camion
 */   
    
    public int getCant_ejes() {
        return cant_ejes;
    }

    public void setCant_ejes(int cant_ejes) {
        this.cant_ejes = cant_ejes;
    }

    public boolean isAcoplado() {
        return acoplado;
    }

    public void setAcoplado(boolean acoplado) {
        this.acoplado = acoplado;
    }
             
}
