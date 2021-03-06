package com.bbva.pzic.loansagreements.dao.model.ugog;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.Transaccion;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

/**
 * <p>Transacci&oacute;n <code>UGOG</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionUgog</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionUgog</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.UGOG.D1181204.txt
 * UGOGDESAFILIACION PRESTAMOS ADS        US        UG2CUGOGPBDUGPO UGMOGE1             UGOG  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2018-12-01XP91947 2018-12-0412.05.23XP91947 2018-12-01-16.57.35.661946XP91947 0001-01-010001-01-01
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMOGE1.D1181204.txt
 * UGMOGE1 �AFILIACION DE PRESTAMO ADS    �F�02�00009�01�00001�IDAFIL �IDENT.DE AFILIACION �A�008�0�R�        �
 * UGMOGE1 �AFILIACION DE PRESTAMO ADS    �F�02�00009�02�00009�ESTAFIL�ESTADO DE AFIIACION �A�001�0�R�        �
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMOGS1.D1181204.txt
 * UGMOGS1 �DESAFILIACION DE PRESTAMO ADS �X�04�00031�01�00001�IDAFIL �IDENTIF. AFILIACION �A�008�0�S�        �
 * UGMOGS1 �DESAFILIACION DE PRESTAMO ADS �X�04�00031�02�00009�DESAFIL�IDENTIF. AFILIACION �A�020�0�S�        �
 * UGMOGS1 �DESAFILIACION DE PRESTAMO ADS �X�04�00031�03�00029�TIPAFIL�TIPO DE AFILIACION  �A�002�0�S�        �
 * UGMOGS1 �DESAFILIACION DE PRESTAMO ADS �X�04�00031�04�00031�ESTAFIL�ESTADO DE AFILIACION�A�001�0�S�        �
 * FICHERO: PEBD.QGFD.FIX.QGDTFDX.UGOG.D1181204.txt
 * UGOGUGMOGS1 UGWCOGS1UG2CUGOG1S                             XP91947 2018-12-01-17.12.43.008789XP91947 2018-12-01-17.12.43.008815
</pre></code>
 *
 * @see RespuestaTransaccionUgog
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "UGOG",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionUgog.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoUGMOGE1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionUgog implements MensajeMultiparte {

	/**
	 * <p>Cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Cuerpo
	private CuerpoMultiparte cuerpo = new CuerpoMultiparte();

	/**
	 * <p>Permite obtener el cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Override
	public CuerpoMultiparte getCuerpo() {
		return cuerpo;
	}

}