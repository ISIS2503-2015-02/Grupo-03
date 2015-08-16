/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Vcub;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ja.silva11
 */
@Local
public interface IServicioVcubMockLocal 
{
    /**
	     * Agrega un Vcub al sistema
	     * @param vcub Nuevo Vcub
	     */
	    public void agregarVcub(Vcub vcub);
	
	    /**
	     * Elimina un Vcub del sistema
	     * @param id Identificador único del Vcub a eliminar
	     */
	    public void eliminarVcub(long id);
	
	    /**
	     * Devuelve todos los Vcubs del sistema
	     * @return Vcubs Lista de Vcubs
	     */
	    public List<Vcub> darVcubs();
}
