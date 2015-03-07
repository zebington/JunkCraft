package uk.zebington.junkcraft.common.items

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntitySnowball
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.ItemStack
import net.minecraft.util.BlockPos
import uk.zebington.junkcraft._
import uk.zebington.junkcraft.common.entities.EntityZombieArmAttack

/**
 * Created by Charlotte on 06/03/2015.
 */
class ItemZombieArm extends ItemJC {
  setUnlocalizedName(NZombieArm)

  override def onLeftClickEntity(stack: ItemStack, player: EntityPlayer, entity: Entity): Boolean = {
    true
  }

  override def onEntitySwing(entityLiving: EntityLivingBase, stack: ItemStack) = {
    if (!entityLiving.isSwingInProgress) {
      if (!entityLiving.worldObj.isRemote) entityLiving.worldObj.spawnEntityInWorld(new EntityZombieArmAttack(entityLiving.worldObj, entityLiving, 2))
      false
    } else true
  }
}
