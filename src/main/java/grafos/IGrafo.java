package grafos;

import java.util.List;

public interface IGrafo {

	void addNodo(String nombre);

	void addArco(String origen, String destino) throws Exception;

	void addArco(Nodo nodoOrigen, Nodo nodoDestino);

	Nodo buscarNodo(String nombre);

	boolean existeRuta(String origen, String destino) throws Exception;

	List<Nodo> buscarRuta(String origen, String destino) throws Exception;

}