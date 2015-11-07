package VcubStandAloneMundo;

public class Vcub 
{
	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
	
    private Long id;
    /**
     * Estado del Vcub
     */
    private String estado;
    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Vcub( )
    {
        
    }
    
    public Vcub(Long pId, String pEstado)
    {
    	id= pId;
        estado = pEstado;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    
    /**
     * Devuelve el estado del Vcub
     * @return estado Estado del Vcub
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
     * Modifica el estado del Vcub
     */
    public void cambiarEstado() {
        if(this.estado.equalsIgnoreCase("disponible"))
        {
            this.estado = "alquilado"; 
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
