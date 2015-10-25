package VcubStandAloneMundo;

public class Usuario
{

	//-----------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------

	/**
	 * Nombres y apellidos del usuario
	 */
	private String nombre;

	/**
	 * N�mero de documento de identidad
	 */
	private long documento;

	/**
	 * Tipo de documento
	 */
	private String tipoDocumento;

	/**
	 * N�mero del tel�fono 
	 */
	private long telefono;

	/**
	 * Direcci�n de residencia del usuario
	 */
	private String direccion;

	/**
	 * Correo electr�nico del usuario
	 */
	private String correo;

	/**
	 * Numero tarjeta de credito
	 */
	private Long tarjeta;

	/**
	 * Bicicleta alquilada por el usuario
	 */
	private Vcub bicicleta;

	/**
	 * Notificacion pendiente para el usuario
	 */
	public String notificacion;

	//-----------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------

	/**
	 * Constructor de la clase sin argumentos
	 */
	public Usuario(String pNombre, long pTelefono, String pDireccion, String pCorreo, long pTarjeta, Vcub pBicicleta)
	{
		nombre = pNombre;
		telefono = pTelefono;
		direccion = pDireccion;
		correo = pCorreo;
		tarjeta = pTarjeta;
		bicicleta = pBicicleta;
	}

	//-----------------------------------------------------------
	// Getters y setters
	//-----------------------------------------------------------

	/**
	 * Metodo para obtener el nombre del usuario
	 * @return nombre dle usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nobmre del usuario
	 * @param nombre nuevo nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Obtiene el tipo de documento de usuario
	 * @return tipo documento del usuario
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public Long getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Long tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	/**
	 * Asigna un nuevo tipo de documento al usuario
	 * @param tipoDocumento nuevo tipo a ser asignado
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * Devuelve el correo electr�nico del usuario
	 * @return correo Correo electr�nico del usuario
	 */
	public String getCorreo()
	{
		return correo;
	}

	/**
	 * Modifica el correo electr�nico del usuario
	 * @param correo Nuevo correo electr�nico
	 */
	public void setCorreo(String correo)
	{
		this.correo = correo;
	}

	/**
	 * Devuelve la direcci�n de residencia del usuario
	 * @return direccion Direcci�n de residencia del usuario
	 */
	public String getDireccion()
	{
		return direccion;
	}

	/**
	 * Modifica la direcci�n del usuario
	 * @param direccion Nueva direcci�n del usuario
	 */
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	/**
	 * Devuelve el n�mero de identificaci�n del usuario
	 * @return documento N�mero de identificaci�n del usuario
	 */
	public long getDocumento()
	{
		return documento;
	}

	/**
	 * Modifica el n�mero de identificaci�n del usuario
	 * @param documento N�mero de identificaci�n
	 */
	public void setDocumento(long documento)
	{
		this.documento = documento;
	}

	/**
	 * Devuelve el n�mero de tel�fono local
	 * @return telefonoLocal N�mero de tel�fono local
	 */
	public long getTelefono()
	{
		return telefono;
	}

	/**
	 * Modifica el n�mero del tel�fono local del usuario
	 * @param telefonoLocal Nuevo n�mero de tel�fono
	 */
	public void setTelefono(long telefonoLocal)
	{
		this.telefono = telefonoLocal;
	}


	public Vcub getBicicleta() {
		return bicicleta;
	}

	public void prestarVicicleta(Vcub bicicleta) {
		this.bicicleta = bicicleta;
	}
	
	public String getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}
}
