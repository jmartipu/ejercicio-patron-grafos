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
public class GrafoNoDirigidoSinPeso extends Grafo {
	@Override
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino)
	{
		IArco arco = FabricaArco.getArco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
		
		arco = FabricaArco.getArco();
		arco.setOrigen(nodoDestino);
		arco.setDestino(nodoOrigen);
		arcos.add(arco);
		nodoDestino.agregarArco(arco);
	}
	
}
