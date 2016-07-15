This is a simple project to verify a geode release.

To use, run ./gradlew build with the urls and version of the release

./gradlew build -PmavenURL=https://repository.apache.org/content/repositories/orgapachegeode-1006 -PdownloadURL=https://dist.apache.org/repos/dist/dev/incubator/geode/1.0.0-incubating.M3.RC2 -Pversion=1.0.0-incubating.M3.RC2

The GPG verification will only pass if you have imported the signature from the KEYS file.

This currently verifies
  - signatures of artifacts
  - download and basic CRUD test of geode-core from the maven site
  - source build works
  - basic gfsh CRUD test (manual validation still advised for this, not all errors make it back to the console).
