package grafos.fabrica.cdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import grafos.IArco;
import grafos.IArcoConPeso;
public class FabricaArco {
	

	
	public static IArco getArco() {
		
		try {
			SeContainer container = SeContainerInitializer.newInstance().initialize();			
			IArco arco = container.select(IArco.class).get();
			return arco;
			
			
		} catch (Exception e) {
			// muestra mensajes de error
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public static IArcoConPeso getArcoConPeso() {
		
		try {
			SeContainer container = SeContainerInitializer.newInstance().initialize();			
			IArcoConPeso arco = container.select(IArcoConPeso.class).get();
			return arco;
			
			
		} catch (Exception e) {
			// muestra mensajes de error
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	
}
