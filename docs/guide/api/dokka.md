# Dokka


Das folgende Code-Snippet zeigt, wie Dokka in einem Kotlin-Projekt konfiguriert wird, um eine API-Dokumentation zu generieren. Hier konzentrieren wir uns auf die **Dokka-spezifischen Teile** und erklären, was sie bewirken.

---
```kotlin
plugins {
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    alias(libs.plugins.org.jetbrains.dokka)
}
dokka {
     dokkaPublications.html {
         outputDirectory.set(rootProject.layout.projectDirectory.dir("docs/public/kdoc"))
     }
        moduleName.set("Room Manager")
        dokkaSourceSets.main {

            sourceLink {
                localDirectory.set(file("src/main/kotlin"))
                remoteUrl("https://github.com/Gr1ll/kotlin")
            }
        }
}
```
## Der `plugins`-Block

Im `plugins`-Block werden die benötigten Plugins für das Projekt eingebunden. In diesem Fall:
- **`org.jetbrains.kotlin.jvm`**: Fügt Unterstützung für Kotlin-JVM-Projekte hinzu.
- **`org.jetbrains.dokka`**: Aktiviert Dokka, das Tool zur Generierung der API-Dokumentation.

```kotlin
plugins {
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    alias(libs.plugins.org.jetbrains.dokka)
}
```

---

## Der `dokka`-Block

Der `dokka`-Block enthält die Konfiguration für Dokka. Hier wird festgelegt, wie und wo die API-Dokumentation generiert wird.

### 1. **`dokkaPublications.html`**
Dieser Abschnitt definiert, dass die Dokumentation im **HTML-Format** generiert wird. Das HTML-Format ist ideal, um die Dokumentation in einem Browser anzuzeigen.

```kotlin
dokkaPublications.html {
    outputDirectory.set(rootProject.layout.projectDirectory.dir("docs/public/kdoc"))
}
```

- **`outputDirectory`**: Gibt an, wo die generierte Dokumentation gespeichert wird. In diesem Fall wird sie im Ordner `docs/public/kdoc` im Projektverzeichnis abgelegt.

---

### 2. **`moduleName`**
Mit `moduleName` wird der Name des Moduls festgelegt, der in der Dokumentation angezeigt wird.

```kotlin
moduleName.set("Room Manager")
```

In diesem Beispiel wird das Modul in der Dokumentation als **"Room Manager"** bezeichnet.

---

### 3. **`dokkaSourceSets.main`**
Hier wird die Haupt-Quellensammlung (`main`) konfiguriert. Das ist der Teil, der Dokka mitteilt, welche Dateien dokumentiert werden sollen und wie die Quellcode-Links eingerichtet werden.

```kotlin
dokkaSourceSets.main {
    sourceLink {
        localDirectory.set(file("src/main/kotlin"))
        remoteUrl("https://github.com/Gr1ll/kotlin")
    }
}
```

- **`sourceLink`**: Verknüpft den lokalen Quellcode mit einem Remote-Repository (z. B. GitHub). Das bedeutet, dass in der generierten Dokumentation Links zu deinem Quellcode angezeigt werden.
  - **`localDirectory`**: Gibt den lokalen Ordner an, in dem sich der Quellcode befindet (hier: `src/main/kotlin`).
  - **`remoteUrl`**: Gibt die URL des Remote-Repositorys an (hier: `https://github.com/Gr1ll/kotlin`). Dadurch können Nutzer der Dokumentation direkt auf den Quellcode im Repository zugreifen.

---

## Zusammenfassung

Dieses Snippet konfiguriert Dokka, um eine API-Dokumentation für das Projekt zu erstellen. Die wichtigsten Punkte sind:
1. **HTML-Dokumentation** wird generiert und im Ordner `docs/public/kdoc` gespeichert.
2. Das Modul wird in der Dokumentation als **"Room Manager"** bezeichnet.

