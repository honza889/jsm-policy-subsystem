package org.picketbox.jsmpolicy.subsystem.extension;

import org.jboss.as.controller.SimpleResourceDefinition;
import org.jboss.as.controller.operations.common.GenericSubsystemDescribeHandler;
import org.jboss.as.controller.registry.ManagementResourceRegistration;
import org.jboss.as.controller.registry.OperationEntry;

import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.DESCRIBE;

/**
 * @author <a href="tcerar@redhat.com">Tomaz Cerar</a>
 */
public class JsmPolicySubsystemDefinition extends SimpleResourceDefinition {

	public static final JsmPolicySubsystemDefinition INSTANCE = new JsmPolicySubsystemDefinition();

	private JsmPolicySubsystemDefinition() {
		super(JsmPolicyExtension.SUBSYSTEM_PATH,
		      JsmPolicyExtension.getResourceDescriptionResolver(null),
		      SubsystemAdd.INSTANCE,
		      SubsystemRemove.INSTANCE);
	}

	/**
	 * {@inheritDoc}
	 * Registers an add operation handler or a remove operation handler if one was provided to the constructor.
	 */
	@Override
	public void registerOperations(ManagementResourceRegistration resourceRegistration) {
		super.registerOperations(resourceRegistration);
		resourceRegistration.registerOperationHandler(DESCRIBE, GenericSubsystemDescribeHandler.INSTANCE, GenericSubsystemDescribeHandler.INSTANCE, false, OperationEntry.EntryType.PRIVATE);
	}
}
