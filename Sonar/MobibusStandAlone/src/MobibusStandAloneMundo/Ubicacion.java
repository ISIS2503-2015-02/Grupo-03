package MobibusStandAloneMundo;

public class Ubicacion 
{
	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	private Long idM;
    /**
     * Latitud de la ubicacion
     */
    private double latitudM;
    
    /**
     * Longitud de la ubicacion
     */
    private double longitudM;

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
    	idM = pId;
    	latitudM = lat;
    	longitudM = lon;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    public double getId()
    {
        return idM;
    }
    
    public void setId(Long id) {
        this.idM = id;
    }
    
    /**
     * Devuelve la latitud de la ubicacion
     * @return latitud Latitud de la ubicacion
     */
    public double getLatitud()
    {
        return latitudM;
    }
    
    /**
     * Devuelve la longitud de la ubicacion
     * @return longitud Longitud de la ubicacion
     */
    public double getLongitud()
    {
        return longitudM;
    }
    
    /**
     * Modifica la latitud de la ubicacion
     * @param lat Nueva latitud de la ubicacion
     */
    public void setLatitud(double lat) {
        this.latitudM = lat;
    }
    
    /**
     * Modifica la longitud de la ubicacion
     * @param lon Nueva longitud de la ubicacion
     */
    public void setLongitud(double lon) {
        this.longitudM = lon;
    }  

}
