package com.bbva.pzic.loansagreements;

import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.util.mappers.ObjectMapperHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Entelgy
 */
public final class EntityMock {

    public static final String CYPHER_KEY = "SomeHostField";
    public static final String MEMBERSHIP_TYPE = "PAYROLL_ADVANCE";

    public static final String DECRYPT_CONTRACT_ID = "DECYPT_CONTRACT_ID";

    public static final String MEMBERSHIP_ID = "I";

    public static final String MEMBERSHIP_BACKEND = "AS";
    public static final String NUMBERTYPE_ID_BACKEND = "L";
    public static final String PRODUCTTYPE_ID_BACKEND = "C";
    public static final String RELATIONTYPE_ID_BACKEND = "P";
    public static final String DELIVERYTYPE_BACKEND = "D";
    public static final String DOCUMENTTYPE_BACKEND = "C";
    public static final String STATUS_BACKEND = "A";

    public static final String PRODUCTTYPE_ID = "ACCOUNTS";
    public static final String RELATIONTYPE_ID = "RECEIVING_ACCOUNT";
    public static final String DELIVERYTYPE = "PHYSICAL";
    public static final String DOCUMENTTYPE = "CONTRACT";
    public static final String STATUS = "ACTIVE";

    private static final EntityMock INSTANCE = new EntityMock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private EntityMock() {
    }

    public static EntityMock getInstance() {
        return INSTANCE;
    }

    public InputListMemberships getInputListMemberships() {
        InputListMemberships input = new InputListMemberships();
        input.setMembershipType(MEMBERSHIP_TYPE);
        return input;
    }

    public DTOIntMembership getDTOIntMembership() throws IOException {
        return objectMapper.readValue(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("mock/dtoIntMembership.json"),
                DTOIntMembership.class);
    }

    public InputModifyMembership getInputModifyMembership() throws IOException {
        return objectMapper.readValue(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("mock/inputModifyMembership.json"),
                InputModifyMembership.class);
    }

    public List<Membership> getListMembership() {
        List<Membership> list = new ArrayList<>();
        list.add(new Membership());
        return list;
    }

    public Membership getMembership() throws IOException {
        return objectMapper.readValue(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("mock/membership.json"),
                Membership.class);
    }

}