package VcubStandAloneMundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Mundo 
{
	private ArrayList<Vcub> disponibles;
	private ArrayList<EstacionVcub> estaciones;

	public Mundo()
	{
		disponibles = new ArrayList<Vcub>();
	}

	public void disponibles()
	{
		try {
			disponibles = new ArrayList<Vcub>();

			URL url = new URL("http://172.24.100.41:80/vcub/disponibles");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			while((output = br.readLine())!=null)
			{
				JsonParser parser = new JsonParser();
				JsonElement arrayElement = parser.parse(output);
				agregarVcubs(arrayElement.getAsJsonArray(), disponibles);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public String generarMapa(Ubicacion x)
	{
		String y = String.valueOf(x.getLatitud());
		String z = String.valueOf(x.getLongitud());
		String URL = "http://maps.googleapis.com/maps/api/staticmap?&zoom=13&size=300x300&maptype=roadmap&markers=color:red%7Clabel:U%7C" + y + "," + z;
		return URL;
	}

	public void estaciones()
	{
		try {
			estaciones = new ArrayList<EstacionVcub>();

			URL url = new URL("http://172.24.100.41:80/estacion/get");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			while((output = br.readLine())!=null)
			{
				JsonParser parser = new JsonParser();
				JsonElement arrayElement = parser.parse(output);
				for(int i=0;i<arrayElement.getAsJsonArray().size();i++)
				{
					if(arrayElement.getAsJsonArray().get(i)!=null)
					{
						int tempId = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("id").getAsInt();
						int tempCap = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("capacidad").getAsInt();
						Long tempId2 = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("id").getAsLong();
						int tempLatitud = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("latitud").getAsInt();
						int tempLongitud = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("longitud").getAsInt();
						Ubicacion tempUb = new Ubicacion(tempId2, tempLatitud, tempLongitud);
						JsonArray vcubsEst = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("vcubs").getAsJsonArray();
						ArrayList<Vcub> agregar = new ArrayList<Vcub>();
						agregarVcubs(vcubsEst, agregar);
						EstacionVcub tempEst = new EstacionVcub(tempId, tempCap, agregar, tempUb);
						estaciones.add(tempEst);
					}
				}

				conn.disconnect();
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void agregarVcubs(JsonArray jsonArray, ArrayList res)
	{
		for(int i=0;i<jsonArray.size();i++)
		{
			if(jsonArray.get(i)!=null)
			{
				Long tempId = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("id").getAsLong();
				String estado = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("estado").getAsString();
				Vcub temp = new Vcub(tempId, estado);
				res.add(temp);
			}
		}
	}


	public ArrayList darDisponibles()
	{

		return disponibles;
	}

	public ArrayList darEstaciones()
	{

		return estaciones;
	}
	
	public boolean iniciar(String pCorreo, String pPassword)
	{
		boolean respuesta = false;
		try {

			URL url = new URL("http://172.24.100.41:80/usuario/get/"+pCorreo);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				return false;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			while((output = br.readLine())!=null)
			{
				JsonParser parser = new JsonParser();
				JsonElement arrayElement = parser.parse(output);
				if(pPassword.equalsIgnoreCase(arrayElement.getAsJsonObject().get("documento").getAsString()))
				{
					respuesta = true;
				}
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return respuesta;
	}
	
	public boolean registrarse(String pNombre, long pDocumento, String pTipoDocumento, long pTelefono, String pDireccion, String pCorreo, long pTarjeta) throws ParseException
	{
		boolean respuesta = false;
		try {

			URL url = new URL("http://172.24.100.41:80/usuario/add");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod("POST");
			JsonObject usuario = new JsonObject();
			
			usuario.addProperty("nombre", pNombre);
			usuario.addProperty("documento", pDocumento);
			usuario.addProperty("tipoDocumento", pTipoDocumento);
			usuario.addProperty("telefono", pTelefono);
			usuario.addProperty("direccion", pDireccion);
			usuario.addProperty("correo", pCorreo);
			usuario.addProperty("tarjeta", pTarjeta);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(usuario.toString());
			wr.flush();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			else 
			{
				respuesta = true;
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return respuesta;
	}
}
