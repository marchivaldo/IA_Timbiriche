package timbiriche;

import java.util.Iterator;
import java.util.LinkedList;

public class Grafo {
	private LinkedList<Integer> adyacentes[];
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Grafo(int tam) {
		adyacentes = new LinkedList[tam];
		for (int i = 0; i < tam; i++)
			adyacentes[i] = new LinkedList();
	}
	
	public void unir2Puntos(int punto1, int punto2) {
		adyacentes[punto1].add(punto2);
	}
	
	public boolean estanConectados(int punto1, int punto2) {
		Iterator<Integer> i = adyacentes[punto1].iterator();
		while(i.hasNext()) {
			int siguiente = i.next();
			if(siguiente == punto2 )
				return true;
		}
		Iterator<Integer> j = adyacentes[punto2].iterator();
		while(j.hasNext()) {
			int siguiente = j.next();
			if(siguiente == punto1)
				return true;
		}
		return false;
	}
	
}
