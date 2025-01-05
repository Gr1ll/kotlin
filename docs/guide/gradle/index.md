
# Maven und Gradle: Was sind sie?

Wenn du an einem Kotlin-Projekt arbeitest, brauchst du oft Werkzeuge, die dir helfen, dein Projekt zu **bauen**, **Abhängigkeiten** (externe Bibliotheken, die dein Projekt benötigt) zu verwalten und Aufgaben wie Tests oder das Verpacken deiner App zu automatisieren. Genau hier kommen **Maven** und **Gradle** ins Spiel.

## Maven
Maven ist wie ein **Rezeptbuch** für dein Projekt. Es verwendet eine XML-Datei (`pom.xml`), um zu definieren, was dein Projekt benötigt und wie es gebaut werden soll. Maven gibt es schon lange und es ist sehr strukturiert, kann sich aber manchmal etwas starr anfühlen.

```
   +-------------------+
   |      Maven        |
   +-------------------+
   | pom.xml (Rezept)  |
   | Abhängigkeiten    |
   | Build-Schritte    |
   +-------------------+
```

## Gradle
Gradle ist wie ein **smarter Assistent**. Es ist moderner, schneller und flexibler als Maven. Anstelle von XML verwendet Gradle Skripte in Groovy oder Kotlin (`build.gradle` oder `build.gradle.kts`), um dein Projekt zu definieren. Gradle ist außerdem effizienter, da es nur das neu baut, was sich geändert hat.

```
   +-------------------+
   |      Gradle       |
   +-------------------+
   | build.gradle(.kts)|
   | Abhängigkeiten    |
   | Build-Schritte    |
   +-------------------+
```

## Wichtige Unterschiede
- **Flexibilität**: Gradle ist flexibler und moderner, während Maven eher starr und traditionell ist.
- **Geschwindigkeit**: Gradle ist schneller, da es inkrementelle Builds verwendet (es baut nur das neu, was sich geändert hat).
- **Syntax**: Maven verwendet XML, während Gradle Groovy- oder Kotlin-Skripte nutzt.

---

## Was macht die Datei `settings.gradle.kts`?

Die Datei `settings.gradle.kts` ist wie das **Inhaltsverzeichnis** deines Projekts. Sie sagt Gradle, welche Module (oder Teilprojekte) zu deinem Projekt gehören. Es ist eine Möglichkeit, dein Projekt in kleinere, übersichtliche Teile zu organisieren.

Ein Beispiel:
```kotlin
rootProject.name = "MeinKotlinProjekt"
include("app", "library")
```

- `rootProject.name`: Legt den Namen deines Projekts fest.
- `include`: Listet alle Module auf (z. B. `app` und `library`), die Teil deines Projekts sind.

---

## Was ist ein Modul?

Ein **Modul** ist wie ein **Kapitel** in einem Buch. Es ist ein kleinerer Teil deines Projekts, der separat gebaut und getestet werden kann. Zum Beispiel könntest du in einem Kotlin-Projekt folgende Module haben:
- Ein `app`-Modul für deine Hauptanwendung.
- Ein `library`-Modul für wiederverwendbaren Code.

Module helfen dir, dein Projekt zu organisieren und einfacher zu verwalten.

---

## Was macht die Datei `build.gradle.kts`?

Die Datei `build.gradle.kts` ist wie das **Rezept** für jedes Modul. Sie sagt Gradle, wie dieses spezifische Modul gebaut werden soll, welche Abhängigkeiten es benötigt und ob es spezielle Anweisungen gibt.

Ein Beispiel:
```kotlin
plugins {
    kotlin("jvm") version "1.8.0"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}
```

- **Plugins**: Fügen deinem Projekt Werkzeuge hinzu (z. B. Kotlin-Unterstützung).
- **Dependencies (Abhängigkeiten)**: Listen die Bibliotheken auf, die dein Modul benötigt, um zu funktionieren.

---

## Wie passt alles zusammen?

Hier ist ein einfaches Diagramm, das zeigt, wie alles miteinander verbunden ist:

```
Projekt-Root
├── settings.gradle.kts  <-- Inhaltsverzeichnis des Projekts
├── app/                 <-- Ein Modul (z. B. deine Haupt-App)
│   └── build.gradle.kts <-- Rezept für den Bau der App
├── library/             <-- Ein weiteres Modul (z. B. wiederverwendbarer Code)
│   └── build.gradle.kts <-- Rezept für den Bau der Bibliothek
```

---

Mit dieser Erklärung solltest du eine klare Vorstellung davon haben, was Maven, Gradle und die wichtigsten Gradle-Dateien in einem Kotlin-Projekt sind