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
	 * Número de documento de identidad
	 */
	private long documentoUU;

	/**
	 * Tipo de documento
	 */
	private String tipoDocumentoUU;

	/**
	 * Número del teléfono 
	 */
	private long telefonoUU;

	/**
	 * Dirección de residencia del usuario
	 */
	private String direccionUU;

	/**
	 * Correo electrónico del usuario
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
	 * Devuelve el correo electrónico del usuario
	 * @return correo Correo electrónico del usuario
	 */
	public String getCorreo()
	{
		return correoUU;
	}

	/**
	 * Modifica el correo electrónico del usuario
	 * @param correo Nuevo correo electrónico
	 */
	public void setCorreo(String correo)
	{
		this.correoUU = correo;
	}

	/**
	 * Devuelve la dirección de residencia del usuario
	 * @return direccion Dirección de residencia del usuario
	 */
	public String getDireccion()
	{
		return direccionUU;
	}

	/**
	 * Modifica la dirección del usuario
	 * @param direccion Nueva dirección del usuario
	 */
	public void setDireccion(String direccion)
	{
		this.direccionUU = direccion;
	}

	/**
	 * Devuelve el número de identificación del usuario
	 * @return documento Número de identificación del usuario
	 */
	public long getDocumento()
	{
		return documentoUU;
	}

	/**
	 * Modifica el número de identificación del usuario
	 * @param documento Número de identificación
	 */
	public void setDocumento(long documento)
	{
		this.documentoUU = documento;
	}

	/**
	 * Devuelve el número de teléfono local
	 * @return telefonoLocal Número de teléfono local
	 */
	public long getTelefono()
	{
		return telefonoUU;
	}

	/**
	 * Modifica el número del teléfono local del usuario
	 * @param telefonoLocal Nuevo número de teléfono
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
