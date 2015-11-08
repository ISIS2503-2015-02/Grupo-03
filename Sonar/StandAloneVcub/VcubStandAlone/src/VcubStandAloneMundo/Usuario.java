package VcubStandAloneMundo;

public class Usuario
{

	//-----------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------

	/**
	 * Nombres y apellidos del usuario
	 */
	private String nombreUU;

	/**
	 * N�mero de documento de identidad
	 */
	private long documentoUU;

	/**
	 * Tipo de documento
	 */
	private String tipoDocumentoUU;

	/**
	 * N�mero del tel�fono 
	 */
	private long telefonoUU;

	/**
	 * Direcci�n de residencia del usuario
	 */
	private String direccionUU;

	/**
	 * Correo electr�nico del usuario
	 */
	private String correoUU;

	/**
	 * Numero tarjeta de credito
	 */
	private Long tarjetaUU;

	/**
	 * Bicicleta alquilada por el usuario
	 */
	private Vcub bicicletaUU;

	/**
	 * Notificacion pendiente para el usuario
	 */
	private String notificacionUU;

	//-----------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------

	/**
	 * Constructor de la clase sin argumentos
	 */
	public Usuario(String pNombre,long pTelefono, String pDireccion, String pCorreo, long pTarjeta, Vcub pBicicleta)
	{
		nombreUU = pNombre;
		telefonoUU = pTelefono;
		direccionUU = pDireccion;
		correoUU = pCorreo;
		tarjetaUU = pTarjeta;
		bicicletaUU = pBicicleta;
	}

	//-----------------------------------------------------------
	// Getters y setters
	//-----------------------------------------------------------

	/**
	 * Metodo para obtener el nombre del usuario
	 * @return nombre dle usuario
	 */
	public String getNombre() {
		return nombreUU;
	}

	/**
	 * Cambia el nobmre del usuario
	 * @param nombre nuevo nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombreUU = nombre;
	}
	
	/**
	 * Obtiene el tipo de documento de usuario
	 * @return tipo documento del usuario
	 */
	public String getTipoDocumento() {
		return tipoDocumentoUU;
	}

	public Long getTarjeta() {
		return tarjetaUU;
	}

	public void setTarjeta(Long tarjeta) {
		this.tarjetaUU = tarjeta;
	}
	
	/**
	 * Asigna un nuevo tipo de documento al usuario
	 * @param tipoDocumento nuevo tipo a ser asignado
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumentoUU = tipoDocumento;
	}

	/**
	 * Devuelve el correo electr�nico del usuario
	 * @return correo Correo electr�nico del usuario
	 */
	public String getCorreo()
	{
		return correoUU;
	}

	/**
	 * Modifica el correo electr�nico del usuario
	 * @param correo Nuevo correo electr�nico
	 */
	public void setCorreo(String correo)
	{
		this.correoUU = correo;
	}

	/**
	 * Devuelve la direcci�n de residencia del usuario
	 * @return direccion Direcci�n de residencia del usuario
	 */
	public String getDireccion()
	{
		return direccionUU;
	}

	/**
	 * Modifica la direcci�n del usuario
	 * @param direccion Nueva direcci�n del usuario
	 */
	public void setDireccion(String direccion)
	{
		this.direccionUU = direccion;
	}

	/**
	 * Devuelve el n�mero de identificaci�n del usuario
	 * @return documento N�mero de identificaci�n del usuario
	 */
	public long getDocumento()
	{
		return documentoUU;
	}

	/**
	 * Modifica el n�mero de identificaci�n del usuario
	 * @param documento N�mero de identificaci�n
	 */
	public void setDocumento(long documento)
	{
		this.documentoUU = documento;
	}

	/**
	 * Devuelve el n�mero de tel�fono local
	 * @return telefonoLocal N�mero de tel�fono local
	 */
	public long getTelefono()
	{
		return telefonoUU;
	}

	/**
	 * Modifica el n�mero del tel�fono local del usuario
	 * @param telefonoLocal Nuevo n�mero de tel�fono
	 */
	public void setTelefono(long telefonoLocal)
	{
		this.telefonoUU = telefonoLocal;
	}


	public Vcub getBicicleta() {
		return bicicletaUU;
	}

	public void prestarVicicleta(Vcub bicicleta) {
		this.bicicletaUU = bicicleta;
	}
	
	public String getNotificacion() {
		return notificacionUU;
	}

	public void setNotificacion(String notificacion) {
		this.notificacionUU = notificacion;
	}
}
