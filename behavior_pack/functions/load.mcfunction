# Scoreboard init
scoreboard objectives add lasthearts dummy "💚 Last Hearts"
scoreboard objectives add temp dummy

# Set default values
scoreboard players set @a lasthearts 10

# Broadcast
tellraw @a {"rawtext":[{"text":"§6§l[Last Heart] §aModun yuklandi! /lastheart help"}

# Start tick function
function lastheart/tick
