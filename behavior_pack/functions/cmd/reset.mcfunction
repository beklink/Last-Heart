# /lastheart reset command
tellraw @s {"rawtext":[{"text":"§b🔄 Yuraklar default-ga qaytarildi (10)!"}]}

scoreboard players set @s lasthearts 10

playsound note.hat @s
effect @s regeneration 3 1 false
