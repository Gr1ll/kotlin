# API-Dokumentation mit Dokka

In diesem Projekt wird die **API-Dokumentation** automatisch mit einem Tool namens **Dokka** generiert. Dokka ist ein leistungsstarkes Werkzeug, das speziell für Kotlin-Projekte entwickelt wurde. Es erstellt eine übersichtliche und leicht zugängliche Dokumentation für deinen Code, ähnlich wie Javadoc für Java.

---

## Was ist eine API-Dokumentation?

Eine **API-Dokumentation** beschreibt, wie verschiedene Teile deines Codes oder deiner Software miteinander kommunizieren können. Sie enthält Informationen über:
- **Klassen**, **Funktionen** und **Eigenschaften** in deinem Code.
- Wie diese verwendet werden können.
- Welche Parameter sie akzeptieren und welche Ergebnisse sie liefern.

Die API-Dokumentation ist besonders nützlich, wenn du deinen Code mit anderen teilst oder wenn du später selbst daran arbeitest und dich schnell wieder zurechtfinden möchtest.

---

## Was macht Dokka?

Dokka nimmt den Code deines Projekts und die darin enthaltenen Kommentare und verwandelt sie in eine gut strukturierte Dokumentation. Diese Dokumentation kann in verschiedenen Formaten generiert werden, z. B.:
- **HTML**: Für eine Webseite, die du in einem Browser öffnen kannst.
- **Javadoc**: Für Projekte, die Javadoc-kompatible Dokumentation benötigen. Old School.

---

## Wie wird die API-Dokumentation generiert?

Die API-Dokumentation wird automatisch generiert, wenn du den entsprechenden Gradle-Befehl ausführst. In der Regel ist Dokka bereits in deinem Projekt konfiguriert. Hier ist ein Beispiel, wie du die Dokumentation erstellen kannst:

1. Öffne ein Terminal in deinem Projektverzeichnis.
2. Führe den folgenden Befehl aus:
   ```bash
   ./gradlew dokkaGeneratePublicationHtml
3. Somit ist die doku unter `public/kdoc` erzeugt.
