package VcubStandAloneMundo;

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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Mundo 
{
	private ArrayList<Vcub> disponibles;

	public Mundo()
	{
		disponibles = new ArrayList<Vcub>();
	}

	public void disponibles()
	{
		try {
			disponibles = new ArrayList<Vcub>();

			URL url = new URL("http://localhost:8080/vcub/disponibles");
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
			output = br.readLine();
			System.out.println(output);
			String array[] = output.split(",");
			System.out.println(array[0]);
			for(int i=0;i+1<array.length;i=i+2)
			{
				array[i].replaceAll("\"", "");
				String y[]=array[i].split(":");
				Long pId = Long.valueOf(y[1]);
				Vcub agregar=new Vcub(pId, "disponible");
				disponibles.add(agregar);

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

	//	public ArrayList estaciones()
	//	{
	//		try {
	//
	//			URL url = new URL("http://localhost:8080/vcub/disponibles");
	//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	//			conn.setRequestMethod("GET");
	//			conn.setRequestProperty("Accept", "application/json");
	//
	//			if (conn.getResponseCode() != 200) {
	//				throw new RuntimeException("Failed : HTTP error code : "
	//						+ conn.getResponseCode());
	//			}
	//
	//			BufferedReader br = new BufferedReader(new InputStreamReader(
	//					(conn.getInputStream())));
	//
	//			String output;
	//			System.out.println("Output from Server .... \n");
	//			while ((output = br.readLine()) != null) 
	//			{
	//				convertir(output, disponibles);
	//				System.out.println(output);
	//			}
	//
	//			conn.disconnect();
	//
	//		} catch (MalformedURLException e) {
	//
	//			e.printStackTrace();
	//
	//		} catch (IOException e) {
	//
	//			e.printStackTrace();
	//
	//		}
	//		return disponibles;
	//	}

	public void convertir(String json, ArrayList arrayV )
	{

		JsonParser parser = new JsonParser();


		JsonArray array = parser.parse(json).getAsJsonArray();

		for(int i=0;i<array.size();i++)
		{
			String blog = String.valueOf(((JsonObject) array.get(i)).get("id"));
			Long id = Long.valueOf(blog);
			System.out.println(id);

			String estado = String.valueOf(("estado"));	
			System.out.println(estado);

			Vcub temp = new Vcub(id, estado);
			arrayV.add(temp);
		}
	}

	public ArrayList darDisponibles()
	{

		return disponibles;
	}
}
