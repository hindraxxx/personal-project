# personal-project

Small Java project prepared for interview practice.

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
