package com.bbva.pzic.loansagreements.dao.model.ugof;

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
 * <p>Transacci&oacute;n <code>UGOF</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionUgof</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionUgof</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.UGOF.D1181204.txt
 * UGOFAFILIACION PRESTAMOS ADS           US        UG2CUGOFPBDUGPO UGMOFE1             UGOF  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2018-11-29XP91947 2018-12-0412.03.45XP91947 2018-11-29-16.10.37.579109XP91947 0001-01-010001-01-01
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMOFE1.D1181204.txt
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�01�00001�TIPAFIL�TIPO DE AFILIACION  �A�002�0�R�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�02�00003�CCCVIN �IDENTIF. CONTRATO   �A�020�0�O�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�03�00023�NROPRO �NRO DEL PRODUCTO    �A�020�0�O�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�04�00043�TIPCVIN�TIPO NUMERO CONTRATO�A�001�0�O�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�05�00044�IDVIN  �IDENT.PRODUC.RELAC. �A�002�0�O�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�06�00046�TIPVIN �TIPO PRODUC.RELAC.  �A�001�0�O�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�07�00047�TIPREL �TIPO RELAC.CONTRATO �A�001�0�O�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�08�00048�TIPOENV�FORMA ENVIO CONTRATO�A�001�0�R�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�09�00049�IDEMAIL�IDENT.EMAIL DEL CLTE�A�015�0�O�        �
 * UGMOFE1 �AFILIACION DE PRESTAMO ADS    �F�10�00064�10�00064�CONMAIL�DOC.ENVIAR CONTRATO �A�001�0�O�        �
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMOFS1.D1181204.txt
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�01�00001�IDAFIL �IDENTIF. AFILIACION �A�008�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�02�00009�DESAFIL�IDENTIF. AFILIACION �A�020�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�03�00029�TIPAFIL�TIPO DE AFILIACION  �A�002�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�04�00031�CCCVIN �IDENT.CONTRATO REL. �A�020�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�05�00051�NROPRO �NUMERO DEL PRODUCTO �A�020�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�06�00071�TIPCVIN�TIPO NUMERO CONTRATO�A�001�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�07�00072�IDVIN  �IDENT.PRODUCTO RELAC�A�002�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�08�00074�TIPVIN �TIPO PRODUCTO RELAC �A�001�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�09�00075�TIPREL �TIPO RELACION CONTR.�A�001�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�10�00076�TIPOENV�FORMA ENVIO CONTRATO�A�001�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�11�00077�IDEMAIL�IDENT. EMAIL CLIENTE�A�015�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�12�00092�CONMAIL�TIPO DOC. A ENVIAR  �A�001�0�S�        �
 * UGMOFS1 �AFILIACION DE PRESTAMO ADS    �X�13�00093�13�00093�ESTAFIL�ESTADO DE AFILIACION�A�001�0�S�        �
 * FICHERO: PEBD.QGFD.FIX.QGDTFDX.UGOF.D1181204.txt
 * UGOFUGMOFS1 UGWCOFS1UG2CUGOF1S                             XP91947 2018-11-29-17.20.19.657546XP91947 2018-11-29-17.20.19.657579
</pre></code>
 *
 * @see RespuestaTransaccionUgof
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "UGOF",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionUgof.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoUGMOFE1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionUgof implements MensajeMultiparte {

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