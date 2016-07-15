This is a simple project to verify a geode release.

To use, run ./gradlew build with the urls and version of the release

./gradlew build -PmavenURL=https://repository.apache.org/content/repositories/orgapachegeode-1006 -PdownloadURL=https://dist.apache.org/repos/dist/dev/incubator/geode/1.0.0-incubating.M3.RC2 -Pversion=1.0.0-incubating.M3.RC2

This currently verifies the signatures, downloads the jar from maven, and builds from source.
