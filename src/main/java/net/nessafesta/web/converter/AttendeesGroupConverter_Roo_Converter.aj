// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.nessafesta.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import net.nessafesta.domain.AttendeesGroup;
import net.nessafesta.web.converter.AttendeesGroupConverter;

privileged aspect AttendeesGroupConverter_Roo_Converter {
    
    declare parents: AttendeesGroupConverter implements Converter;
    
    declare @type: AttendeesGroupConverter: @FacesConverter("net.nessafesta.web.converter.AttendeesGroupConverter");
    
    public Object AttendeesGroupConverter.getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        Long id = Long.parseLong(value);
        return AttendeesGroup.findAttendeesGroup(id);
    }
    
    public String AttendeesGroupConverter.getAsString(FacesContext context, UIComponent component, Object value) {
        return value instanceof AttendeesGroup ? ((AttendeesGroup) value).getInviteesGroupId().toString() : "";
    }
    
}