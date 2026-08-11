package ru.cws.fox.helper.ignite.mixin.core;

import io.papermc.paper.ServerBuildInfoImpl;
import net.kyori.adventure.key.Key;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.cws.fox.loader.Fox;

import java.time.Instant;
import java.util.Optional;
import java.util.OptionalInt;

@Mixin(ServerBuildInfoImpl.class)
public class ServerBuildInfoImplMixin {
  @Mutable
  @Shadow
  @Final
  private Key brandId;

  @Mutable
  @Shadow
  @Final
  private String brandName;

  @Mutable
  @Shadow
  @Final
  private OptionalInt buildNumber;

  /**
   * @author DomamaN202
   * @reason Z
   */
  @Inject(method = "<init>(Lnet/kyori/adventure/key/Key;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/OptionalInt;Ljava/time/Instant;Ljava/util/Optional;Ljava/util/Optional;)V", at = @At("RETURN"))
  public void ctor(Key brandId, String brandName, String minecraftVersionId, String minecraftVersionName, OptionalInt buildNumber, Instant buildTime, Optional gitBranch, Optional gitCommit, CallbackInfo ci) {
    this.brandId = Key.key("fox");
    this.brandName = "FoX";
    this.buildNumber = OptionalInt.of(Fox.VERSION.replace(".", "000").hashCode());
  }
}
