/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Ubicacion;
import com.mycompany.arquisoft.dto.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author df.sabogal10
 */
@Local
public interface IServicioVehiculoMockLocal 
{
        /**
         * Agrega un Vehiculo al sistema
         * @param cehiculo Nuevo Vehiculo
         */
        public void agregarVehiculo(Vehiculo vehiculo);

        /**
         * Elimina un Vehiculo del sistema
         * @param id Identificador único del Vehiculo a eliminar
         */
        public void eliminarVehiculo(int id);

            /**
         * Actualiza un Vehiculo al sistema
         * @param vehiculo Nuevo Vehiculo
         */
        public void actualizarVehiculo(Vehiculo vehiculo);

        /**
         * Devuelve todos los Vehiculos del sistema
         * @return vehiculos Lista de Vehiculos
         */
        public List<Vehiculo> darVehiculos();
        /**
         * Devuelve un vehiculo dado el id
         * @param id id del vehiculo a devolver
         * @return  v Vehiculo a devolver
         */
         public Vehiculo darVehiculo(int id);
}
