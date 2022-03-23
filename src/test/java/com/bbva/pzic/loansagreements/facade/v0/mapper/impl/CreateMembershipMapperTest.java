package com.bbva.pzic.loansagreements.facade.v0.mapper.impl;

import com.bbva.pzic.loansagreements.EntityMock;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.canonic.MembershipData;
import com.bbva.pzic.loansagreements.facade.RegistryIds;
import com.bbva.pzic.loansagreements.util.encrypt.AbstractCypherTool;
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
public class CreateMembershipMapperTest {

    @InjectMocks
    private CreateMembershipMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    @Mock
    private AbstractCypherTool cypherTool;

    @Test
    public void mapInFullTest() throws IOException {
        Membership input = EntityMock.getInstance().getMembership();

        Mockito.when(enumMapper.getBackendValue("loansAgreements.membershipType", input.getMembershipType()))
                .thenReturn(MEMBERSHIP_BACKEND);

        Mockito.when(enumMapper.getBackendValue("loansAgreements.numberType.id", input.getRelatedContracts().get(0).getNumberType().getId()))
                .thenReturn(NUMBERTYPE_ID_BACKEND);

        Mockito.when(enumMapper.getBackendValue("loansAgreements.product.productType.id", input.getRelatedContracts().get(0).getProduct().getProductType().getId()))
                .thenReturn(PRODUCTTYPE_ID_BACKEND);

        Mockito.when(enumMapper.getBackendValue("loansAgreements.product.relationType.id", input.getRelatedContracts().get(0).getProduct().getRelationType().getId()))
                .thenReturn(RELATIONTYPE_ID_BACKEND);

        Mockito.when(enumMapper.getBackendValue("loansAgreements.deliveryType", input.getDeliveries().get(0).getDeliveryType()))
                .thenReturn(DELIVERYTYPE_BACKEND);

        Mockito.when(enumMapper.getBackendValue("loansAgreements.documentType", input.getDeliveries().get(0).getDocumentType()))
                .thenReturn(DOCUMENTTYPE_BACKEND);

        Mockito.when(cypherTool.decrypt(Mockito.anyString(), Mockito.eq(AbstractCypherTool.ACCOUNT_ID), Mockito.eq(RegistryIds.SMC_REGISTRY_ID_OF_CREATE_MEMBERSHIP))).thenReturn(DECRYPT_CONTRACT_ID);

        DTOIntMembership result = mapper.mapIn(input);
        assertNotNull(result);
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

        assertEquals(MEMBERSHIP_BACKEND, result.getMembershipType());
        assertEquals(DECRYPT_CONTRACT_ID, result.getRelatedContracts().get(0).getContractId());
        assertEquals(input.getRelatedContracts().get(0).getNumber(), result.getRelatedContracts().get(0).getNumber());
        assertEquals(NUMBERTYPE_ID_BACKEND, result.getRelatedContracts().get(0).getNumberType().getId());
        assertEquals(input.getRelatedContracts().get(0).getProduct().getId(), result.getRelatedContracts().get(0).getProduct().getId());
        assertEquals(PRODUCTTYPE_ID_BACKEND, result.getRelatedContracts().get(0).getProduct().getProductType().getId());
        assertEquals(RELATIONTYPE_ID_BACKEND, result.getRelatedContracts().get(0).getProduct().getRelationType().getId());
        assertEquals(DELIVERYTYPE_BACKEND, result.getDeliveries().get(0).getDeliveryType());
        assertEquals(DOCUMENTTYPE_BACKEND, result.getDeliveries().get(0).getDocumentType());
        assertEquals(input.getDeliveries().get(0).getContactDetails().get(0).getId(), result.getDeliveries().get(0).getContactDetails().get(0).getId());
    }

    @Test
    public void mapInFullRelatedContractsFieldsPartialNullTest() throws IOException {
        Membership input = EntityMock.getInstance().getMembership();
        input.getRelatedContracts().get(0).setNumber(null);
        input.getRelatedContracts().get(0).setProduct(null);

        Mockito.when(enumMapper.getBackendValue("loansAgreements.numberType.id", input.getRelatedContracts().get(0).getNumberType().getId()))
                .thenReturn(NUMBERTYPE_ID_BACKEND);

        Mockito.when(cypherTool.decrypt(Mockito.anyString(), Mockito.eq(AbstractCypherTool.ACCOUNT_ID), Mockito.eq(RegistryIds.SMC_REGISTRY_ID_OF_CREATE_MEMBERSHIP))).thenReturn(DECRYPT_CONTRACT_ID);

        DTOIntMembership result = mapper.mapIn(input);
        assertNotNull(result);
        assertNotNull(result.getRelatedContracts().get(0).getContractId());
        assertNull(result.getRelatedContracts().get(0).getNumber());
        assertNotNull(result.getRelatedContracts().get(0).getNumberType().getId());
        assertNull(result.getRelatedContracts().get(0).getProduct());

        assertEquals(DECRYPT_CONTRACT_ID, result.getRelatedContracts().get(0).getContractId());
        assertEquals(NUMBERTYPE_ID_BACKEND, result.getRelatedContracts().get(0).getNumberType().getId());

    }

    @Test
    public void mapInEmptyTest() {
        DTOIntMembership result = mapper.mapIn(new Membership());
        assertNotNull(result);
        assertNull(result.getMembershipType());
        assertNull(result.getRelatedContracts());
        assertNull(result.getDeliveries());
    }

    @Test
    public void mapOutFullTest() {
        MembershipData result = mapper.mapOut(new Membership());
        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        MembershipData result = mapper.mapOut(null);
        assertNull(result);
    }
}