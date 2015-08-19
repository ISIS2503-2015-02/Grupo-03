/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.Reporte;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioReporteMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioReporteMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author df.sabogal10
 */
@Stateless
public class ServicioReporteMock implements IServicioReporteMockLocal
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaMockLocal persistencia;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioReporteMock() throws OperacionInvalidaException
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de las reportes
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    @Override
    public void agregarReporte(Reporte reporte) {
        try
        {
            persistencia.create(reporte);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioReporteMock.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }    

    @Override
    public void eliminarReporte(int id) 
    {
        Reporte e=(Reporte) persistencia.findById(Reporte.class, id);
        try
        {
            persistencia.delete(e);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioReporteMock.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

    @Override
    public void actualizarReporte(Reporte reporte) {
        persistencia.update(reporte);    
    }

    @Override
    public List<Reporte> darReportes() {
        return persistencia.findAll(Reporte.class);
    }

    @Override
    public Reporte darReporte(int id) {
        return (Reporte) persistencia.findById(Reporte.class, id);
    }
}