# personal-project

Small Java project prepared for interview practice.

## Interview prep

- [Airwallex DSA question bank](docs/airwallex-dsa-question-bank.md)
- [OOP interview question bank](docs/oop-interview-question-bank.md)

## Validate practice changes

Use this quick loop after implementing any exercise:

```sh
gradle test
```

If Gradle is unavailable:

```sh
bash scripts/run-plain-tests.sh
```

For each solution, validate:

- Happy path examples pass.
- Edge cases from the question artifact pass.
- Public API stays small and readable.
- Time and space complexity can be explained in 1 minute.
- OOP exercises separate game/model rules from input/output.

## Run tests

Preferred:

```sh
gradle test
```

If Gradle is not installed yet, run the plain Java smoke test:

```sh
bash scripts/run-plain-tests.sh
```

## Gradle vs plain Java tests

Use Gradle for interviews when allowed. It gives repeatable test commands, dependency
management, IDE import, and standard JUnit output.

Plain Java tests are okay for very small exercises or restricted environments, but you
lose JUnit assertions, reports, and dependency handling.
