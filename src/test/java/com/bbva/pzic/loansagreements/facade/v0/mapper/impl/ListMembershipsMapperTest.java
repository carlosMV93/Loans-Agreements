package com.bbva.pzic.loansagreements.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.loansagreements.EntityMock;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.bbva.pzic.loansagreements.EntityMock.MEMBERSHIP_BACKEND;
import static com.bbva.pzic.loansagreements.EntityMock.MEMBERSHIP_TYPE;
import static org.junit.Assert.*;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ListMembershipsMapperTest {

    @InjectMocks
    private ListMembershipsMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    @Test
    public void mapInFullTest() {
        Mockito.when(enumMapper.getBackendValue("loansAgreements.membershipType", MEMBERSHIP_TYPE))
                .thenReturn(MEMBERSHIP_BACKEND);

        InputListMemberships result = mapper.mapIn(MEMBERSHIP_TYPE);
        assertNotNull(result);
        assertNotNull(result.getMembershipType());
        assertEquals(MEMBERSHIP_BACKEND, result.getMembershipType());
    }

    @Test
    public void mapInEmptyTest() {
        InputListMemberships result = mapper.mapIn(null);
        assertNotNull(result);
        assertNull(result.getMembershipType());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<List<Membership>> result = mapper.mapOut(EntityMock.getInstance().getListMembership());
        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<List<Membership>> result = mapper.mapOut(null);
        assertNull(result);
    }
}