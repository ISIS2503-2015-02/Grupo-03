package VcubStandAloneMundo;

public class Vcub 
{
	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
	
    private Long idVV;
    /**
     * Estado del Vcub
     */
    private String estadoVV;
    

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
    	idVV = pId;
        estadoVV = pEstado;
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
        return estadoVV;
    }

    public void setEstado(String estado) {
        this.estadoVV = estado;
    }

    public Long getId() {
        return idVV;
    }

    public void setId(Long id) {
        this.idVV = id;
    }
            
    /**
     * Modifica el estado del Vcub
     */
    public void cambiarEstado() {
        if("disponible".equalsIgnoreCase(this.estadoVV))
        {
            this.estadoVV = "alquilado"; 
        }
        else
        {
            this.estadoVV = "disponible";
        }
    }
    
    @Override
    public String toString()
    {
    	return "id:"+String.valueOf(idVV);
    }
}
