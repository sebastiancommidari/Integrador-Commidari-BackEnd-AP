package com.porfolio.commidari.controller;

import com.porfolio.commidari.entity.Persona;
import com.porfolio.commidari.interfaz.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gladys
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/listar")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
     @GetMapping("/personas/listar/usuario")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    
    @PostMapping("/personas/nuevo")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "Se ha creado un nuevo usuario";
    }
    
    @DeleteMapping("/personas/eliminar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "Usuario eliminado";
    }
    
    @PutMapping("/personas/modificar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevaImg){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
}
