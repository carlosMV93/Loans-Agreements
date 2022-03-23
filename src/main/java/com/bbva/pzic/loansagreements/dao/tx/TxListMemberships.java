package com.bbva.pzic.loansagreements.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFEGOC;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFSGOC;
import com.bbva.pzic.loansagreements.dao.model.ugoc.PeticionTransaccionUgoc;
import com.bbva.pzic.loansagreements.dao.model.ugoc.RespuestaTransaccionUgoc;
import com.bbva.pzic.loansagreements.dao.tx.mapper.ITxListMembershipsMapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@Tx("txListMemberships")
public class TxListMemberships
        extends SingleOutputFormat<InputListMemberships, FormatoUGFEGOC, List<Membership>, FormatoUGFSGOC> {

    @Resource(name = "txListMembershipsMapper")
    private ITxListMembershipsMapper mapper;

    @Autowired
    public TxListMemberships(@Qualifier("transaccionUgoc") InvocadorTransaccion<PeticionTransaccionUgoc, RespuestaTransaccionUgoc> transaction) {
        super(transaction, PeticionTransaccionUgoc::new, ArrayList::new, FormatoUGFSGOC.class);
    }

    @Override
    protected FormatoUGFEGOC mapInput(InputListMemberships inputListMemberships) {
        return mapper.mapIn(inputListMemberships);
    }

    @Override
    protected List<Membership> mapFirstOutputFormat(FormatoUGFSGOC formatoUGFSGOC, InputListMemberships inputListMemberships, List<Membership> memberships) {
        return mapper.mapOut(formatoUGFSGOC);
    }


}