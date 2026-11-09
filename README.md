# MineX Launcher — Android starter

An independent Kotlin/Android starter project for a future Minecraft Java launcher.

## Included now
- Native Android application shell
- MineX Launcher home screen
- Version selector UI placeholder
- Memory allocation control (UI only)
- Status panels for Java, mod loaders, accounts, files, and logs

## Not implemented yet
This package is **not a functioning Minecraft Java launcher** and does not create a playable game session. It currently has no:
- Java runtime installation or execution
- Minecraft version manifest/download/asset/library resolver
- Microsoft OAuth authentication or account token handling
- Forge/Fabric installer
- LWJGL/GLFW/SDL graphics and input bridge
- Game process orchestration, crash reporting, or device-specific native binaries

These are substantial components and must be implemented and tested separately. Do not enter Microsoft credentials into this starter app.

## Build requirements
- Android Studio
- JDK 17
- Android SDK Platform 35
- Android Gradle Plugin 8.7.3 / Kotlin 2.0.21

Open the project directory in Android Studio, sync Gradle, then select:
**Build > Build Bundle(s) / APK(s) > Build APK(s)**.

This environment did not build or test an APK. The ZIP contains source files only.
