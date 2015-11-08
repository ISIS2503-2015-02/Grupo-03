package TranviaStandAloneMundo;

public class Ubicacion 
{
	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	private Long idT;
    /**
     * Latitud de la ubicacion
     */
    private double latitudT;
    
    /**
     * Longitud de la ubicacion
     */
    private double longitudT;

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
    	idT = pId;
    	latitudT = lat;
    	longitudT = lon;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    public double getIdT()
    {
        return idT;
    }
    
    public void setIdU(Long id) {
        this.idT = id;
    }
    
    /**
     * Devuelve la latitud de la ubicacion
     * @return latitud Latitud de la ubicacion
     */
    public double getLatitud()
    {
        return latitudT;
    }
    
    /**
     * Devuelve la longitud de la ubicacion
     * @return longitud Longitud de la ubicacion
     */
    public double getLongitud()
    {
        return longitudT;
    }
    
    /**
     * Modifica la latitud de la ubicacion
     * @param lat Nueva latitud de la ubicacion
     */
    public void setLatitud(double lat) {
        this.latitudT = lat;
    }
    
    /**
     * Modifica la longitud de la ubicacion
     * @param lon Nueva longitud de la ubicacion
     */
    public void setLongitud(double lon) {
        this.longitudT = lon;
    }  

}
