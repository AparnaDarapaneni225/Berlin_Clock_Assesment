# Berlin Clock - Java Assessment Solution

## Requirements

- Java 17 or newer
- Maven 3.8+ (recommended)
- IntelliJ IDEA, Eclipse, or VS Code with Java support

## Project structure

```text
berlin-clock/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── assessment/
    │               ├── BerlinClock.java
    │               └── Main.java
    └── test/
        └── java/
            └── com/
                └── assessment/
                    └── BerlinClockTest.java
```

## Run the application

From the project root:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.assessment.Main"
```

If your Maven installation does not have the exec plugin configured, simply run
`Main.java` directly from your IDE.

## Run tests

```bash
mvn test
```

## Expected output

For `12:56:01`:

```text
O
RROO
RROO
YYRYYRYYRYY
YOOO
```

For `00:00:00`:

```text
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO
```

For `22:32:45`:

```text
O
RRRR
RROO
YYRYYROOOOO
YYOO
```

## Approach

1. Parse the hour, minute, and second from `HH:mm:ss`.
2. Seconds row:
   - even second = `Y`
   - odd second = `O`
3. Five-hour row uses `hour / 5` red lights.
4. One-hour row uses `hour % 5` red lights.
5. Five-minute row uses `minute / 5` lights.
   - positions 3, 6, and 9 are red (`R`)
   - other lit positions are yellow (`Y`)
6. One-minute row uses `minute % 5` yellow lights.
7. Join all five rows with `\\n`.

The implementation uses only standard Java plus JUnit 5 for tests.
