# Last Heart Bedrock Edition

## 🎮 Xususiyatlar

### Yurak Tizimi
- **Default Hearts**: 10 ta yurak (20 half-hearts)
- **Extra Hearts**: 0-10 ta qo'shimcha yurak
- **Maximum**: 20 ta yurak
- **Scoreboard**: `lasthearts` - yurak counter

### 🛠️ Admin Commands

#### `/lastheart give <player>`
**Qo'llanilishi**: Oyunchiga 1 ta yurak qo'shish
```
/lastheart give @s          # O'ziga qo'shish
/lastheart give @a          # Barchasiga qo'shish
/lastheart give @p          # Eng yaqin o'yunchiga
```

#### `/lastheart set <player> <count>`
**Qo'llanilishi**: Yurak sonini to'g'ridan-to'g'ri o'rnatish (0-10)
```
/lastheart set @s 5         # O'ziga 5 yurak o'rnatish
/lastheart set @a 3         # Barchasiga 3 yurak
/lastheart set @p 10        # Maksimal 10 yurak
```

#### `/lastheart remove <player>`
**Qo'llanilishi**: 1 ta yurakni olib olish
```
/lastheart remove @s        # O'zidan olib olish
/lastheart remove @a        # Barchasidan olib olish
```

#### `/lastheart reset <player>`
**Qo'llanilishi**: Yurakni defaultga qaytarish (10)
```
/lastheart reset @s         # O'zini reset qilish
/lastheart reset @a         # Barchasini reset qilish
```

---

## 📦 O'rnatish (Installation)

### Android/iOS
1. **Last-Heart-Bedrock.mcpack** faylni yuklab oling
2. **Minecraft Bedrock** ochib main menu-ga o'ting
3. **Settings** → **Resource Packs** → Import `.mcpack`
4. **Behavior Packs** → Import `.mcpack`
5. **Yaratgan world-ga** enable qiling
6. **Play**! 🎮

### Windows/Mac
1. `.mcpack` faylni yuklab oling
2. **Minecraft** ochib
3. **Settings** → **Packs**
4. **My Packs** → `.mcpack` import qiling
5. World-ga qo'llang

---

## 📊 Scoreboards

**Faqat admin-lar uchun:**
```
/scoreboard players list              # Barchasining yurak sonini ko'rish
/scoreboard players get @s lasthearts # O'zining yurak sonini ko'rish
```

---

## ⚙️ O'lim Mexanizmasi

**Vanilla Minecraft mexanizmasi:**
- O'yinchi o'lib qolsa - respawn qiladi
- **Future update**: Custom death system

---

## 🎨 Texture Pack

**Item textures:**
- `textures/items/heart_soul.png`
- `textures/items/half_heart.png`
- `textures/items/heart_tier.png`
- `textures/items/extra_heart.png`

---

## 📝 Version
- **Version**: 1.0.0
- **Minecraft**: 1.19.0+
- **Type**: Behavior Pack + Resource Pack

---

## 🛠️ Talab qilinadigan Versiyalar
- **Minecraft Bedrock**: 1.19.0+
- **Device**: Windows, Mac, Android, iOS, Nintendo Switch, Xbox

---

**Yaratuvchi**: beklink  
**O'zbek tilida**: ✅
**English tilida**: ✅

