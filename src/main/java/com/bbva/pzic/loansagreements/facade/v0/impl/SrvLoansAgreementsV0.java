package com.bbva.pzic.loansagreements.facade.v0.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.servicing.annotations.PATCH;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.pzic.loansagreements.business.ISrvIntLoansAgreements;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.canonic.MembershipData;
import com.bbva.pzic.loansagreements.facade.RegistryIds;
import com.bbva.pzic.loansagreements.facade.v0.ISrvLoansAgreementsV0;
import com.bbva.pzic.loansagreements.facade.v0.mapper.ICreateMembershipMapper;
import com.bbva.pzic.loansagreements.facade.v0.mapper.IListMembershipsMapper;
import com.bbva.pzic.loansagreements.facade.v0.mapper.IModifyMembershipMapper;
import com.bbva.pzic.routine.processing.data.DataProcessingExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@Path("/v0")
@Produces(MediaType.APPLICATION_JSON)
@SN(registryID = "SNPE1800108", logicalID = "loans-agreements")
@VN(vnn = "v0")
@Service
public class SrvLoansAgreementsV0 implements ISrvLoansAgreementsV0, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

    private static final Log LOG = LogFactory.getLog(SrvLoansAgreementsV0.class);

    public HttpHeaders httpHeaders;
    public UriInfo uriInfo;

    @Autowired
    private ISrvIntLoansAgreements srvIntLoansAgreements;

    @Autowired
    private IListMembershipsMapper listMembershipsMapper;

    @Autowired
    private ICreateMembershipMapper createMembershipMapper;

    @Autowired
    private IModifyMembershipMapper modifyMembershipMapper;

    @Autowired
    private DataProcessingExecutor inputDataProcessingExecutor;

    @Autowired
    private DataProcessingExecutor outputDataProcessingExecutor;

    @Override
    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Override
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GET
    @Path("/memberships")
    @SMC(registryID = RegistryIds.SMC_REGISTRY_ID_OF_LIST_MEMBERSHIPS, logicalID = "listMemberships", forcedCatalog = "asoCatalog")
    public ServiceResponse<List<Membership>> listMemberships(
            @QueryParam("membershipType") final String membershipType) {
        LOG.info("----- Invoking service listMemberships -----");

        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("membershipType", membershipType);

        inputDataProcessingExecutor.perform(RegistryIds.SMC_REGISTRY_ID_OF_LIST_MEMBERSHIPS, null, null, queryParam);

        ServiceResponse<List<Membership>> memberships = listMembershipsMapper.mapOut(
                srvIntLoansAgreements.listMemberships(
                        listMembershipsMapper.mapIn(membershipType)));

        outputDataProcessingExecutor.perform(RegistryIds.SMC_REGISTRY_ID_OF_LIST_MEMBERSHIPS, memberships, null, queryParam);

        return memberships;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @POST
    @Path("/memberships")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = RegistryIds.SMC_REGISTRY_ID_OF_CREATE_MEMBERSHIP, logicalID = "createMembership", forcedCatalog = "asoCatalog")
    public Response createMembership(final Membership membership) {
        LOG.info("----- Invoking service createMembership -----");

        inputDataProcessingExecutor.perform(RegistryIds.SMC_REGISTRY_ID_OF_CREATE_MEMBERSHIP, membership, null, null);

        MembershipData membershipData = createMembershipMapper.mapOut(
                srvIntLoansAgreements.createMembership(
                        createMembershipMapper.mapIn(membership)));

        if (membershipData == null)
            return null;

        outputDataProcessingExecutor.perform(RegistryIds.SMC_REGISTRY_ID_OF_CREATE_MEMBERSHIP, membershipData, null, null);

        return Response.status(Response.Status.CREATED).entity(membershipData).build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PATCH
    @Path("/memberships/{membership-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_MEMBERSHIP, logicalID = "modifyMembership", forcedCatalog = "asoCatalog")
    public ServiceResponse<Membership> modifyMembership(
            @PathParam("membership-id") final String membershipId,
            final Membership membership) {
        LOG.info("----- Invoking service modifyMembership -----");

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("membership-id", membershipId);

        inputDataProcessingExecutor.perform(RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_MEMBERSHIP,
                membership, pathParams, null);

        ServiceResponse<Membership> membershipData = modifyMembershipMapper.mapOut(
                srvIntLoansAgreements.modifyMembership(
                        modifyMembershipMapper.mapIn(pathParams.get("membership-id").toString(), membership)));

        outputDataProcessingExecutor.perform(RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_MEMBERSHIP,
                membershipData, pathParams, null);

        return membershipData;
    }
}