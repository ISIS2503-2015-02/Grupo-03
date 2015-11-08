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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import java.util.ListIterator;
import java.util.logging.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Mundo 
{
	private List<Mobibus> disponibles;
	private List<Emergencia> emergencias;
	private Logger LOGGER;
	
	public Mundo()
	{
		disponibles = new List<Mobibus>() {

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Mobibus> subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Mobibus set(int index, Mobibus element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Mobibus remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public ListIterator<Mobibus> listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListIterator<Mobibus> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Iterator<Mobibus> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Mobibus get(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean addAll(int index, Collection<? extends Mobibus> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Mobibus> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void add(int index, Mobibus element) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean add(Mobibus e) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		emergencias = new List<Emergencia>() {

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Emergencia> subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Emergencia set(int index, Emergencia element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Emergencia remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public ListIterator<Emergencia> listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListIterator<Emergencia> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Iterator<Emergencia> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Emergencia get(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean addAll(int index, Collection<? extends Emergencia> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Emergencia> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void add(int index, Emergencia element) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean add(Emergencia e) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

	public void disponibles()
	{
		try {
			disponibles = new List<Mobibus>() {

				@Override
				public <T> T[] toArray(T[] a) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Object[] toArray() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public List<Mobibus> subList(int fromIndex, int toIndex) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int size() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Mobibus set(int index, Mobibus element) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean retainAll(Collection<?> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean removeAll(Collection<?> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public Mobibus remove(int index) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean remove(Object o) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public ListIterator<Mobibus> listIterator(int index) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public ListIterator<Mobibus> listIterator() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int lastIndexOf(Object o) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Iterator<Mobibus> iterator() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean isEmpty() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public int indexOf(Object o) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Mobibus get(int index) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean containsAll(Collection<?> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean contains(Object o) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void clear() {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean addAll(int index, Collection<? extends Mobibus> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean addAll(Collection<? extends Mobibus> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void add(int index, Mobibus element) {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean add(Mobibus e) {
					// TODO Auto-generated method stub
					return false;
				}
			};

			URL urlX = new URL("http://172.24.100.41:80/mobibus/get");
			HttpURLConnection connX = (HttpURLConnection) urlX.openConnection();
			connX.setRequestMethod("GET");
			connX.setRequestProperty("Accept", "application/json");

			if (connX.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connX.getResponseCode());
			}

			BufferedReader brX = new BufferedReader(new InputStreamReader(
					(connX.getInputStream())));

			String outputX;
			while((outputX = brX.readLine())!=null)
			{
				JsonParser parserX = new JsonParser();
				JsonElement arrayElementX = parserX.parse(outputX);
				agregarMobibus(arrayElementX.getAsJsonArray(), disponibles);
			}

			connX.disconnect();

		} catch (MalformedURLException e) {

			LOGGER.log(null, "context", e);

		} catch (IOException e) {
			LOGGER.log(null, "context", e);

		}
	}

	public void emergencias()
	{
		try {
			emergencias = new List<Emergencia>() {

				@Override
				public <T> T[] toArray(T[] a) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Object[] toArray() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public List<Emergencia> subList(int fromIndex, int toIndex) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int size() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Emergencia set(int index, Emergencia element) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean retainAll(Collection<?> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean removeAll(Collection<?> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public Emergencia remove(int index) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean remove(Object o) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public ListIterator<Emergencia> listIterator(int index) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public ListIterator<Emergencia> listIterator() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int lastIndexOf(Object o) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Iterator<Emergencia> iterator() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean isEmpty() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public int indexOf(Object o) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Emergencia get(int index) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean containsAll(Collection<?> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean contains(Object o) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void clear() {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean addAll(int index, Collection<? extends Emergencia> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean addAll(Collection<? extends Emergencia> c) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void add(int index, Emergencia element) {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean add(Emergencia e) {
					// TODO Auto-generated method stub
					return false;
				}
			};

			URL urlY = new URL("http://172.24.100.41:80/emergencia/get");
			HttpURLConnection connY = (HttpURLConnection) urlY.openConnection();
			connY.setRequestMethod("GET");
			connY.setRequestProperty("Accept", "application/json");

			if (connY.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connY.getResponseCode());
			}

			BufferedReader brY = new BufferedReader(new InputStreamReader(
					(connY.getInputStream())));

			String outputY;
			while((outputY = brY.readLine())!=null)
			{
				JsonParser parserY = new JsonParser();
				JsonElement arrayElementY = parserY.parse(outputY);
				for(int i=0;i<arrayElementY.getAsJsonArray().size();i++)
				{
					if(arrayElementY.getAsJsonArray().get(i)!=null)
					{
						String blog = String.valueOf(arrayElementY.getAsJsonArray().get(i).getAsJsonObject().get("id"));
						Long id = Long.valueOf(blog);
						String descripcion = String.valueOf(arrayElementY.getAsJsonArray().get(i).getAsJsonObject().get("descripcion"));
						String consecuencia = String.valueOf(arrayElementY.getAsJsonArray().get(i).getAsJsonObject().get("consecuencia"));
						String magnitud = String.valueOf(arrayElementY.getAsJsonArray().get(i).getAsJsonObject().get("magnitud"));
						Ubicacion tempUb = new Ubicacion(Long.valueOf(i), i*4, i+3);
						Long pId = Long.valueOf(blog);
						Emergencia temp = new Emergencia(descripcion, consecuencia, magnitud, null, tempUb, null);
						emergencias.add(temp);
					}
				}
			}

			connY.disconnect();

		} catch (MalformedURLException e) {
			LOGGER.log(null, "context", e);

		} catch (IOException e) {
			LOGGER.log(null, "context", e);

		}
	}


	public String generarMapa(Ubicacion x)
	{
		Ubicacion w = null;
		if(x == null)
		{
			w = new Ubicacion(Long.parseLong("900"), 4.60, -74.07);
		}
		String y = String.valueOf(w.getLatitud());
		String z = String.valueOf(w.getLongitud());
		String URL = "http://maps.googleapis.com/maps/api/staticmap?&zoom=13&size=300x300&maptype=roadmap&markers=color:red%7Clabel:U%7C" + y + "," + z;
		return URL;
	}


	public void agregarMobibus(JsonArray jsonArray, List res)
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

	public void agregarEmergencia(JsonArray jsonArray, List res)
	{
		for(int i=0;i<jsonArray.size();i++)
		{
			if(jsonArray.get(i)!=null)
			{
				String descripcion = String.valueOf(((JsonObject) jsonArray.get(i)).get("descripcion"));
				String consecuencia = String.valueOf(((JsonObject) jsonArray.get(i)).get("consecuencia"));
				String magnitud = String.valueOf(((JsonObject) jsonArray.get(i)).get("magnitud"));
				Long tempId2 = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("id").getAsLong();
				int tempLatitud = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("latitud").getAsInt();
				int tempLongitud = jsonArray.getAsJsonArray().get(i).getAsJsonObject().get("ubicacion").getAsJsonObject().get("longitud").getAsInt();
				Ubicacion tempUb = new Ubicacion(tempId2, tempLatitud, tempLongitud);
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

	public List darDisponibles()
	{

		return disponibles;
	}

	public List<Emergencia> derEmergencias()
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

