package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Persona;
import modelo.Tipo;

public class RAMPersonaDAO implements PersonaDAO {

    private ArrayList<Persona> personas;

    public RAMPersonaDAO() {

        personas = new ArrayList<>();
        personas.add(new Persona("11111111X", "Eva Rey", 69, Tipo.CLIENTE));
        personas.add(new Persona("22222222H", "Rosa Meltroso", 31, Tipo.EMPLEADO));
        personas.add(new Persona("33333333F", "Ricardo Nardo", 24, Tipo.PROVEEDOR));
        personas.add(new Persona("44444444R", "Luis Pitis", 44, Tipo.CLIENTE));
    }

    @Override
    public List<Persona> getAllPersona() {
        return personas;
    }

    @Override
    public Persona getPersonaByNIF(String NIF) {
        for (Persona p : personas) {
            if (p.getNIF().equals(NIF)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean addPersona(Persona p) {
        if (personas.contains(p)) {
            return false;
        } else {
            personas.add(p);
            return true;
        }
    }

    @Override
    public boolean removePersona(Persona p) {
        return personas.remove(p);
    }

    @Override
    public boolean updatePersona(Persona p) {
        int indice;
        if ((indice = personas.indexOf(p)) == -1) {
            return false;
        } else {
            personas.set(indice, p);
            return true;
        }
    }

}
