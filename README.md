# 📱 RegisterApp - Android Studio Project
### Tugas Pertemuan 5 | Mobile Programming
Link Video Demo : https://drive.google.com/file/d/1i6l63A-EsKUywWSxhguKTyx3v0jNN4CL/view?usp=drivesdk

---

## 📋 Deskripsi Proyek

**RegisterApp** adalah aplikasi Android lengkap yang dibangun menggunakan **Kotlin** dan **Material Design 3**, mengimplementasikan seluruh materi Pertemuan 5:

| No | Fitur | Status |
|----|-------|--------|
| 01 | Complete Form (TextInputLayout) | ✅ |
| 02 | Advanced Validation (real-time) | ✅ |
| 03 | Selection Controls (RadioGroup + CheckBox) | ✅ |
| 04 | Spinner & AlertDialog | ✅ |
| 05 | Gesture Interaction (Long Press) | ✅ |
| 06 | GitHub Repository + README | ✅ |

---

## 🎨 Desain UI/UX

**Konsep**: Modern Indigo-Violet dengan aksen Teal  
**Font**: Poppins (Google Fonts)  
**Library**: Material Design Components 1.11.0

| Warna | Hex | Kegunaan |
|-------|-----|----------|
| Indigo | `#5C6BC0` | Primary / Utama |
| Teal | `#00897B` | Success / Sukses |
| Amber | `#FFB300` | Highlight / Aksen |
| Light Gray | `#F5F6FA` | Background |

---

## 🏗️ Struktur Project

```
RegisterApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/registerapp/
│   │       │   ├── MainActivity.kt          # Entry point
│   │       │   ├── RegisterActivity.kt      # Form registrasi utama
│   │       │   └── SuccessActivity.kt       # Halaman sukses
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_register.xml    # Layout form
│   │       │   │   ├── activity_success.xml     # Layout sukses
│   │       │   │   ├── item_data_row.xml         # Komponen baris data
│   │       │   │   ├── spinner_item.xml          # Item Spinner
│   │       │   │   └── spinner_dropdown_item.xml # Dropdown Spinner
│   │       │   ├── drawable/
│   │       │   │   ├── bg_header_gradient.xml
│   │       │   │   ├── bg_success_gradient.xml
│   │       │   │   ├── bg_icon_circle.xml
│   │       │   │   ├── bg_section_label.xml
│   │       │   │   ├── bg_radio_option.xml
│   │       │   │   ├── ic_person.xml
│   │       │   │   ├── ic_email.xml
│   │       │   │   ├── ic_lock.xml
│   │       │   │   ├── ic_lock_check.xml
│   │       │   │   ├── ic_location.xml
│   │       │   │   ├── ic_check_circle.xml
│   │       │   │   └── ic_app_logo.xml
│   │       │   ├── color/
│   │       │   │   └── input_stroke_selector.xml
│   │       │   ├── font/
│   │       │   │   ├── poppins_regular.ttf  (download manual)
│   │       │   │   ├── poppins_medium.ttf   (download manual)
│   │       │   │   ├── poppins_semibold.ttf (download manual)
│   │       │   │   └── poppins_bold.ttf     (download manual)
│   │       │   └── values/
│   │       │       ├── colors.xml
│   │       │       ├── strings.xml
│   │       │       └── themes.xml
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

---

## ⚙️ Cara Menjalankan

### Prasyarat
- Android Studio Hedgehog (2023.1.1) atau lebih baru
- Android SDK 34 (Android 14)
- Kotlin 1.9.22
- JDK 17

### Langkah Setup

1. **Clone repository**
   ```bash
   git clone https://github.com/username/RegisterApp.git
   cd RegisterApp
   ```

2. **Download Font Poppins**  
   Unduh dari [Google Fonts - Poppins](https://fonts.google.com/specimen/Poppins)  
   Letakkan file `.ttf` berikut di `app/src/main/res/font/`:
   - `poppins_regular.ttf`
   - `poppins_medium.ttf`
   - `poppins_semibold.ttf`
   - `poppins_bold.ttf`

   **Cara alternatif di Android Studio:**
   - Klik kanan folder `res/font` → New → Font Resource File
   - Pilih "More Fonts" → cari "Poppins" → pilih weights 400, 500, 600, 700

3. **Buka di Android Studio**
   - File → Open → pilih folder `RegisterApp`
   - Tunggu Gradle sync selesai

4. **Build & Run**
   - Sambungkan device atau buka emulator (API 24+)
   - Klik tombol ▶ Run

---

## 📖 Penjelasan Fitur

### 01 · Complete Form
Form registrasi menggunakan `TextInputLayout` dari Material Design:
- **Nama Lengkap** — `inputType="textPersonName"`
- **Email** — `inputType="textEmailAddress"`
- **Password** — `inputType="textPassword"` dengan toggle visibility
- **Confirm Password** — `inputType="textPassword"` dengan toggle visibility

### 02 · Advanced Validation
Validasi komprehensif diimplementasikan di `RegisterActivity.kt`:
- ✅ Tidak boleh kosong (semua field)
- ✅ Format email valid (`android.util.Patterns.EMAIL_ADDRESS`)
- ✅ Password minimal 8 karakter + kombinasi huruf & angka
- ✅ Confirm password harus cocok
- ✅ **Real-time validation** via `TextWatcher`
- ✅ Error message inline di bawah setiap field

### 03 · Selection Controls
```kotlin
// RadioGroup untuk Gender
rgGender.checkedRadioButtonId // -1 jika belum dipilih

// Checkbox Hobi (minimal 3)
val selectedHobi = getSelectedHobi()
if (selectedHobi.size < 3) showError()
```

### 04 · Spinner & AlertDialog
```kotlin
// Spinner dengan custom adapter
val adapter = ArrayAdapter(this, R.layout.spinner_item, listKota)
adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
spinnerKota.adapter = adapter

// AlertDialog konfirmasi sebelum submit
AlertDialog.Builder(this, R.style.CustomAlertDialog)
    .setTitle("Konfirmasi")
    .setMessage(summary)
    .setPositiveButton("Daftar") { _, _ -> navigateToSuccess() }
    .show()
```

### 05 · Gesture Interaction (Long Press)
```kotlin
// Long Press pada tombol Daftar
btnDaftar.setOnLongClickListener { view ->
    view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
    showPreviewDialog() // Tampilkan preview data
    true
}
```

### 06 · GitHub Repository
Project ini diupload ke GitHub/GitLab dengan:
- README.md lengkap dengan dokumentasi
- Struktur folder yang terorganisir
- Komentar kode yang terstruktur

---

## 🧪 Test Cases

| Test | Input | Expected |
|------|-------|----------|
| Nama kosong | `""` | Error: "Nama tidak boleh kosong" |
| Nama pendek | `"Jo"` | Error: "Nama minimal 3 karakter" |
| Email invalid | `"abc"` | Error: "Format email tidak valid" |
| Password pendek | `"pass"` | Error: "Password minimal 8 karakter" |
| Password tanpa angka | `"password"` | Error: "Password harus mengandung angka" |
| Confirm tidak cocok | `"pass1234"` vs `"pass1235"` | Error: "Password tidak cocok" |
| Hobi < 3 | 2 dipilih | Toast: "Pilih minimal 3 hobi" |
| Kota belum dipilih | index 0 | Toast: "Pilih kota asal" |

---

## 👨‍💻 Developer

**Nama**: Hilvan Yadhisnata

**NIM**: 24552011163

**Kelas**: TIF K 24A

**Mata Kuliah**: Pemrograman Mobile I  

**Pertemuan**: 5 — Form, Validation, Selection Controls

---

## 📄 Lisensi

Project ini dibuat untuk keperluan akademik.  
© 2026 — Semua hak dilindungi.
