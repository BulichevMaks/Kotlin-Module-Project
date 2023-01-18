import java.lang.Exception
import java.util.*

class UserScreen {

    fun createScreen(map: MutableMap<Int, () -> Unit>): Boolean {

        val exit = map.size
        println("$exit. Выход")
        //Проверка ввода пользователя
        val choice = try {
            Scanner(System.`in`).nextLine().toInt()
        } catch (e: Exception) {
            println("Нужно ввести число!!!")
            return false
        }
        if (choice !in 0..exit) {
            println("Введите цифру из списка!!!")
            return false
        }
        //Обработка ввода пользователя
        when (choice) {
            exit -> return true
            choice -> map[choice]?.invoke()
        }
        return false
    }
}