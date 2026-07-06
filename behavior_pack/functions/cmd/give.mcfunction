# /lastheart give command
tellraw @s {"rawtext":[{"text":"§a✅ Yurak qo'shildi!"}

scoreboard players add @s lasthearts 1

if score @s lasthearts matches 11.. {
  scoreboard players set @s lasthearts 10
  tellraw @s {"rawtext":[{"text":"§e⚠️ Maksimal yurakka yetdingiz (10)!"}]}
} else {
  playsound item.pickup @s
  effect @s regeneration 5 2 false
}
