package o1.adventure

import scala.util.Random
import scala.collection.mutable.Map

class MysticForest(description: String) extends Area("Mystic Forest", description) {

    val player = new Player(this)
    val witch = new WiseWitch

    override def addItem(item: Item) = {       
      def choose = new Random()
      def probability = Vector(this.goods.put(item.name, item), None, None, None, None)
      def appear = choose.nextInt(probability.length)
      
      probability(appear)
    }
    
    def especiallyRun(player: Player) = {
      println("Look Around... someone is here.")
      for (range <- 1 to 3) {
        print(". ")
        Thread.sleep(500)
      }
      
      Thread.sleep(1000)
      println("\nBoo! Wise Witch has appeared! She will lead you the best way.")
      println(player.inventory)
      print("So, you might be going to")
      for (range <- 1 to 3) {
        print(". ")
        Thread.sleep(500)
      }
      
      witch.sendPlayer(player)
    }

    override def fullDescription = {         
        val availableGoodsList = {
            if (this.goods.isEmpty) ""
            else                    "\nAlso you See Here: " + this.goods.values.mkString(" ")
        }
        val exitList = "\n\nYou can't use 'go' command in here.\nThe only way to out of is to get help to someone mysterious."
        this.description + exitList + availableGoodsList
    }
}

