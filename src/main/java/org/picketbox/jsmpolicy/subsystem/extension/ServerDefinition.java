package org.picketbox.jsmpolicy.subsystem.extension;

import org.jboss.as.controller.SimpleAttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinitionBuilder;
import org.jboss.as.controller.SimpleResourceDefinition;
import org.jboss.as.controller.operations.validation.ModelTypeValidator;
import org.jboss.as.controller.registry.AttributeAccess;
import org.jboss.as.controller.registry.ManagementResourceRegistration;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;

import static org.picketbox.jsmpolicy.subsystem.extension.JsmPolicyExtension.SERVER;
import static org.picketbox.jsmpolicy.subsystem.extension.JsmPolicyExtension.SERVER_PATH;

/**
 * @author <a href="tcerar@redhat.com">Tomaz Cerar</a>
 */
public class ServerDefinition extends SimpleResourceDefinition {

	public static final ServerDefinition INSTANCE = new ServerDefinition();

    protected static final SimpleAttributeDefinition POLICY =
            new SimpleAttributeDefinitionBuilder(JsmPolicyExtension.POLICY, ModelType.STRING)
                    .setAllowExpression(true)
                    .setXmlName(JsmPolicyExtension.POLICY)
                    .setFlags(AttributeAccess.Flag.RESTART_ALL_SERVICES)
                    .setDefaultValue(null)
                    .setAllowNull(true)
                    .build();

    private ServerDefinition() {
        super(SERVER_PATH,
                JsmPolicyExtension.getResourceDescriptionResolver(SERVER),
                ServerAdd.INSTANCE,
                ServerRemove.INSTANCE);
    }

    @Override
    public void registerAttributes(ManagementResourceRegistration resourceRegistration) {
        resourceRegistration.registerReadWriteAttribute(POLICY, null, JsmPolicyAttributeHandler.INSTANCE);
    }
}