# JSpecify with NullAway Demo

This project serves as a demonstration of how to leverage **JSpecify** annotations in conjunction with **NullAway** to
enforce null-safety within a Java application. By integrating these tools, the goal is to enhance code robustness,
minimise runtime errors, and improve overall code quality.

## Introduction

Java's handling of null values has historically been a source of many bugs, particularly NullPointerExceptions (NPEs).
[JSpecify](https://jspecify.dev/) and [NullAway](https://github.com/uber/NullAway) offer a powerful combination for
addressing this issue. JSpecify provides type annotations, such as `@Nullable`, that specify nullability constraints.
By using [Error Prone](https://errorprone.info/) as the foundation, with NullAway configured as an additional checker,
we ensure that the nullability contracts defined by JSpecify annotations are effectively enforced, thereby providing a
robust mechanism for eliminating null-related bugs.

## Features

- **Null-safety enforcement:** Use [JSpecify](https://jspecify.dev/) annotations, like @Nullable, to explicitly mark
  and handle nullable types.
- **Compile-time analysis:** [NullAway](https://github.com/uber/NullAway) and [Error Prone](https://errorprone.info/)
  perform static analysis to ensure compliance with the specified nullability contracts.
- **Seamless integration:** Maven setup with detailed configuration in `pom.xml` for effortless integration into
  your existing Java projects.
- **Detailed error reporting:** Clear and actionable warnings are provided, allowing for easy debugging and code
  improvement.

## Prerequisites

- Java Development Kit (JDK) 21 or higher
- Apache Maven 3.6.3 or higher

## JVM Configuration

This project includes a `jvm.config` file located in the `.mvn` directory. This file is crucial for enabling the
necessary JVM options that allow Error Prone and NullAway to function correctly with the Java compiler by
ensuring compatibility with internal APIs of the compiler.

These options ensure that internal APIs of the Java compiler are accessible to Error Prone and NullAway. Without these
settings, you might encounter compilation issues or runtime errors when building the project.

If you’re integrating this project into a different setup, ensure that these JVM options are correctly applied to
maintain compatibility with the tools used.

## Installation

Clone the repository to your local machine:

```bash
git clone https://github.com/ahauschulte/jspecify-with-nullaway.git
cd jspecify-with-nullaway
```

Build the project using Maven:

```bash
mvn clean package
```

## Usage

### Running the Application

You can run the application using the following Maven command:

```bash
mvn exec:java -Dexec.mainClass="com.github.ahauschulte.nullness.Main"
```

### Code Overview

The project demonstrates the use of the `@Nullable` annotation from JSpecify to handle nullable values safely, with the
package annotated as `@NullMarked` to enforce non-nullability by default. NullAway is configured to enforce these
annotations, ensuring that any violations of the null-safety contracts are caught at compile time.

Key components include:

- The `com.github.ahauschulte.nullness.Main` class, which demonstrates the use of null-safety annotations in code.
- The `pom.xml` configuration, which integrates NullAway and Error Prone for compile-time null-safety checks.

### Example Output

Running the application will produce output that recognises individuals by their names and optionally their birthdays if
known:

```plaintext
Hello, Joe!
Oh, I think we've met before. Isn't your birthday 1982-03-04?

Hello, Jane!
Oh, I think we've met before. Isn't your birthday 1986-05-06?
So, you are actually younger than me.

Hello, Paul!
Nice to meet you.

Oh, come on. That's not your real name, is it?
```

## AI Tools Used

This project utilises the assistance of AI tools, specifically ChatGPT by OpenAI, to help generate and refine
documentation. All AI-generated content has been thoroughly reviewed and validated by human contributors to ensure
its accuracy and quality.
