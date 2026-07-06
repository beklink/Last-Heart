# /lastheart check - internal function
if score @s lasthearts matches 0 {
  title @s title §4§l⚠️ OXIRGI YURAK!
  title @s subtitle §c§lO'YIN TUGADI!
  effect @s blindness 2 0 false
  effect @s wither 1 1 false
  playsound mob.wither.death @s
}
