package com.bbva.pzic.loansagreements.dao.model.ugoc;


import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>UGFEGOC</code> de la transacci&oacute;n <code>UGOC</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGFEGOC")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGFEGOC {

	/**
	 * <p>Campo <code>TIPAFIL</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "TIPAFIL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipafil;

}