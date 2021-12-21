package centrefx.mixin;

import centrefx.util.IEntityDataSaver;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin implements IEntityDataSaver {

    private NbtList homePositionList;

    @Override
    public NbtList getHomePosition() {
        if (homePositionList == null) {
            homePositionList = new NbtList();
        }
        return homePositionList;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void writeLocation(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if (homePositionList != null) {
            nbt.put("homepos", homePositionList);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void readLocation(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("homepos", NbtType.DOUBLE)) {
            homePositionList = nbt.getList("homepos", NbtType.DOUBLE);
        }
    }
}
