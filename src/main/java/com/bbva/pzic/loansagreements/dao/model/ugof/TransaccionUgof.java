package com.bbva.pzic.loansagreements.dao.model.ugof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>UGOF</code>
 * 
 * @see PeticionTransaccionUgof
 * @see RespuestaTransaccionUgof
 */
@Component
public class TransaccionUgof implements InvocadorTransaccion<PeticionTransaccionUgof,RespuestaTransaccionUgof> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionUgof invocar(PeticionTransaccionUgof transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionUgof.class, RespuestaTransaccionUgof.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionUgof invocarCache(PeticionTransaccionUgof transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionUgof.class, RespuestaTransaccionUgof.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}