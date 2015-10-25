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
	 * Número de documento de identidad
	 */
	private long documento;

	/**
	 * Tipo de documento
	 */
	private String tipoDocumento;

	/**
	 * Número del teléfono 
	 */
	private long telefono;

	/**
	 * Dirección de residencia del usuario
	 */
	private String direccion;

	/**
	 * Correo electrónico del usuario
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
	 * Devuelve el correo electrónico del usuario
	 * @return correo Correo electrónico del usuario
	 */
	public String getCorreo()
	{
		return correo;
	}

	/**
	 * Modifica el correo electrónico del usuario
	 * @param correo Nuevo correo electrónico
	 */
	public void setCorreo(String correo)
	{
		this.correo = correo;
	}

	/**
	 * Devuelve la dirección de residencia del usuario
	 * @return direccion Dirección de residencia del usuario
	 */
	public String getDireccion()
	{
		return direccion;
	}

	/**
	 * Modifica la dirección del usuario
	 * @param direccion Nueva dirección del usuario
	 */
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	/**
	 * Devuelve el número de identificación del usuario
	 * @return documento Número de identificación del usuario
	 */
	public long getDocumento()
	{
		return documento;
	}

	/**
	 * Modifica el número de identificación del usuario
	 * @param documento Número de identificación
	 */
	public void setDocumento(long documento)
	{
		this.documento = documento;
	}

	/**
	 * Devuelve el número de teléfono local
	 * @return telefonoLocal Número de teléfono local
	 */
	public long getTelefono()
	{
		return telefono;
	}

	/**
	 * Modifica el número del teléfono local del usuario
	 * @param telefonoLocal Nuevo número de teléfono
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
