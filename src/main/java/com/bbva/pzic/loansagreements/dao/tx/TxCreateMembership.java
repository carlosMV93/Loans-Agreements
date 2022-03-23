package com.bbva.pzic.loansagreements.dao.tx;

import com.bbva.pzic.loansagreements.dao.tx.mapper.ITxCreateMembershipMapper;
import javax.annotation.Resource;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFE1;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFS1;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.loansagreements.dao.model.ugof.PeticionTransaccionUgof;
import com.bbva.pzic.loansagreements.dao.model.ugof.RespuestaTransaccionUgof;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
@Tx("txCreateMembership")
public class TxCreateMembership extends SingleOutputFormat<DTOIntMembership, FormatoUGMOFE1, Membership, FormatoUGMOFS1> {

	@Resource(name = "txCreateMembershipMapper")
	private ITxCreateMembershipMapper mapper;

	@Autowired
	public TxCreateMembership(@Qualifier("transaccionUgof") InvocadorTransaccion<PeticionTransaccionUgof,RespuestaTransaccionUgof> transaction) {
		super(transaction, PeticionTransaccionUgof::new, Membership::new, FormatoUGMOFS1.class);
	}

	@Override
	protected FormatoUGMOFE1 mapInput(DTOIntMembership dtoIntMembership) {
		return mapper.mapIn(dtoIntMembership);
	}

	@Override
	protected Membership mapFirstOutputFormat(FormatoUGMOFS1 formatoUGMOFS1, DTOIntMembership dtoIntMembership, Membership membership) {
		return mapper.mapOut(formatoUGMOFS1);
	}
}