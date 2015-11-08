package TranviaStandAloneMundo;

public class Vehiculo 
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del VehiculoDTO
     */

    private int idTR;
    
    /**
     * capacidad del vehiculo
     */
    private int capacidadTR;
    
    /**
     * ubicacion del vehiculo
     */

    private Ubicacion ubicacionTR;
    
    
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
        this.idTR = id;
        ubicacionTR = ubic;    
    }
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

     /**
     * Devuelve el id del VehiculoDTO
     * @return id Id del VehiculoDTO
     */
    public long getIdTR()
    {
        return idTR;
    }
    
    /**
     * Devuelve la capacidad del VehiculoDTO
     * @return capacidad Capacidad del vehiculo
     */
    public int getCapacidad()
    {
        return capacidadTR;
    }

    /**
     * getter ubicacion
     * @return ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacionTR;
    }

    /**
     * Modifica la capacidad del VehiculoDTO
     * @param cap La nueva capacidad del vehiculo
     */
    public void setCapacidad(int cap) {
        capacidadTR = cap;
    }

    /**
     * setter ubicacion
     * @param ubicacion 
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacionTR = ubicacion;
    }
}
