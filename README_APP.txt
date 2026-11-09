MineXLauncher app module

Copy the entire app/ folder into the root of the existing MineXLauncher repository.

This is an Android Compose starter interface only. It does NOT yet authenticate Microsoft accounts,
download Minecraft versions, install Java, load Forge/Fabric, or launch the game.

Build requirements:
- Android Studio
- JDK 17
- Android SDK 35
- Root project plugins: Android Gradle Plugin 8.7.3 and Kotlin 2.0.21

After copying:
1. Open/sync the project in Android Studio.
2. Build > Build Bundle(s) / APK(s) > Build APK(s).
