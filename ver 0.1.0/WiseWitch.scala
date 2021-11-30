package o1.adventure

class WiseWitch {
  
    def sendPlayer(player: Player) = {      
      if (player.has("battery")) {
        if (player.has("remote")) {
          player.goHome() 
        }
        else {
          player.changeLocation("clearing")  
          "Forest Clearing!"
        }
      }
       else  {
        if (player.has("remote")) {
          player.changeLocation("forest")
          "Forest!"
        }
        else {
          player.changeLocation("anywhere")
          "Somewhere. anyway forest."
        }
      }
   }
}