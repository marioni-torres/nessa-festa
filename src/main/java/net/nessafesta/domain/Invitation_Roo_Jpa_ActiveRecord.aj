// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.nessafesta.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.nessafesta.domain.Invitation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Invitation_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Invitation.entityManager;
    
    public static final List<String> Invitation.fieldNames4OrderClauseFilter = java.util.Arrays.asList("id", "title", "numberGuests", "notes", "event", "inviteeGroups");
    
    public static final EntityManager Invitation.entityManager() {
        EntityManager em = new Invitation().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Invitation.countInvitations() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Invitation o", Long.class).getSingleResult();
    }
    
    public static List<Invitation> Invitation.findAllInvitations() {
        return entityManager().createQuery("SELECT o FROM Invitation o", Invitation.class).getResultList();
    }
    
    public static List<Invitation> Invitation.findAllInvitations(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Invitation o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Invitation.class).getResultList();
    }
    
    public static Invitation Invitation.findInvitation(String id) {
        if (id == null || id.length() == 0) return null;
        return entityManager().find(Invitation.class, id);
    }
    
    public static List<Invitation> Invitation.findInvitationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Invitation o", Invitation.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Invitation> Invitation.findInvitationEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Invitation o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Invitation.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Invitation.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Invitation.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Invitation attached = Invitation.findInvitation(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Invitation.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Invitation.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Invitation Invitation.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Invitation merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
