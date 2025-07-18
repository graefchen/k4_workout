# Workout

Projekt Nummer Vier der Kotlin Reihe für [Basissysteme der Informationsverarbeitung II](https://lehre.idh.uni-koeln.de/lehrveranstaltungen/sommersemester-2025/basissysteme-der-informationsverarbeitung-1/).

Eine einfache [HIIT](https://en.wikipedia.org/wiki/High-intensity_interval_training) inspirierte Workout App (eher ein MVP).

## Funktionale Anforderungen

- Übungen anzeigen: Jede Übung enthält eine Textbeschreibung und ein Bild und die Reihenfolge der Übungen kann festgelegt oder zufällig sein.
- Pausen zwischen den Übungen: Die verbleibende Zeit wird als Countdown angezeigt.
- ~~Soundeffekte zur Orientierung: Ein Signalton kündigt den Start und das Ende jeder Übung an und ein anderer Sound signalisiert den Beginn und das Ende der Pausen.~~
- ~~Fortschrittsanzeige: Erfüllte Workouts werden gespeichert und User sehen z.B. mit einem Forschrittsbalken, wie viele Übungen sie bereits abgeschlossen haben.~~

## Wichtige Datein

- app/src/main/java/com/example/workout/MainActivity.kt
- app/src/main/java/com/example/workout/activity/workout/Activity.kt
- app/src/main/java/com/example/workout/activity/workout/Finished.kt
- app/src/main/java/com/example/workout/activity/workout/Pause.kt
- app/src/main/java/com/example/workout/activity/workout/Preparation.kt
- app/src/main/java/com/example/workout/activity/Choose.kt
- app/src/main/java/com/example/workout/activity/Workout.kt
- app/src/main/java/com/example/workout/components/SportsPlayer.kt
- app/src/main/java/com/example/workout/data/Workout.kt
- app/src/main/java/com/example/workout/data/WorkoutList.kt
- app/src/main/java/com/example/workout/data/WorkoutSingleton.kt

## Bilder

Sind einfach nur geklaut ([Eh-oh, eh-oh](https://youtu.be/yMR45cZbvDw)). Ja, das ist nicht nett. Ich weiß es zu 100% nicht ok.

## APK

Die apk Datei kann unter dem APK-Ordner gefunden werden

## Genutzte Referenzen

- https://stackoverflow.com/questions/41782779/how-do-we-remove-elements-from-a-mutablelist-in-kotlin
- https://stackoverflow.com/questions/51834996/singleton-class-in-kotlin
- https://en.wikipedia.org/wiki/Singleton_pattern
- https://www.geeksforgeeks.org/kotlin/kotlin-hashmap/
- https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images#3
- https://developer.android.com/develop/ui/compose/modifiers
- https://developer.android.com/develop/ui/compose/lists
- https://developer.android.com/develop/ui/compose/layouts/flow
- https://developer.android.com/develop/ui/compose/components/progress
- https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images
- 