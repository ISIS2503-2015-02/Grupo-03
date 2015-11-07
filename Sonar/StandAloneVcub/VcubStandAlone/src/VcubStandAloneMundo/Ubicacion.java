package VcubStandAloneMundo;

public class Ubicacion 
{
	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	private Long id;
    /**
     * Latitud de la ubicacion
     */
    private double latitud;
    
    /**
     * Longitud de la ubicacion
     */
    private double longitud;

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
    	id = pId;
    	latitud = lat;
    	longitud = lon;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve la latitud de la ubicacion
     * @return latitud Latitud de la ubicacion
     */
    public double getLatitud()
    {
        return latitud;
    }
    
    /**
     * Devuelve la longitud de la ubicacion
     * @return longitud Longitud de la ubicacion
     */
    public double getLongitud()
    {
        return longitud;
    }
    
    /**
     * Modifica la latitud de la ubicacion
     * @param lat Nueva latitud de la ubicacion
     */
    public void setLatitud(double lat) {
        this.latitud = lat;
    }
    
    /**
     * Modifica la longitud de la ubicacion
     * @param lon Nueva longitud de la ubicacion
     */
    public void setLongitud(double lon) {
        this.longitud = lon;
    }  

}
