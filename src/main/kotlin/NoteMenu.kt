class NoteMenu(private val content: String) {

    private val screen = UserScreen()

    //Экран заметки
    fun crateMenu() {
        while (true) {
            println("Тест заметки: $content")
            if (screen.createScreen(mutableMapOf())) return
        }
    }
}
