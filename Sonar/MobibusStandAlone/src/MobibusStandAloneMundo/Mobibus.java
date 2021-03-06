package MobibusStandAloneMundo;

public class Mobibus 
{
	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
	
    private Long id;
    /**
     * Estado del Mobibus
     */
    private String estado;
    
    private Ubicacion ubic;
    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Mobibus( )
    {
        
    }
    
    public Mobibus(Long pId)
    {
    	id= pId;
        estado = "disponible";
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    
    /**
     * Devuelve el estado del Mobibus
     * @return estado Estado del Mobibus
     */
    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Ubicacion getUbicacion() {
        return ubic;
    }

    public void setUbicacion(Ubicacion ubic) {
        this.ubic = ubic;
    }
            
    /**
     * Modifica el estado del Mobibus
     */
    public void cambiarEstado() {
        if("disponible".equalsIgnoreCase(this.estado))
        {
            this.estado = "reservado"; 
        }
        else if(this.estado==null)
        {
            this.estado = "disponible";
        }
        else
        	this.estado = "disponible";
    }
    
    @Override
    public String toString()
    {
    	return "id:"+String.valueOf(id);
    }
}
