package MobibusStandAloneMundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Mundo 
{
	private ArrayList<Mobibus> disponibles;
	private ArrayList<Emergencia> emergencias;

	public Mundo()
	{
		disponibles = new ArrayList<Mobibus>();
		emergencias = new ArrayList<Emergencia>();
	}

	public void disponibles()
	{
		try {
			disponibles = new ArrayList<Mobibus>();

			URL url = new URL("http://172.24.100.41:80/mobibus/get");
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
			System.out.println("Output from Server .... \n");
			while((output = br.readLine())!=null)
			{
				JsonParser parser = new JsonParser();
				JsonElement arrayElement = parser.parse(output);
				System.out.println(arrayElement.getAsJsonArray().size());
				System.out.println(output);
				agregarMobibus(arrayElement.getAsJsonArray(), disponibles);
				//				String array[] = output.split(",");
				//				System.out.println(array[0]);
				//				for(int i=0;i+1<array.length;i=i+2)
				//				{
				//					array[i].replaceAll("\"", "");
				//					String y[]=array[i].split(":");
				//					Long pId = Long.valueOf(y[1]);
				//					Mobibus agregar=new Mobibus(pId, "disponible");
				//					disponibles.add(agregar);
				//
				//				}
			}
			//			while ((output = br.readLine()) != null) 
			//			{
			//				convertir(output, disponibles);
			//				System.out.println(output);
			//			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void emergencias()
	{
		try {
			emergencias = new ArrayList<Emergencia>();

			URL url = new URL("http://172.24.100.41:80/emergencia/get");
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
			System.out.println("Output from Server .... \n");
			while((output = br.readLine())!=null)
			{
				JsonParser parser = new JsonParser();
				JsonElement arrayElement = parser.parse(output);
				System.out.println(arrayElement.getAsJsonArray().size());
				System.out.println(output);
				for(int i=0;i<arrayElement.getAsJsonArray().size();i++)
				{
					if(arrayElement.getAsJsonArray().get(i)!=null)
					{
						String blog = String.valueOf(arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("id"));
						Long id = Long.valueOf(blog);
						System.out.println(id);
						String descripcion = String.valueOf(arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("descripcion"));
						String consecuencia = String.valueOf(arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("consecuencia"));
						String magnitud = String.valueOf(arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("magnitud"));
//						Long tempId2 = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("id").getAsLong();
//						int tempLatitud = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("latitud").getAsInt();
//						int tempLongitud = arrayElement.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("longitud").getAsInt();
						Ubicacion tempUb = new Ubicacion(Long.valueOf(i), i*4, i+3);
						Long pId = Long.valueOf(blog);
						Emergencia temp = new Emergencia(descripcion, consecuencia, magnitud, null, tempUb, null);
						emergencias.add(temp);
					}
				}
				//				String array[] = output.split(",");
				//				System.out.println(array[0]);
				//				for(int i=0;i+1<array.length;i=i+2)
				//				{
				//					array[i].replaceAll("\"", "");
				//					String y[]=array[i].split(":");
				//					Long pId = Long.valueOf(y[1]);
				//					Mobibus agregar=new Mobibus(pId, "disponible");
				//					disponibles.add(agregar);
				//
				//				}
			}
			//			while ((output = br.readLine()) != null) 
			//			{
			//				convertir(output, disponibles);
			//				System.out.println(output);
			//			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}


	public String generarMapa(Ubicacion x)
	{
		if(x == null)
		{
			Ubicacion w = new Ubicacion(Long.parseLong("900"), 4.60, -74.07);
			x = w;
		}
		String y = String.valueOf(x.getLatitud());
		String z = String.valueOf(x.getLongitud());
		String URL = "http://maps.googleapis.com/maps/api/staticmap?&zoom=13&size=300x300&maptype=roadmap&markers=color:red%7Clabel:U%7C" + y + "," + z;
		return URL;
	}


	public void agregarMobibus(JsonArray jsonArray, ArrayList res)
	{
		for(int i=0;i<jsonArray.size();i++)
		{
			if(jsonArray.get(i)!=null)
			{
				Long tempId = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("id").getAsLong();
				Mobibus temp = new Mobibus(tempId);
				res.add(temp);
			}
		}
	}

	public void agregarEmergencia(JsonArray jsonArray, ArrayList res)
	{
		for(int i=0;i<jsonArray.size();i++)
		{
			if(jsonArray.get(i)!=null)
			{
				String blog = String.valueOf(((JsonObject) jsonArray.get(i)).get("id"));
				Long id = Long.valueOf(blog);
				System.out.println(id);
				String descripcion = String.valueOf(((JsonObject) jsonArray.get(i)).get("descripcion"));
				String consecuencia = String.valueOf(((JsonObject) jsonArray.get(i)).get("consecuencia"));
				String magnitud = String.valueOf(((JsonObject) jsonArray.get(i)).get("magnitud"));
				Long tempId2 = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("id").getAsLong();
				int tempLatitud = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("latitud").getAsInt();
				int tempLongitud = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("longitud").getAsInt();
				Ubicacion tempUb = new Ubicacion(tempId2, tempLatitud, tempLongitud);
				Long pId = Long.valueOf(blog);
				Emergencia temp = new Emergencia(descripcion, consecuencia, magnitud, null, tempUb, null);
				res.add(temp);
			}
		}
	}

	public Mobibus cercano(Emergencia em)
	{
		disponibles();
		Mobibus res = null;
		double menor = distancia(disponibles.get(0).getUbicacion(),em.darUbicacion());
		for(int i=1; i<disponibles.size();i++)
		{
			double x= distancia(disponibles.get(i).getUbicacion(),em.darUbicacion());
			if(x < menor)
			{
				menor = x;
				res = disponibles.get(i);
			}
		}
		return res;
	}

	public ArrayList darDisponibles()
	{

		return disponibles;
	}
	
	public ArrayList<Emergencia> derEmergencias()
	{
		return emergencias;
	}

	public void cambiarEstado(Mobibus mobi)
	{
		mobi.cambiarEstado();
	}

	public double distancia(Ubicacion ubi1, Ubicacion ubi2)
	{
		double distancia = 0;
		if(ubi1!=null && ubi2!=null)
		{
			distancia=Math.pow((Math.pow((ubi1.getLatitud()-ubi2.getLatitud()),2)+Math.pow((ubi1.getLongitud()-ubi2.getLongitud()),2)),1/2);
		}
		return distancia;
	}
}

