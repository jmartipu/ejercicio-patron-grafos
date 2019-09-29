package grafos;

import javax.enterprise.inject.Alternative;

@Alternative
public class ArcoConPeso extends Arco implements IArco{
	private int		peso;
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
}
