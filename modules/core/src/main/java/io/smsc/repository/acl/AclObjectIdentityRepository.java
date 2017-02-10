package io.smsc.repository.acl;

import io.smsc.model.acl.AclClass;
import io.smsc.model.acl.AclObjectIdentity;
import io.smsc.model.projections.AclObjectIdentityProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * This REST repository class is used for providing default {@link JpaRepository}
 * CRUD methods to operate with {@link AclObjectIdentity} entities and exporting them to
 * appropriate endpoints.
 *
 * @author Nazar Lipkovskyy
 * @since 0.0.1-SNAPSHOT
 */
@RepositoryRestResource(collectionResourceRel = "acl-object-identities", path = "acl-object-identities", excerptProjection = AclObjectIdentityProjection.class)
@Transactional(readOnly = true)
public interface AclObjectIdentityRepository extends JpaRepository<AclObjectIdentity, Long> {

    //All query method resources are exposed under the resource 'search'.

    @Override
    @Transactional
    void delete(Long id);

    @Override
    @Transactional
    AclObjectIdentity save(AclObjectIdentity aclObjectIdentity);

    @Override
    @EntityGraph(attributePaths = {"parentObject", "ownerSid", "aclEntries"})
    AclObjectIdentity findOne(Long id);

    @EntityGraph(attributePaths = {"parentObject", "ownerSid", "aclEntries"})
    AclObjectIdentity findByObjectIdIdentity(@Param("objectIdIdentity") Long objectIdIdentity);

    @EntityGraph(attributePaths = {"parentObject", "ownerSid", "aclEntries"})
    AclObjectIdentity findByObjectIdClass(@Param("objectIdClass") AclClass objectIdClass);

    @Override
    @EntityGraph(attributePaths = {"parentObject", "ownerSid", "aclEntries"})
    Page<AclObjectIdentity> findAll(Pageable pageable);
}
