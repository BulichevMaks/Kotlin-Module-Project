import java.util.*

class MainMenu {
    private val archives = mutableMapOf<Int, Archive>()
    private val screen = UserScreen()
    private var numArchive = 0

    //Экран списка архивов
    fun crateMenu() {
        while (true) {
            println("Список архивов:")
            println("0. Создать архив")
            archives.forEach { println("${it.key}. ${it.value}") }
            if (screen.createScreen(createMenuList())) return
        }
    }

    //Создает набор для исполнения функций при выборе пункта меню
    private fun createMenuList(): MutableMap<Int, () -> Unit> {
        val menu = mutableMapOf<Int, () -> Unit>()
        menu[0] = { archives[++numArchive] = archiveCreate() }
        for (i in 1..archives.size) {
            menu[i] = { archives[i]?.archiveScreen?.crateMenu() }
        }
        return menu
    }

    //Экран создания архива
    private fun archiveCreate(): Archive {
        println("Создание архива")
        println("Введите название архива:")
        return Archive(Scanner(System.`in`).nextLine())
    }
}

