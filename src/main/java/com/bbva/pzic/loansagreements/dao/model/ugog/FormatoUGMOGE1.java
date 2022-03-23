package com.bbva.pzic.loansagreements.dao.model.ugog;


import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>UGMOGE1</code> de la transacci&oacute;n <code>UGOG</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGMOGE1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGMOGE1 {

	/**
	 * <p>Campo <code>IDAFIL</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDAFIL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String idafil;

	/**
	 * <p>Campo <code>ESTAFIL</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "ESTAFIL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estafil;

}