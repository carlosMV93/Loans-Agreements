package com.bbva.pzic.loansagreements.dao.model.ugog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>UGOG</code>
 * 
 * @see PeticionTransaccionUgog
 * @see RespuestaTransaccionUgog
 */
@Component
public class TransaccionUgog implements InvocadorTransaccion<PeticionTransaccionUgog,RespuestaTransaccionUgog> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionUgog invocar(PeticionTransaccionUgog transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionUgog.class, RespuestaTransaccionUgog.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionUgog invocarCache(PeticionTransaccionUgog transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionUgog.class, RespuestaTransaccionUgog.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}