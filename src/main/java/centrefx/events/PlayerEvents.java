package centrefx.events;

import centrefx.util.IEntityDataSaver;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.nbt.NbtDouble;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerEvents implements ServerPlayerEvents.CopyFrom {

    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        IEntityDataSaver original = (IEntityDataSaver) oldPlayer;
        IEntityDataSaver player = (IEntityDataSaver) newPlayer;

        NbtList list = original.getHomePosition();
        player.getHomePosition().add(NbtDouble.of(list.getDouble(0)));
        player.getHomePosition().add(NbtDouble.of(list.getDouble(1)));
        player.getHomePosition().add(NbtDouble.of(list.getDouble(2)));
    }
}
