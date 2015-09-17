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
    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Mobibus( )
    {
        
    }
    
    public Mobibus(Long pId, String pEstado)
    {
    	id= pId;
        estado = pEstado;
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
            
    /**
     * Modifica el estado del Mobibus
     */
    public void cambiarEstado() {
        if(this.estado.equalsIgnoreCase("disponible"))
        {
            this.estado = "reservado"; 
        }
        else
        {
            this.estado = "disponible";
        }
    }
    
    public String toString()
    {
    	return "id:"+String.valueOf(id);
    }
}
