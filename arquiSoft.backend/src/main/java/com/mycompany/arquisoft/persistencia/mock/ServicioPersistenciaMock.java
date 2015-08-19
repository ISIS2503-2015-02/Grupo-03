package com.mycompany.arquisoft.persistencia.mock;


import com.mycompany.arquisoft.dto.Emergencia;
import com.mycompany.arquisoft.dto.EstacionVcub;
import com.mycompany.arquisoft.dto.Estacion;
import com.mycompany.arquisoft.dto.Reporte;
import com.mycompany.arquisoft.dto.Ubicacion;
import com.mycompany.arquisoft.dto.Usuario;

import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockRemote;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.dto.Tranvia;
import com.mycompany.arquisoft.dto.Vehiculo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ServicioPersistenciaMock implements IServicioPersistenciaMockRemote, IServicioPersistenciaMockLocal {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Lista con los vcubs del sistema
     */
    private static ArrayList<Vcub> vcubs;
    
    /**
     * Lista con los vehiculos desl sistema
     */
    private static ArrayList<Vehiculo> vehiculos;
    
    /**
     * Lista tranvias del sistema
     */
    private static ArrayList<Tranvia> tranvias;
     /**
      * Lista con las ubicaciones del sistema
     */
    private static ArrayList<Ubicacion> ubicaciones;
    /**
     * Lista de usuarios del sistema
     */
    private static ArrayList<Usuario> usuarios;
    
    /**
     * Lista de emergencias del sistema
     */
    private static ArrayList<Emergencia> emergencias;
    
    /**
     * Lista de estaciones de Vcub del sistema
     */
    private static ArrayList<EstacionVcub> estacionesVcub;
    /**     
    * Lista de estaciones del sistema
     */
    private static ArrayList<Estacion> estaciones;
    
    /**
     * 
     */
    private static ArrayList<Reporte> reportes;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public ServicioPersistenciaMock() throws OperacionInvalidaException
    {
        if (vcubs == null)
        {
            vcubs = new ArrayList();
            vcubs.add(new Vcub(1));
            vcubs.add(new Vcub(2));
            
            estacionesVcub = new ArrayList<EstacionVcub>();
            estacionesVcub.add(new EstacionVcub(50));
            estacionesVcub.add(new EstacionVcub(20));
            
            vehiculos = new ArrayList();
            vehiculos.add(new Vehiculo(1, new Ubicacion(64,26)));
                        
            tranvias = new ArrayList<Tranvia>();
            tranvias.add(new Tranvia(69 ,"A", "123123'222:12", 15));
            tranvias.add(new Tranvia(78 ,"A", "123123'222:12", 15));
            
            ubicaciones = new ArrayList<Ubicacion>();
            ubicaciones.add(new Ubicacion(0,0));
            ubicaciones.add(new Ubicacion(12.3,21.2));
            
            usuarios =new ArrayList<Usuario>();
            usuarios.add(new Usuario("Java", 78, "CE", 15));
            usuarios.add(new Usuario("Java", 123456, "CE", 3104444));
            
            emergencias = new ArrayList<Emergencia>();
            List<Vehiculo> vInvolucrados=new ArrayList<Vehiculo>();
            vInvolucrados.add(new Vehiculo(1, new Ubicacion(10,70)));
            emergencias.add(new Emergencia(1,"choque suave", vInvolucrados, Emergencia.LEVE, new Ubicacion(10,20), new Date("31/10/1996"), Emergencia.VEHICULOS_SIGUEN_FUNCIONANDO));
            
            estaciones = new ArrayList<Estacion>();
            List<Vcub> vcubs= new ArrayList<Vcub>();
            vcubs.add(new Vcub(1));
            vcubs.add(new Vcub(2));
            estaciones.add(new Estacion(1, 500, vcubs, new Ubicacion(24, 36)));
            
            reportes = new ArrayList<Reporte>();
            reportes.add(new Reporte(1, new Date("19/08/2015"), new Vehiculo(1,new Ubicacion(60,78))));
                   
        }
    }

    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
    
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     * @throws com.mycompany.arquisoft.excepciones.OperacionInvalidaException
     */
    @Override
    public void create(Object obj) throws OperacionInvalidaException
    {
        if (obj instanceof Vcub)
        {
            Vcub v = (Vcub) obj;
            v.setId(vcubs.size() + 1);
            vcubs.add(v);
        }
        else if (obj instanceof Tranvia)
        {
           Tranvia jesus = (Tranvia) obj;
           tranvias.add(jesus); 
           
        }
        else if(obj instanceof Vehiculo)
        {
            Vehiculo v = (Vehiculo) obj;
            vehiculos.add(v);
        }
        else if (obj instanceof Usuario)
        {
           Usuario jesus = (Usuario) obj;
           usuarios.add(jesus);    
        }
        else if (obj instanceof Emergencia)
        {
            Emergencia e = (Emergencia) obj;
            emergencias.add(e);
        }
        else if (obj instanceof Reporte)
        {
            Reporte e = (Reporte) obj;
            reportes.add(e);
        }

        else if (obj instanceof Estacion)
        {
            Estacion e=(Estacion) obj;
            estaciones.add(e);
        }
        else if (obj instanceof EstacionVcub)
        {
            EstacionVcub e=(EstacionVcub) obj;
            estacionesVcub.add(e);
        }
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
        
    @Override
    public void update(Object obj)
    {
        if (obj instanceof Vcub)
        {
            Vcub editar = (Vcub) obj;
            Vcub vcub;
            for (int i = 0; i < vcubs.size(); i++)
            {
                vcub = vcubs.get(i);
                if (vcub.getId() == editar.getId())
                {
                    vcubs.set(i, editar);
                    break;
                }
            }
        }
        else  if (obj instanceof Tranvia)
        {
            Tranvia cuestion = (Tranvia) obj;
            for (int i = 0; i < tranvias.size(); i++)
            {
               Tranvia tranvia = tranvias.get(i);
                if (tranvia.getId() == cuestion.getId())
                {
                    tranvias.remove(i);
                    tranvias.add(cuestion);                    
                    break;
                }
            }
        }
        else if (obj instanceof Vehiculo)
        {
            Vehiculo nuevo = (Vehiculo) obj;
            Vehiculo v;
            for (int i = 0; i < vehiculos.size(); i++) 
            {
               v= vehiculos.get(i);
               if(v.getId() == nuevo.getId())
               {
                   vehiculos.set(i, nuevo);
                   break;
               }
                    
            }
        }
        else  if (obj instanceof Usuario)
        {
            Usuario cuestion = (Usuario) obj;
            for (int i = 0; i < usuarios.size(); i++)
            {
               Usuario usr = usuarios.get(i);
                if (usr.getDocumento()== cuestion.getDocumento())
                {
                    usuarios.remove(i);
                    usuarios.add(cuestion);                    
                    break;
                }
            }
        }
        else if (obj instanceof Emergencia)
        {
            Emergencia nueva = (Emergencia) obj;
            Emergencia e;
            for (int i = 0; i < emergencias.size(); i++) 
            {
               e=emergencias.get(i);
               if(e.getId() == nueva.getId())
               {
                   emergencias.set(i, nueva);
                   break;
               }                   
            }
        }
        else if (obj instanceof Reporte)
        {
            Reporte nuevo = (Reporte) obj;
            Reporte e;
            for (int i = 0; i < reportes.size(); i++) 
            {
               e=reportes.get(i);
               if(e.getId() == nuevo.getId())
               {
                   reportes.set(i, nuevo);
                   break;
               }                   
            }
        }
        else if (obj instanceof Estacion)
        {
            Estacion nueva = (Estacion) obj;
            Estacion e;
            for (int i = 0; i < estaciones.size(); i++) 
            {
               e=estaciones.get(i);
               if(e.getId() == nueva.getId())
               {
                   estaciones.set(i, nueva);
                   break;
               }                   
            }
        }
        else{}
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     * @throws com.mycompany.arquisoft.excepciones.OperacionInvalidaException
     */
    @Override
    public void delete(Object obj) throws OperacionInvalidaException
    {
        if (obj instanceof Vcub)
        {
            Vcub vcubABorrar = (Vcub) obj;

            for (int e = 0; e < vcubs.size(); e++)
            {
                Vcub v = (Vcub) vcubs.get(e);
                if (v.getId() == vcubABorrar.getId())
                {
                    vcubs.remove(e);
                    break;
                }
            }
        } 
        else if (obj instanceof Tranvia)
        {
            Tranvia aBorrar = (Tranvia) obj;

            for (int e = 0; e < tranvias.size(); e++)
            {
                Tranvia jesus = (Tranvia) tranvias.get(e);
                if (jesus.getId() == aBorrar.getId())
                {
                    tranvias.remove(e);
                    break;
                }
            }
        } 
        else if(obj instanceof Vehiculo)
        {
            Vehiculo ae= (Vehiculo) obj;
            for (int i = 0; i <vehiculos.size(); i++) {
                Vehiculo v= (Vehiculo) vehiculos.get(i);
                if(v.getId() == ae.getId())
                {
                    vehiculos.remove(i);
                    break;
                }
                
            }
        }
        else if(obj instanceof Emergencia)
        {
            Emergencia ae= (Emergencia) obj;
            for (int i = 0; i < emergencias.size(); i++) {
                Emergencia e= (Emergencia) emergencias.get(i);
                if(e.getId() == ae.getId())
                {
                    emergencias.remove(i);
                    break;
                }
                
            }
        }  
         else if(obj instanceof Reporte)
        {
            Reporte ae= (Reporte) obj;
            for (int i = 0; i < reportes.size(); i++) {
                Reporte e= (Reporte) reportes.get(i);
                if(e.getId() == ae.getId())
                {
                    reportes.remove(i);
                    break;
                }
                
            }
        } 
        else if(obj instanceof Estacion)
        {
            Estacion ae= (Estacion) obj;
            for (int i = 0; i < estaciones.size(); i++) {
                Estacion e= (Estacion) estaciones.get(i);
                if(e.getId() == ae.getId())
                {
                    estaciones.remove(i);
                    break;
                }
                
            }
        }
        else{}
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    @Override
    public List findAll(Class c)
    {
        if (c.equals(Vcub.class))
        {
            return vcubs;
        } 
        else if (c.equals(Tranvia.class))
        {
            return tranvias;
        }
        else if(c.equals(Ubicacion.class))
        {
            return ubicaciones;
        }
        else if(c.equals(Vehiculo.class))
        {
            return vehiculos;
        }
         else if(c.equals(Usuario.class))
        {
            return usuarios;
        }
        else if(c.equals(Emergencia.class))
        {
            return emergencias; 
        }
        else if(c.equals(Reporte.class))
        {
            return reportes; 
        }

        else if(c.equals(Estacion.class))
        {
            return estaciones; 
        }
        else if(c.equals(EstacionVcub.class))
        {
            return estacionesVcub; 
        }
        else
        {
            return null;
        }
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id)
    {
        if (c.equals(Vcub.class))
        {
            for (Object v : findAll(c))
            {
                Vcub vcub = (Vcub) v;
                if (vcub.getId() == Integer.parseInt(id.toString()))
                {
                    return vcub;
                }
            }
        }
        else  if (c.equals(Tranvia.class))
        {
            for (Object v : findAll(c))
            {
                Tranvia tranvia = (Tranvia) v;
                if (tranvia.getId() == Long.parseLong(id.toString()))
                {
                    return tranvia;
                }
            }
        }
        else if (c.equals(Vehiculo.class))
        {
            for(Object v : findAll(c))
            {
                Vehiculo ve =(Vehiculo) v;
                if(ve.getId()== Integer.parseInt(id.toString()))
                {
                    return ve;
                }
            }
        }
         else if (c.equals(Emergencia.class))
        {
            for(Object e : findAll(c))
            {
                Emergencia ve =(Emergencia) e;
                if(ve.getId()== Integer.parseInt(id.toString()))
                {
                    return ve;
                }
            }
        }
         else if (c.equals(Reporte.class))
        {
            for(Object e : findAll(c))
            {
                Reporte ve =(Reporte) e;
                if(ve.getId()== Integer.parseInt(id.toString()))
                {
                    return ve;
                }
            }
        }

          else if (c.equals(Estacion.class))
        {
            for(Object e : findAll(c))
            {
                Estacion ve =(Estacion) e;
                if(ve.getId()== Integer.parseInt(id.toString()))
                {
                    return ve;
                }
            }
        }
         else  if (c.equals(Usuario.class))
        {
            for (Object v : findAll(c))
            {
                Usuario usr = (Usuario) v;
                if (usr.getDocumento()== Long.parseLong(id.toString()))
                {
                    return usr;
                }
            }
        }
        return null;
    }
    
    @Override
    public Vcub agregarVcubEstacion(long idEstacion,long idVcub)
    {
        EstacionVcub ev = (EstacionVcub)findById(EstacionVcub.class,idEstacion);
        ev.agregarVcub(idVcub);
        Vcub vb = (Vcub) findById(Vcub.class, idVcub);
        return vb;
    }
    
    @Override
    public void eliminarVcubEstacion(long idEstacion,long idVcub)
    {
        EstacionVcub ev = (EstacionVcub)findById(EstacionVcub.class,idEstacion);
        ev.eliminarVcub(idVcub);
    }
}
            
        
