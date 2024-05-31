# Full Stack Kotlin Application Development
## GOTO Amsterdam: 10th June 2024

This repository contains a series of independant Kotlin / Gradle projects, to be used on the [Full Stack Kotlin Application Development](https://gotoams.nl/2024/masterclasses/438/full-stack-kotlin-application-development) workshop at [GOTO Amsterdam](https://gotoams.nl/2024).

Full details can be found in the slide deck used to deliver the workshop. Please note that:

* All the projects are independent. Opening the entire repo in an IDE will take a very long time and is not recommended. 
* After cloning this repository, you will need to make the *gradlew* scripts executable if you intend to build and run the projects manually.

### Back end projects, using Ktor and Exposed

* *ktor-fundamentals-start* - A basic Task Manager example in Ktor, with additional links to implement.
* *ktor-fundamentals-finish* - As above, but with the additional links implemented.
* *ktor-web-applications-start* - The example rewritten using Thymeleaf Templates, with extra functionaliy to implement.
* *ktor-web-applications-finish* - As above, but with the additional features implemented.
* *ktor-rest-start* - The example rewritten as a JavaScript Single Page Application interacting with a Ktor RESTful Service. With room for expansion.
* *ktor-rest-finish* - The above example, with full functionality
* *ktor-testing-start* - The above example, refactored to support Dependency Injection. Which then allows us to create a suite of tests using the Ktor Test Framework.
* *ktor-client-start* - A full stack application. We use Compose Multiplatform for Desktop and the Ktor Client to interact with the RESTful service. NB this was created via the [Kotlin Multiplatform Wizard](https://kmp.jetbrains.com/).
* *ktor-exposed-start* - Our REST / SPA based application, but now talking to a PostgreSQL database via a repository implemented using the Exposed Framework. With two tasks to complete.
* *ktor-exposed-finish* - The completed version of the above.

### Front end projects, using KMP and Compose Multiplatform

 * *kmp-weather-basic-start* - A skeleton multiplatform app for viewing the weather in different capital cities around the world. With several UI related tasks to complete.
* *kmp-weather-basic-finish* - As above, but with full UI functionality.
* *kmp-weather-networking-start* - The weather application, now with partial networking functionality. 
* *kmp-weather-networking-finish* - As above, but with all the networking code written.
* *kmp-weather-native-start* - A completed weather application. Except for the ability to detect the users current locale. This needs to be implemented in a platform specific way, via expected and actual declarations.
* *kmp-weather-native-finish* - The completed version of the above.
* *kmp-multiplatform-testing-start* - A example of how to test platform specific functionality.