# Main tick function - har tick ishga tushadi

# Check death
if entity @s[scores={death_count=1..}] {
  function lastheart/on_death
  scoreboard players set @s death_count 0
}

# Check hearts
if score @s lasthearts matches 0 {
  function lastheart/check
}

# Clamp hearts (0-10)
if score @s lasthearts matches 11.. {
  scoreboard players set @s lasthearts 10
}

if score @s lasthearts matches ..-1 {
  scoreboard players set @s lasthearts 0
}
