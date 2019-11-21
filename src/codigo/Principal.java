package codigo;

import dao.RAMPersonaDAO;
import java.util.List;
import modelo.Persona;
import modelo.Tipo;

public class Principal {

    public static void main(String[] args) {

        RAMPersonaDAO misDatos = new RAMPersonaDAO();

        //Mostramos la lista de personas
        System.out.println("Datos iniciales");
        muestraPersonas(misDatos.getAllPersona());
        System.out.println("");

        //añadimos una persona a la lista
        
        Persona nueva = new Persona("55555555B", "Laura Retuerto", 55, Tipo.EMPLEADO);

        misDatos.addPersona(nueva);
        System.out.println("Despues de añadir a Laura");
        muestraPersonas(misDatos.getAllPersona());
        System.out.println("");
        
        
        
        System.out.println("Muestro datos de juano");

        Persona otra = new Persona("66666666K", "Juano Melano", 88, Tipo.PROVEEDOR);
        misDatos.addPersona(otra);
        System.out.println(misDatos.getPersonaByNIF("66666666K"));

        //Borrar una persona
        System.out.println("Antes de eliminar a nif: 11111111X");
        misDatos.removePersona(misDatos.getPersonaByNIF("11111111X"));
        muestraPersonas(misDatos.getAllPersona());
        System.out.println("");
        
        //Actualizamos una persona
        
        
        System.out.println("Antes de actualizar a nif: 22222222H");
        Persona recuperada = misDatos.getPersonaByNIF("22222222H");
        recuperada.setNombre("Pepa Rey");
        misDatos.updatePersona(recuperada);
        
        muestraPersonas(misDatos.getAllPersona());
        System.out.println("");

    }

    private static void muestraPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            System.out.println(p);
        }
    }

}
