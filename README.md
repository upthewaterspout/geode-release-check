This is a simple project to verify a geode release.

To use, run ./gradlew build with the urls and version of the release

./gradlew build -PmavenURL=https://repository.apache.org/content/repositories/orgapachegeode-1058 -PdownloadURL=https://dist.apache.org/repos/dist/dev/geode/1.10.0.RC1/ -Pversion=1.10.0.RC1

The GPG verification will only pass if you have imported the signature from the KEYS file.

This currently verifies
  - signatures of artifacts
  - download and basic CRUD test of geode-core from the maven site
  - source build works
  - basic gfsh CRUD test
