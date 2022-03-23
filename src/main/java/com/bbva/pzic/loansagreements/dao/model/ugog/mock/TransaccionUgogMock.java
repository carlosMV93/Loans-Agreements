package com.bbva.pzic.loansagreements.dao.model.ugog.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGE1;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGS1;
import com.bbva.pzic.loansagreements.dao.model.ugog.PeticionTransaccionUgog;
import com.bbva.pzic.loansagreements.dao.model.ugog.RespuestaTransaccionUgog;
import com.bbva.pzic.loansagreements.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionUgog")
public class TransaccionUgogMock
        implements InvocadorTransaccion<PeticionTransaccionUgog, RespuestaTransaccionUgog> {

    public static final String TEST_EMPTY = "6666";
    public static final String TEST_NO_RESPONSE = "9999";

    @Override
    public RespuestaTransaccionUgog invocar(PeticionTransaccionUgog peticion) throws ExcepcionTransaccion {
        RespuestaTransaccionUgog response = new RespuestaTransaccionUgog();
        response.setCodigoRetorno("OK_COMMIT");
        response.setCodigoControl("OK");

        FormatoUGMOGE1 formatoUGMOGE1 = peticion.getCuerpo().getParte(FormatoUGMOGE1.class);

        String membershipId = formatoUGMOGE1.getIdafil();
        try {
            switch (membershipId) {
                case TEST_NO_RESPONSE:
                    return response;
                case TEST_EMPTY:
                    response.getCuerpo().getPartes().add(this.buildData(new FormatoUGMOGS1()));
                    return response;
                default:
                    response.getCuerpo().getPartes().add(this.buildData(FormatsUgogMock.getInstance().getFormatoUGMOGS1()));
                    return response;
            }
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    @Override
    public RespuestaTransaccionUgog invocarCache(PeticionTransaccionUgog peticionTransaccionUgog) throws ExcepcionTransaccion {
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