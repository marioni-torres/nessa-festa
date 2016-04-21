package net.nessafesta.aspect;

import net.nessafesta.service.IInvitationService;

public aspect AroundAspect {
	pointcut imprimeResultado(IInvitationService is, String eventUUID,
			String invitationUUID) : 
				call(net.nessafesta.domain.Invitation net.nessafesta..IInvitationService.findAssignedTo(String, String)) 
				&& target(is) 
				&& args(eventUUID, invitationUUID);

	after(IInvitationService is, String eventUUID, String invitationUUID) returning: imprimeResultado(is, eventUUID, invitationUUID) {
		System.out
				.println(String
						.format("[net.nessafesta.aspect.AroundAspect]Service bean %s, has invoked findAssignedTo(%s, %s)",
								is, eventUUID, invitationUUID));
	}
}
