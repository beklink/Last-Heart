# /lastheart set <count> command
# Usage: /lastheart set @s 5

tellraw @s {"rawtext":[{"text":"§b📊 Yurak o'rnatildi!"}]}

scoreboard players operation @s lasthearts = temp lasthearts

if score @s lasthearts matches 11.. {
  scoreboard players set @s lasthearts 10
  tellraw @s {"rawtext":[{"text":"§e⚠️ Maksimal 10 yurak (clamped)!"}]}
}

if score @s lasthearts matches ..-1 {
  scoreboard players set @s lasthearts 0
  tellraw @s {"rawtext":[{"text":"§c⚠️ Minimum 0 yurak (clamped)!"}]}
}

playsound note.bell @s
