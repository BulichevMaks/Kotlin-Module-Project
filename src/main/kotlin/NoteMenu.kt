class NoteMenu(private val content: String) {

    private val screen = UserScreen()

    //Экран заметки
    fun crateMenu() {
        while (true) {
            println("Тест заметки: $content")
            if (screen.createScreen(foo())) return
        }
    }

    //Создает набор для исполнения функций при выборе пункта меню
    private fun foo(): MutableMap<Int, () -> Unit> {
        val menu = mutableMapOf<Int, () -> Unit>()
        menu[0] = {}//создаёт одно значение чтобы переменная exit не имела значение 0 :-)
        return menu
    }
}
