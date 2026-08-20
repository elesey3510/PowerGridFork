package org.patryk3211.powergrid.compat.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.widget.Bounds;
import org.patryk3211.powergrid.circuits.editor.CircuitDesignTableEditScreen;
import org.patryk3211.powergrid.circuits.gui.ComponentPropertiesWidget;

@EmiEntrypoint
public class PowerGridEmiPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.addExclusionArea(CircuitDesignTableEditScreen.class, (screen, consumer) -> {
            ComponentPropertiesWidget widget = screen.getPropertiesWidget();
            if (widget != null && widget.isVisible()) {
                consumer.accept(new Bounds(
                    widget.getX(), 
                    widget.getY(), 
                    widget.getWidth(), 
                    widget.getTotalHeight()
                ));
            }
        });
    }
}