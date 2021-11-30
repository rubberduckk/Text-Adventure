package o1.adventure

import scala.util.Random

class Adventure {

    val title = "A forest Adventure"

    private val middle      = new Area("Forest", "You are somewhere in the forest. There are a lot of trees here.\nBirds are singing.")
    private val northForest = new Area("Forest", "You are somewhere in the forest. A tangle of bushes blocks further passage north.\nBirds are singing.")
    private val southForest = new Area("Forest", "The forest just goes on and on.")
    private val clearing    = new Area("Forest Clearing", "You are at a small clearing in the middle of forest.\nNearly invisible, twisted paths lead in many directions.")
    private val tangle      = new Area("Tangle of Bushes", "You are in a dense tangle of bushes. It's hard to see exactly where you're going.")
    private val home        = new Area("Home", "Home sweet home! Now the only thing you need is a working remote control.") 

    val mysticForest = new MysticForest("Wait... do you REALLY know where you are?")

    private val destination = home

    middle.setNeighbors       (Vector("north" -> northForest, "east" -> tangle, "south" -> southForest, "west" -> clearing   ))
    northForest.setNeighbors  (Vector("north" -> mysticForest,"east" -> tangle, "south" -> middle,      "west" -> clearing   ))
    southForest.setNeighbors  (Vector("north" -> middle,      "east" -> tangle, "south" -> southForest, "west" -> clearing   ))
    clearing.setNeighbors     (Vector("north" -> northForest, "east" -> middle, "south" -> southForest, "west" -> northForest))
    tangle.setNeighbors       (Vector("north" -> northForest, "east" -> home,   "south" -> southForest, "west" -> northForest))
    home.setNeighbors         (Vector(                                                                  "west" -> tangle     ))

    mysticForest.setNeighbors(Vector(                                                                                      ))

    clearing.addItem(new Item("battery", "It's a small battery cell. Looks new."))
    southForest.addItem(new Item("remote", "It's the remote control for your TV.\nWhat it was doing in the forest, you have no idea.\nProblem is, there's no battery."))
    
    mysticForest.addItem(new Item("wing", "You find a magical wing!\nNow you can easily go home as you want."))
    
    val player = new Player(middle)
     
    var turnCount = 0
    val timeLimit = 40

    def isComplete = (this.player.location == this.destination) && (this.player.has("battery") && this.player.has("remote"))
    def isOver = this.isComplete || this.player.hasQuit || this.turnCount == this.timeLimit

    def welcomeMessage = "You are lost in the woods. Find your way back home.\n\nBetter hurry, 'cause Scalatut elämät is on real soon now. And you can't miss Scalkkarit, right?"
    def goodbyeMessage = {
        if (this.isComplete)    
            "Home at last... and phew, just in time! Well done!"
        else if (this.turnCount == this.timeLimit)
            "Oh no! Time's up. Starved of entertainment, you collapse and weep like a child.\nGame over!"
        else
            "Quitter!" 
    }

    def playTurn(cmd: String): String = {
        val action = new Action(cmd)        
        val outcomeReport = action.execute(this.player)
        if (this.player.location == mysticForest) { 
            Some(mysticForest.especiallyRun(this.player))
        }
        if (outcomeReport.isDefined)    this.turnCount += 1
     
        outcomeReport.getOrElse("Unknown command: \"" + cmd + "\".")
        // 얘가 여기에 들어오거나 execute에 들어가야 함
        // 실행 조건 : player가 MF에 있을 때  
        
    }
}
