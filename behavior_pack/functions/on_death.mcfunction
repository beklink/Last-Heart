# On player death
tellraw @s {"rawtext":[{"text":"§c❤️ Yurak yo'qoldi! Qolgan: "},{"score":{"name":"@s","objective":"lasthearts"}}]}

scoreboard players remove @s lasthearts 1

if score @s lasthearts matches 0 {
  title @s title §4§l⚠️ OXIRGI YURAK!
  title @s subtitle §c§lO'YIN TUGADI!
  effect @s blindness 10 0 false
  playsound mob.wither.death @s
} else {
  playsound item.break @s
}
