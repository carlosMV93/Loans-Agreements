// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.loansagreements.dao.model.ugof;

import java.lang.String;

privileged aspect FormatoUGMOFS1_Roo_ToString {
    
    public String FormatoUGMOFS1.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cccvin: ").append(getCccvin()).append(", ");
        sb.append("Conmail: ").append(getConmail()).append(", ");
        sb.append("Desafil: ").append(getDesafil()).append(", ");
        sb.append("Estafil: ").append(getEstafil()).append(", ");
        sb.append("Idafil: ").append(getIdafil()).append(", ");
        sb.append("Idemail: ").append(getIdemail()).append(", ");
        sb.append("Idvin: ").append(getIdvin()).append(", ");
        sb.append("Nropro: ").append(getNropro()).append(", ");
        sb.append("Tipafil: ").append(getTipafil()).append(", ");
        sb.append("Tipcvin: ").append(getTipcvin()).append(", ");
        sb.append("Tipoenv: ").append(getTipoenv()).append(", ");
        sb.append("Tiprel: ").append(getTiprel()).append(", ");
        sb.append("Tipvin: ").append(getTipvin());
        return sb.toString();
    }
    
}