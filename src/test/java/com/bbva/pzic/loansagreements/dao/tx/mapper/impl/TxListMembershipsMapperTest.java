package com.bbva.pzic.loansagreements.dao.tx.mapper.impl;

import com.bbva.pzic.loansagreements.EntityMock;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFEGOC;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFSGOC;
import com.bbva.pzic.loansagreements.dao.model.ugoc.mock.FormatsUgocMock;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static com.bbva.pzic.loansagreements.EntityMock.*;
import static org.junit.Assert.*;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxListMembershipsMapperTest {

    @InjectMocks
    private TxListMembershipsMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    @Test
    public void mapInFullTest() {
        InputListMemberships input = EntityMock.getInstance().getInputListMemberships();
        FormatoUGFEGOC result = mapper.mapIn(input);
        assertNotNull(result);
        assertNotNull(result.getTipafil());
        assertEquals(input.getMembershipType(), result.getTipafil());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoUGFEGOC result = mapper.mapIn(new InputListMemberships());
        assertNotNull(result);
        assertNull(result.getTipafil());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        FormatoUGFSGOC format = FormatsUgocMock.getInstance().getFormatoUGFSGOC().get(0);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.membershipType", format.getTipafil()))
                .thenReturn(MEMBERSHIP_TYPE);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.deliveryType", format.getTipoenv()))
                .thenReturn(DELIVERYTYPE);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.documentType", format.getConmail()))
                .thenReturn(DOCUMENTTYPE);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.status", format.getEstafil()))
                .thenReturn(STATUS);

        List<Membership> membershipList = mapper.mapOut(format);
        Membership  result = membershipList.get(0);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getDescription());
        assertNotNull(result.getMembershipType());
        assertNotNull(result.getDeliveries().get(0).getDeliveryType());
        assertNotNull(result.getDeliveries().get(0).getDocumentType());
        assertNotNull(result.getDeliveries().get(0).getContactDetails().get(0).getId());
        assertNotNull(result.getStatus());
        assertEquals(format.getIdafil(), result.getId());
        assertEquals(format.getDesafil(), result.getDescription());
        assertEquals(MEMBERSHIP_TYPE, result.getMembershipType());
        assertEquals(DELIVERYTYPE, result.getDeliveries().get(0).getDeliveryType());
        assertEquals(DOCUMENTTYPE, result.getDeliveries().get(0).getDocumentType());
        assertEquals(format.getIdemail(), result.getDeliveries().get(0).getContactDetails().get(0).getId());
        assertEquals(STATUS, result.getStatus());
    }

    @Test
    public void mapOutEmptyTest() {
        List<Membership> result = mapper.mapOut(new FormatoUGFSGOC());

        assertNotNull(result);
        assertNull(result.get(0).getId());
        assertNull(result.get(0).getDescription());
        assertNull(result.get(0).getMembershipType());
        assertNull(result.get(0).getDeliveries());
        assertNull(result.get(0).getStatus());
    }
}