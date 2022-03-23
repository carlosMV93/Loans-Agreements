package com.bbva.pzic.loansagreements.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.loansagreements.EntityMock;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.loansagreements.EntityMock.MEMBERSHIP_ID;
import static com.bbva.pzic.loansagreements.EntityMock.STATUS_BACKEND;
import static org.junit.Assert.*;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ModifyMembershipMapperTest {

    @InjectMocks
    private ModifyMembershipMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    @Test
    public void mapInFullTest() throws IOException {
        Membership input = EntityMock.getInstance().getMembership();

        Mockito.when(enumMapper.getBackendValue("loansAgreements.status", input.getStatus()))
                .thenReturn(STATUS_BACKEND);

        InputModifyMembership result = mapper.mapIn(MEMBERSHIP_ID, input);
        assertNotNull(result);
        assertNotNull(result.getMembershipId());
        assertNotNull(result.getMembership().getStatus());


        assertEquals(MEMBERSHIP_ID, result.getMembershipId());
        assertEquals(STATUS_BACKEND, result.getMembership().getStatus());
    }

    @Test
    public void mapInEmptyTest() {
        InputModifyMembership result = mapper.mapIn(MEMBERSHIP_ID, new Membership());
        assertNotNull(result);
        assertNotNull(result.getMembershipId());
        assertNull(result.getMembership());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<Membership> result = mapper.mapOut(new Membership());
        assertNotNull(result);
        assertNotNull(result.getData());
        assertNotNull(result.getMessages());
        assertNull(result.getPagination());

    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<Membership> result = mapper.mapOut(null);
        assertNull(result);
    }
}