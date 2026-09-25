KNOWN WORLD — MILESTONE 1

Goal:
- Minecraft 26.3
- Fabric
- Java 25
- Mod ID: knownworld
- Horizontal scale: 1 Minecraft block = 1 metre
- /knownworld geo debug command

IMPORTANT:
The zip intentionally does not contain the binary gradle-wrapper.jar.
Run setup-wrapper.ps1 once on Windows to download the official wrapper
from FabricMC's 26.3 example project.

After that:

1. Open PowerShell in this folder.
2. Run:
   .\setup-wrapper.ps1
3. Then:
   .\gradlew.bat build
4. Open this folder in IntelliJ as a Gradle project.
5. Set Gradle JVM / Project SDK to Java 25.
6. Run the generated Minecraft Client configuration.
7. Create a Creative world with cheats enabled.
8. Run:
   /knownworld geo

Expected:
Two chat lines showing your Minecraft X/Z, Known World east/north metres,
1 block = 1 m, UNASSIGNED region, 0.0 m elevation and placeholder data.
