/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.fotografia.ejb;

import co.edu.uniandes.csw.fotografia.entities.FotografoEntity;
import co.edu.uniandes.csw.fotografia.persistence.FotografoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.acostav
 */

@Stateless
public class FotografoLogic {
    
     private static final Logger LOGGER = Logger.getLogger(FotografoLogic.class.getName());

    @Inject
    private FotografoPersistence persistence;
    
    public FotografoEntity createFotografo(FotografoEntity fotografo){
        LOGGER.log(Level.INFO, "Inicia proceso de creación del fotografo");
        FotografoEntity newFotografoEntity = persistence.create(fotografo);
        LOGGER.log(Level.INFO, "Termina proceso de creación del fotografo");
        return newFotografoEntity;
    }
    
    public FotografoEntity getFotografo(long pId){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el fotografo con id = {0}", pId);
        FotografoEntity fotografoEntity = persistence.find(pId);
        if (fotografoEntity == null) {
            LOGGER.log(Level.SEVERE, "El fotografo con el id = {0} no existe", pId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el fotografo con id = {0}", pId);
        return fotografoEntity;
    }
    
    public List<FotografoEntity> getFotografos(){
       LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los fotografos");
        List<FotografoEntity> lista = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los fotografos");
        return lista;
    }
    
     public FotografoEntity updateFotografo(Long fotografoId, FotografoEntity entity){
       LOGGER.log(Level.INFO, "Inicia proceso de actualizar el fotografo con id = {0}", fotografoId);
        FotografoEntity newFotografoEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el fotografo con id = {0}", fotografoId);
        return newFotografoEntity;
     }
     
     public void deleteFotografo(Long fotografoId){
     }
     
}
