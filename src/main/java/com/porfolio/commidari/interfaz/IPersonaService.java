package com.porfolio.commidari.interfaz;

import com.porfolio.commidari.entity.Persona;
import java.util.List;

/**
 *
 * @author Gladys
 */

public interface IPersonaService {
    
    //Traer lista de personas
    public List<Persona> getPersona();
    
    //Guardar persona objeto
    public void savePersona(Persona persona);
    
    //Elimanar persona por ID
    public void deletePersona(Long id);
    
    //Buscar persona por ID
    public Persona findPersona(Long id);
}
