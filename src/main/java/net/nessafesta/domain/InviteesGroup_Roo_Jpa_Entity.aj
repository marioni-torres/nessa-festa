// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.nessafesta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import net.nessafesta.domain.InviteesGroup;

privileged aspect InviteesGroup_Roo_Jpa_Entity {
    
    declare @type: InviteesGroup: @Entity;
    
    declare @type: InviteesGroup: @Table(name = "INVITEES_GROUP");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long InviteesGroup.id;
    
    @Version
    @Column(name = "version")
    private Integer InviteesGroup.version;
    
    public Long InviteesGroup.getId() {
        return this.id;
    }
    
    public void InviteesGroup.setId(Long id) {
        this.id = id;
    }
    
    public Integer InviteesGroup.getVersion() {
        return this.version;
    }
    
    public void InviteesGroup.setVersion(Integer version) {
        this.version = version;
    }
    
}
