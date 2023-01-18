data class Note(var number: Int, var content: String) {

    val noteScreen = NoteMenu(content)

    override fun toString(): String {
        return "Заметка №$number"
    }
}



