package MobibusStandAloneMundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Mundo 
{
	private ArrayList<Mobibus> disponibles;
	public Mundo()
	{
		disponibles = new ArrayList<Mobibus>();
	}

	public void disponibles()
	{
		try {
			disponibles = new ArrayList<Mobibus>();

			URL url = new URL("http://localhost:8080/mobibus/get");
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


	public ArrayList darDisponibles()
	{
		
		return disponibles;
	}
	
	public void cambiarEstado(Mobibus mobi)
	{
		mobi.cambiarEstado();
	}
	

	
}

