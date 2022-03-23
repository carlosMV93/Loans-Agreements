package com.bbva.pzic.loansagreements.facade.v0.mapper.impl;

import com.bbva.pzic.loansagreements.business.dto.DTOIntDelivery;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.business.dto.DTOIntRelatedContract;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.canonic.MembershipData;
import com.bbva.pzic.loansagreements.facade.RegistryIds;
import com.bbva.pzic.loansagreements.facade.v0.mapper.ICreateMembershipMapper;
import com.bbva.pzic.loansagreements.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import com.bbva.pzic.loansagreements.util.mappers.Mapper;
import com.bbva.pzic.loansagreements.util.orika.MapperFactory;
import com.bbva.pzic.loansagreements.util.orika.impl.ConfigurableMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@Mapper
public class CreateMembershipMapper extends ConfigurableMapper
        implements ICreateMembershipMapper {

    private static final Log LOG = LogFactory.getLog(CreateMembershipMapper.class);

    @Autowired
    private EnumMapper mapper;

    @Autowired
    private AbstractCypherTool cypherTool;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(Membership.class, DTOIntMembership.class)
                .field("membershipType", "membershipType")
                .field("relatedContracts[0].contractId", "relatedContracts[0].contractId")
                .field("relatedContracts[0].number", "relatedContracts[0].number")
                .field("relatedContracts[0].numberType.id", "relatedContracts[0].numberType.id")
                .field("relatedContracts[0].product.id", "relatedContracts[0].product.id")
                .field("relatedContracts[0].product.productType.id", "relatedContracts[0].product.productType.id")
                .field("relatedContracts[0].product.relationType.id", "relatedContracts[0].product.relationType.id")
                .field("deliveries[0].deliveryType", "deliveries[0].deliveryType")
                .field("deliveries[0].documentType", "deliveries[0].documentType")
                .field("deliveries[0].contactDetails[0].id", "deliveries[0].contactDetails[0].id")
                .register();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntMembership mapIn(final Membership membership) {
        LOG.info("... called method CreateMembershipMapper.mapIn ...");
        DTOIntMembership dtoInt = map(membership, DTOIntMembership.class);
        if (dtoInt.getRelatedContracts() != null &&
                !dtoInt.getRelatedContracts().isEmpty()) {

            if (dtoInt.getRelatedContracts().get(0).getContractId() != null) {
                dtoInt.getRelatedContracts().get(0).setContractId(cypherTool.decrypt(dtoInt.getRelatedContracts().get(0).getContractId(), AbstractCypherTool.ACCOUNT_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_MEMBERSHIP));
            }

            enumMapInRelatedContracts(dtoInt.getRelatedContracts());
        }
        dtoInt.setMembershipType(mapper
                .getBackendValue("loansAgreements.membershipType", membership.getMembershipType()));

        enumMapDeliveries(dtoInt.getDeliveries());
        return dtoInt;
    }

    private void enumMapInRelatedContracts(List<DTOIntRelatedContract> relatedContracts) {

        if (CollectionUtils.isEmpty(relatedContracts)) {
            return;
        }

        for (DTOIntRelatedContract dtoIntRelatedContract : relatedContracts) {
            if (dtoIntRelatedContract.getNumberType() != null) {
                dtoIntRelatedContract.getNumberType().setId(mapper
                        .getBackendValue("loansAgreements.numberType.id", dtoIntRelatedContract.getNumberType().getId()));
            }

            if (dtoIntRelatedContract.getProduct() != null) {

                if (dtoIntRelatedContract.getProduct().getProductType() != null) {
                    dtoIntRelatedContract.getProduct().getProductType().setId(mapper
                            .getBackendValue("loansAgreements.product.productType.id",
                                    dtoIntRelatedContract.getProduct().getProductType().getId()));
                }
                if (dtoIntRelatedContract.getProduct().getRelationType() != null) {
                    dtoIntRelatedContract.getProduct().getRelationType().setId(mapper
                            .getBackendValue("loansAgreements.product.relationType.id",
                                    dtoIntRelatedContract.getProduct().getRelationType().getId()));
                }

            }
        }
    }

    private void enumMapDeliveries(List<DTOIntDelivery> deliveries) {

        if (CollectionUtils.isEmpty(deliveries)) {
            return;
        }

        for (DTOIntDelivery dtoIntDelivery : deliveries) {
            dtoIntDelivery.setDeliveryType(mapper
                    .getBackendValue("loansAgreements.deliveryType", dtoIntDelivery.getDeliveryType()));

            dtoIntDelivery.setDocumentType(mapper
                    .getBackendValue("loansAgreements.documentType", dtoIntDelivery.getDocumentType()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MembershipData mapOut(final Membership membership) {
        LOG.info("... called method CreateMembershipMapper.mapOut ...");
        if (membership == null) {
            return null;
        }

        MembershipData data = new MembershipData();
        data.setData(membership);

        return data;
    }

}