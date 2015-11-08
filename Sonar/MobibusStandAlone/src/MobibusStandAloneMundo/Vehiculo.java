package MobibusStandAloneMundo;

public class Vehiculo 
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del VehiculoDTO
     */

    private int idMV;
    
    /**
     * capacidad del vehiculo
     */
    private int capacidadMV;
    
    /**
     * ubicacion del vehiculo
     */

    private Ubicacion ubicacionMV;
    
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Vehiculo()
    {

    }
    
    /**
     * Constructor de la clase (con argumentos)
     * @param id
     * @param ubic
     */
    public Vehiculo(int id, Ubicacion ubic)
    {
        this.idMV = id;
        ubicacionMV = ubic;    
    }
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

     /**
     * Devuelve el id del VehiculoDTO
     * @return id Id del VehiculoDTO
     */
    public long getId()
    {
        return idMV;
    }
    
    /**
     * Devuelve la capacidad del VehiculoDTO
     * @return capacidad Capacidad del vehiculo
     */
    public int getCapacidad()
    {
        return capacidadMV;
    }

    /**
     * getter ubicacion
     * @return ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacionMV;
    }

    /**
     * Modifica la capacidad del VehiculoDTO
     * @param cap La nueva capacidad del vehiculo
     */
    public void setCapacidad(int cap) {
        capacidadMV= cap;
    }

    /**
     * setter ubicacion
     * @param ubicacion 
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacionMV = ubicacion;
    }
   
    


}
