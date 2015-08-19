/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Conductor;
import com.mycompany.arquisoft.dto.Mobibus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dc.bonilla10
 */
@Local
public interface IServicioConductorMockLocal 
{
        /**
         * Agrega un Conductor al sistema
         * @param cond Nuevo Mobibus
         */
        public void agregarConductor(Conductor cond);

        /**
         * Elimina un Conductor del sistema
         * @param cc Cedula única del conductor a eliminar
         */
        public void eliminarConductor(long cc);

        /**
         * Devuelve todos los conductores del sistema
         * @return Conductor Lista de Conductores
         */
        public List<Conductor> darConductor();
}

