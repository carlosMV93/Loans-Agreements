package com.bbva.pzic.loansagreements.dao.model.ugog;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>UGMOGS1</code> de la transacci&oacute;n <code>UGOG</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGMOGS1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGMOGS1 {

	/**
	 * <p>Campo <code>IDAFIL</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDAFIL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String idafil;

	/**
	 * <p>Campo <code>DESAFIL</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "DESAFIL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String desafil;

	/**
	 * <p>Campo <code>TIPAFIL</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "TIPAFIL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipafil;

	/**
	 * <p>Campo <code>ESTAFIL</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "ESTAFIL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estafil;

}