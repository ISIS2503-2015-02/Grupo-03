package VcubStandAloneMundo;

import java.util.ArrayList;
import java.util.List;

public class EstacionVcub 
{
	 //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID de la estación
     */
    private int idXX;
    
    /**
     * capacidad de guardar vcubs
     */
    private int capacidadXX;
    
    /**
     * los vcubs guardados en la estación.
     */
    private List vcubsXX;
    
    /**
     * la ubicacion de la estación de vcubs.
     */
    private Ubicacion ubicacionXX;
    
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

      /**
     * Constructor de la clase (sin argumentos)
     */
    public EstacionVcub()
    {

    }
    /**
     * constructor de Estacion
     * @param id
     * @param capacidad
     * @param agregar
     * @param ubicacion 
     */
    public EstacionVcub(int id, int capacidad, List<Vcub> agregar, Ubicacion ubicacion) {
        this.idXX = id;
        this.capacidadXX = capacidad;
        this.vcubsXX = agregar;
        this.ubicacionXX = ubicacion;
    }

    /**
     * setter id
     * @return 
     */
    public int getId() {
        return idXX;
    }

    /**
     * setter capacidad
     * @return 
     */
    public int getCapacidad() {
        return capacidadXX;
    }

    /**
     * getter vcubs
     * @return 
     */
    public List<Vcub> getVcubs() {
        return vcubsXX;
    }

    /**
     * getter ubicacion
     * @return 
     */
    public Ubicacion getUbicacion() {
        return ubicacionXX;
    }

    /**
     * setter id
     * @param id 
     */
    public void setId(int id) {
        this.idXX = id;
    }

    /**
     * setter capacidad
     * @param capacidad 
     */
    public void setCapacidad(int capacidad) {
        this.capacidadXX = capacidad;
    }

    /**
     * setter vcubs
     * @param vcubs 
     */
    public void setVcubs(List<Vcub> vcubs) {
        this.vcubsXX = vcubs;
    }

    /**
     * setter ubicacion
     * @param ubicacion 
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacionXX = ubicacion;
    }
    
    @Override
    public String toString()
    {
    	return "Estacion #" + idXX;
    }
}
