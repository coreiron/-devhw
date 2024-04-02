import java.util.*

open class Item(val name: String, val price: Double)

class Food(name: String, price: Double, val weight: String) : Item(name, price)

class Cloth(name: String, price: Double, val type: String) : Item(name, price)

class ShoppingList {
    private val items = mutableListOf<Item>()

    fun addItem() {
        val scanner = Scanner(System.`in`)
        println("Add Item:")
        println("1. Food")
        println("2. Cloth")
        print("Choose item type: ")
        val itemType = scanner.nextInt()
        when (itemType) {
            1 -> {
                print("Enter food name: ")
                val name = scanner.next()
                print("Enter price: ")
                val price = scanner.nextDouble()
                print("Enter weight: ")
                val weight = scanner.next()
                items.add(Food(name, price, weight))
            }
            2 -> {
                print("Enter cloth name: ")
                val name = scanner.next()
                print("Enter price: ")
                val price = scanner.nextDouble()
                print("Enter type: ")
                val type = scanner.next()
                items.add(Cloth(name, price, type))
            }
            else -> println("Invalid option. Please choose a valid option.")
        }
    }

    fun displayItems() {
        println("Shopping List:")
        items.forEachIndexed { index, item ->
            println("${index + 1}. ${item.name}, Price: ${item.price}")
            when (item) {
                is Food -> println("   Type: Food, Weight: ${item.weight}")
                is Cloth -> println("   Type: Cloth, Type: ${item.type}")
            }
        }
    }

    fun deleteItem() {
        val scanner = Scanner(System.`in`)
        displayItems()
        print("Enter the item number to delete: ")
        val itemNumber = scanner.nextInt()
        if (itemNumber in 1..items.size) {
            items.removeAt(itemNumber - 1)
            println("Item $itemNumber deleted successfully.")
        } else {
            println("Invalid item number.")
        }
    }
}

fun main() {
    val shoppingList = ShoppingList()
    val scanner = Scanner(System.`in`)
    var option: Int
    do {
        println("\nMenu:")1
        println("1. Add Item")
        println("2. Display Items")
        println("3. Delete Item")
        println("4. Exit")
        print("Choose an option: ")
        option = scanner.nextInt()
        when (option) {
            1 -> shoppingList.addItem()
            2 -> shoppingList.displayItems()
            3 -> shoppingList.deleteItem()
            4 -> println("Exiting...")
            else -> println("Invalid option. Please choose a valid option.")
        }
    } while (option != 4)
}
