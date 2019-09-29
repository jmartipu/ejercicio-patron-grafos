package grafos;

import java.util.List;

public interface IGrafoConPeso extends IGrafo {

	void addArco(String origen, String destino, int peso) throws Exception;

	void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso);
}