// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.loansagreements.dao.model.ugog;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import java.lang.String;

privileged aspect RespuestaTransaccionUgog_Roo_JavaBean {
    
    public String RespuestaTransaccionUgog.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    public void RespuestaTransaccionUgog.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }
    
    public String RespuestaTransaccionUgog.getCodigoControl() {
        return this.codigoControl;
    }
    
    public void RespuestaTransaccionUgog.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }
    
    public void RespuestaTransaccionUgog.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}