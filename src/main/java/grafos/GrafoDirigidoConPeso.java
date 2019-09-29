package grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.enterprise.inject.Alternative;

import grafos.fabrica.cdi.FabricaArco;
import grafos.fabrica.cdi.FabricaBusqueda;

@Alternative
public class GrafoDirigidoConPeso extends Grafo implements IGrafoConPeso {

	public void addArco(String origen, String destino, int peso) throws Exception {
		
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		addArco(nodoOrigen, nodoDestino, peso);
	}
	
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso)
	{
		IArcoConPeso arco = (IArcoConPeso) FabricaArco.getArco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}
	
}
