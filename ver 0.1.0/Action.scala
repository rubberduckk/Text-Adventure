package o1.adventure

class Action(input: String) {

    private val commandText = input.trim.toLowerCase
    private val verb        = commandText.takeWhile(_ != ' ')
    private val modifiers   = commandText.drop(verb.length).trim

    def execute(actor: Player) = {
        
        
        if      (this.verb == "go")         { Some(actor.go(this.modifiers)) }
        else if (this.verb == "rest")       { Some(actor.rest()) }
        else if (this.verb == "xyzzy")      { Some("The grue tastes yummy.") } 
        else if (this.verb == "quit")       { Some(actor.quit()) }  
        else if (this.verb == "inventory")  { Some(actor.inventory) } 
        else if (this.verb == "get")        { Some(actor.get(this.modifiers)) } 
        else if (this.verb == "drop")       { Some(actor.drop(this.modifiers)) } 
        else if (this.verb == "examine")    { Some(actor.examine(this.modifiers)) } 
        else if (this.verb == "fly")        { Some(actor.goHome()) }
        else                                { None }
    }

    
    override def toString = this.verb + " (modifiers: " + this.modifiers + ")"  
}