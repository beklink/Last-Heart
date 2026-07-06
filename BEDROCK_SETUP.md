# Last Heart Bedrock Edition - Complete Setup

## 📁 Folder Structure

```
Last-Heart/
├── behavior_pack/
│   ├── manifest.json                 # Behavior Pack config
│   ├── functions/
│   │   ├── load.mcfunction          # Initialization
│   │   ├── tick.mcfunction          # Main tick loop
│   │   ├── on_death.mcfunction      # Death event
│   │   └── cmd/
│   │       ├── give.mcfunction      # /lastheart give
│   │       ├── set.mcfunction       # /lastheart set
│   │       ├── remove.mcfunction    # /lastheart remove
│   │       ├── reset.mcfunction     # /lastheart reset
│   │       └── check.mcfunction     # Internal check
│   ├── texts/
│   │   ├── en_US.json              # English
│   │   └── uz_UZ.json              # O'zbek
│   ├── items/
│   │   └── extra_heart.json        # Custom items
│   └── commands.json               # Command definitions
│
├── resource_pack/
│   ├── manifest.json               # Resource Pack config
│   ├── textures/
│   │   └── items/
│   │       ├── heart_soul.png
│   │       ├── half_heart.png
│   │       ├── heart_tier.png
│   │       └── extra_heart.png
│   └── lang/
│       ├── en_US.lang
│       └── uz_UZ.lang
│
├── README_BEDROCK.md               # Bu fayl
└── .gitignore
```

---

## 🎮 Commands (O'zbekcha)

### 1. **Yurak Qo'shish**
```
/lastheart give @s
```
- **Qo'llanilishi**: O'ziga 1 ta yurak qo'shish
- **Maksimal**: 10 ta yurak
- **Sound**: Item pickup

### 2. **Yurak O'rnatish**
```
/lastheart set @s 5
```
- **Qo'llanilishi**: Oyunchiga aniq miqdordagi yurak o'rnatish
- **Range**: 0-10
- **Misol**: 
  - `/lastheart set @a 3` - Barchasiga 3 yurak
  - `/lastheart set @p 10` - Eng yaqin o'yunchiga 10 yurak

### 3. **Yurak Olib Olish**
```
/lastheart remove @s
```
- **Qo'llanilishi**: 1 ta yurakni olib olish
- **Minimum**: 0 ta yurak

### 4. **Yurakni Reset Qilish**
```
/lastheart reset @s
```
- **Qo'llanilishi**: Yurakni default (10) ga qaytarish
- **Effect**: Regeneration + Sound

---

## 📊 Scoreboards

**Yurakni ko'rish:**
```
/scoreboard objectives list
/scoreboard players list
/scoreboard players get @s lasthearts
```

---

## ⚙️ O'rnatish Qadamlari

### **Mobile (Android/iOS)**
1. **Last-Heart-Bedrock.mcpack** yuklab oling
2. **Minecraft Bedrock** ochib main menu
3. **Settings** → **Global Resources**
4. **Behavior Packs** tab → `.mcpack` import
5. **World-ga enable qiling**
6. **Play!** 🎮

### **Desktop (Windows/Mac)**
1. `.mcpack` yuklab oling
2. **Minecraft Bedrock** → **Settings**
3. **Packs** → **My Packs**
4. `.mcpack` import qiling
5. World-ni create qilayotganda enable qiling

---

## 🛠️ Develop qilish

### Behavior Pack Structure
```json
{
  "format_version": 2,
  "header": {
    "name": "Last Heart Bedrock",
    "version": [1, 0, 0]
  },
  "modules": [
    {
      "type": "behaviors",
      "version": [1, 0, 0]
    }
  ]
}
```

### mcfunction syntax
```
# Scoreboard
scoreboard players add @s lasthearts 1
scoreboard players remove @s lasthearts 1
scoreboard players set @s lasthearts 10

# Messages
tellraw @s {"rawtext":[{"text":"📊 Yurak: 5"}]}
title @s actionbar §aSuccessful!

# Effects
effect @s regeneration 5 2 false
playsound item.pickup @s

# Conditions
if score @s lasthearts matches 0 {
  # Commands here
}
```

---

## 📝 Versiyalar

- **Version**: 1.0.0
- **Minecraft**: 1.19.0+
- **Platform**: Windows, Mac, Android, iOS, Nintendo Switch, Xbox

---

## 🎨 Features

✅ Admin commands
✅ Scoreboard system
✅ O'zbek tili
✅ English language
✅ Sound effects
✅ Title messages
✅ Custom items
✅ Tick function system

---

**Yaratuvchi**: beklink
**Platform**: Minecraft Bedrock Edition
**Maqsad**: Hardcore gameplay mode
