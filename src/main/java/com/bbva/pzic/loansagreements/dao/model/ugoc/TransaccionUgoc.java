package com.bbva.pzic.loansagreements.dao.model.ugoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>UGOC</code>
 * 
 * @see PeticionTransaccionUgoc
 * @see RespuestaTransaccionUgoc
 */
@Component
public class TransaccionUgoc implements InvocadorTransaccion<PeticionTransaccionUgoc,RespuestaTransaccionUgoc> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionUgoc invocar(PeticionTransaccionUgoc transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionUgoc.class, RespuestaTransaccionUgoc.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionUgoc invocarCache(PeticionTransaccionUgoc transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionUgoc.class, RespuestaTransaccionUgoc.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}