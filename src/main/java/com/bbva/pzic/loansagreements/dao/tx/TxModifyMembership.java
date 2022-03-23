package com.bbva.pzic.loansagreements.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGE1;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGS1;
import com.bbva.pzic.loansagreements.dao.model.ugog.PeticionTransaccionUgog;
import com.bbva.pzic.loansagreements.dao.model.ugog.RespuestaTransaccionUgog;
import com.bbva.pzic.loansagreements.dao.tx.mapper.ITxModifyMembershipMapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@Tx("txModifyMembership")
public class TxModifyMembership
        extends SingleOutputFormat<InputModifyMembership, FormatoUGMOGE1, Membership, FormatoUGMOGS1> {

    @Resource(name = "txModifyMembershipMapper")
    private ITxModifyMembershipMapper mapper;

    @Autowired
    public TxModifyMembership(@Qualifier("transaccionUgog") InvocadorTransaccion<PeticionTransaccionUgog, RespuestaTransaccionUgog> transaction) {
        super(transaction, PeticionTransaccionUgog::new, Membership::new, FormatoUGMOGS1.class);
    }

    @Override
    protected FormatoUGMOGE1 mapInput(InputModifyMembership inputModifyMembership) {
        return mapper.mapIn(inputModifyMembership);
    }

    @Override
    protected Membership mapFirstOutputFormat(FormatoUGMOGS1 formatoUGMOGS1, InputModifyMembership inputModifyMembership, Membership membership) {
        return mapper.mapOut(formatoUGMOGS1);
    }
}