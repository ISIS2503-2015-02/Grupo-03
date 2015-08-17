package com.mycompany.arquisoft.persistencia.mock;


import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockRemote;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.dto.Tranvia;


import java.util.ArrayList;
import java.util.List;


public class ServicioPersistenciaMock implements IServicioPersistenciaMockRemote, IServicioPersistenciaMockLocal {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

     /**
     * Lista con los vendedores del sistema
     */
    private static ArrayList<Vcub> vcubs;
    
    /**
     * Lista tranvias del sistema
     */
    private static ArrayList<Tranvia> tranvias;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public ServicioPersistenciaMock()
    {
        if (vcubs == null)
        {
            vcubs = new ArrayList();
            vcubs.add(new Vcub(1));
            vcubs.add(new Vcub(2));
            
            tranvias = new ArrayList<Tranvia>();
            tranvias.add(new Tranvia(69 ,"A", "123123'222:12", 15));
            
        }
    }

    //-----------------------------------------------------------
    // Métodos
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
            Tranvia tranvia;
            for (int i = 0; i < tranvias.size(); i++)
            {
                tranvia = tranvias.get(i);
                if (tranvia.getId() == cuestion.getId())
                {
                    tranvias.set(i, cuestion);
                    break;
                }
            }
        }
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
        return null;
    }
}
