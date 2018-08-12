# Spring REST Docs with asciidoctor 예제

## requirements

  * Java 1.8 or later
  * Gradle


## Usage
### How to generate asciidoc
아스키닥터 파일(*.adoc)은 테스트가 수행될 때 생성된다. 그러므로 ```gradle test```로 테스트를 수행하면 테스트 코드에 선언한 ```build/snippets``` 하위 디렉토리에 아스키닥터 파일이 생성된다. 

```bash
gradle test
```

```GreetingControllerTest.java```
```java
...

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
@AutoConfigureRestDocs(outputDir = "build/snippets")
public class GreetingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnJustHello() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                .andDo(document("home"));
    }
    
...
```

### How to generate HTML5 documents

```build.gradle``` 에 명시된 asciidoctor task를 실행하면 ```/src/docs/asciidoc``` 하위의 템플릿 파일에 맞춰 ```/src/main/resources/static/rest-api-docs```에 HTML 문서를 생성한다.
 
```bash
gradle asciidoctor
```