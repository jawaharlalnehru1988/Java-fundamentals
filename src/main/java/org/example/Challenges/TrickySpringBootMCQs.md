# 🍃 100+ Deep-Dive Tricky Spring Boot Interview MCQs (Master Guide)

A comprehensive compilation of **105 advanced, tricky, and deep-dive Multiple Choice Questions** designed to test subtle Spring Boot mechanisms, Spring Core IoC/DI, CGLIB proxies, `@Transactional` traps, JPA/Hibernate persistence context, Spring Security Filter Chains, Actuator, and Microservice architectures.

---

## 📑 Table of Contents
1. [Section 1: Spring Core, IoC, DI & Bean Lifecycle (Q1 – Q18)](#section-1-spring-core-ioc-di--bean-lifecycle)
2. [Section 2: Spring Boot Autoconfiguration & Starters (Q19 – Q32)](#section-2-spring-boot-autoconfiguration--starters)
3. [Section 3: Spring MVC, REST APIs & Exception Handling (Q33 – Q48)](#section-3-spring-mvc-rest-apis--exception-handling)
4. [Section 4: Spring Data JPA, Hibernate & Transaction Management (Q49 – Q68)](#section-4-spring-data-jpa-hibernate--transaction-management)
5. [Section 5: Spring Security & OAuth2 Internals (Q69 – Q82)](#section-5-spring-security--oauth2-internals)
6. [Section 6: Spring Boot Actuator & Observability (Q83 – Q92)](#section-6-spring-boot-actuator--observability)
7. [Section 7: Caching, Events, Microservices & Spring Boot 3+ (Q93 – Q105)](#section-7-caching-events-microservices--spring-boot-3)

---

## Section 1: Spring Core, IoC, DI & Bean Lifecycle

### Q1. What happens when `@Configuration(proxyBeanMethods = true)` (default) is used vs `false`?
```java
@Configuration(proxyBeanMethods = true)
public class AppConfig {
    @Bean
    public ServiceA serviceA() { return new ServiceA(databaseHelper()); }

    @Bean
    public ServiceB serviceB() { return new ServiceB(databaseHelper()); }

    @Bean
    public DatabaseHelper databaseHelper() { return new DatabaseHelper(); }
}
```
- A) Both `serviceA()` and `serviceB()` receive different instances of `DatabaseHelper`
- B) `DatabaseHelper` is instantiated once and shared (singleton) because Spring creates a CGLIB subclass proxy intercepting direct method calls
- C) Compilation error: Cannot call `@Bean` methods inside another `@Bean` method
- D) Runtime `CircularDependencyException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `DatabaseHelper` is instantiated once and shared (singleton) because Spring creates a CGLIB subclass proxy intercepting direct method calls**
**Explanation:** When `proxyBeanMethods = true` (Full `@Configuration` mode), Spring wraps the configuration class in a CGLIB proxy. Direct calls to `@Bean` methods (`databaseHelper()`) are intercepted by the proxy to return the existing singleton bean from the `ApplicationContext`. If set to `false` (Lite mode), plain Java method calls occur, creating separate instances on each invocation.
</details>

---

### Q2. What problem occurs when injecting a `prototype` scoped bean into a `singleton` scoped bean?
- A) Throws `BeanCreationException` at application startup
- B) The prototype bean is created only ONCE when the singleton bean is instantiated, and never recreated on subsequent calls
- C) Spring automatically converts the singleton bean into a prototype bean
- D) Memory leak causing immediate `OutOfMemoryError`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The prototype bean is created only ONCE when the singleton bean is instantiated, and never recreated on subsequent calls**
**Explanation:** Dependency injection happens during bean creation. Because the singleton bean is created only once during container startup, its dependencies (even if prototype-scoped) are injected only once. To obtain a fresh prototype on every call, one must use `@Lookup` method injection, `ObjectFactory<T>`, `Provider<T>`, or `ApplicationContext.getBean()`.
</details>

---

### Q3. How does Spring Boot 2.6+ handle circular dependencies by default?
```java
@Service
public class ServiceA {
    @Autowired private ServiceB serviceB;
}
@Service
public class ServiceB {
    @Autowired private ServiceA serviceA;
}
```
- A) Resolves them automatically using 3-level cache
- B) Throws `BeanCurrentlyInCreationException` and fails startup by default (`spring.main.allow-circular-references=false`)
- C) Converts them to lazy proxies silently
- D) Ignores ServiceB injection in ServiceA

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `BeanCurrentlyInCreationException` and fails startup by default (`spring.main.allow-circular-references=false`)**
**Explanation:** Starting from Spring Boot 2.6, circular dependencies are strictly forbidden and disabled by default to promote clean architecture. To resolve it without setting `spring.main.allow-circular-references=true`, one must refactor dependencies or mark one with `@Lazy`.
</details>

---

### Q4. What is the execution order of Bean Lifecycle callbacks in Spring?
1. Constructor
2. `BeanPostProcessor.postProcessAfterInitialization()`
3. `@PostConstruct`
4. `InitializingBean.afterPropertiesSet()`
5. `BeanPostProcessor.postProcessBeforeInitialization()`

- A) 1 -> 3 -> 4 -> 5 -> 2
- B) 1 -> 5 -> 3 -> 4 -> 2
- C) 1 -> 5 -> 4 -> 3 -> 2
- D) 3 -> 1 -> 4 -> 5 -> 2

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) 1 -> 5 -> 3 -> 4 -> 2**
**Explanation:**
1. Constructor executes & dependencies are injected.
2. `BeanPostProcessor.postProcessBeforeInitialization()` runs.
3. `@PostConstruct` annotated methods execute (invoked by `CommonAnnotationBeanPostProcessor`).
4. `InitializingBean.afterPropertiesSet()` executes.
5. `BeanPostProcessor.postProcessAfterInitialization()` runs (where AOP/CGLIB proxies are typically created).
</details>

---

### Q5. What is the difference between `BeanFactoryPostProcessor` (BFPP) and `BeanPostProcessor` (BPP)?
- A) BFPP modifies bean definitions and configuration metadata before any bean instances are created; BPP operates on actual bean instances during initialization
- B) BPP is executed during application shutdown; BFPP is during startup
- C) BFPP is for prototype beans; BPP is for singleton beans
- D) There is no difference; they are aliases

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) BFPP modifies bean definitions and configuration metadata before any bean instances are created; BPP operates on actual bean instances during initialization**
**Explanation:** `BeanFactoryPostProcessor` (e.g. `PropertySourcesPlaceholderConfigurer`) intercepts and alters `BeanDefinition` objects before beans are instantiated. `BeanPostProcessor` (e.g. `AutowiredAnnotationBeanPostProcessor`) intercepts and wraps instantiated bean objects before and after their initialization phase.
</details>

---

### Q6. Why is Field Injection (`@Autowired private MyService myService;`) discouraged by the Spring Team?
- A) It violates immutability (fields cannot be `final`), hides class dependencies, and makes standalone unit testing without reflection/Spring container difficult
- B) Field injection causes 50% slower runtime execution
- C) Field injection is deprecated in Java 17
- D) It only works with prototype-scoped beans

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) It violates immutability (fields cannot be `final`), hides class dependencies, and makes standalone unit testing without reflection/Spring container difficult**
**Explanation:** Constructor injection allows dependencies to be `final` (thread-safe, immutable), clearly communicates required dependencies at compile time, and enables easy mock injection in plain JUnit tests (`new MyController(mockService)`).
</details>

---

### Q7. What happens when two beans of the same type exist and neither is marked with `@Primary` nor `@Qualifier`?
```java
@Component public class EmailService implements NotificationService {}
@Component public class SmsService implements NotificationService {}
@Service
public class OrderService {
    public OrderService(NotificationService service) {} // Injection target
}
```
- A) Injects `EmailService` alphabetically
- B) Throws `NoUniqueBeanDefinitionException: expected single matching bean but found 2`
- C) Automatically injects both as an array
- D) Injects `null`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `NoUniqueBeanDefinitionException: expected single matching bean but found 2`**
**Explanation:** Spring cannot determine which bean to inject without disambiguation via `@Primary` on one bean definition or `@Qualifier("emailService")` at the injection point.
</details>

---

### Q8. What happens if the constructor parameter name matches one of the bean names?
```java
public OrderService(NotificationService emailService) {} // param name = "emailService"
```
- A) Throws `NoUniqueBeanDefinitionException`
- B) Spring uses fallback matching by bean name (`emailService`) and injects `EmailService` successfully
- C) Compilation error
- D) Injects `SmsService`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Spring uses fallback matching by bean name (`emailService`) and injects `EmailService` successfully**
**Explanation:** If type-based autowiring finds multiple candidate beans, Spring's autowiring algorithm uses the parameter or field name as a fallback qualifier to match against bean names.
</details>

---

### Q9. What does `@Lazy` on an injection point do?
```java
@Autowired
public OrderService(@Lazy PaymentService paymentService) {}
```
- A) Delays initialization of `OrderService` until first HTTP request
- B) Injects a dynamic proxy for `PaymentService`; the real `PaymentService` is instantiated only upon its first method call
- C) Makes `PaymentService` run in a background virtual thread
- D) Marks the bean for garbage collection

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Injects a dynamic proxy for `PaymentService`; the real `PaymentService` is instantiated only upon its first method call**
**Explanation:** `@Lazy` at an injection point tells Spring to inject a synthetic proxy instead of eagerly instantiating the target bean during context startup. The actual target bean is fetched and initialized the first time a method is invoked on the proxy.
</details>

---

### Q10. Which bean scope creates a single bean instance per HTTP request in a web-aware Spring ApplicationContext?
- A) `singleton`
- B) `prototype`
- C) `request`
- D) `session`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `request`**
**Explanation:** `@RequestScope` (or `@Scope("request")`) creates a new bean instance for each individual HTTP request. Once the HTTP request completes, the bean is discarded.
</details>

---

### Q11. Which annotation is used to dynamically inject a property value with Spring Expression Language (SpEL)?
- A) `@PropertySource`
- B) `@Value("#{systemProperties['user.home']}")`
- C) `@Value("${app.timeout}")`
- D) `@ConfigurationProperties`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `@Value("#{systemProperties['user.home']}")`**
**Explanation:** The `#{...}` syntax evaluates **SpEL (Spring Expression Language)** expressions against the bean context or runtime environment. The `${...}` syntax is for property placeholder resolution.
</details>

---

### Q12. What does `@ConditionalOnMissingBean` do in Spring Boot autoconfiguration?
- A) Throws an exception if a bean is missing
- B) Registers the bean only if no bean of the specified type/name already exists in the `ApplicationContext` (enabling user override)
- C) Deletes existing beans of that type
- D) Injects a dummy mock bean

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Registers the bean only if no bean of the specified type/name already exists in the `ApplicationContext` (enabling user override)**
**Explanation:** `@ConditionalOnMissingBean` is the backbone of Spring Boot's opinionated defaults. It allows users to define custom beans (e.g. `DataSource` or `ObjectMapper`), which cleanly overrides Spring Boot's auto-configured default.
</details>

---

### Q13. Can `@PostConstruct` methods throw checked exceptions?
- A) No, compilation error
- B) Yes, but if a `@PostConstruct` method throws any exception, bean initialization fails and the Spring Context halts startup with `BeanCreationException`
- C) Yes, and Spring automatically catches and logs it as a warning
- D) Only `IOException` is permitted

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, but if a `@PostConstruct` method throws any exception, bean initialization fails and the Spring Context halts startup with `BeanCreationException`**
**Explanation:** Any exception thrown in a lifecycle initialization method (`@PostConstruct`, `afterPropertiesSet()`) aborts context initialization to prevent operating with partially configured beans.
</details>

---

### Q14. What is the difference between `@Component`, `@Service`, and `@Repository`?
- A) `@Component` is a generic stereotype; `@Service` and `@Repository` are specialized stereotypes with identical functionality plus semantic clarity (and `@Repository` automatically enables automatic persistence exception translation)
- B) `@Service` beans run in separate threads; `@Repository` runs in a transaction
- C) `@Component` cannot be autowired
- D) `@Service` beans are prototype scoped by default

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@Component` is a generic stereotype; `@Service` and `@Repository` are specialized stereotypes with identical functionality plus semantic clarity (and `@Repository` automatically enables automatic persistence exception translation)**
**Explanation:** `@Service` and `@Repository` are meta-annotated with `@Component`. `@Repository` also registers `PersistenceExceptionTranslationPostProcessor`, translating native JPA/Hibernate/JDBC SQLExceptions into Spring's consistent `DataAccessException` hierarchy.
</details>

---

### Q15. What happens when calling `context.close()` vs `context.stop()`?
- A) `close()` destroys all singleton beans and completely closes the ApplicationContext; `stop()` only sends a stop signal to `Lifecycle` components without destroying beans
- B) Both are identical
- C) `close()` cannot be called on web applications
- D) `stop()` kills the JVM process

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `close()` destroys all singleton beans and completely closes the ApplicationContext; `stop()` only sends a stop signal to `Lifecycle` components without destroying beans**
**Explanation:** `close()` invokes `@PreDestroy` and `DisposableBean.destroy()`, releasing resources and terminating the context. `stop()` only invokes `Lifecycle.stop()` on registered lifecycle beans, allowing the context to be restarted via `start()`.
</details>

---

### Q16. Can `@Bean` methods in a `@Component` class be `private`?
- A) Yes, since Java 9
- B) No, `@Bean` methods cannot be `private` or `final` because Spring needs to discover and subclass them
- C) Yes, if marked with `@Autowired`
- D) Only in test configurations

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, `@Bean` methods cannot be `private` or `final` because Spring needs to discover and subclass them**
**Explanation:** In Spring, factory methods declared with `@Bean` must be overridable/accessible (typically `public` or `package-private`). Making them `private` or `final` results in a compilation/startup validation failure.
</details>

---

### Q17. What is an `ApplicationContextAware` interface used for?
- A) To notify Spring when the application is deployed to cloud
- B) To give a bean access to the enclosing Spring `ApplicationContext` instance
- C) To make a bean thread-safe
- D) To create a new ApplicationContext for each request

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) To give a bean access to the enclosing Spring `ApplicationContext` instance**
**Explanation:** Implementing `ApplicationContextAware` (or using `@Autowired private ApplicationContext ctx;`) allows a bean to dynamically look up other beans, publish events, or inspect environment properties.
</details>

---

### Q18. What does `@DependsOn` annotation specify on a Bean?
- A) Forces garbage collection of the dependent bean
- B) Explicitly guarantees that specified beans are initialized BEFORE the annotated bean is initialized
- C) Injects all methods from that bean
- D) Makes the bean depend on an external HTTP service

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Explicitly guarantees that specified beans are initialized BEFORE the annotated bean is initialized**
**Explanation:** `@DependsOn({"beanA", "beanB"})` forces Spring to fully construct and initialize `beanA` and `beanB` before attempting to construct the annotated bean (useful for background thread managers or database driver setups).
</details>

---

## Section 2: Spring Boot Autoconfiguration & Starters

### Q19. What 3 annotations are bundled inside `@SpringBootApplication`?
- A) `@Configuration`, `@EnableAutoConfiguration`, `@ComponentScan`
- B) `@SpringBootConfiguration`, `@EnableAutoConfiguration`, `@ComponentScan`
- C) `@Service`, `@Controller`, `@Repository`
- D) `@EnableScheduling`, `@EnableAsync`, `@Configuration`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `@SpringBootConfiguration`, `@EnableAutoConfiguration`, `@ComponentScan`**
**Explanation:** `@SpringBootApplication` is a convenience meta-annotation combining `@SpringBootConfiguration` (a specialized form of `@Configuration`), `@EnableAutoConfiguration` (to load auto-config classes), and `@ComponentScan` with default package filtering.
</details>

---

### Q20. Where are Auto-configuration classes declared in Spring Boot 3.0+?
- A) `META-INF/spring.factories` under `org.springframework.boot.autoconfigure.EnableAutoConfiguration`
- B) `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`
- C) `application.properties`
- D) `pom.xml`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`**
**Explanation:** In Spring Boot 2.7+ and standard in 3.0+, auto-configuration registrations were migrated from `META-INF/spring.factories` to line-separated class names in `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`.
</details>

---

### Q21. What is "Relaxed Binding" in `@ConfigurationProperties`?
- A) Allows binding properties without validating their types
- B) Allows flexible property name matching (e.g. `server.port-number`, `server.portNumber`, `SERVER_PORTNUMBER`, and `server.port_number` all bind to the field `portNumber`)
- C) Allows properties to be injected without getters/setters
- D) Allows missing configuration files without error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Allows flexible property name matching (e.g. `server.port-number`, `server.portNumber`, `SERVER_PORTNUMBER`, and `server.port_number` all bind to the field `portNumber`)**
**Explanation:** Spring Boot uses relaxed binding for `@ConfigurationProperties`, allowing kebab-case, camelCase, snake_case, and UPPERCASE environment variables to seamlessly bind to Java properties.
</details>

---

### Q22. What is the priority order of configuration sources in Spring Boot (highest to lowest)?
1. Command Line Arguments (`--server.port=9090`)
2. `application.properties` inside jar (classpath)
3. OS Environment Variables (`SERVER_PORT=8080`)
4. Java System Properties (`-Dserver.port=7070`)

- A) 1 -> 4 -> 3 -> 2
- B) 3 -> 1 -> 4 -> 2
- C) 1 -> 3 -> 4 -> 2
- D) 4 -> 1 -> 3 -> 2

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) 1 -> 4 -> 3 -> 2**
**Explanation:** Command line arguments have the highest precedence, followed by Java System Properties (`-D`), OS Environment variables, and finally packaged classpath `application.properties`/`application.yml`.
</details>

---

### Q23. What is the difference between `CommandLineRunner` and `ApplicationRunner`?
- A) `CommandLineRunner` accepts raw `String[] args`; `ApplicationRunner` provides structured `ApplicationArguments` with parsed options and non-option arguments
- B) `CommandLineRunner` executes before context refresh; `ApplicationRunner` executes after
- C) `CommandLineRunner` is deprecated
- D) `ApplicationRunner` runs on a separate thread

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `CommandLineRunner` accepts raw `String[] args`; `ApplicationRunner` provides structured `ApplicationArguments` with parsed options and non-option arguments**
**Explanation:** Both run right after the Spring ApplicationContext is fully started. `ApplicationRunner` provides convenient helper methods like `args.getOptionNames()`, `args.getOptionValues("name")`.
</details>

---

### Q24. How can you exclude a specific auto-configuration class in Spring Boot?
- A) `@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})`
- B) `spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration` in `application.properties`
- C) Both A and B are valid
- D) By deleting the starter dependency only

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) Both A and B are valid**
**Explanation:** Specific auto-configuration classes can be disabled programmatically via the `exclude` attribute on `@SpringBootApplication` or declaratively via `spring.autoconfigure.exclude` in configuration properties.
</details>

---

### Q25. What does `@ConditionalOnProperty(name = "feature.enabled", havingValue = "true", matchIfMissing = false)` do?
- A) Always loads the bean
- B) Loads the bean only if `feature.enabled` is explicitly set to `"true"` in properties/environment
- C) Throws an exception if the property is missing
- D) Loads the bean if the property is missing

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Loads the bean only if `feature.enabled` is explicitly set to `"true"` in properties/environment**
**Explanation:** Because `matchIfMissing = false`, if `feature.enabled` is not found, the condition evaluates to false and the bean is not loaded.
</details>

---

### Q26. Which embedded servlet container is the default in `spring-boot-starter-web`?
- A) Jetty
- B) Apache Tomcat
- C) Undertow
- D) Netty

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Apache Tomcat**
**Explanation:** `spring-boot-starter-web` includes Apache Tomcat by default. To use Jetty or Undertow, Tomcat must be excluded from the starter and the corresponding starter dependency included.
</details>

---

### Q27. Which embedded reactive web server is the default in `spring-boot-starter-webflux`?
- A) Apache Tomcat
- B) Reactor Netty
- C) Undertow
- D) Jetty

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Reactor Netty**
**Explanation:** Spring WebFlux uses non-blocking event-driven Reactor Netty as its default embedded server runtime.
</details>

---

### Q28. What is the role of Spring Boot Maven/Gradle plugin during packaging?
- A) Compiles Java files only
- B) Repackages compiled classes and dependencies into an executable "Fat JAR" with nested JAR loaders and custom `Main-Class: org.springframework.boot.loader.JarLauncher`
- C) Obfuscates bytecode
- D) Uploads the jar to Docker Hub

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Repackages compiled classes and dependencies into an executable "Fat JAR" with nested JAR loaders and custom `Main-Class: org.springframework.boot.loader.JarLauncher`**
**Explanation:** Standard Java JAR loaders do not support nested JARs inside JARs (`BOOT-INF/lib`). The Spring Boot plugin creates an executable archive that includes a custom launcher capable of loading nested libraries.
</details>

---

### Q29. How can you define multi-profile documents in a single `application.yml` file?
```yaml
server:
  port: 8080
---
spring:
  config:
    activate:
      on-profile: prod
server:
  port: 443
```
- A) Using `---` document separators and `spring.config.activate.on-profile`
- B) Using `@Profile` tags inside YAML
- C) Not supported; multiple files are mandatory
- D) Using `###` comments

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Using `---` document separators and `spring.config.activate.on-profile`**
**Explanation:** In Spring Boot 2.4+, YAML multi-document support uses `---` as separators combined with `spring.config.activate.on-profile: <profile_name>`.
</details>

---

### Q30. What happens if a property is defined in both `application.properties` and `application-dev.properties` when the `dev` profile is active?
- A) Throws `DuplicateKeyException`
- B) `application-dev.properties` value overrides the value in `application.properties`
- C) `application.properties` value takes precedence
- D) Both values are concatenated

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `application-dev.properties` value overrides the value in `application.properties`**
**Explanation:** Profile-specific property files (`application-{profile}.properties`) have higher precedence than the default generic `application.properties` file and will override matching keys.
</details>

---

### Q31. What is the effect of setting `spring.main.banner-mode=off`?
- A) Disables logging
- B) Suppresses the ASCII Spring Boot Banner printed on console during startup
- C) Speeds up CPU clock
- D) Disables web endpoints

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Suppresses the ASCII Spring Boot Banner printed on console during startup**
**Explanation:** Setting banner mode to `off` suppresses the default ASCII logo printout during JVM bootstrap.
</details>

---

### Q32. What does `@AutoConfigureAfter(DataSourceAutoConfiguration.class)` achieve?
- A) Automatically loads DataSource after the annotated auto-configuration class
- B) Hints to Spring Boot's auto-configuration ordering engine to evaluate the annotated configuration class AFTER `DataSourceAutoConfiguration` has completed
- C) Enforces a compile-time dependency
- D) Closes DataSource after execution

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Hints to Spring Boot's auto-configuration ordering engine to evaluate the annotated configuration class AFTER `DataSourceAutoConfiguration` has completed**
**Explanation:** In custom auto-configuration starters, `@AutoConfigureAfter` and `@AutoConfigureBefore` control the deterministic sequencing of auto-configuration phases.
</details>

---

## Section 3: Spring MVC, REST APIs & Exception Handling

### Q33. What is the difference between `@Controller` and `@RestController`?
- A) `@RestController` is meta-annotated with `@Controller` and `@ResponseBody`, automatically serializing return values into HTTP response bodies (JSON/XML)
- B) `@RestController` does not support GET requests
- C) `@Controller` can only be used with SOAP services
- D) `@RestController` is asynchronous by default

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@RestController` is meta-annotated with `@Controller` and `@ResponseBody`, automatically serializing return values into HTTP response bodies (JSON/XML)**
**Explanation:** In a standard `@Controller`, a String return value is interpreted as a view name resolved by a `ViewResolver`. In `@RestController`, `@ResponseBody` is implicitly active on every method, sending serialized data directly to the client via `HttpMessageConverter` (like Jackson).
</details>

---

### Q34. What is the difference between `@RequestParam` and `@PathVariable`?
```java
// URL: /users/42?details=true
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id, @RequestParam boolean details) {}
```
- A) `@PathVariable` extracts values embedded directly in URI path segments (`{id}`); `@RequestParam` extracts query string parameters (`?details=true`) or form data
- B) `@RequestParam` is for headers; `@PathVariable` is for cookies
- C) `@PathVariable` cannot be converted to numbers
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@PathVariable` extracts values embedded directly in URI path segments (`{id}`); `@RequestParam` extracts query string parameters (`?details=true`) or form data**
**Explanation:** `@PathVariable` maps RESTful URI templates (e.g. `/users/42`), while `@RequestParam` reads URL query parameters (e.g. `?details=true`).
</details>

---

### Q35. What is the execution order of `HandlerInterceptor` methods during an HTTP request?
- A) `preHandle` -> Controller Method -> `postHandle` -> View Rendered -> `afterCompletion`
- B) `preHandle` -> `afterCompletion` -> Controller Method -> `postHandle`
- C) Controller Method -> `preHandle` -> `postHandle`
- D) `postHandle` -> `preHandle` -> `afterCompletion`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `preHandle` -> Controller Method -> `postHandle` -> View Rendered -> `afterCompletion`**
**Explanation:**
1. `preHandle()` runs before controller execution (returns `false` to abort).
2. Controller method processes request.
3. `postHandle()` runs after controller returns, before view rendering.
4. `afterCompletion()` executes after the entire request and response processing is complete (ideal for cleanup and performance metrics).
</details>

---

### Q36. What is the difference between a Servlet `Filter` and a Spring `HandlerInterceptor`?
- A) Filters are part of the Servlet container and execute before request reaches the `DispatcherServlet`; Interceptors are Spring-managed and execute inside the Spring MVC context between `DispatcherServlet` and Controller handlers
- B) Filters only work with HTTPS
- C) Interceptors cannot access Spring beans
- D) Filters cannot modify HTTP headers

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Filters are part of the Servlet container and execute before request reaches the `DispatcherServlet`; Interceptors are Spring-managed and execute inside the Spring MVC context between `DispatcherServlet` and Controller handlers**
**Explanation:** Servlet Filters sit at the outer web layer (handling low-level tasks like CORS, security, encoding, logging before reaching Spring). Interceptors sit inside Spring MVC, with access to handler metadata (`HandlerMethod`) and Spring exception translation.
</details>

---

### Q37. What does `@ControllerAdvice` / `@RestControllerAdvice` provide?
- A) Global cross-cutting exception handling, model attributes, and init binders across all `@Controller` / `@RestController` classes
- B) Automated unit tests generation
- C) Database caching advice
- D) Security authorization checks

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Global cross-cutting exception handling, model attributes, and init binders across all `@Controller` / `@RestController` classes**
**Explanation:** `@RestControllerAdvice` allows centralized error handling using `@ExceptionHandler` methods, transforming unhandled application exceptions into standardized REST error response envelopes.
</details>

---

### Q38. What exception is thrown when request body validation fails with `@Valid` on a `@RequestBody` parameter?
- A) `ConstraintViolationException`
- B) `MethodArgumentNotValidException`
- C) `IllegalArgumentException`
- D) `HttpMediaTypeNotSupportedException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `MethodArgumentNotValidException`**
**Explanation:** In Spring MVC, when `@Valid` or `@Validated` fails on a `@RequestBody` DTO parameter, Spring automatically throws `MethodArgumentNotValidException` (which typically translates to HTTP 400 Bad Request).
</details>

---

### Q39. What is the difference between `@Valid` and `@Validated`?
- A) `@Valid` is standard Jakarta/JSR-380 (supports nested cascaded validation); `@Validated` is a Spring-specific variant that supports **Validation Groups** and can be applied at the class level for method parameter validation
- B) `@Validated` is deprecated
- C) `@Valid` only works on database entities
- D) `@Validated` can only validate numbers

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@Valid` is standard Jakarta/JSR-380 (supports nested cascaded validation); `@Validated` is a Spring-specific variant that supports **Validation Groups** and can be applied at the class level for method parameter validation**
**Explanation:** `@Validated` allows specifying groups (e.g. `@Validated(OnCreate.class)` vs `@Validated(OnUpdate.class)`) to conditionally trigger specific validation rules.
</details>

---

### Q40. Which HTTP status code should be returned when a new resource is successfully created via a POST request?
- A) `200 OK`
- B) `201 Created`
- C) `204 No Content`
- D) `202 Accepted`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `201 Created`**
**Explanation:** Standard REST specification mandates returning `201 Created` (preferably with a `Location` header pointing to the newly created resource URI).
</details>

---

### Q41. What HTTP status code is returned for `204 No Content`?
- A) Request succeeded, but the response body is intentionally empty (e.g. successful DELETE operation)
- B) Resource not found
- C) Request timed out
- D) Server error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Request succeeded, but the response body is intentionally empty (e.g. successful DELETE operation)**
**Explanation:** `204 No Content` indicates successful completion where the client does not need to navigate away or expect a payload body.
</details>

---

### Q42. What is the role of `DispatcherServlet` in Spring MVC?
- A) Acts as the Front Controller, intercepting all incoming HTTP requests and dispatching them to appropriate handler mappings, controllers, view resolvers, and message converters
- B) Manages database transactions
- C) Compiles JSP pages
- D) Encrypts HTTP traffic

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Acts as the Front Controller, intercepting all incoming HTTP requests and dispatching them to appropriate handler mappings, controllers, view resolvers, and message converters**
**Explanation:** `DispatcherServlet` is the core architectural entry point of Spring MVC implementing the Front Controller design pattern.
</details>

---

### Q43. What does `@ResponseStatus(HttpStatus.NOT_FOUND)` on a custom Exception class do?
```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {}
```
- A) Automatically maps the exception to HTTP 404 response when thrown from a controller method without needing an explicit `@ExceptionHandler`
- B) Logs the exception as 404 in console only
- C) Retries the request 404 times
- D) Causes a compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Automatically maps the exception to HTTP 404 response when thrown from a controller method without needing an explicit `@ExceptionHandler`**
**Explanation:** `@ResponseStatus` tells Spring MVC to set the HTTP response code to `404 Not Found` whenever this unhandled exception bubbles up from a controller handler.
</details>

---

### Q44. How does Content Negotiation work in Spring MVC?
- A) By inspecting the `Accept` request header, query parameters, or file extensions to select the appropriate `HttpMessageConverter` (e.g., JSON via Jackson vs XML via JAXB)
- B) By negotiating with the database driver
- C) By negotiating network bandwidth with the client
- D) By selecting between HTTP/1.1 and HTTP/2

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) By inspecting the `Accept` request header, query parameters, or file extensions to select the appropriate `HttpMessageConverter` (e.g., JSON via Jackson vs XML via JAXB)**
**Explanation:** When a client sends `Accept: application/xml`, Spring looks for an `HttpMessageConverter` configured for XML; if `Accept: application/json` is sent, Jackson produces JSON.
</details>

---

### Q45. What is the return type for pushing Server-Sent Events (SSE) in Spring MVC?
- A) `WebSocketSession`
- B) `SseEmitter`
- C) `ResponseEntity<String>`
- D) `AsyncResponse`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `SseEmitter`**
**Explanation:** `SseEmitter` is a specialized Spring MVC return type designed for streaming asynchronous text/event streams over a long-lived HTTP connection.
</details>

---

### Q46. What is the difference between `@RequestBody` and `@ModelAttribute`?
- A) `@RequestBody` reads and deserializes the raw HTTP request body via `HttpMessageConverter` (typically JSON/XML); `@ModelAttribute` binds form-encoded data or query parameters to a Java model object
- B) `@ModelAttribute` is only for XML
- C) `@RequestBody` only works with GET requests
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@RequestBody` reads and deserializes the raw HTTP request body via `HttpMessageConverter` (typically JSON/XML); `@ModelAttribute` binds form-encoded data or query parameters to a Java model object**
**Explanation:** `@RequestBody` is used for payload-driven APIs (`application/json`), whereas `@ModelAttribute` is used for form submissions (`application/x-www-form-urlencoded` or `multipart/form-data`).
</details>

---

### Q47. What does `OncePerRequestFilter` guarantee?
- A) Filter executes only once in the lifetime of the application
- B) Guarantees execution exactly once per request dispatch in a single request thread, preventing duplicate filter invocations during internal forward or error dispatches
- C) Restricts requests to 1 concurrent user
- D) Automatically caches the request

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Guarantees execution exactly once per request dispatch in a single request thread, preventing duplicate filter invocations during internal forward or error dispatches**
**Explanation:** In servlet containers, request forwarding or asynchronous dispatches can trigger standard filters multiple times. `OncePerRequestFilter` uses request attributes to ensure idempotent single execution.
</details>

---

### Q48. What does `@CrossOrigin` annotation enable?
- A) Cross-Origin Resource Sharing (CORS) headers (such as `Access-Control-Allow-Origin`) for allowing browser requests from different origins/domains
- B) Database replication across cloud regions
- C) Cross-site scripting (XSS) prevention
- D) Session replication

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Cross-Origin Resource Sharing (CORS) headers (such as `Access-Control-Allow-Origin`) for allowing browser requests from different origins/domains**
**Explanation:** Browsers enforce the Same-Origin Policy. `@CrossOrigin(origins = "http://frontend.com")` instructs Spring to attach appropriate CORS response headers.
</details>

---

## Section 4: Spring Data JPA, Hibernate & Transaction Management

### Q49. Why does `@Transactional` fail to execute when a method is called from another method within the same class?
```java
@Service
public class UserService {
    public void registerUser() {
        // internal self-invocation
        saveUserData(); 
    }

    @Transactional
    public void saveUserData() {
        // database operations
    }
}
```
- A) `@Transactional` is not supported on public methods
- B) Spring uses CGLIB/JDK dynamic proxies for transaction interception. Internal self-invocations (`this.saveUserData()`) bypass the Spring proxy, invoking the raw instance directly without starting a transaction
- C) Hibernate disables transactions automatically
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Spring uses CGLIB/JDK dynamic proxies for transaction interception. Internal self-invocations (`this.saveUserData()`) bypass the Spring proxy, invoking the raw instance directly without starting a transaction**
**Explanation:** Spring AOP proxies intercept external calls coming into the bean. When calling a method internally via `this`, the call does not pass through the proxy wrapper, causing `@Transactional`, `@Async`, and `@Cacheable` to be completely ignored.
</details>

---

### Q50. By default, which exceptions trigger a rollback in a `@Transactional` method?
- A) All checked and unchecked exceptions
- B) Only `RuntimeException` and `Error` (Unchecked Exceptions)
- C) Only `SQLException`
- D) Only `NullPointerException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Only `RuntimeException` and `Error` (Unchecked Exceptions)**
**Explanation:** By default, Spring's transaction infrastructure only rolls back on unchecked exceptions (`RuntimeException` and `Error`). Checked exceptions (e.g. `IOException`, `Exception`) commit the transaction unless explicitly declared with `@Transactional(rollbackFor = Exception.class)`.
</details>

---

### Q51. What is the behavior of `Propagation.REQUIRES_NEW`?
- A) Joins the existing transaction if one exists
- B) Suspends any existing outer transaction, creates a brand new independent physical transaction, and resumes the outer transaction once the new transaction finishes
- C) Throws an exception if a transaction already exists
- D) Runs without any transaction

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Suspends any existing outer transaction, creates a brand new independent physical transaction, and resumes the outer transaction once the new transaction finishes**
**Explanation:** `REQUIRES_NEW` guarantees an isolated transaction that commits or rolls back independently of the calling outer transaction (commonly used for audit logging).
</details>

---

### Q52. What is the default Transaction Propagation level in Spring?
- A) `Propagation.SUPPORTS`
- B) `Propagation.REQUIRED`
- C) `Propagation.REQUIRES_NEW`
- D) `Propagation.MANDATORY`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `Propagation.REQUIRED`**
**Explanation:** `REQUIRED` is the default. If a transaction already exists, it participates in it; if no transaction exists, it creates a new one.
</details>

---

### Q53. What is the N+1 Query Problem in JPA/Hibernate?
- A) Executing 1 query to fetch $N$ parent records, followed by $N$ separate queries to fetch the associated child collection for each parent
- B) Inserting $N+1$ records into the database
- C) A syntax error in JPQL
- D) Running out of database connections

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Executing 1 query to fetch $N$ parent records, followed by $N$ separate queries to fetch the associated child collection for each parent**
**Explanation:** If an entity has a lazy association (`@ManyToOne` or `@OneToMany`) and is loaded via `findAll()`, iterating over the collection fires 1 initial query plus $N$ additional queries for every single row, destroying database performance.
</details>

---

### Q54. How do you solve the N+1 query problem in Spring Data JPA?
- A) Use `JOIN FETCH` in a custom JPQL query or define an `@EntityGraph(attributePaths = {"children"})`
- B) Change all relations to `FetchType.EAGER`
- C) Increase database connection pool size
- D) Disable Hibernate caching

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Use `JOIN FETCH` in a custom JPQL query or define an `@EntityGraph(attributePaths = {"children"})`**
**Explanation:** `JOIN FETCH` forces Hibernate to load parents and their associated relations in a single SQL `INNER/LEFT JOIN` query.
</details>

---

### Q55. What causes a `LazyInitializationException` in Hibernate?
- A) Database driver is outdated
- B) Accessing a lazily-fetched entity property or collection outside of an active Hibernate `Session` / Transaction (when the session has already closed)
- C) Creating a circular entity relation
- D) Using `@GeneratedValue` incorrectly

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Accessing a lazily-fetched entity property or collection outside of an active Hibernate `Session` / Transaction (when the session has already closed)**
**Explanation:** Lazily loaded associations rely on dynamic proxies that require an open Hibernate `Session` to execute database queries on demand. If accessed after the session closes (e.g. in a Controller after the `@Transactional` service has completed), Hibernate throws `LazyInitializationException`.
</details>

---

### Q56. What is Hibernate "Dirty Checking"?
- A) Scanning database for corrupted records
- B) Automatic detection of state modifications on managed entities within a transaction, automatically executing SQL `UPDATE` statements on transaction commit without needing explicit `repository.save()`
- C) Validating entity constraints before insert
- D) Deleting unreferenced child rows

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Automatic detection of state modifications on managed entities within a transaction, automatically executing SQL `UPDATE` statements on transaction commit without needing explicit `repository.save()`**
**Explanation:** Hibernate maintains snapshots of all managed entities in the First-Level Cache (Persistence Context). At flush/commit time, it compares the current state with the snapshot and issues SQL `UPDATE` statements automatically.
</details>

---

### Q57. What are the 4 Entity Lifecycle States in JPA?
- A) New, Active, Inactive, Dead
- B) Transient (New), Managed (Persistent), Detached, Removed
- C) Created, Read, Updated, Deleted
- D) Saved, Cached, Flushed, Closed

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Transient (New), Managed (Persistent), Detached, Removed**
**Explanation:**
- **Transient**: Object created via `new`, not associated with any persistence context.
- **Managed**: Associated with persistence context; changes are tracked and saved automatically.
- **Detached**: Previously managed, but its session/context has closed.
- **Removed**: Marked for deletion from database upon commit.
</details>

---

### Q58. What is the difference between `repository.findById(id)` and `repository.getReferenceById(id)` (formerly `getOne`)?
- A) `findById` eagerly executes SQL `SELECT` and returns `Optional<T>`; `getReferenceById` returns a lazy CGLIB proxy without hitting the database until a property is accessed
- B) `getReferenceById` only works with String IDs
- C) `findById` throws an exception if the entity does not exist
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `findById` eagerly executes SQL `SELECT` and returns `Optional<T>`; `getReferenceById` returns a lazy CGLIB proxy without hitting the database until a property is accessed**
**Explanation:** `getReferenceById(id)` internally calls `EntityManager.getReference()`, returning a proxy. This is optimal when setting foreign key references without needing to load all data from the database.
</details>

---

### Q59. How does Optimistic Locking work in Spring Data JPA?
- A) By locking database rows using `SELECT ... FOR UPDATE`
- B) By maintaining a `@Version` column (number or timestamp) on the entity; updates check if the version matches, throwing `OptimisticLockingFailureException` on concurrent overwrite conflicts
- C) Disables transactions
- D) Only allows one user at a time to login

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) By maintaining a `@Version` column (number or timestamp) on the entity; updates check if the version matches, throwing `OptimisticLockingFailureException` on concurrent overwrite conflicts**
**Explanation:** Optimistic locking assumes collisions are rare. On update, SQL executes: `UPDATE entity SET val = ?, version = version + 1 WHERE id = ? AND version = ?`. If rows affected is 0, a concurrent update occurred.
</details>

---

### Q60. What is the difference between `orphanRemoval = true` and `CascadeType.REMOVE`?
- A) `CascadeType.REMOVE` deletes children only when the parent entity is explicitly deleted; `orphanRemoval = true` ALSO deletes a child entity from the database when it is simply removed from the parent's collection (`parent.getChildren().remove(child)`)
- B) `orphanRemoval` only applies to `@ManyToOne`
- C) `CascadeType.REMOVE` is deprecated
- D) Both do the exact same thing

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `CascadeType.REMOVE` deletes children only when the parent entity is explicitly deleted; `orphanRemoval = true` ALSO deletes a child entity from the database when it is simply removed from the parent's collection (`parent.getChildren().remove(child)`)**
**Explanation:** `orphanRemoval` ensures database rows are deleted if they are disconnected from their parent collection, preventing orphaned database records.
</details>

---

### Q61. What does the `@Modifying` annotation in Spring Data JPA do?
```java
@Modifying
@Query("UPDATE User u SET u.active = false WHERE u.lastLogin < :date")
int deactivateInactiveUsers(@Param("date") LocalDate date);
```
- A) Tells Spring Data JPA that the query is an `UPDATE` or `DELETE` statement (DML) rather than a `SELECT` query
- B) Modifies the return type to JSON
- C) Bypasses validation
- D) Enables async query execution

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Tells Spring Data JPA that the query is an `UPDATE` or `DELETE` statement (DML) rather than a `SELECT` query**
**Explanation:** `@Query` defaults to `SELECT` execution via `executeQuery()`. `@Modifying` instructs Spring Data JPA to invoke `executeUpdate()` on the underlying JPA `Query`.
</details>

---

### Q62. Why should `@Modifying(clearAutomatically = true)` be used after bulk updates?
- A) Clears the database table
- B) Automatically clears the underlying EntityManager / First-Level Cache to prevent stale entity state in memory
- C) Closes the connection pool
- D) Deletes all logs

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Automatically clears the underlying EntityManager / First-Level Cache to prevent stale entity state in memory**
**Explanation:** Direct JPQL bulk updates bypass the persistence context. Entities already loaded in the first-level cache will retain old values unless the cache is cleared via `clearAutomatically = true`.
</details>

---

### Q63. What is the Open Session in View (OSIV) pattern in Spring Boot?
- A) Keeps the Hibernate Session/EntityManager open throughout the entire HTTP request lifecycle (including view rendering) to allow lazy loading in controllers and templates
- B) Opens a socket connection to the database
- C) Allows multiple users to share a session
- D) Enables terminal GUI view for Hibernate

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Keeps the Hibernate Session/EntityManager open throughout the entire HTTP request lifecycle (including view rendering) to allow lazy loading in controllers and templates**
**Explanation:** OSIV is enabled by default (`spring.jpa.open-in-view=true`). While it prevents `LazyInitializationException`, it holds database connections open much longer, risking connection pool exhaustion in high-throughput APIs.
</details>

---

### Q64. What is the difference between `Isolation.READ_COMMITTED` and `Isolation.REPEATABLE_READ`?
- A) `READ_COMMITTED` prevents dirty reads; `REPEATABLE_READ` prevents dirty reads AND non-repeatable reads (ensuring repeated reads of the same row return identical values within the transaction)
- B) `REPEATABLE_READ` is faster than `READ_COMMITTED`
- C) `READ_COMMITTED` allows dirty reads
- D) `REPEATABLE_READ` prevents phantom reads in all databases

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `READ_COMMITTED` prevents dirty reads; `REPEATABLE_READ` prevents dirty reads AND non-repeatable reads (ensuring repeated reads of the same row return identical values within the transaction)**
**Explanation:** Under `READ_COMMITTED`, if Transaction B updates and commits a row, Transaction A reading that row again will see the new data (Non-repeatable read). `REPEATABLE_READ` locks the row snapshot so Transaction A always sees consistent data.
</details>

---

### Q65. Which database connection pool is the default in Spring Boot 2.x and 3.x?
- A) Apache Commons DBCP2
- B) Tomcat JDBC Pool
- C) HikariCP
- D) C3P0

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) HikariCP**
**Explanation:** HikariCP is selected as the default connection pool in Spring Boot due to its superior performance, lightweight footprint, and reliable connection leak detection.
</details>

---

### Q66. What happens if a Spring Data repository method name is `findByAgeGreaterThanEqual(int age)`?
- A) Throws `PropertyReferenceException`
- B) Spring Data JPA automatically parses the method name keyword into JPQL: `WHERE u.age >= :age`
- C) Requires a manual `@Query`
- D) Compiles only with SQL Server

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Spring Data JPA automatically parses the method name keyword into JPQL: `WHERE u.age >= :age`**
**Explanation:** Spring Data JPA's query creation from method names parses domain-specific keywords (`GreaterThanEqual`, `Between`, `Like`, `IgnoreCase`) into valid SQL queries automatically.
</details>

---

### Q67. What is a Projection in Spring Data JPA?
- A) Projecting database records onto a 3D interface
- B) Retrieving only specific subsets of entity fields/columns (using interfaces or DTO constructors) instead of loading the full entity
- C) Replicating data to an external cluster
- D) A database index type

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Retrieving only specific subsets of entity fields/columns (using interfaces or DTO constructors) instead of loading the full entity**
**Explanation:** Projections (Interface-based or Class-based DTOs) optimize database bandwidth by selecting only needed columns (`SELECT u.name, u.email FROM User u`).
</details>

---

### Q68. What is the Hibernate First-Level Cache scope?
- A) Application / JVM wide
- B) Bound strictly to the current Hibernate `Session` / `EntityManager` (Transaction scope)
- C) Clustered across all microservices
- D) Saved on disk

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Bound strictly to the current Hibernate `Session` / `EntityManager` (Transaction scope)**
**Explanation:** The First-Level Cache is mandatory and tied to the lifecycle of the current `Session`. The Second-Level Cache (`L2`) is optional and shared across multiple sessions / application-wide.
</details>

---

## Section 5: Spring Security & OAuth2 Internals

### Q69. How is Spring Security integrated into standard Servlet Web applications?
- A) Through a single `DelegatingFilterProxy` registered in the Servlet container that delegates request filtering to the Spring-managed `FilterChainProxy` containing `SecurityFilterChain` beans
- B) Using an AOP interceptor on each controller
- C) Modifying Tomcat kernel code
- D) Using direct database authentication triggers

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Through a single `DelegatingFilterProxy` registered in the Servlet container that delegates request filtering to the Spring-managed `FilterChainProxy` containing `SecurityFilterChain` beans**
**Explanation:** `DelegatingFilterProxy` bridges the Servlet container's lifecycle to Spring's `ApplicationContext`, handing requests over to Spring Security's `FilterChainProxy`.
</details>

---

### Q70. What is the modern way (Spring Security 5.7+ / 6+) to configure HTTP security?
- A) Extending `WebSecurityConfigurerAdapter` and overriding `configure(HttpSecurity http)`
- B) Registering a `@Bean` of type `SecurityFilterChain`
- C) Writing XML security tags
- D) Using `@EnableGlobalSecurity`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Registering a `@Bean` of type `SecurityFilterChain`**
**Explanation:** `WebSecurityConfigurerAdapter` was deprecated and completely removed in Spring Security 6. Security configuration is now component-based by declaring a `public SecurityFilterChain filterChain(HttpSecurity http)` bean.
</details>

---

### Q71. Why is CSRF (Cross-Site Request Forgery) protection typically disabled (`csrf.disable()`) in stateless REST APIs using JWT?
- A) JWT tokens stored in HTTP headers (e.g. `Authorization: Bearer <token>`) are not automatically attached by web browsers on cross-site requests (unlike browser cookies), making browser CSRF exploits impossible
- B) CSRF slows down encryption
- C) CSRF is incompatible with JSON
- D) JWT automatically disables CSRF

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) JWT tokens stored in HTTP headers (e.g. `Authorization: Bearer <token>`) are not automatically attached by web browsers on cross-site requests (unlike browser cookies), making browser CSRF exploits impossible**
**Explanation:** CSRF attacks exploit automatic browser cookie transmission. When using stateless token authentication stored in memory or request headers, CSRF protection is unnecessary.
</details>

---

### Q72. Where does Spring Security store authentication information for the current request thread by default?
- A) `HttpSession` only
- B) `SecurityContextHolder` (using `ThreadLocal` strategy)
- C) Database table
- D) ApplicationContext

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `SecurityContextHolder` (using `ThreadLocal` strategy)**
**Explanation:** By default, `SecurityContextHolder.getContext().getAuthentication()` reads from a `ThreadLocal` storage specific to the currently executing thread.
</details>

---

### Q73. What is the difference between `hasRole('ADMIN')` and `hasAuthority('ADMIN')`?
- A) `hasRole('ADMIN')` automatically prefixes `'ROLE_'` to the string (checking for `ROLE_ADMIN`); `hasAuthority('ADMIN')` checks for the exact raw string `'ADMIN'` without prefixing
- B) `hasAuthority` is deprecated
- C) `hasRole` only works with LDAP
- D) Both check for the exact same string

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `hasRole('ADMIN')` automatically prefixes `'ROLE_'` to the string (checking for `ROLE_ADMIN`); `hasAuthority('ADMIN')` checks for the exact raw string `'ADMIN'` without prefixing**
**Explanation:** In Spring Security, Roles are authorities that follow the `ROLE_` naming convention. `hasRole("USER")` searches for `GrantedAuthority("ROLE_USER")`.
</details>

---

### Q74. What is the purpose of `BCryptPasswordEncoder`?
- A) Two-way reversible encryption of passwords
- B) One-way adaptive cryptographic hashing with built-in random salting to prevent rainbow table attacks
- C) Compressing passwords to 16 bytes
- D) Encrypting database connections

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) One-way adaptive cryptographic hashing with built-in random salting to prevent rainbow table attacks**
**Explanation:** BCrypt is a slow, one-way cryptographic hash function. Each hash includes a unique random 16-byte salt and configurable work factor (cost) to defend against brute-force attacks.
</details>

---

### Q75. What does `@PreAuthorize("hasRole('ADMIN') and #userId == authentication.principal.id")` enable?
- A) Expression-based method security with SpEL evaluating both user roles and runtime method parameters before method invocation
- B) Database row filtering
- C) Encrypts method arguments
- D) Disables method execution for everyone

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Expression-based method security with SpEL evaluating both user roles and runtime method parameters before method invocation**
**Explanation:** When `@EnableMethodSecurity` (or `@EnableGlobalMethodSecurity`) is active, `@PreAuthorize` uses SpEL expressions to enforce granular authorization rules before invoking a method.
</details>

---

### Q76. What is the difference between `@PreAuthorize` and `@PostAuthorize`?
- A) `@PreAuthorize` checks access before method execution; `@PostAuthorize` executes the method first and checks authorization before returning the result (with access to `returnObject`)
- B) `@PostAuthorize` is only for HTTP POST requests
- C) `@PreAuthorize` is deprecated
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@PreAuthorize` checks access before method execution; `@PostAuthorize` executes the method first and checks authorization before returning the result (with access to `returnObject`)**
**Explanation:** `@PostAuthorize("returnObject.owner == authentication.name")` allows the method to load an object and verifies whether the caller is authorized to view that specific return payload.
</details>

---

### Q77. What interface must be implemented to load user data from a custom database in Spring Security?
- A) `UserDetailsService` (implementing `loadUserByUsername(String username)`)
- B) `AuthenticationManager`
- C) `SecurityContext`
- D) `AccessDecisionManager`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `UserDetailsService` (implementing `loadUserByUsername(String username)`)**
**Explanation:** Spring Security queries `UserDetailsService.loadUserByUsername()` to retrieve `UserDetails` (username, password hash, authorities) during authentication.
</details>

---

### Q78. What does `AuthenticationEntryPoint` handle in Spring Security?
- A) Successful logins
- B) Commencing authentication when an unauthenticated user attempts to access a protected resource (e.g. returning HTTP 401 Unauthorized)
- C) User registration
- D) Password reset

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Commencing authentication when an unauthenticated user attempts to access a protected resource (e.g. returning HTTP 401 Unauthorized)**
**Explanation:** `AuthenticationEntryPoint` is triggered by `ExceptionTranslationFilter` when an `AuthenticationException` is caught.
</details>

---

### Q79. What does `AccessDeniedHandler` handle?
- A) Returning HTTP 403 Forbidden when an authenticated user lacks sufficient roles/permissions to access a resource
- B) User lockout after failed password attempts
- C) Expired passwords
- D) HTTP 404 errors

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Returning HTTP 403 Forbidden when an authenticated user lacks sufficient roles/permissions to access a resource**
**Explanation:** `AccessDeniedHandler` is invoked when an authenticated user attempts an operation forbidden by authorization rules (`AccessDeniedException`).
</details>

---

### Q80. In an OAuth2 Resource Server, what does `@EnableResourceServer` / `oauth2ResourceServer()` validate?
- A) Validates JWT or opaque access tokens issued by an Authorization Server (e.g. Keycloak, Auth0, Okta)
- B) Generates client credentials
- C) Provides login UI
- D) Manages user passwords

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Validates JWT or opaque access tokens issued by an Authorization Server (e.g. Keycloak, Auth0, Okta)**
**Explanation:** A Resource Server protects APIs by verifying JWT signatures against the Authorization Server's JWKS endpoint.
</details>

---

### Q81. What is the difference between Authentication and Authorization?
- A) Authentication verifies WHO you are (identity); Authorization determines WHAT you are allowed to do (permissions/roles)
- B) Authentication is for databases; Authorization is for web pages
- C) Both are the same concept
- D) Authorization happens before Authentication

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Authentication verifies WHO you are (identity); Authorization determines WHAT you are allowed to do (permissions/roles)**
**Explanation:** First, the system authenticates credentials (username/password/token). Once identity is established, the authorization engine checks permissions against requested resources.
</details>

---

### Q82. What is the `SecurityContextPersistenceFilter` (or `SecurityContextHolderFilter` in Spring Security 6)?
- A) Restores `SecurityContext` from `SecurityContextRepository` (e.g. HTTP Session) at the beginning of a request and clears it at request completion
- B) Saves user passwords to database
- C) Persists audit logs to disk
- D) Encrypts HTTPS payload

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Restores `SecurityContext` from `SecurityContextRepository` (e.g. HTTP Session) at the beginning of a request and clears it at request completion**
**Explanation:** This filter ensures that the `SecurityContext` is cleanly populated on the thread during request processing and cleaned up afterwards to avoid `ThreadLocal` leaks.
</details>

---

## Section 6: Spring Boot Actuator & Observability

### Q83. Which dependency adds production-ready monitoring and management endpoints to a Spring Boot app?
- A) `spring-boot-starter-logging`
- B) `spring-boot-starter-actuator`
- C) `spring-boot-starter-devtools`
- D) `spring-boot-starter-monitoring`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `spring-boot-starter-actuator`**
**Explanation:** Spring Boot Actuator provides built-in endpoints for health monitoring, metrics, thread dumps, environment inspection, and audit information.
</details>

---

### Q84. By default in Spring Boot, which Actuator endpoints are exposed over HTTP?
- A) All endpoints
- B) Only `/actuator/health` (and `/actuator/info` in older versions)
- C) `/actuator/beans` and `/actuator/env`
- D) None

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Only `/actuator/health` (and `/actuator/info` in older versions)**
**Explanation:** For security reasons, Spring Boot restricts default HTTP web exposure to only `/actuator/health`. All other endpoints must be explicitly exposed via `management.endpoints.web.exposure.include`.
</details>

---

### Q85. How do you expose all Actuator endpoints over web/HTTP?
- A) `management.endpoints.web.exposure.include=*`
- B) `endpoints.all=true`
- C) `actuator.expose.all=true`
- D) `spring.actuator.enabled=true`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `management.endpoints.web.exposure.include=*`**
**Explanation:** Setting `include=*` exposes all available actuator endpoints over HTTP (ensure sensitive endpoints like `/env`, `/beans`, `/heapdump` are secured!).
</details>

---

### Q86. How do you create a custom Health Indicator in Spring Boot?
- A) Implement `HealthIndicator` interface and override `health()` returning `Health.up()` or `Health.down()`
- B) Create a controller with URL `/health`
- C) Annotate a method with `@HealthCheck`
- D) Implement `ServletFilter`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Implement `HealthIndicator` interface and override `health()` returning `Health.up()` or `Health.down()`**
**Explanation:** Registering a `@Component` implementing `HealthIndicator` integrates custom database, third-party API, or disk health status directly into `/actuator/health`.
</details>

---

### Q87. What does the `/actuator/metrics` endpoint provide?
- A) Application dimensional metrics (JVM memory, GC pauses, CPU usage, HTTP request counts, response latency) via **Micrometer**
- B) Git commit history
- C) Database query logs
- D) Exception stack traces

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Application dimensional metrics (JVM memory, GC pauses, CPU usage, HTTP request counts, response latency) via **Micrometer****
**Explanation:** Actuator integrates with Micrometer, exposing metrics in formats consumable by Prometheus, Datadog, InfluxDB, Grafana, and CloudWatch.
</details>

---

### Q88. How can you dynamically change the logging level of a package at runtime without restarting the application?
- A) Issue an HTTP POST request to `/actuator/loggers/{packageName}` with JSON payload `{"configuredLevel": "DEBUG"}`
- B) Modify `logback.xml` on disk
- C) Restart the application with `--debug`
- D) It is impossible without restart

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Issue an HTTP POST request to `/actuator/loggers/{packageName}` with JSON payload `{"configuredLevel": "DEBUG"}`**
**Explanation:** The `/actuator/loggers` endpoint allows inspecting and dynamically altering logger levels at runtime without application downtime.
</details>

---

### Q89. What does `/actuator/threaddump` return?
- A) Thread stack traces and state information for diagnosing deadlocks and thread contention
- B) Thread pool configuration
- C) Memory allocation per thread
- D) CPU temperature

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Thread stack traces and state information for diagnosing deadlocks and thread contention**
**Explanation:** `/actuator/threaddump` captures a snapshot of all active JVM threads, their execution state (RUNNABLE, BLOCKED, WAITING), and lock acquisitions.
</details>

---

### Q90. How can you change the management port for Actuator endpoints so they are separated from business traffic?
- A) `management.server.port=8081`
- B) `server.actuator.port=8081`
- C) `actuator.port=8081`
- D) `spring.management.port=8081`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `management.server.port=8081`**
**Explanation:** Setting `management.server.port` exposes actuator management endpoints on a dedicated internal port, preventing external internet access to monitoring endpoints.
</details>

---

### Q91. What is the difference between Liveness and Readiness probes in Spring Boot Actuator (for Kubernetes)?
- A) **Liveness** indicates whether the internal state is healthy (if failing, Kubernetes restarts the pod); **Readiness** indicates whether the app is ready to accept HTTP traffic (if failing, Kubernetes removes it from Service routing)
- B) Liveness is for CPU; Readiness is for Memory
- C) Both are the same check
- D) Readiness restarts the pod

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) **Liveness** indicates whether the internal state is healthy (if failing, Kubernetes restarts the pod); **Readiness** indicates whether the app is ready to accept HTTP traffic (if failing, Kubernetes removes it from Service routing)**
**Explanation:** Spring Boot provides dedicated endpoints `/actuator/health/liveness` and `/actuator/health/readiness` tailored for Kubernetes container orchestration.
</details>

---

### Q92. What is Micrometer in the Spring ecosystem?
- A) A vendor-neutral dimensional metrics facade (analogous to SLF4J, but for application metrics)
- B) A database migration tool
- C) A bytecode manipulation library
- D) A microservice discovery server

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A vendor-neutral dimensional metrics facade (analogous to SLF4J, but for application metrics)**
**Explanation:** Micrometer is the core metrics collection library integrated into Spring Boot, exporting metrics to monitoring backends (Prometheus, New Relic, StatsD, Dynatrace).
</details>

---

## Section 7: Caching, Events, Microservices & Spring Boot 3+

### Q93. What is the difference between `@Cacheable` and `@CachePut` in Spring Cache?
- A) `@Cacheable` skips method execution if the result is already in cache; `@CachePut` ALWAYS executes the method and updates the cache with the new return value
- B) `@CachePut` deletes the cache; `@Cacheable` reads the cache
- C) `@Cacheable` is for Redis; `@CachePut` is for Ehcache
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@Cacheable` skips method execution if the result is already in cache; `@CachePut` ALWAYS executes the method and updates the cache with the new return value**
**Explanation:** `@Cacheable` is for reading with cache hit optimization; `@CachePut` is for write/update operations ensuring the cache stays in sync with modified database records.
</details>

---

### Q94. What does `@CacheEvict(value = "users", allEntries = true)` do?
- A) Removes all entries from the `"users"` cache
- B) Disables caching for users
- C) Evicts only expired entries
- D) Throws an exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Removes all entries from the `"users"` cache**
**Explanation:** `@CacheEvict` with `allEntries = true` clears all cached keys inside the specified cache region (cache invalidation).
</details>

---

### Q95. What is the difference between `@EventListener` and `@TransactionalEventListener`?
- A) `@TransactionalEventListener` allows binding event execution to specific transaction lifecycle phases (e.g. `TransactionPhase.AFTER_COMMIT`), executing only if the publishing transaction successfully commits
- B) `@TransactionalEventListener` automatically creates a new transaction
- C) `@EventListener` only works with Kafka
- D) There is no difference

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@TransactionalEventListener` allows binding event execution to specific transaction lifecycle phases (e.g. `TransactionPhase.AFTER_COMMIT`), executing only if the publishing transaction successfully commits**
**Explanation:** Standard `@EventListener` fires immediately when published. `@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)` guarantees external side-effects (like sending confirmation emails or publishing Kafka messages) only happen if the database transaction commits.
</details>

---

### Q96. How do you make a method execute asynchronously in Spring?
- A) Mark the method with `@Async` and enable asynchronous processing on a configuration class using `@EnableAsync`
- B) Create a `new Thread()` inside the method
- C) Set `spring.async=true`
- D) Annotate with `@Scheduled`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Mark the method with `@Async` and enable asynchronous processing on a configuration class using `@EnableAsync`**
**Explanation:** Spring wraps `@Async` methods in a proxy, submitting their execution to a `TaskExecutor` thread pool and optionally returning `CompletableFuture<T>`.
</details>

---

### Q97. What is the core namespace change in Spring Boot 3.0 / Spring Framework 6?
- A) Java EE `javax.*` packages were migrated to Jakarta EE `jakarta.*` packages (e.g., `jakarta.persistence.*`, `jakarta.servlet.*`, `jakarta.validation.*`)
- B) All classes renamed to lowercase
- C) Removed Maven support
- D) Deprecated REST controllers

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Java EE `javax.*` packages were migrated to Jakarta EE `jakarta.*` packages (e.g., `jakarta.persistence.*`, `jakarta.servlet.*`, `jakarta.validation.*`)**
**Explanation:** Due to Oracle transferring Java EE to the Eclipse Foundation, Spring Boot 3.0 baseline requires Java 17 and uses Jakarta EE 9/10 `jakarta.*` namespace.
</details>

---

### Q98. What is the minimum Java version required to run Spring Boot 3.x?
- A) Java 8
- B) Java 11
- C) Java 17
- D) Java 21

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) Java 17**
**Explanation:** Spring Boot 3.0 raised the baseline Java requirement from Java 8 to Java 17 (and fully supports Java 21 LTS).
</details>

---

### Q99. What does GraalVM Native Image compilation provide in Spring Boot 3?
- A) Instant startup times (single-digit milliseconds) and minimal memory consumption by compiling Spring Boot applications Ahead-Of-Time (AOT) into standalone native OS machine executables
- B) Automatic SQL generation
- C) Real-time code reloading
- D) Replaces Docker

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Instant startup times (single-digit milliseconds) and minimal memory consumption by compiling Spring Boot applications Ahead-Of-Time (AOT) into standalone native OS machine executables**
**Explanation:** Spring Boot 3 AOT engine computes bean definitions, reflection hints, and proxies at build-time, allowing GraalVM to compile native binaries ideal for serverless and Kubernetes microservices.
</details>

---

### Q100. What is the role of a Circuit Breaker (e.g. Resilience4j) in microservices?
- A) Prevents cascading system failures across distributed services by automatically cutting off requests to a failing downstream service (OPEN state) and redirecting traffic to fallback methods
- B) Protects against electrical power outages
- C) Encrypts network communication
- D) Replaces load balancers

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Prevents cascading system failures across distributed services by automatically cutting off requests to a failing downstream service (OPEN state) and redirecting traffic to fallback methods**
**Explanation:** Circuit breakers have 3 states: **CLOSED** (normal operation), **OPEN** (fast-fail, calling fallbacks), and **HALF-OPEN** (trial requests to test recovery).
</details>

---

### Q101. What does Spring Cloud Gateway use under the hood for non-blocking routing?
- A) Apache Tomcat
- B) Spring WebFlux and Project Reactor (Reactor Netty)
- C) Spring MVC
- D) Apache HTTP Server

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Spring WebFlux and Project Reactor (Reactor Netty)**
**Explanation:** Unlike Netflix Zuul 1.x (which used blocking servlet threads), Spring Cloud Gateway is built on non-blocking reactive streams (WebFlux/Netty), handling tens of thousands of concurrent connections efficiently.
</details>

---

### Q102. What is Distributed Tracing in Spring Boot microservices?
- A) Tracking request journeys across multiple microservices using unique `TraceId` and `SpanId` identifiers (via Micrometer Tracing / Zipkin / OpenTelemetry)
- B) Profiling CPU performance
- C) Replicating data across regions
- D) Monitoring database table growth

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Tracking request journeys across multiple microservices using unique `TraceId` and `SpanId` identifiers (via Micrometer Tracing / Zipkin / OpenTelemetry)**
**Explanation:** Distributed tracing injects correlation headers (`X-B3-TraceId` or W3C `traceparent`) into HTTP/messaging requests, allowing tools like Zipkin/Jaeger to visualize the end-to-end latency across microservices.
</details>

---

### Q103. What is the difference between Eureka Service Registry and Client-Side Load Balancing (Spring Cloud LoadBalancer)?
- A) Eureka registers service instance network locations (IP/Port); Spring Cloud LoadBalancer uses the registered instances to balance client requests across healthy nodes
- B) Eureka is a load balancer; Spring Cloud LoadBalancer is a registry
- C) Both are deprecated
- D) Eureka only works with AWS

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Eureka registers service instance network locations (IP/Port); Spring Cloud LoadBalancer uses the registered instances to balance client requests across healthy nodes**
**Explanation:** Microservices register themselves with Eureka Service Discovery. When `WebClient` or `RestTemplate` makes a call, the client-side load balancer picks an active instance using Round-Robin or custom algorithms.
</details>

---

### Q104. How can you enable Virtual Threads (Java 21) in Spring Boot 3.2+?
- A) `spring.threads.virtual.enabled=true`
- B) `@EnableVirtualThreads`
- C) `server.virtual-threads=on`
- D) By removing Tomcat

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `spring.threads.virtual.enabled=true`**
**Explanation:** In Spring Boot 3.2+, setting `spring.threads.virtual.enabled=true` automatically switches embedded Tomcat and Spring MVC task executors to use lightweight Java 21 Virtual Threads (`Executors.newVirtualThreadPerTaskExecutor()`).
</details>

---

### Q105. What is the difference between `@MockBean` (or `@MockitoBean` in Spring Boot 3.4+) and `@Mock`?
- A) `@Mock` is standard Mockito (creates an isolated mock object); `@MockBean` creates a Mockito mock AND registers/replaces that bean directly inside the Spring `ApplicationContext`
- B) `@MockBean` is only for database repositories
- C) `@Mock` starts the full Spring Boot application
- D) There is no difference

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `@Mock` is standard Mockito (creates an isolated mock object); `@MockBean` creates a Mockito mock AND registers/replaces that bean directly inside the Spring `ApplicationContext`**
**Explanation:** `@MockBean` is used in Spring integration tests (like `@WebMvcTest` or `@SpringBootTest`) to mock out collaborating beans inside the Spring container hierarchy.
</details>

---

## 🏆 Scoring & Proficiency Benchmark

| Score Range | Proficiency Level | Evaluation |
| :--- | :--- | :--- |
| **95 – 105** | 🌟 **Spring Boot Architect** | Exceptional mastery of Spring internals, AOP proxies, transaction management, and cloud architecture. |
| **80 – 94** | 🚀 **Senior Spring Developer** | Deep understanding of IoC, JPA N+1 traps, security filter chains, and Actuator metrics. |
| **60 – 79** | 📈 **Intermediate Developer** | Solid foundation; brush up on proxy self-invocation, propagation levels, and autoconfiguration. |
| **Below 60** | 💡 **Associate / Junior** | Re-read the explanations, inspect the bean lifecycle, and build mini-projects to reinforce concepts! |
