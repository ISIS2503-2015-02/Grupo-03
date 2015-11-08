package MobibusStandAloneMundo;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Emergencia 
{
	private String descripcionM;

	private String consecuenciaM;

	private String magnitudM;

	private Date fechaM;

	private Ubicacion ubicacionM;
	
	private List<Vehiculo> vehiculosM;

	public Emergencia(String pDescripcion, String pConsecuencia, String pMagnitud, Date pFecha, Ubicacion pUbicacion, List<Vehiculo> pVehiculos)
	{
		descripcionM = pDescripcion;
		consecuenciaM = pConsecuencia;
		magnitudM = pMagnitud;
		fechaM = pFecha;
		ubicacionM = pUbicacion;
		vehiculosM = pVehiculos;
	}

	public String darDescripcion()
	{
		return descripcionM;
	}

	public String darConsecuencia()
	{
		return consecuenciaM;
	}

	public String darMagnitud()
	{
		return magnitudM;
	}
	
	public Date darFecha()
	{
		return fechaM;
	}
	
	public Ubicacion darUbicacion()
	{
		return ubicacionM;
	}
	
	public List<Vehiculo> darVehiculos()
	{
		return vehiculosM;
	}
	
	@Override
	public String toString()
	{
		return magnitudM;
	}
}