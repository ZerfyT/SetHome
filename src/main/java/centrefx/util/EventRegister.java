package centrefx.util;

import centrefx.events.PlayerEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class EventRegister {

    public static void register() {
        ServerPlayerEvents.COPY_FROM.register(new PlayerEvents());
    }
}
