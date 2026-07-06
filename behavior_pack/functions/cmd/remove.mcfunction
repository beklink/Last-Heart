# /lastheart remove command
tellraw @s {"rawtext":[{"text":"§c❤️ Yurak olib tashlandi!"}]}

scoreboard players remove @s lasthearts 1

if score @s lasthearts matches ..-1 {
  scoreboard players set @s lasthearts 0
  tellraw @s {"rawtext":[{"text":"§c⚠️ Yurak yoq! (0 ni o'z ichiga oladi)"}]}
} else {
  playsound item.break @s
}
