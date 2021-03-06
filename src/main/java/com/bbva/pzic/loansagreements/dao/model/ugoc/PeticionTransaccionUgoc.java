package com.bbva.pzic.loansagreements.dao.model.ugoc;

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
 * <p>Transacci&oacute;n <code>UGOC</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionUgoc</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionUgoc</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.UGOC.D1181204.txt
 * UGOCCONSULTA DE PRESTAMOS ADS          US        UG2CUGOCPBDUGPO UGFEGOC             UGOC  NN3000CNNNNN    SSTN    C   SNNSSNNN  NN                2018-11-30XP91621 2018-12-0412.03.24XP91947 2018-11-30-10.00.26.102400XP91621 0001-01-010001-01-01
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGFEGOC.D1181204.txt
 * UGFEGOC �CONSULTA DE PRESTAMO ADS      �F�01�00002�01�00001�TIPAFIL�TIPO DE AFILIACION  �A�002�0�O�        �
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGFSGOC.D1181204.txt
 * UGFSGOC �CONSULTA DE PRESTAMO ADS      �X�07�00048�01�00001�IDAFIL �IDENT. AFILIACION   �A�008�0�S�        �
 * UGFSGOC �CONSULTA DE PRESTAMO ADS      �X�07�00048�02�00009�DESAFIL�DESC. DE AFILIACION �A�020�0�S�        �
 * UGFSGOC �CONSULTA DE PRESTAMO ADS      �X�07�00048�03�00029�TIPAFIL�TIPO DE AFILIACION  �A�002�0�S�        �
 * UGFSGOC �CONSULTA DE PRESTAMO ADS      �X�07�00048�04�00031�TIPOENV�TIPO DE ENVIO       �A�001�0�S�        �
 * UGFSGOC �CONSULTA DE PRESTAMO ADS      �X�07�00048�05�00032�IDEMAIL�IDENT. DE EMAIL     �A�015�0�S�        �
 * UGFSGOC �CONSULTA DE PRESTAMO ADS      �X�07�00048�06�00047�CONMAIL�TIP. DOC. CONTRATO  �A�001�0�S�        �
 * UGFSGOC �CONSULTA DE PRESTAMO ADS      �X�07�00048�07�00048�ESTAFIL�ESTADO AFILIACION   �A�001�0�S�        �
 * FICHERO: PEBD.QGFD.FIX.QGDTFDX.UGOC.D1181204.txt
 * UGOCUGFSGOC UGWFSGOCUG2CUGOC1S                             XP91621 2018-11-30-10.17.33.032935XP91621 2018-11-30-10.17.33.032963
</pre></code>
 *
 * @see RespuestaTransaccionUgoc
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "UGOC",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionUgoc.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoUGFEGOC.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionUgoc implements MensajeMultiparte {

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