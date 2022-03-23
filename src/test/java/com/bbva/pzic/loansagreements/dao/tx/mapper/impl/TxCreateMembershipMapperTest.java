package com.bbva.pzic.loansagreements.dao.tx.mapper.impl;

import com.bbva.pzic.loansagreements.EntityMock;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFE1;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFS1;
import com.bbva.pzic.loansagreements.dao.model.ugof.mock.FormatsUgofMock;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.loansagreements.EntityMock.*;
import static org.junit.Assert.*;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxCreateMembershipMapperTest {

    @InjectMocks
    private TxCreateMembershipMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    @Test
    public void mapInFullTest() throws IOException {
        DTOIntMembership input = EntityMock.getInstance().getDTOIntMembership();
        FormatoUGMOFE1 result = mapper.mapIn(input);
        assertNotNull(result);
        assertNotNull(result.getTipafil());
        assertNotNull(result.getCccvin());
        assertNotNull(result.getNropro());
        assertNotNull(result.getTipcvin());
        assertNotNull(result.getIdvin());
        assertNotNull(result.getTipvin());
        assertNotNull(result.getTiprel());
        assertNotNull(result.getTipoenv());
        assertNotNull(result.getConmail());
        assertNotNull(result.getIdemail());
        assertEquals(input.getMembershipType(), result.getTipafil());
        assertEquals(input.getRelatedContracts().get(0).getContractId(), result.getCccvin());
        assertEquals(input.getRelatedContracts().get(0).getNumber(), result.getNropro());
        assertEquals(input.getRelatedContracts().get(0).getNumberType().getId(), result.getTipcvin());
        assertEquals(input.getRelatedContracts().get(0).getProduct().getId(), result.getIdvin());
        assertEquals(input.getRelatedContracts().get(0).getProduct().getProductType().getId(), result.getTipvin());
        assertEquals(input.getRelatedContracts().get(0).getProduct().getRelationType().getId(), result.getTiprel());
        assertEquals(input.getDeliveries().get(0).getDeliveryType(), result.getTipoenv());
        assertEquals(input.getDeliveries().get(0).getDocumentType(), result.getConmail());
        assertEquals(input.getDeliveries().get(0).getContactDetails().get(0).getId(), result.getIdemail());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoUGMOFE1 result = mapper.mapIn(new DTOIntMembership());
        assertNotNull(result);
        assertNull(result.getTipafil());
        assertNull(result.getCccvin());
        assertNull(result.getNropro());
        assertNull(result.getTipcvin());
        assertNull(result.getIdvin());
        assertNull(result.getTipvin());
        assertNull(result.getTiprel());
        assertNull(result.getTipoenv());
        assertNull(result.getConmail());
        assertNull(result.getIdemail());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        FormatoUGMOFS1 format = FormatsUgofMock.getInstance().getFormatoUGMOFS1();

        Mockito.when(enumMapper.getEnumValue("loansAgreements.membershipType", format.getTipafil()))
                .thenReturn(MEMBERSHIP_TYPE);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.product.productType.id", format.getTipvin()))
                .thenReturn(PRODUCTTYPE_ID);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.product.relationType.id", format.getTiprel()))
                .thenReturn(RELATIONTYPE_ID);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.deliveryType", format.getTipoenv()))
                .thenReturn(DELIVERYTYPE);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.documentType", format.getConmail()))
                .thenReturn(DOCUMENTTYPE);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.status", format.getEstafil()))
                .thenReturn(STATUS);

        Membership result = mapper.mapOut(format);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getDescription());
        assertNotNull(result.getMembershipType());
        assertNotNull(result.getRelatedContracts().get(0).getContractId());
        assertNotNull(result.getRelatedContracts().get(0).getNumber());
        assertNotNull(result.getRelatedContracts().get(0).getNumberType().getId());
        assertNotNull(result.getRelatedContracts().get(0).getProduct().getId());
        assertNotNull(result.getRelatedContracts().get(0).getProduct().getProductType().getId());
        assertNotNull(result.getRelatedContracts().get(0).getProduct().getRelationType().getId());
        assertNotNull(result.getDeliveries().get(0).getDeliveryType());
        assertNotNull(result.getDeliveries().get(0).getDocumentType());
        assertNotNull(result.getDeliveries().get(0).getContactDetails().get(0).getId());
        assertNotNull(result.getStatus());

        assertEquals(format.getIdafil(), result.getId());
        assertEquals(format.getDesafil(), result.getDescription());
        assertEquals(MEMBERSHIP_TYPE, result.getMembershipType());
        assertEquals(format.getCccvin(), result.getRelatedContracts().get(0).getContractId());
        assertEquals(format.getNropro(), result.getRelatedContracts().get(0).getNumber());
        assertEquals(format.getTipcvin(), result.getRelatedContracts().get(0).getNumberType().getId());
        assertEquals(format.getIdvin(), result.getRelatedContracts().get(0).getProduct().getId());
        assertEquals(PRODUCTTYPE_ID, result.getRelatedContracts().get(0).getProduct().getProductType().getId());
        assertEquals(RELATIONTYPE_ID, result.getRelatedContracts().get(0).getProduct().getRelationType().getId());
        assertEquals(DELIVERYTYPE, result.getDeliveries().get(0).getDeliveryType());
        assertEquals(DOCUMENTTYPE, result.getDeliveries().get(0).getDocumentType());
        assertEquals(format.getIdemail(), result.getDeliveries().get(0).getContactDetails().get(0).getId());
        assertEquals(STATUS, result.getStatus());
    }

    @Test
    public void mapOutEmptyTest() {
        Membership result = mapper.mapOut(new FormatoUGMOFS1());
        assertNotNull(result);
        assertNull(result.getId());
        assertNull(result.getDescription());
        assertNull(result.getMembershipType());
        assertNull(result.getRelatedContracts());
        assertNull(result.getDeliveries());
        assertNull(result.getStatus());
    }
}