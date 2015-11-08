package VcubStandAloneMundo;

public class Ubicacion 
{
	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	private Long idU;
    /**
     * Latitud de la ubicacion
     */
    private double latitudU;
    
    /**
     * Longitud de la ubicacion
     */
    private double longitudU;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Ubicacion()
    {

    }
    
    public Ubicacion(Long pId, double lat, double lon)
    {
    	idU = pId;
    	latitudU = lat;
    	longitudU = lon;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    public double getIdU()
    {
        return idU;
    }
    
    public void setIdU(Long id) {
        this.idU = id;
    }
    
    /**
     * Devuelve la latitud de la ubicacion
     * @return latitud Latitud de la ubicacion
     */
    public double getLatitud()
    {
        return latitudU;
    }
    
    /**
     * Devuelve la longitud de la ubicacion
     * @return longitud Longitud de la ubicacion
     */
    public double getLongitud()
    {
        return longitudU;
    }
    
    /**
     * Modifica la latitud de la ubicacion
     * @param lat Nueva latitud de la ubicacion
     */
    public void setLatitud(double lat) {
        this.latitudU = lat;
    }
    
    /**
     * Modifica la longitud de la ubicacion
     * @param lon Nueva longitud de la ubicacion
     */
    public void setLongitud(double lon) {
        this.longitudU = lon;
    }  

}
