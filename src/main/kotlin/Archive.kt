class Archive(private val name: String) {

    val archiveScreen = ArchiveMenu(name)

    override fun toString(): String {
        return "Архив: $name"
    }
}