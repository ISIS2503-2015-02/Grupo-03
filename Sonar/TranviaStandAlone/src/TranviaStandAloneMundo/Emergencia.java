package TranviaStandAloneMundo;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Emergencia 
{
	private String descripcion;

	private String consecuencia;

	private String magnitud;

	private Date fecha;

	private Ubicacion ubicacion;
	
	private List<Vehiculo> vehiculos;

	public Emergencia(String pDescripcion, String pConsecuencia, String pMagnitud, Date pFecha, Ubicacion pUbicacion, List<Vehiculo> pVehiculos)
	{
		descripcion = pDescripcion;
		consecuencia = pConsecuencia;
		magnitud = pMagnitud;
		fecha = pFecha;
		ubicacion = pUbicacion;
		vehiculos = pVehiculos;
	}

	public String darDescripcion()
	{
		return descripcion;
	}

	public String darConsecuencia()
	{
		return consecuencia;
	}

	public String darMagnitud()
	{
		return magnitud;
	}
	
	public Date darFecha()
	{
		return fecha;
	}
	
	public Ubicacion darUbicacion()
	{
		return ubicacion;
	}
	
	public List<Vehiculo> darVehiculos()
	{
		return vehiculos;
	}
}