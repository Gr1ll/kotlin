# Erklärung von TOML-Dateien in Gradle

## Was ist eine TOML-Datei?

TOML steht für "Tom's Obvious, Minimal Language". Es handelt sich um ein einfaches und leicht lesbares Dateiformat, das oft für Konfigurationen verwendet wird. In Gradle-Projekten wird eine spezielle TOML-Datei namens `libs.versions.toml` genutzt, um Abhängigkeiten und ihre Versionen zentral zu verwalten.

## Warum verwenden wir TOML in Gradle?

In einem Gradle-Projekt gibt es oft viele Abhängigkeiten (Libraries), die wir verwenden, um Funktionen hinzuzufügen. Jede Abhängigkeit hat eine spezifische Version, die wir angeben müssen. Anstatt diese Versionen direkt im `build.gradle.kts`-Skript zu schreiben, können wir sie in der `libs.versions.toml`-Datei definieren. Dies hat mehrere Vorteile:

1. **Zentrale Verwaltung**: Alle Versionen befinden sich an einem Ort, was die Verwaltung und Aktualisierung erleichtert.
2. **Klarheit und Übersicht**: Der `build.gradle.kts`-Code wird sauberer und übersichtlicher.
3. **Wiederverwendbarkeit**: Wenn mehrere Module im Projekt dieselbe Abhängigkeit nutzen, können sie alle auf dieselbe Version in der TOML-Datei verweisen.
4. **Fehlervermeidung**: Es reduziert das Risiko, verschiedene Versionen derselben Abhängigkeit in einem Projekt zu verwenden.

## Wie funktioniert die `libs.versions.toml`?

In der `libs.versions.toml`-Datei definieren wir:

 **Versionen**: Unter `[versions]` werden die spezifischen Versionen von Abhängigkeiten angegeben.
 **Bibliotheken**: Unter `[libraries]` werden die Abhängigkeiten mit ihrem Modulnamen und ihrer entsprechenden Version verknüpft.
 **Plugins**: Unter `[plugins]` werden Plugins mit ihren IDs und Versionen definiert.

Beispiel aus der `libs.versions.toml`:
```toml
[versions]
com-google-code-gson-gson = "2.11.0"

[libraries]
com-google-code-gson-gson = { module = "com.google.code.gson:gson", version.ref = "com-google-code-gson-gson" }
```
Im build.gradle.kts-Skript können wir dann einfach auf diese Definitionen verweisen:
```kotlin
dependencies {
    api(libs.com.google.code.gson.gson)
}

```

## Fazit

Die Verwendung von TOML-Dateien in Gradle-Projekten macht die Verwaltung von Abhängigkeiten einfacher und effizienter. Sie sorgt für eine klare Struktur und reduziert mögliche Fehlerquellen. Besonders in größeren Projekten oder Teams ist dies ein wertvolles Werkzeug, um den Überblick zu behalten und die Zusammenarbeit zu verbessern.