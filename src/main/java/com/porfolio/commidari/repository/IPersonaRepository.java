package com.porfolio.commidari.repository;

import com.porfolio.commidari.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gladys
 */
@Repository 
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
    
    
}
