/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Ubicacion;
import com.mycompany.arquisoft.dto.Reporte;
import com.mycompany.arquisoft.dto.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author df.sabogal10
 */
@Local
public interface IServicioReporteMockLocal 
{
        /**
         * Agrega una reporte al sistema
         * @param reporte Nuevo reporte
         */
        public void agregarReporte(Reporte reporte);

        /**
         * Elimina una reporte del sistema
         * @param id Identificador único del reporte a eliminar
         */
        public void eliminarReporte(int id);

            /**
         * Actualiza un reporte al sistema
         * @param reporte Nuevo reporte
         */
        public void actualizarReporte(Reporte reporte);

        /**
         * Devuelve todos los reportes del sistema
         * @return reportes Lista de reportes
         */
        public List<Reporte> darReportes();
        /**
         * Devuelve un reporte dado el id
         * @param id id del reporte a devolver
         * @return  e Reporte a devolver
         */
         public Reporte darReporte(int id);
}
