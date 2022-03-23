package com.bbva.pzic.loansagreements.dao.model.ugof.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFE1;
import com.bbva.pzic.loansagreements.dao.model.ugof.PeticionTransaccionUgof;
import com.bbva.pzic.loansagreements.dao.model.ugof.RespuestaTransaccionUgof;
import com.bbva.pzic.loansagreements.util.Errors;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionUgof")
public class TransaccionUgofMock
        implements InvocadorTransaccion<PeticionTransaccionUgof, RespuestaTransaccionUgof> {

    public static final String TEST_EMPTY = "6666";
    public static final String TEST_NO_RESPONSE = "9999";

    @Override
    public RespuestaTransaccionUgof invocar(PeticionTransaccionUgof peticion) throws ExcepcionTransaccion {
        RespuestaTransaccionUgof response= new RespuestaTransaccionUgof();
        response.setCodigoRetorno("OK_COMMIT");
        response.setCodigoControl("OK");

        FormatoUGMOFE1 format = peticion.getCuerpo().getParte(FormatoUGMOFE1.class);
        String nropro = format.getNropro();

        try {

            if(StringUtils.isEmpty(nropro)){
                response.getCuerpo().getPartes().add(this.buildData(FormatsUgofMock.getInstance().getFormatoUGMOFS1()));
                return response;
            }


            switch (nropro) {
                case TEST_NO_RESPONSE:
                    return response;
                case TEST_EMPTY:
                    response.getCuerpo().getPartes().add(this.buildData(FormatsUgofMock.getInstance().getFormatoUGMOFS1Empty()));
                    return response;
                default:
                    response.getCuerpo().getPartes().add(this.buildData(FormatsUgofMock.getInstance().getFormatoUGMOFS1()));
                   return response;
            }
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }

    }

    @Override
    public RespuestaTransaccionUgof invocarCache(PeticionTransaccionUgof peticionTransaccionUgof) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }

    private CopySalida buildData(Object object) {
        CopySalida copy = new CopySalida();
        copy.setCopy(object);
        return copy;
    }


}
