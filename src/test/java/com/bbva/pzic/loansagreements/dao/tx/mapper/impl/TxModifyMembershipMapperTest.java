package com.bbva.pzic.loansagreements.dao.tx.mapper.impl;

import com.bbva.pzic.loansagreements.EntityMock;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGE1;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGS1;
import com.bbva.pzic.loansagreements.dao.model.ugog.mock.FormatsUgogMock;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.loansagreements.EntityMock.MEMBERSHIP_TYPE;
import static com.bbva.pzic.loansagreements.EntityMock.STATUS;
import static org.junit.Assert.*;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxModifyMembershipMapperTest {

    @InjectMocks
    private TxModifyMembershipMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    @Test
    public void mapInFullTest() throws IOException {
        InputModifyMembership input = EntityMock.getInstance().getInputModifyMembership();
        FormatoUGMOGE1 result = mapper.mapIn(input);
        assertNotNull(result);
        assertNotNull(result.getIdafil());
        assertNotNull(result.getEstafil());
        assertEquals(input.getMembershipId(), result.getIdafil());
        assertEquals(input.getMembership().getStatus(), result.getEstafil());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoUGMOGE1 result = mapper.mapIn(new InputModifyMembership());
        assertNotNull(result);
        assertNull(result.getIdafil());
        assertNull(result.getEstafil());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        FormatoUGMOGS1 format = FormatsUgogMock.getInstance().getFormatoUGMOGS1();
        Mockito.when(enumMapper.getEnumValue("loansAgreements.status", format.getEstafil()))
                .thenReturn(STATUS);

        Mockito.when(enumMapper.getEnumValue("loansAgreements.membershipType", format.getTipafil()))
                .thenReturn(MEMBERSHIP_TYPE);

        Membership result = mapper.mapOut(format);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getDescription());
        assertNotNull(result.getMembershipType());
        assertNotNull(result.getStatus());
        assertEquals(format.getIdafil(), result.getId());
        assertEquals(format.getDesafil(), result.getDescription());
        assertEquals(MEMBERSHIP_TYPE, result.getMembershipType());
        assertEquals(STATUS, result.getStatus());
    }

    @Test
    public void mapOutEmptyTest() {
        Membership result = mapper.mapOut(new FormatoUGMOGS1());
        assertNotNull(result);
        assertNull(result.getId());
        assertNull(result.getDescription());
        assertNull(result.getMembershipType());
        assertNull(result.getStatus());
    }
}