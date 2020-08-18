package ink.ptms.adyeshach.internal.migrate

/**
 * @Author sky
 * @Since 2020-08-14 18:17
 */
abstract class Migrate {

    abstract fun depend(): String

    abstract fun migrate()

    companion object {

        val migrates = hashMapOf("Citizens" to MigrateCitizens(), "ServerNPC" to MigrateServerNPC())
    }
}