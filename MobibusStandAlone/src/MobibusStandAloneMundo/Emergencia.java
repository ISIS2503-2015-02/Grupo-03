package MobibusStandAloneMundo;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;

public class Emergencia 
{
	private String descripcion;

	private String consecuencia;

	private String magnitud;

	private Date fecha;

	private Ubicacion ubicacion;
	
	private ArrayList<Vehiculo> vehiculos;

	public Emergencia(String pDescripcion, String pConsecuencia, String pMagnitud, Date pFecha, Ubicacion pUbicacion, ArrayList<Vehiculo> pVehiculos)
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
	
	public ArrayList<Vehiculo> darVehiculos()
	{
		return vehiculos;
	}
}