package grafos.fabrica.cdi;

import java.io.Console;
import java.util.List;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import grafos.GrafoDirigidoConPeso;
import grafos.GrafoNoDirigidoConPeso;
import grafos.IArco;
import grafos.IGrafo;
import grafos.IGrafoConPeso;
import grafos.ITipoBusqueda;
import grafos.Nodo;
public class MainConCDI {
	

	public static void main(String[] args) {
		
		try {
			SeContainer container = SeContainerInitializer.newInstance().initialize();			
			IArco arco = container.select(IArco.class).get();
			ITipoBusqueda tipoBusqueda = container.select(ITipoBusqueda.class).get();
			IGrafo grafo = container.select(IGrafo.class).get();
			
				
				
				if(grafo.getClass().equals(GrafoNoDirigidoConPeso.class) || 
						grafo.getClass().equals(GrafoDirigidoConPeso.class) ) {
					IGrafoConPeso g = (IGrafoConPeso) grafo;
					g.addNodo("A");
					g.addNodo("B");
					g.addNodo("C");
					
					g.addArco("A", "B", 1);
					g.addArco("B", "C", 1);
					g.addArco("A", "C", 2);

					List<Nodo> camino = g.buscarRuta("A", "C");
					
					if (camino == null) {
						System.out.println("Camino A -> C no encontrado");
					} else {
						System.out.println("Camino A -> C encontrado");
						for (Nodo nodo: camino) {
							System.out.println(nodo.getNombre());
						}				
					}
					System.out.println();
					
					g = (IGrafoConPeso) grafo;
					
					g.addNodo("A");
					g.addNodo("B");
					g.addNodo("C");
					g.addNodo("D");
					g.addNodo("E");
					
					g.addArco("A", "B", 1);
					g.addArco("B", "C", 1);
					g.addArco("C", "D", 1);
					g.addArco("E", "D", 2);
					g.addArco("A", "C", 3);
					
					camino = g.buscarRuta("A", "E");
					
					if (camino == null) {
						System.out.println("Camino A -> E no encontrado");
					} else {
						System.out.println("Camino A -> E encontrado");
						for (Nodo nodo: camino) {
							System.out.println(nodo.getNombre());
						}				
					}
				}else {
					IGrafo g = grafo;
					g.addNodo("A");
					g.addNodo("B");
					g.addNodo("C");
					
					g.addArco("A", "B");
					g.addArco("B", "C");
					g.addArco("A", "C");

					List<Nodo> camino = g.buscarRuta("A", "C");
					
					if (camino == null) {
						System.out.println("Camino A -> C no encontrado");
					} else {
						System.out.println("Camino A -> C encontrado");
						for (Nodo nodo: camino) {
							System.out.println(nodo.getNombre());
						}				
					}
					System.out.println();
					
					g = grafo;
					
					g.addNodo("A");
					g.addNodo("B");
					g.addNodo("C");
					g.addNodo("D");
					g.addNodo("E");
					
					g.addArco("A", "B");
					g.addArco("B", "C");
					g.addArco("C", "D");
					g.addArco("E", "D");
					g.addArco("A", "C");
					
					camino = g.buscarRuta("A", "E");
					
					if (camino == null) {
						System.out.println("Camino A -> E no encontrado");
					} else {
						System.out.println("Camino A -> E encontrado");
						for (Nodo nodo: camino) {
							System.out.println(nodo.getNombre());
						}				
					}
					
				}
			
			
		} catch (Exception e) {
			// muestra mensajes de error
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
}
