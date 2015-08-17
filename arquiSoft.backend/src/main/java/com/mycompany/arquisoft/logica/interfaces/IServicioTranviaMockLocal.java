/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Tranvia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ja.silva11
 */
@Local
public interface IServicioTranviaMockLocal 
{
            /**
	     * Agrega un Tranvia
	     * @param tranvia Nuevo Tranvia
	     */
	    public void agregarTranvia(Tranvia tranvia);
	
	    /**
	     * Elimina un Tranvia
	     * @param id Identificador único del Tranvia a eliminar
	     */
	    public void eliminarTranvia(long id);
            
            /**
	     * Actualiza un Tranvia 
	     * @param tranvia Nuevo Tranvia
	     */
	    public void actualizarTranvia(Tranvia tranvia);
	
	    /**
	     * Devuelve todos los Tranvias del sistema
	     * @return Tranvias Lista de Tranvias
	     */
	    public List<Tranvia> darTranvias();
            
            /**
             * Genera una emergencia en el tranvia
             * @param id Tranvia en cuestion
             */
            public void emergenciaTranvia(long id);
            /**
             * Reporta un choque del tranvia
             * @param id Tranvia en cuestion
             */
            public void choqueTranvia(long id);

}
