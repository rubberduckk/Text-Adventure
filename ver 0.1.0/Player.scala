package o1.adventure

import scala.collection.mutable.Map

class Player(startingArea: Area) {
    
    private var currentLocation = startingArea
    private var quitCommandGiven = false
    private var nowHave = Map[String, Item]()

    def hasQuit = this.quitCommandGiven
    def location = this.currentLocation 

    def go(direction: String) = {
        val destination = this.location.neighbor(direction)
        this.currentLocation = destination.getOrElse(this.currentLocation)

        if (destination.isDefined)  "You go " + direction + "."
        else                        "You can't go " + direction + "."
    }

    def rest() = {
        Thread.sleep(1000)
        "You rest for a while. Better get a move on, though."
    }

    def quit() = {
        this.quitCommandGiven = true
        ""
    }

    def get(itemName: String) = {
        val receive = this.location.removeItem(itemName)
        
        for (item <- receive)
            this.nowHave.put(itemName, item)
        
        if (receive.isDefined) {
            val defaultSaying = "You pick up the " + itemName + "."
            if (itemName == "hang-glider")
                defaultSaying + "\nNow you can use 'fly' command to go straight home."
            else    
                defaultSaying
        }
        else                    "There is no " + itemName + " here to pick up."
    }

    def drop(itemName: String) = {
        val remove = this.nowHave.remove(itemName)

        for (old <- remove)
            this.location.addItem(old)

        if (remove.isDefined)   "You drop the " + itemName + "."
        else                    "You don't have that!"
    }

    def has(itemName: String) = this.nowHave.contains(itemName)

    def examine(itemName: String) = {
        def lookingClose(item: Item) = "You look closely at the " + item.name + ".\n" + item.description
        val ifInvalid = "If you want to examine something, you need to pick it up first"

        this.nowHave.get(itemName).map(lookingClose).getOrElse(ifInvalid)
    }

    def inventory = {
        if (this.nowHave.isEmpty)   "You are empty-handed."
        else                        "You are carring: \n" + this.nowHave.keys.mkString(" ")
    }
    
    def changeLocation(to: String) = {
      this.currentLocation = startingArea 
      if      (to == "home")     { Some(for (range <- 1 to 2)  this.go("east")) }
      else if (to == "tangle")   { Some(this.go("east")) }
      else if (to == "clearing") { Some(this.go("west")) }
      else if (to == "forest")   { Some(this.go("south")) }
      else                       { None } 
    }
    
    def goHome(): String = {
     this.changeLocation("home")         
      "You got home in a flash!"
    }


    override def toString = "Now at: " + this.location.name
}