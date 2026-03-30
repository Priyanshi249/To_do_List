# To-Do List

Android to-do app using **Room**, **Material 3**, and **MVVM** (`MainActivity` → `TaskViewModel` → `TaskRepository`). Package: `com.example.todolist`.

## Prerequisites

- **JDK 17** (or newer) on your `PATH` or set **`JAVA_HOME`**.  
  On macOS with Homebrew: `brew install openjdk@17`, then either set `JAVA_HOME` to the JDK path or use the helper script below (it tries common locations).
- **Android SDK** — easiest path is installing [Android Studio](https://developer.android.com/studio), which creates the SDK and can write **`local.properties`** with `sdk.dir=...` when you open this folder as a project.

## Run with Android Studio (recommended)

1. Open the **`To_do_List-main`** folder in Android Studio.
2. Wait for Gradle sync to finish.
3. Create or start a **virtual device** (Device Manager) or connect a phone with **USB debugging** enabled.
4. Click **Run** (green play) and choose the device.

## Run from the terminal

From the project root:

```bash
chmod +x run.sh   # once, if needed
./run.sh
```

The script:

- Picks **JDK 17** when possible (Homebrew path or `/usr/libexec/java_home`).
- Adds **`platform-tools`** to `PATH` using `sdk.dir` from **`local.properties`** (if present).
- Runs **`./gradlew assembleDebug`**.
- If **`adb`** sees a device or emulator, it runs **`installDebug`** and starts **`MainActivity`**.

Without a device, the build still succeeds; install manually after you start an emulator or plug in a phone:

```bash
./gradlew installDebug
adb shell am start -n com.example.todolist/.MainActivity
```

**Debug APK** (after a successful debug build):

`build/outputs/apk/debug/To_do_List-main-debug.apk`

## Troubleshooting

- **“Unable to locate a Java Runtime”** — Install JDK 17+ and export `JAVA_HOME`, or run `./run.sh` which sets it when Homebrew’s OpenJDK 17 is installed.
- **No device** — Start an AVD in Android Studio (Device Manager) or run `adb devices` and confirm a line ending in `device`.
- **Odd install errors or stale UI** — Clean and rebuild:

  ```bash
  ./gradlew clean assembleDebug
  ```

## More detail

See **[PROJECT_CHANGES.md](PROJECT_CHANGES.md)** for architecture notes and a map of source files.
