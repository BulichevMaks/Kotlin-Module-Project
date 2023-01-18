import java.util.*

class ArchiveMenu(private val name: String) {
    private val notes = mutableMapOf<Int, Note>()
    private val screen = UserScreen()
    private var numNote = 0
    private var numMenu = 0

    //Экран выбранного архива
    fun crateMenu() {
        while (true) {
            println("Архив: $name")
            println("Список заметок:")
            println("0. Создать заметку")
            notes.forEach { println("${it.key}. ${it.value}") }
            if (screen.createScreen(createMenuList())) return
        }
    }

    //Создает набор для исполнения функций при выборе пункта меню
    private fun createMenuList(): MutableMap<Int, () -> Unit> {
        val menu = mutableMapOf<Int, () -> Unit>()
        menu[0] = { notes[++numMenu] = noteCreate() }
        for (i in 1..notes.size) {
            menu[i] = { notes[i]?.noteScreen?.crateMenu() }
        }
        return menu
    }

    //Экран создания заметки
    private fun noteCreate(): Note {
        println("Создание новой заметки")
        println("Введите текст:")
        return Note(++numNote, Scanner(System.`in`).nextLine())
    }
}