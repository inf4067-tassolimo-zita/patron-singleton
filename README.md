# patron-singleton - Patron de construction : Singleton

Devoir INF4067 / INF461 - Design Patterns : patrons de construction.

Auteur : TASSOLIMO Zita - Matricule 23U2313

## Organisation du code

```
src/
  cours/     -> code source de l'exemple vu en cours
  modifie/   -> code source de l'exemple modifie
```

## Compilation et execution (Java 8+)

```bash
javac -d bin $(find src -name "*.java")
java -cp bin <classe principale>
```

| Classe principale | Exemple |
|---|---|
| `cours.exemple1.Main` | exemple 1 du cours |
| `cours.exemple2.TestSingleton` | exemple 2 du cours |
| `modifie.singleton.TestSingleton` | exemple modifie (thread-safe) |

Sous Windows (PowerShell) : `javac -d bin (Get-ChildItem -Recurse src -Filter *.java).FullName`
