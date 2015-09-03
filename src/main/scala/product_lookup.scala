package com.amyunger.products
import org.json4s._
import org.json4s.native.JsonMethods._

/**
 *
 * ### Problem statement
 *
 * Create a program that takes a product name as input and retrieves the current
 * price and quantity for that product. The product data is in a data file in the
 * JSON format and looks like this:
 *
 *     {
 *       "products" : [
 *         {"name": "Widget", "price": 25.00, "quantity": 5 },
 *         {"name": "Thing", "price": 15.00, "quantity": 5 },
 *         {"name": "Dodad", "price": 5.00, "quantity": 10 }
 *     ] }
 *
 * Print out the product name, price, and quantity if the product is found. If no
 * product matches the search, state that no product was found and start over.
 *
 * ### Example Output
 *
 *     What is the product name? iPad
 *     Sorry, that product was not found in our inventory.
 *     What is the product name? Widget
 *     Name: Widget
 *     Price: $25.00
 *     Quantity on hand: 5
 *
 * ### Constraints
 *
 * * The file is in the JSON format.  Use a JSON parser to pull the values out of
 *   the file.
 * * If a record is not found, prompt again.
 *
 * ### Challenges
 *
 * * Ensure that the product search is case-insensitive.
 * * When a product is not found, ask if the product should be added. If yes, ask
 *   for the price and the quantity and save it in the JSON file. Ensure the
 *   newly-added product is immediately available for searching without restarting
 *   the program.
 * * When a product is found save the search result into a history file with the 
 *    following JSON format.  Use a iso8601 format for the searched_at date.
 *
 *     {
 *       "history" : [
 *         {"name": "iPad", searched_at: "2015-09-22T19:21:48.461+02:00", result: "Not Found" },
 *         {"name": "Widget", searched_at: "2015-09-22T19:21:48.461+02:00", result: "Found" }
 *     ] }
 **/

// class ProductSearchHistory(fileName: String) {
//   val fileName: String = fileName
// }

class ProductDb(fileName: String) {

  val fileName: String = fileName
  // var db: ?? = buildFromFile()

  // def findByName
  // def addProduct

  def buildFromFile(fileName: String) = {
    val file = io.Source.fromFile(fileName)
    val jsonString = file.getLines.mkString
    var json = parse(jsonString)
    file.close
  }

  // def flushToFile

}

object ProductLookup {
  private val userInputPrompt = "What is the product name? "

  def main(args: Array[String]) = {
    var userInput = readLine(userInputPrompt)


    while( userWantsToContinue(userInput) ) {
      println(userInput)
      userInput = readLine(userInputPrompt)
    }
  }

  def userWantsToContinue(userInput: String) : Boolean = {
    val exitCommands = "(exit|quit)"

    return !userInput.matches(exitCommands)
  }
}
