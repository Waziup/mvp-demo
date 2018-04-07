package com.apps.waziup.domain.services.api;

import com.apps.waziup.domain.services.model.Entity;
import com.apps.waziup.domain.services.model.EntityAttr;
import com.apps.waziup.domain.services.model.EntityWithAttr;
import com.apps.waziup.domain.services.model.EntityWithCurrentAttr;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface EntitiesApi {
    /**
     * delete a single entity
     *
     * @param domain     (required)
     * @param entityType (required)
     * @param entityId   (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("domains/{domain}/entities/{entity_type}/{entity_id}")
    Observable<Void> domainsDomainEntitiesEntityTypeEntityIdDelete(
            @Path("domain") String domain, @Path("entity_type") String entityType, @Path("entity_id") String entityId
    );

    /**
     * delete an entity attribute
     * Drop all stored entity data and remove the attribute.
     *
     * @param domain          (required)
     * @param entityType      (required)
     * @param entityId        (required)
     * @param entityAttribute (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("domains/{domain}/entities/{entity_type}/{entity_id}/{entity_attribute}")
    Observable<Void> domainsDomainEntitiesEntityTypeEntityIdEntityAttributeDelete(
            @Path("domain") String domain, @Path("entity_type") String entityType, @Path("entity_id") String entityId, @Path("entity_attribute") String entityAttribute
    );

    /**
     * get entity attribute values
     * Get all stored values of a single attribute. - If there multiple values (from multiple PUT requests), this returns an array with all values (newest first). - If there is only one value (from a POST request), this returns an array with only one element.
     *
     * @param domain          (required)
     * @param entityType      (required)
     * @param entityId        (required)
     * @param entityAttribute (required)
     * @return Call&lt;List&lt;EntityAttr&gt;&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/entities/{entity_type}/{entity_id}/{entity_attribute}")
    Observable<List<EntityAttr>> domainsDomainEntitiesEntityTypeEntityIdEntityAttributeGet(
            @Path("domain") String domain, @Path("entity_type") String entityType, @Path("entity_id") String entityId, @Path("entity_attribute") String entityAttribute
    );

    /**
     * add an entity attribute value
     * Add new a value to the list of stored values for this attribute. If this attribute does not exist, it will be created within this request.
     *
     * @param domain          (required)
     * @param entityType      (required)
     * @param entityId        (required)
     * @param entityAttribute (required)
     * @param body            (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/entities/{entity_type}/{entity_id}/{entity_attribute}")
    Observable<Void> domainsDomainEntitiesEntityTypeEntityIdEntityAttributePost(
            @Path("domain") String domain, @Path("entity_type") String entityType, @Path("entity_id") String entityId, @Path("entity_attribute") String entityAttribute, @Body EntityAttr body
    );

    /**
     * set entity attribute values
     * Set new values for this attribute, removing all previous values. If this attribute does not exist, it will be created within this request.
     *
     * @param domain          (required)
     * @param entityType      (required)
     * @param entityId        (required)
     * @param entityAttribute (required)
     * @param body            (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("domains/{domain}/entities/{entity_type}/{entity_id}/{entity_attribute}")
    Single<Response<Void>> domainsDomainEntitiesEntityTypeEntityIdEntityAttributePut(
            @Path("domain") String domain, @Path("entity_type") String entityType, @Path("entity_id") String entityId, @Path("entity_attribute") String entityAttribute, @Body List<EntityAttr> body
    );

    /**
     * get a single entity
     *
     * @param domain     (required)
     * @param entityType (required)
     * @param entityId   (required)
     * @return Call&lt;EntityWithCurrentAttr&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/entities/{entity_type}/{entity_id}")
    Observable<EntityWithCurrentAttr> domainsDomainEntitiesEntityTypeEntityIdGet(
            @Path("domain") String domain, @Path("entity_type") String entityType, @Path("entity_id") String entityId
    );

    /**
     * get entities of one type
     *
     * @param domain     (required)
     * @param entityType (required)
     * @return Call&lt;List&lt;Entity&gt;&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/entities/{entity_type}")
    Observable<List<Entity>> domainsDomainEntitiesEntityTypeGet(
            @Path("domain") String domain, @Path("entity_type") String entityType
    );

    /**
     * create a new entity
     * Endpoint to create a new entity with type and name.
     *
     * @param body   (required)
     * @param domain (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/entities")
    Single<Response<Void>> domainsDomainEntitiesPost(
            @Body EntityWithAttr body, @Path("domain") String domain
    );

    /**
     * get all known entity types
     *
     * @param domain (required)
     * @return Call&lt;List&lt;String&gt;&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/entities/types")
    Observable<List<String>> domainsDomainEntitiesTypesGet(
            @Path("domain") String domain
    );

}
