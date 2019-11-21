package dao;

import java.util.List;
import modelo.Persona;

public interface PersonaDAO {

    
    //Operaciones CRUD de Persona
    List <Persona> getAllPersona();
    Persona getPersonaByNIF(String NIF);
    boolean addPersona(Persona p);
    boolean removePersona(Persona p);
    boolean updatePersona (Persona p);
    
}
