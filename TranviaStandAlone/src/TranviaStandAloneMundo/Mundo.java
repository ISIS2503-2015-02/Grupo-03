package TranviaStandAloneMundo;

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
	
	Tranvia actual;

	public Mundo()
	{
		actual= new Tranvia(1,"el bronx","97,08",45000);
	}
	
	public void cambiarTranvia(Tranvia actual)
	{
		this.actual=actual;
	}

	public void crearEmergencia(String descripcion, String consecuencia, String magnitud) throws ParseException
	{
		try {

			URL url = new URL("http://localhost:8080/emergencia/add/" + actual.getId());
			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json; charset=UTF-8");
			JsonObject emergencia = new JsonObject();
			JsonArray vehicInvolv= new JsonArray();

				JsonObject u= new JsonObject();
				String [] coordenadas= actual.getCoordenada().split(",");
				u.addProperty("latitud", coordenadas[0]);
				u.addProperty("longitud", coordenadas[1]);
			
			emergencia.addProperty( "descripcion", descripcion);
			emergencia.addProperty("consecuencia", consecuencia);
			emergencia.add("vehiculosInvolucrados", vehicInvolv);
			emergencia.addProperty("magnitud", magnitud);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
			Date date = new Date(); 
			String formattedDate= df.format(date);
			emergencia.addProperty("fecha", formattedDate);
			emergencia.add("ubicacion", u);
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(emergencia.toString());
			System.out.println(emergencia);
			wr.flush();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			else 
			{
				
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	
	public void Panico()
	{
		try {

			URL url = new URL("http://localhost:8080/emergencia/add/" + actual.getId());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json; charset=UTF-8");
			JsonObject emergencia = new JsonObject();
			JsonArray vehicInvolv= new JsonArray();

				JsonObject u= new JsonObject();
				String [] coordenadas= actual.getCoordenada().split(",");
				u.addProperty("latitud", coordenadas[0]);
				u.addProperty("longitud", coordenadas[1]);
				
			
			emergencia.addProperty( "descripcion", "Accidente crítico");
			emergencia.addProperty("consecuencia", "ko");
			emergencia.add("vehiculosInvolucrados", vehicInvolv);
			emergencia.addProperty("magnitud", "grave");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
			Date date = new Date(); 
			String formattedDate= df.format(date);
			emergencia.addProperty("fecha", formattedDate);
			emergencia.add("ubicacion", u);
			conn.setDoOutput(true);			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(emergencia.toString());
			System.out.println(emergencia);
			System.out.println(url);


			wr.flush();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			else 
			{
				
			}


			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void getTranvia(String string) {
		try {

			URL url = new URL("http://localhost:8080/Tranvia/get/"+string);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json; charset=UTF-8");
			JsonObject emergencia = new JsonObject();
			JsonArray vehicInvolv= new JsonArray();

				JsonObject o= new JsonObject();
				JsonObject u= new JsonObject();
				String [] coordenadas= actual.getCoordenada().split(",");
				u.addProperty("latitud", coordenadas[0]);
				u.addProperty("longitud", coordenadas[1]);
				o.addProperty("id", actual.getId());
				o.addProperty("capacidad", 150);
				o.add("ubicacion", u);
				vehicInvolv.add(o);
			
			emergencia.addProperty( "descripcion", "Accidente crítico");
			emergencia.addProperty("consecuencia", "ko");
			emergencia.add("vehiculosInvolucrados", vehicInvolv);
			emergencia.addProperty("magnitud", "grave");
			emergencia.addProperty("fecha", String.valueOf(new Date()));
			emergencia.add("ubicacion", u);
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(emergencia.toString());
			wr.flush();

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
	//			agregarVcubs(arrayElement.getAsJsonArray(), disponibles);
				//				String array[] = output.split(",");
				//				System.out.println(array[0]);
				//				for(int i=0;i+1<array.length;i=i+2)
				//				{
				//					array[i].replaceAll("\"", "");
				//					String y[]=array[i].split(":");
				//					Long pId = Long.valueOf(y[1]);
				//					Vcub agregar=new Vcub(pId, "disponible");
				//					disponibles.add(agregar);
				//
				//				}
			}



			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}		
	}


//	public void convertir(String json, ArrayList arrayV )
//	{
//
//		JsonParser parser = new JsonParser();
//
//
//		JsonArray array = parser.parse(json).getAsJsonArray();
//
//		for(int i=0;i<array.size();i++)
//		{
//			String blog = String.valueOf(((JsonObject) array.get(i)).get("id"));
//			Long id = Long.valueOf(blog);
//			System.out.println(id);
//
//			String estado = String.valueOf(("estado"));	
//			System.out.println(estado);
//
//			Vcub temp = new Vcub(id, estado);
//			arrayV.add(temp);
//		}
//	}


}
