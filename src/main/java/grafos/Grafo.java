package grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


import grafos.fabrica.cdi.FabricaArco;
import grafos.fabrica.cdi.FabricaBusqueda;

public abstract class Grafo implements IGrafo {

	List<Nodo> nodos = new ArrayList<>();
	List<IArco> arcos = new ArrayList<>();
	
	public Grafo() { }
	
	/* (non-Javadoc)
	 * @see grafos.IGrafo#addNodo(java.lang.String)
	 */
	@Override
	public void addNodo(String nombre)
	{
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);
	}
	
	/* (non-Javadoc)
	 * @see grafos.IGrafo#addArco(java.lang.String, java.lang.String)
	 */
	@Override
	public void addArco(String origen, String destino) throws Exception {
		
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		addArco(nodoOrigen, nodoDestino);
	}
	
	/* (non-Javadoc)
	 * @see grafos.IGrafo#addArco(grafos.Nodo, grafos.Nodo)
	 */
	@Override
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino)
	{
		IArco arco = FabricaArco.getArco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);

	}
	
	/* (non-Javadoc)
	 * @see grafos.IGrafo#buscarNodo(java.lang.String)
	 */
	@Override
	public Nodo buscarNodo(String nombre) 
	{
		for (Nodo nodo: nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see grafos.IGrafo#existeRuta(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existeRuta(String origen, String destino) throws Exception {
		if (buscarRuta(origen, destino) != null) {
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see grafos.IGrafo#buscarRuta(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Nodo> buscarRuta(String origen, String destino) throws Exception {
		
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		List<Nodo> nodosRuta = new ArrayList<>();
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		ITipoBusqueda busqueda = FabricaBusqueda.getTipoBusqueda();
		if (busqueda.buscarRuta(nodosRuta, nodoOrigen, nodoDestino)) {
			return nodosRuta;
		} else {
			return null;
		}
	}
	
	
	
}
