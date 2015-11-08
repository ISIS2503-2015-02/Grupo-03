package TranviaStandAloneMundo;

public class Tranvia {
    /**
     * ID del TranviaDTO
     */
   
    private int idT;
    
    /**
     * Estado del TranviaDTO
     */
    private int choqueT;
    
    
    /**
     * Temperatura
     */
   private int tempaturaT;
   
   /**
    * Boolean con referencia al boton de paanico para situacion de emergencia
    */
   private int panicoT; 
   
    /**
     * String coordenada
     */
    private String coordenadaT;
    
    /**
     * Linea de circulacion
     */
    private String lineaT;
    /**
     * Kilometraje recorrido
     */
    private int kilometrajeT;
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

  

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Tranvia()
    {

    }
    
    /**
     * 
     * @param id
     * @param plinea
     * @param coordenadaInic
     * @param pkilometraje
     */
    public Tranvia(int id ,String plinea, String coordenadaInic)
    {
        this.idT = id;
        this.lineaT= plinea;
        this.tempaturaT = 0;
        this.coordenadaT = coordenadaInic;
        this.panicoT= 0;
        this.choqueT=0;
    }
    
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id del TranviaDTO
     * @return id Id del TranviaDTO
     */
    public int getId()
    {
        return idT;
    }
    
    /**
     * Devuelve si ha sufrido un choque
     * @return choque si ha sufrido un choque o no
     */
    public boolean getChoque()
    {
        return choqueT >= 1 ;
    }
    
    /**
     * Modifica el id del Trnavia
     * @param id Nuevo id del Vcub
     */
    public void setId(int id) {
        this.idT = id;
    }
    
    /**
     * Indica que ha sufrido un choque
     */
    public void setChocado()
    {
     this.choqueT = 1;
    }
      public int getKilometraje() {
        return kilometrajeT;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometrajeT = kilometraje;
    }

    public int getTempatura() {
        return tempaturaT;
    }

    public void setTempatura(int tempatura) {
        this.tempaturaT = tempatura;
    }

    public boolean getPanico() {
        return panicoT >=1;
    }

    public void setPanico() {
        this.panicoT = 1;
    }

    public String getCoordenada() {
        return coordenadaT;
    }

    public void setCoordenada(String coordenada) {
        this.coordenadaT = coordenada;
    }

    public String getLinea() {
        return lineaT;
    }

    public void setLinea(String linea) {
        this.lineaT = linea;
    }
}
