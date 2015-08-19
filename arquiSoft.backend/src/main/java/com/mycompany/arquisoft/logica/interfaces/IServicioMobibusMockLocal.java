/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Mobibus;
import com.mycompany.arquisoft.dto.Vcub;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dc.bonilla10
 */
@Local
public interface IServicioMobibusMockLocal 
{
        /**
         * Agrega un Mobibus al sistema
         * @param mobibus Nuevo Mobibus
         */
        public void agregarMobibus(Mobibus mobibus);

        /**
         * Elimina un Mobibusdel sistema
         * @param id Identificador único del Mobibus a eliminar
         */
        public void eliminarMobibus(long id);

            /**
         * Actualiza un Mobibus del sistema
         * @param mobibus Nuevo Mobibus
         */
        public void actualizarMobibus(Mobibus mobibus);

        /**
         * Devuelve todos los Mobibus del sistema
         * @return Mobibus Lista de Mobibus
         */
        public List<Mobibus> darMobibus();
}
