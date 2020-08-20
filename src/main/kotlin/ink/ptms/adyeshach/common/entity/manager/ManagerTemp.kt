package ink.ptms.adyeshach.common.entity.manager

import ink.ptms.adyeshach.Adyeshach
import ink.ptms.adyeshach.api.AdyeshachAPI
import ink.ptms.adyeshach.common.entity.EntityInstance
import ink.ptms.adyeshach.common.entity.EntityTypes
import io.izzel.taboolib.util.Files
import org.bukkit.Bukkit
import org.bukkit.Location
import java.io.File
import java.util.concurrent.CopyOnWriteArrayList

/**
 * @Author sky
 * @Since 2020-08-14 19:08
 */
class ManagerTemp : Manager() {

    val activeEntity = CopyOnWriteArrayList<EntityInstance>()

    override fun onEnable() {
    }

    override fun onDisable() {
        activeEntity.forEach {
            it.destroy()
        }
    }

    override fun onSave() {
    }

    override fun create(entityTypes: EntityTypes, location: Location, function: (EntityInstance) -> Unit): EntityInstance {
        return create(entityTypes, location, location.world!!.players, function).run {
            activeEntity.add(this)
            this
        }
    }

    override fun remove(entityInstance: EntityInstance) {
        activeEntity.remove(entityInstance)
    }

    override fun getEntities(): List<EntityInstance> {
        return activeEntity
    }

    override fun getEntityById(id: String): List<EntityInstance> {
        return activeEntity.filter { it.id == id }
    }

    override fun getEntityByUniqueId(id: String): List<EntityInstance> {
        return activeEntity.filter { it.uniqueId == id }
    }
}