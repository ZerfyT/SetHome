package centrefx;

import centrefx.util.CommandRegister;
import centrefx.util.EventRegister;
import net.fabricmc.api.ModInitializer;

public class SetHome implements ModInitializer {

    public static final String MOD_ID = "sethome";
    public static final String MOD_NAME = "SetHome";

    @Override
    public void onInitialize() {
        CommandRegister.registerCommands();
        EventRegister.register();
    }
}