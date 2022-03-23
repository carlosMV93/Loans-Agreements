package com.bbva.pzic.loansagreements.dao.model.ugoc.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFEGOC;
import com.bbva.pzic.loansagreements.dao.model.ugoc.PeticionTransaccionUgoc;
import com.bbva.pzic.loansagreements.dao.model.ugoc.RespuestaTransaccionUgoc;
import com.bbva.pzic.loansagreements.util.Errors;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionUgoc")
public class TransaccionUgocMock
        implements InvocadorTransaccion<PeticionTransaccionUgoc, RespuestaTransaccionUgoc> {

    public static final String TEST_EMPTY = "66";
    public static final String TEST_NO_RESPONSE = "99";

    @Override
    public RespuestaTransaccionUgoc invocar(PeticionTransaccionUgoc peticion) {
        RespuestaTransaccionUgoc response = new RespuestaTransaccionUgoc();
        response.setCodigoRetorno("OK_COMMIT");
        response.setCodigoControl("OK");

        FormatoUGFEGOC format = peticion.getCuerpo().getParte(FormatoUGFEGOC.class);
        String tipafil = format.getTipafil();

        try {
            if (StringUtils.isEmpty(tipafil)) {
                response.getCuerpo().getPartes().add(this.buildData(FormatsUgocMock.getInstance().getFormatoUGFSGOC().get(0)));
                response.getCuerpo().getPartes().add(this.buildData(FormatsUgocMock.getInstance().getFormatoUGFSGOC().get(1)));
                response.getCuerpo().getPartes().add(this.buildData(FormatsUgocMock.getInstance().getFormatoUGFSGOC().get(2)));
                return response;
            }

            switch (tipafil) {
                case TEST_NO_RESPONSE:
                    return response;
                case TEST_EMPTY:
                    response.getCuerpo().getPartes().add(this.buildData(FormatsUgocMock.getInstance().getFormatoUGFSGOC().get(3)));
                    return response;
                default:
                    response.getCuerpo().getPartes().add(this.buildData(FormatsUgocMock.getInstance().getFormatoUGFSGOC().get(0)));
                    response.getCuerpo().getPartes().add(this.buildData(FormatsUgocMock.getInstance().getFormatoUGFSGOC().get(1)));
                    response.getCuerpo().getPartes().add(this.buildData(FormatsUgocMock.getInstance().getFormatoUGFSGOC().get(2)));
                    return response;
            }
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    @Override
    public RespuestaTransaccionUgoc invocarCache(PeticionTransaccionUgoc peticionTransaccionUgoc) {
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
