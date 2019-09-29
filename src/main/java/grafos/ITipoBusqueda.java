package grafos;

import java.util.List;

public interface ITipoBusqueda {
	
	public boolean buscarRuta(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino);
	
}
