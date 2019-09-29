package grafos.fabrica.cdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import grafos.IArco;
import grafos.ITipoBusqueda;
public class FabricaBusqueda {
	

	public static ITipoBusqueda getTipoBusqueda() {
		
		try {
			SeContainer container = SeContainerInitializer.newInstance().initialize();			
			ITipoBusqueda tipoBusqueda = container.select(ITipoBusqueda.class).get();
			return tipoBusqueda;
			
			
		} catch (Exception e) {
			// muestra mensajes de error
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
