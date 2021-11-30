package o1.adventure

import scala.collection.mutable.Map

class Area (var name: String, var description: String) {

    protected val neighbors = Map[String, Area]()
    protected val goods = Map[String, Item]()
    
     protected def getKeys = {
        val key = Vector[String]()
        for (range <- 0 until neighbors.size)
            key ++ this.neighbors.keys
        key
    }
    protected def getValues = {
        val value = Vector[Area]()
        for (range <- 0 until neighbors.size)
            value ++ this.neighbors.values
        value
    }
    
    def neighbor(direction: String) = this.neighbors.get(direction)
 
    def setNeighbor(direction: String, neighbor: Area) = {
        this.neighbors += direction -> neighbor
    }
    
    def setNeighbors(exits: Vector[(String, Area)]) = {
        this.neighbors ++= exits
    }

    def addItem(item: Item) = {
        this.goods.put(item.name, item)
    }

    def contains(itemName: String) = this.goods.contains(itemName)

    def removeItem(itemName: String) = {
        this.goods.remove(itemName)
    }


    def fullDescription = {
        val availableGoodsList = {
            if (this.goods.isEmpty) ""
            else                    "\nYou See Here: " + this.goods.values.mkString(" ")
        }
        val exitList = "\n\nExits available: " + this.neighbors.keys.mkString(" ")
        this.description + availableGoodsList + exitList
    }
    
    
    override def toString = this.name + ": " + this.description.replaceAll("\n", " ").take(150)
}
