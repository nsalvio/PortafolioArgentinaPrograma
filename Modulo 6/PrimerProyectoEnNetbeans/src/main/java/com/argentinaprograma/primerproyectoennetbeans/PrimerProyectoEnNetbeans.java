package com.argentinaprograma.primerproyectoennetbeans;

/**
 * @author noelia
 * creación de la clase PrimerProyectoEnNetbeans, 
 */

public class PrimerProyectoEnNetbeans {

    public static void main(String[] args) {
        Vehiculo vehi = new Vehiculo (567892, 4, "Renault", "Indefinido");
        Auto auto2 = new Auto (1, "AA111JO", 5, "rojo", true, 65432, 4, "Volkswagen", "Gold Trend");
        Moto moto1 = new Moto (125, 456733, 2, "Yamaha", "ZR 125");
        Camion cami = new Camion (6, true, 698743, 10, "Mercedes", "Un modelo");
        
        /**
 * creación de un vector, asignación de valores 
 */
        
        Vehiculo vector [] = new Vehiculo [4];
         vector[0] = vehi;
         vector[1] = auto2;
         vector[2] = moto1;
         vector[3] = cami;
         
/**
 * recorrer el vector con el método for
 */
         
         for (int i=0; i<4; i++){
             System.out.println("Registro Num " + i + " " + vector[i].getMarca());
         }
                
       /*
        System.out.println(auto2.toString());
        System.out.println(auto1.toString());
         */

        /*
                auto1.setId(1500);
                auto1.setPatente("ABC5567AB");
                auto1.setCant_puertas(3);
                auto1.setColor("amarillo");
                auto1.setCant_puertas(3);
                
                System.out.println("------------");
                System.out.println("La nueva id del auto es: " + auto1.getId());
                System.out.println("El nuevo color del auto es: " + auto1.getColor());
                
               /* auto2.encender();
                auto2.acelerar(60);
                auto2.frenar(30);
                auto2.apagar(); */
               
                /*         
                System.out.println("El valor de la id es: " + auto2.getId());
                auto2.setId(35000);
                System.out.println("El nuevo valor de la id es: " + auto2.getId());
*/

        
    }

    public PrimerProyectoEnNetbeans() {
    }
}



        
        
        
