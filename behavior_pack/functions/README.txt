# LastHeart Bedrock Command Functions

## Function: lastheart/give
title @s actionbar §a💚 Yurak qo'shildi!
scoreboard players add @s lasthearts 1
scoreboard players operation @s lasthearts < max_hearts limit
playsound note.pling @s

## Function: lastheart/set
title @s actionbar §e📊 Yurak o'rnatildi!
scoreboard players operation @s lasthearts = value
playsound note.bell @s

## Function: lastheart/remove
title @s actionbar §c❤️ Yurak olib tashlandi!
scoreboard players remove @s lasthearts 1
scoreboard players operation @s lasthearts < zero limit
playsound item.break @s

## Function: lastheart/reset
title @s actionbar §b🔄 Default yurakka qaytarildi!
scoreboard players set @s lasthearts 10
playsound note.hat @s

## Function: lastheart/check
if score @s lasthearts matches 0 {
  title @s title §4§l⚠️ OXIRGI YURAK!
  title @s subtitle §c§lO'YIN TUGADI!
  effect @s blindness 2 0 false
}

## Function: lastheart/init
scoreboard objectives add lasthearts dummy "Last Heart"
scoreboard players set @a lasthearts 10
title @a title §6§lLast Heart Mod
title @a subtitle §e§l1.0.0
