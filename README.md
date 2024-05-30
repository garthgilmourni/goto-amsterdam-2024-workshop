# Full Stack Kotlin Application Development
## GOTO Amsterdam: 10th June 2024

This repository contains a series of independant Kotlin / Gradle projects, to be used on the [Full Stack Kotlin Application Development](https://gotoams.nl/2024/masterclasses/438/full-stack-kotlin-application-development) workshop at [GOTO Amsterdam](https://gotoams.nl/2024).

Full details can be found in the slide deck used to deliver the workshop. Please note that:

* All the projects are independent. Opening the entire repo in an IDE will take a very long time and so is not recommended. 
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
 * TODO
