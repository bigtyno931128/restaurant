<aside>
๐ **Goal:  " ์๊ตฌ์ฌํญ์ ๋ง์ถฐ ๋ฐฐ๋ฌ์๋น์ค API๋ฅผ ๊ตฌ์ฑํด๋ณด๊ธฐ"**

</aside>

<aside>
๐ฉ **Requirement:  ๊ณผ์ ์ ์๊ตฌ๋๋ ์ฌํญ์ด์์**

</aside>

[์ํ ๋ง]

๋ฐฐ๋ฌ์ฑ ํ ๋ฒ์ฉ์ ์ฌ์ฉํด ๋ณด์จ์ฃ ? ์ฌ๋ฌ๋ถ์ ์ด๋ฒ ๊ณผ์ ๋ฅผ ํตํด ๋ฐฐ๋ฌ์ฑ์ ๋ฐฑ์๋ ์๋ฒ ๊ฐ๋ฐ์๊ฐ ๋์ด ๋ฐฐ๋ฌ์ฑ ์๋ฒ์ ํ์ํ ํต์ฌ API ๋ฅผ ๊ตฌํํด ๋ณผ ์์ ์๋๋ค.

- `๊ณผ์  ์๊ตฌ ์ฌํญ`์ ๋ชจ๋ ์์ํด์ผ ํฉ๋๋ค!
    
    <aside>
    โ ๊ณผ์  ์๊ตฌ ์ฌํญ
    
    </aside>
    
    ์คํ๋ง ์๋ฒ๋ฅผ ํตํด  ์๋ ์๊ตฌ์ฌํญ์ ๋ง์ถฐ ๋ฐฐ๋ฌ์ฑ API ๋ฅผ ๊ตฌํํฉ๋๋ค. ํฌ๊ฒ 3๊ฐ์ ์๊ตฌ์ฌํญ์ผ๋ก ๋๋์ด์ ธ ์๊ณ , ์ ๊ณต๋๋ ํ์คํธ ์ฝ๋๊ฐ ๋ชจ๋ ์ฑ๊ณต์ ์ผ๋ก ์๋ํ๊ฒ ๋๋ฉด ๊ณผ์  ์๋ฃ์๋๋ค! 
    
    - ํ์คํธ ์ฝ๋ ์คํ์ ์ํด build.gradle ํ์ผ์ ์๋ ๋ด์ฉ ์ถ๊ฐ
        
        ```json
        dependencies {
        		// Lombok ๋ผ์ด๋ธ๋ฌ๋ฆฌ
            compileOnly 'org.projectlombok:lombok'
        		// ์คํ๋ง ๋ถํธ ๋ผ์ด๋ธ๋ฌ๋ฆฌ
            implementation 'org.springframework.boot:spring-boot-starter-web'
        		// ์คํ๋ง ๋ถํธ ํ์คํธ๋ฅผ ์ํ ๋ผ์ด๋ธ๋ฌ๋ฆฌ
            testImplementation 'org.springframework.boot:spring-boot-starter-test'
        }
        ```
        
    
    **[์๊ตฌ์ฌํญ]**
    
    1. ์์์  ๋ฑ๋ก ๋ฐ ์กฐํ
    2. ์์ ๋ฑ๋ก ๋ฐ ๋ฉ๋ดํ ์กฐํ
    3. ์ฃผ๋ฌธํ๊ธฐ
    
    UI ๊ฐ๋ฐ ์์ด ๋ฐฑ์๋ ์๋ฒ๋ฅผ ๊ฐ๋ฐํด์ผ ํ๊ธฐ ๋๋ฌธ์, ๊ฐ API ์์ ์ ๊ณต๋๋ ๋ฐ์ดํฐ๋ค์ด ์ด๋ป๊ฒ ์ฌ์ฉ๋ ์ง๋ ์๋ ๋ฐฐ๋ฌ์ฑ ์ํ UI ๋ฅผ ์ฐธ๊ณ ํฉ๋๋ค. 
    
    <aside>
    ๐จ ์ฃผ์! ์ํ UI ๋ ์ดํด๋ฅผ ๋๊ธฐ ์ํ ๊ฒ์ผ๋ก ์ค์  ์๊ตฌ์ฌํญ๊ณผ ๋ค๋ฅผ ์ ์์ต๋๋ค. ๋ฐ๋์ ๊ณผ์  ์๊ตฌ์ฌํญ ๋ด์ฉ์ ๋ง์ถฐ ๊ตฌํ ํด ์ฃผ์ธ์.
    
    </aside>
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d02b62b2-a4b1-4225-985b-06c4566263b9/Untitled.png)
    
    1. ์์์  ๋ฑ๋ก ๋ฐ ์กฐํ
        - ์์์  ์ ๋ณด ์๋ ฅ๋ฐ์ ๋ฑ๋ก
            1. ์์์  ์ด๋ฆ (name)
            2. ์ต์์ฃผ๋ฌธ ๊ฐ๊ฒฉ (minOrderPrice)
                1. ํ์ฉ๊ฐ: 1,000์ ~ 100,000์ ์๋ ฅ
                2. 100 ์ ๋จ์๋ก๋ง ์๋ ฅ ๊ฐ๋ฅ (์. 2,220์ ์๋ ฅ ์ ์๋ฌ๋ฐ์. 2,300์์ ์๋ ฅ ๊ฐ๋ฅ)
                3. ํ์ฉ๊ฐ์ด ์๋๊ฑฐ๋ 100์ ๋จ์ ์๋ ฅ์ด ์๋ ๊ฒฝ์ฐ ์๋ฌ ๋ฐ์์ํด
            3. ๊ธฐ๋ณธ ๋ฐฐ๋ฌ๋น (deliveryFee)
                1. ํ์ฉ๊ฐ: 0์ ~ 10,000์ (์. 11,000์ ์๋ ฅ ์ ์๋ฌ๋ฐ์.)
                2. 500 ์ ๋จ์๋ก๋ง ์๋ ฅ ๊ฐ๋ฅ (์. 2,200์ ์๋ ฅ ์ ์๋ฌ๋ฐ์. 2,500์ ์๋ ฅ ๊ฐ๋ฅ) 
                
        - ์์์  ์กฐํ
            - ๋ฑ๋ก๋ ๋ชจ๋  ์์์  ์ ๋ณด ์กฐํ ๊ฐ๋ฅ
                1. ๋ฑ๋ก ์ ์๋ ฅํ ์์์  ์ ๋ณด (name, minOrderPrice, deliveryFee)
                2. DB ํ์ด๋ธ ID (id)  
                
        
    2. ์์ ๋ฑ๋ก ๋ฐ ๋ฉ๋ดํ ์กฐํ
        - ์์์  ID ๋ฐ ์์ ์ ๋ณด ์๋ ฅ๋ฐ์ ๋ฑ๋ก
            1. ์์์  ID (restaurantId)
                1. ์์์  DB ํ์ด๋ธ ID
            2. ์์๋ช (name)
                1. ๊ฐ์ ์์์  ๋ด์์๋ ์์ ์ด๋ฆ์ด ์ค๋ณต๋  ์ ์์ (์. '์๋ด์นํจ ๊ฐ๋จ์ '์ 'ํ๋ผ์ด๋์นํจ' ์ด ์ด๋ฏธ ๋ฑ๋ก๋์ด ์๋ค๋ฉด ์ค๋ณตํ์ฌ ๋ฑ๋กํ  ์ ์์ง๋ง, ๋ค๋ฅธ ์์์ ์ธ '๋ง์คํฐ์น ๊ฐ๋จ์ '์๋ 'ํ๋ผ์ด๋์นํจ' ์ ๋ฑ๋ก ๊ฐ๋ฅ)
            3. ๊ฐ๊ฒฉ (price)
                1. ํ์ฉ๊ฐ: 100์ ~ 1,000,000์
                2. 100 ์ ๋จ์๋ก๋ง ์๋ ฅ ๊ฐ๋ฅ (์. 2,220์ ์๋ ฅ ์ ์๋ฌ๋ฐ์. 2,300์ ์๋ ฅ ๊ฐ๋ฅ)
                3. ํ์ฉ๊ฐ์ด ์๋๊ฑฐ๋ 100์ ๋จ์ ์๋ ฅ์ด ์๋ ๊ฒฝ์ฐ ์๋ฌ ๋ฐ์์ํด
                
        - ๋ฉ๋ดํ ์กฐํ
            - ํ๋์ ์์์ ์ ๋ฑ๋ก๋ ๋ชจ๋  ์์ ์ ๋ณด ์กฐํ
                1. ๋ฑ๋ก ์ ์๋ ฅํ ์์ ์ ๋ณด (name, price)
                2. DB ํ์ด๋ธ ID (id)
                
        
    3. ์ฃผ๋ฌธ ์์ฒญํ๊ธฐ ๋ฐ ์ฃผ๋ฌธ ์กฐํ
        - ์ฃผ๋ฌธ ์์ฒญ ์ ๋ฐฐ๋ฌ ์์์  ๋ฐ ์์ ์ ๋ณด ์๋ ฅ๋ฐ์
            1. ์์์  ID (restaurantId)
            2. ์์ ์ฃผ๋ฌธ ์ ๋ณด (foods)
                1. ์์ ID (id)
                2. ์์์ ์ฃผ๋ฌธํ  ์๋ (quantity)
                    1. ํ์ฉ๊ฐ: 1 ~ 100
                    2. ํ์ฉ๊ฐ์ด ์๋๋ฉด ์๋ฌ ๋ฐ์์ํด
                    
        - ์ฃผ๋ฌธ ์์ฒญ์ ๋ํ ์๋ต์ผ๋ก ๋ค์ ์ ๋ณด๋ฅผ ํฌํจ์ํด
            1. ์ฃผ๋ฌธ ์์์  ์ด๋ฆ (restaurantName)
            2. ์ฃผ๋ฌธ ์์ ์ ๋ณด (foods)
                - ์ฃผ๋ฌธ ์์๋ช (name)
                - ์ฃผ๋ฌธ ์๋ (quantity)
                - ์ฃผ๋ฌธ ์์์ ๊ฐ๊ฒฉ (price)
                    - ๊ณ์ฐ๋ฐฉ๋ฒ
                        - ์ฃผ๋ฌธ ์์ 1๊ฐ์ ๊ฐ๊ฒฉ * ์ฃผ๋ฌธ ์๋
            3. ๋ฐฐ๋ฌ๋น (deliveryFee)
                - ์ฃผ๋ฌธ ์์์ ์ ๊ธฐ๋ณธ ๋ฐฐ๋ฌ๋น
            4. ์ต์ข ๊ฒฐ์  ๊ธ์ก (totalPrice)
                - ๊ณ์ฐ๋ฐฉ๋ฒ
                    - ์ฃผ๋ฌธ ์์ ๊ฐ๊ฒฉ๋ค์ ์ด ํฉ + ๋ฐฐ๋ฌ๋น
                - "์ฃผ๋ฌธ ์์ ๊ฐ๊ฒฉ๋ค์ ์ด ํฉ" ์ด ์ฃผ๋ฌธ ์์์ ์ "์ต์์ฃผ๋ฌธ ๊ฐ๊ฒฉ" ์ ๋์ง ์์ ์ ์๋ฌ ๋ฐ์์ํด
                
        - ์ฃผ๋ฌธ ์กฐํ
            - ๊ทธ๋์ ์ฑ๊ณตํ ๋ชจ๋  ์ฃผ๋ฌธ ์์ฒญ์ ์กฐํ ๊ฐ๋ฅ
        
    
- `๊ณผ์  ์๊ตฌ ์ฌํญ` ๊ฒ์ฆ์ ์ํ ํ์คํธ ์ฝ๋
    
    ์๋ ์ ๊ณต๋๋ `3๊ฐ์ ํ์คํธ ์ฝ๋` ๋ฅผ ๊ณผ์  ํ๋ก์ ํธ์ test ํจํค์ง์ ๋ณต์ฌ ํ  ๋ชจ๋ ์ฑ๊ณต์ ์ผ๋ก ์๋ํ๊ฒ ํ๋ฉด ๊ณผ์  ์๋ฃ์๋๋ค! 
    
    - 1. `์์์  ๋ฑ๋ก ๋ฐ ์กฐํ` ํ์คํธ์ฝ๋
        
        ```java
        import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import lombok.Builder;
        import lombok.Getter;
        import lombok.Setter;
        import org.junit.jupiter.api.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.boot.test.web.client.TestRestTemplate;
        import org.springframework.http.*;
        
        import java.util.ArrayList;
        import java.util.List;
        
        import static org.junit.jupiter.api.Assertions.*;
        
        @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class RestaurantIntegrationTest {
            @Autowired
            private TestRestTemplate restTemplate;
        
            private HttpHeaders headers;
            private ObjectMapper mapper = new ObjectMapper();
        
            private final List<RestaurantDto> registeredRestaurants = new ArrayList<>();
        
            @BeforeEach
            public void setup() {
                headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
            }
        
            @Nested
            @DisplayName("์์์  3๊ฐ ๋ฑ๋ก ๋ฐ ์กฐํ")
            class RegisterRestaurants {
                @Test
                @Order(1)
                @DisplayName("์์์ 1 ๋ฑ๋ก")
                void test1() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                            .minOrderPrice(1_000)
                            .deliveryFee(0)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertEquals(HttpStatus.OK, response.getStatusCode());
        
                    RestaurantDto restaurantResponse = response.getBody();
                    assertNotNull(restaurantResponse);
                    assertTrue(restaurantResponse.id > 0);
                    assertEquals(restaurantRequest.name, restaurantResponse.name);
                    assertEquals(restaurantRequest.minOrderPrice, restaurantResponse.minOrderPrice);
                    assertEquals(restaurantRequest.deliveryFee, restaurantResponse.deliveryFee);
        
                    // ์์์  ๋ฑ๋ก ์ฑ๊ณต ์, registeredRestaurants ์ ์ถ๊ฐ
                    registeredRestaurants.add(restaurantResponse);
                }
        
                @Test
                @Order(2)
                @DisplayName("์์์ 2 ๋ฑ๋ก")
                void test2() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("์๋ด์นํจ ๊ฐ๋จ์ ")
                            .minOrderPrice(100_000)
                            .deliveryFee(10_000)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertEquals(HttpStatus.OK, response.getStatusCode());
        
                    RestaurantDto restaurantResponse = response.getBody();
                    assertNotNull(restaurantResponse);
                    assertTrue(restaurantResponse.id > 0);
                    assertEquals(restaurantRequest.name, restaurantResponse.name);
                    assertEquals(restaurantRequest.minOrderPrice, restaurantResponse.minOrderPrice);
                    assertEquals(restaurantRequest.deliveryFee, restaurantResponse.deliveryFee);
        
                    // ์์์  ๋ฑ๋ก ์ฑ๊ณต ์, registeredRestaurants ์ ์ถ๊ฐ
                    registeredRestaurants.add(restaurantResponse);
                }
        
                @Test
                @Order(3)
                @DisplayName("์์์ 3 ๋ฑ๋ก")
                void test3() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("๋ง๋ผํ์ค ์๋ก์ ")
                            .minOrderPrice(100000)
                            .deliveryFee(10000)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertEquals(HttpStatus.OK, response.getStatusCode());
        
                    RestaurantDto restaurantResponse = response.getBody();
                    assertNotNull(restaurantResponse);
                    assertTrue(restaurantResponse.id > 0);
                    assertEquals(restaurantRequest.name, restaurantResponse.name);
                    assertEquals(restaurantRequest.minOrderPrice, restaurantResponse.minOrderPrice);
                    assertEquals(restaurantRequest.deliveryFee, restaurantResponse.deliveryFee);
        
                    // ์์์  ๋ฑ๋ก ์ฑ๊ณต ์, registeredRestaurants ์ ์ถ๊ฐ
                    registeredRestaurants.add(restaurantResponse);
                }
        
                @Test
                @Order(4)
                @DisplayName("๋ฑ๋ก๋ ๋ชจ๋  ์์์  ์กฐํ")
                void test4() {
                    // when
                    ResponseEntity<RestaurantDto[]> response = restTemplate.getForEntity(
                            "/restaurants",
                            RestaurantDto[].class
                    );
        
                    // then
                    assertEquals(HttpStatus.OK, response.getStatusCode());
                    RestaurantDto[] responseRestaurants = response.getBody();
                    assertNotNull(responseRestaurants);
                    assertEquals(registeredRestaurants.size(), responseRestaurants.length);
                    for (RestaurantDto responseRestaurant : responseRestaurants) {
                        RestaurantDto registerRestaurant = registeredRestaurants.stream()
                                .filter(restaurant -> responseRestaurant.getId().equals(restaurant.getId()))
                                .findAny()
                                .orElse(null);
        
                        assertNotNull(registerRestaurant);
                        assertEquals(registerRestaurant.getName(), responseRestaurant.getName());
                        assertEquals(registerRestaurant.getDeliveryFee(), responseRestaurant.getDeliveryFee());
                        assertEquals(registerRestaurant.getMinOrderPrice(), responseRestaurant.getMinOrderPrice());
                    }
                }
            }
        
            @Nested
            @DisplayName("์ต์์ฃผ๋ฌธ ๊ฐ๊ฒฉ")
            class MinOrderPrice {
                @Test
                @DisplayName("1,000์ ๋ฏธ๋ง ์๋ฌ")
                void test1() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                            .minOrderPrice(500)
                            .deliveryFee(1000)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
        
                @Test
                @DisplayName("100,000์ ์ด๊ณผ ์๋ฌ")
                void test2() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                            .minOrderPrice(100100)
                            .deliveryFee(1000)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
        
                @Test
                @DisplayName("100์ ๋จ์๋ก ์๋ ฅ ์ ๋จ ์๋ฌ")
                void test3() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                            .minOrderPrice(2220)
                            .deliveryFee(1000)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
            }
        
            @Nested
            @DisplayName("๊ธฐ๋ณธ ๋ฐฐ๋ฌ๋น")
            class DeliveryFee {
                @Test
                @DisplayName("0์ ๋ฏธ๋ง ์๋ฌ")
                void test2() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                            .minOrderPrice(5000)
                            .deliveryFee(-500)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
        
                @Test
                @DisplayName("10,000์ ์ด๊ณผ ์๋ฌ")
                void test3() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                            .minOrderPrice(5000)
                            .deliveryFee(20000)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
        
                @Test
                @DisplayName("500์ ๋จ์๋ก ์๋ ฅ ์ ๋จ ์๋ฌ")
                void test4() throws JsonProcessingException {
                    // given
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                            .minOrderPrice(5000)
                            .deliveryFee(2200)
                            .build();
        
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
            }
        
            @Getter
            @Setter
            @Builder
            static class RestaurantDto {
                private Long id;
                private String name;
                private int minOrderPrice;
                private int deliveryFee;
            }
        }
        ```
        
    - 2. `์์ ๋ฑ๋ก ๋ฐ ๋ฉ๋ดํ ์กฐํ` ํ์คํธ์ฝ๋
        
        ```java
        import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import lombok.Builder;
        import lombok.Getter;
        import lombok.Setter;
        import org.junit.jupiter.api.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.boot.test.web.client.TestRestTemplate;
        import org.springframework.http.*;
        
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        
        import static org.junit.jupiter.api.Assertions.*;
        
        @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class FoodIntegrationTest {
            @Autowired
            private TestRestTemplate restTemplate;
        
            private HttpHeaders headers;
            private ObjectMapper mapper = new ObjectMapper();
        
            private RestaurantDto registeredRestaurant;
        
            private FoodDto food1 = FoodDto.builder()
                    .id(null)
                    .name("์๋ฒ๊ฑฐ ๋๋ธ")
                    .price(10900)
                    .build();
        
            private FoodDto food2 = FoodDto.builder()
                    .id(null)
                    .name("์น์ฆ ๊ฐ์ํ๊น")
                    .price(4900)
                    .build();
        
            private FoodDto food3 = FoodDto.builder()
                    .id(null)
                    .name("์์ดํฌ")
                    .price(5900)
                    .build();
        
            private FoodDto food4 = FoodDto.builder()
                    .id(null)
                    .name("์คํธ๋ก๋ฒ ๋ฆฌ๋ฒ ๋ฆฌ")
                    .price(11400)
                    .build();
        
            @BeforeEach
            public void setup() {
                headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
            }
        
            @Test
            @Order(1)
            @DisplayName("์์์ 1 ๋ฑ๋ก")
            void test1() throws JsonProcessingException {
                // given
                RestaurantDto restaurantRequest = RestaurantDto.builder()
                        .id(null)
                        .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                        .minOrderPrice(5000)
                        .deliveryFee(1000)
                        .build();
        
                String requestBody = mapper.writeValueAsString(restaurantRequest);
                HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                // when
                ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                        "/restaurant/register",
                        request,
                        RestaurantDto.class);
        
                // then
                assertEquals(HttpStatus.OK, response.getStatusCode());
        
                RestaurantDto restaurantResponse = response.getBody();
                assertNotNull(restaurantResponse);
                assertTrue(restaurantResponse.id > 0);
                assertEquals(restaurantRequest.name, restaurantResponse.name);
                assertEquals(restaurantRequest.minOrderPrice, restaurantResponse.minOrderPrice);
                assertEquals(restaurantRequest.deliveryFee, restaurantResponse.deliveryFee);
        
                // ์์์  ๋ฑ๋ก ์ฑ๊ณต ์, registeredRestaurant ์ ํ ๋น
                registeredRestaurant = restaurantResponse;
            }
        
            @Nested
            @DisplayName("์์์ ์ ์์ 3๊ฐ ๋ฑ๋ก ๋ฐ ๋ฉ๋ดํ ์กฐํ")
            class RegisterRestaurants {
                @Test
                @Order(1)
                @DisplayName("์์ 1๊ฐ ๋ฑ๋ก")
                void test1() throws JsonProcessingException {
                    // given
                    List<FoodDto> foodsRequest = new ArrayList<>();
                    // ์์2 ์ถ๊ฐ
                    foodsRequest.add(food2);
        
                    String requestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<Object> response = restTemplate.postForEntity(
                            "/restaurant/" + restaurantId + "/food/register",
                            request,
                            Object.class);
        
                    // then
                    assertEquals(HttpStatus.OK, response.getStatusCode());
                    assertNull(response.getBody());
                }
        
                @Test
                @Order(2)
                @DisplayName("์์ 2๊ฐ ๋ฑ๋ก")
                void test2() throws JsonProcessingException {
                    // given
                    List<FoodDto> foodsRequest = new ArrayList<>();
        
                    // ์์3 ์ถ๊ฐ
                    foodsRequest.add(food3);
        
                    // ์์4 ์ถ๊ฐ
                    foodsRequest.add(food4);
        
                    String requestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<Object> response = restTemplate.postForEntity(
                            "/restaurant/" + restaurantId + "/food/register",
                            request,
                            Object.class);
        
                    // then
                    assertEquals(HttpStatus.OK, response.getStatusCode());
                    assertNull(response.getBody());
                }
        
                @Test
                @Order(3)
                @DisplayName("์์์  ๋ฉ๋ดํ ์กฐํ")
                void test3() throws JsonProcessingException {
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<FoodDto[]> response = restTemplate.getForEntity(
                            "/restaurant/" + restaurantId + "/foods",
                            FoodDto[].class);
        
                    // then
                    assertEquals(HttpStatus.OK, response.getStatusCode());
                    FoodDto[] foodsResponse = response.getBody();
                    assertNotNull(foodsResponse);
                    assertEquals(4, foodsResponse.length);
                    // ์์ 1 ํ์ธ
                    FoodDto food1Response = Arrays.stream(foodsResponse)
                            .filter(food -> food1.getName().equals(food.getName()))
                            .findAny()
                            .orElse(null);
                    assertNotNull(food1Response);
                    assertNotNull(food1Response.getId());
                    assertEquals(food1.getName(), food1Response.getName());
                    assertEquals(food1.getPrice(), food1Response.getPrice());
        
                    // ์์ 2 ํ์ธ
                    FoodDto food2Response = Arrays.stream(foodsResponse)
                            .filter(food -> food2.getName().equals(food.getName()))
                            .findAny()
                            .orElse(null);
                    assertNotNull(food2Response);
                    assertNotNull(food2Response.getId());
                    assertEquals(food2.getName(), food2Response.getName());
                    assertEquals(food2.getPrice(), food2Response.getPrice());
        
                    // ์์ 3 ํ์ธ
                    FoodDto food3Response = Arrays.stream(foodsResponse)
                            .filter(food -> food3.getName().equals(food.getName()))
                            .findAny()
                            .orElse(null);
                    assertNotNull(food3Response);
                    assertNotNull(food3Response.getId());
                    assertEquals(food3.getName(), food3Response.getName());
                    assertEquals(food3.getPrice(), food3Response.getPrice());
        
                    // ์์ 4 ํ์ธ
                    FoodDto food4Response = Arrays.stream(foodsResponse)
                            .filter(food -> food4.getName().equals(food.getName()))
                            .findAny()
                            .orElse(null);
                    assertNotNull(food4Response);
                    assertNotNull(food4Response.getId());
                    assertEquals(food4.getName(), food4Response.getName());
                    assertEquals(food4.getPrice(), food4Response.getPrice());
                }
            }
        
            @Nested
            @DisplayName("์์๋ช")
            class FoodName {
                @Test
                @Order(1)
                @DisplayName("์์ 1๊ฐ ๋ฑ๋ก")
                void test1() throws JsonProcessingException {
                    // given
                    List<FoodDto> foodsRequest = new ArrayList<>();
                    // ์์1 ์ถ๊ฐ
                    foodsRequest.add(food1);
        
                    String requestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<Object> response = restTemplate.postForEntity(
                            "/restaurant/" + restaurantId + "/food/register",
                            request,
                            Object.class);
        
                    // then
                    assertEquals(HttpStatus.OK, response.getStatusCode());
                    assertNull(response.getBody());
                }
        
                @Test
                @Order(2)
                @DisplayName("๊ธฐ์กด ์ ์ฅ๋ ์์๋ช๊ณผ ์ค๋ณต")
                void test2() throws JsonProcessingException {
                    // given
                    List<FoodDto> foodsRequest = new ArrayList<>();
                    // ์์1 ์ถ๊ฐ
                    foodsRequest.add(food1);
                    // ์์2 ์ถ๊ฐ
                    foodsRequest.add(food2);
        
                    String requestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<Object> response = restTemplate.postForEntity(
                            "/restaurant/" + restaurantId + "/food/register",
                            request,
                            Object.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
        
                @Test
                @Order(3)
                @DisplayName("์๋ ฅ๋ ์์๋ช์ ์ค๋ณต ์๋ฌ")
                void test3() throws JsonProcessingException {
                    // given
                    List<FoodDto> foodsRequest = new ArrayList<>();
                    // ์์2 ์ถ๊ฐ (์์๋ช: "์น์ฆ ๊ฐ์ํ๊น")
                    foodsRequest.add(food2);
        						// ์์3 ์ถ๊ฐ (์์๋ช: "์์ดํฌ")
                    foodsRequest.add(food3);
        						// ์์2 ์ค๋ณต ์ถ๊ฐ (์์๋ช: "์น์ฆ ๊ฐ์ํ๊น")
                    foodsRequest.add(food2);
        
                    String requestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<Object> response = restTemplate.postForEntity(
                            "/restaurant/" + restaurantId + "/food/register",
                            request,
                            Object.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
        
                @Test
                @Order(4)
                @DisplayName("์์์  2์ ์์๋ช 1์ ๋ฑ๋ก๋์ด ์๋ ์์๋ช ์๋ ฅ ๊ฐ๋ฅ")
                void test4() throws JsonProcessingException {
                    // given
                    // ์์์ 2 ์ถ๊ฐ
                    RestaurantDto restaurantRequest = RestaurantDto.builder()
                            .id(null)
                            .name("๋ฒ ์คํจ๋ผ๋น์ค ์ดํ์์ ")
                            .minOrderPrice(13000)
                            .deliveryFee(5000)
                            .build();
                    String requestBody = mapper.writeValueAsString(restaurantRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
                    ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                            "/restaurant/register",
                            request,
                            RestaurantDto.class);
                    assertEquals(HttpStatus.OK, response.getStatusCode());
                    RestaurantDto restaurantDto2 = response.getBody();
        
                    //  ์ถ๊ฐ ์๋
                    List<FoodDto> foodsRequest = new ArrayList<>();
                    // ์์์ 1์ ๋ฑ๋ก๋์ด ์๋ ์์1 ์ ์์์ 2์ ์ถ๊ฐ
                    foodsRequest.add(food1);
        
                    String foodRequestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> foodRequest = new HttpEntity<>(foodRequestBody, headers);
        
                    // when
                    Long restaurant2Id = restaurantDto2.id;
                    ResponseEntity<Object> foodResponse = restTemplate.postForEntity(
                            "/restaurant/" + restaurant2Id + "/food/register",
                            foodRequest,
                            Object.class);
        
                    // then
                    assertEquals(HttpStatus.OK, foodResponse.getStatusCode());
                }
            }
        
            @Nested
            @DisplayName("์์ ๊ฐ๊ฒฉ")
            class FoodPrice {
                @Test
                @DisplayName("100์ ๋ฏธ๋ง ์๋ฌ")
                void test1() throws JsonProcessingException {
                    // given
                    List<FoodDto> foodsRequest = new ArrayList<>();
        
                    foodsRequest.add(
                            FoodDto.builder()
                                    .id(null)
                                    .name("์น์ฆ ๊ฐ์ํ๊น")
                                    .price(0)
                                    .build()
                    );
        
                    String requestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<Object> response = restTemplate.postForEntity(
                            "/restaurant/" + restaurantId + "/food/register",
                            request,
                            Object.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
        
                @Test
                @DisplayName("1,000,000์ ์ด๊ณผ ์๋ฌ")
                void test2() throws JsonProcessingException {
                    // given
                    List<FoodDto> foodsRequest = new ArrayList<>();
        
                    foodsRequest.add(
                            FoodDto.builder()
                                    .id(null)
                                    .name("์น์ฆ ๊ฐ์ํ๊น")
                                    .price(1_000_100)
                                    .build()
                    );
        
                    String requestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<Object> response = restTemplate.postForEntity(
                            "/restaurant/" + restaurantId + "/food/register",
                            request,
                            Object.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
        
                @Test
                @DisplayName("100์ ๋จ์๋ก ์๋ ฅ ์ ๋จ ์๋ฌ")
                void test3() throws JsonProcessingException {
                    // given
                    List<FoodDto> foodsRequest = new ArrayList<>();
        
                    foodsRequest.add(
                            FoodDto.builder()
                                    .id(null)
                                    .name("์น์ฆ ๊ฐ์ํ๊น")
                                    .price(770)
                                    .build()
                    );
        
                    String requestBody = mapper.writeValueAsString(foodsRequest);
                    HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                    // when
                    Long restaurantId = registeredRestaurant.id;
                    ResponseEntity<Object> response = restTemplate.postForEntity(
                            "/restaurant/" + restaurantId + "/food/register",
                            request,
                            Object.class);
        
                    // then
                    assertTrue(
                            response.getStatusCode() == HttpStatus.BAD_REQUEST
                                    || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                    );
                }
            }
        
            @Getter
            @Setter
            @Builder
            static class RestaurantDto {
                private Long id;
                private String name;
                private int minOrderPrice;
                private int deliveryFee;
            }
        
            @Getter
            @Setter
            @Builder
            static class FoodDto {
                private Long id;
                private String name;
                private int price;
            }
        }
        ```
        
    - 3. `์ฃผ๋ฌธํ๊ธฐ ๋ฐ ์กฐํ` ํ์คํธ์ฝ๋
        
        ```java
        import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import lombok.Builder;
        import lombok.Getter;
        import lombok.Setter;
        import org.junit.jupiter.api.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.boot.test.web.client.TestRestTemplate;
        import org.springframework.http.*;
        
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        
        import static org.junit.jupiter.api.Assertions.*;
        
        @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class OrderIntegrationTest {
            @Autowired
            private TestRestTemplate restTemplate;
        
            private HttpHeaders headers;
            private ObjectMapper mapper = new ObjectMapper();
        
            private RestaurantDto registeredRestaurant;
        
            private FoodDto food1 = FoodDto.builder()
                    .id(null)
                    .name("์๋ฒ๊ฑฐ ๋๋ธ")
                    .price(10900)
                    .build();
        
            private FoodDto food2 = FoodDto.builder()
                    .id(null)
                    .name("์น์ฆ ๊ฐ์ํ๊น")
                    .price(4900)
                    .build();
        
            private FoodDto food3 = FoodDto.builder()
                    .id(null)
                    .name("์์ดํฌ")
                    .price(5900)
                    .build();
        
            @BeforeEach
            public void setup() {
                headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
            }
        
            @Test
            @Order(1)
            @DisplayName("์์์ 1 ๋ฑ๋ก")
            void test1() throws JsonProcessingException {
                // given
                RestaurantDto restaurantRequest = RestaurantDto.builder()
                        .id(null)
                        .name("์์ดํฌ์ ์ฒญ๋ด์ ")
                        .minOrderPrice(5000)
                        .deliveryFee(2000)
                        .build();
        
                String requestBody = mapper.writeValueAsString(restaurantRequest);
                HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                // when
                ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
                        "/restaurant/register",
                        request,
                        RestaurantDto.class);
        
                // then
                assertEquals(HttpStatus.OK, response.getStatusCode());
        
                RestaurantDto restaurantResponse = response.getBody();
                assertNotNull(restaurantResponse);
                assertTrue(restaurantResponse.id > 0);
                assertEquals(restaurantRequest.name, restaurantResponse.name);
                assertEquals(restaurantRequest.minOrderPrice, restaurantResponse.minOrderPrice);
                assertEquals(restaurantRequest.deliveryFee, restaurantResponse.deliveryFee);
        
                // ์์์  ๋ฑ๋ก ์ฑ๊ณต ์, registeredRestaurant ์ ํ ๋น
                registeredRestaurant = restaurantResponse;
            }
        
            @Test
            @Order(2)
            @DisplayName("์์์ ์ ์์ 3๊ฐ ๋ฑ๋ก")
            void test2() throws JsonProcessingException {
                // given
                List<FoodDto> foodsRequest = new ArrayList<>();
                foodsRequest.add(food1);
                foodsRequest.add(food2);
                foodsRequest.add(food3);
        
                String requestBody = mapper.writeValueAsString(foodsRequest);
                HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                // when
                Long restaurantId = registeredRestaurant.id;
                ResponseEntity<Object> response = restTemplate.postForEntity(
                        "/restaurant/" + restaurantId + "/food/register",
                        request,
                        Object.class);
        
                // then
                assertEquals(HttpStatus.OK, response.getStatusCode());
                assertNull(response.getBody());
            }
        
            @Test
            @Order(3)
            @DisplayName("์์์  ๋ฉ๋ดํ ์กฐํ")
            void test3() {
                // when
                Long restaurantId = registeredRestaurant.id;
                ResponseEntity<FoodIntegrationTest.FoodDto[]> response = restTemplate.getForEntity(
                        "/restaurant/" + restaurantId + "/foods",
                        FoodIntegrationTest.FoodDto[].class);
        
                // then
                assertEquals(HttpStatus.OK, response.getStatusCode());
                FoodIntegrationTest.FoodDto[] foodsResponse = response.getBody();
                assertNotNull(foodsResponse);
                assertEquals(3, foodsResponse.length);
                // ์์ 1 ํ์ธ
                FoodIntegrationTest.FoodDto food1Response = Arrays.stream(foodsResponse)
                        .filter(food -> food1.getName().equals(food.getName()))
                        .findAny()
                        .orElse(null);
                assertNotNull(food1Response);
                assertNotNull(food1Response.getId());
                assertEquals(food1.getName(), food1Response.getName());
                assertEquals(food1.getPrice(), food1Response.getPrice());
                food1.id = food1Response.getId();
        
                // ์์ 2 ํ์ธ
                FoodIntegrationTest.FoodDto food2Response = Arrays.stream(foodsResponse)
                        .filter(food -> food2.getName().equals(food.getName()))
                        .findAny()
                        .orElse(null);
                assertNotNull(food2Response);
                assertNotNull(food2Response.getId());
                assertEquals(food2.getName(), food2Response.getName());
                assertEquals(food2.getPrice(), food2Response.getPrice());
                food2.id = food2Response.getId();
        
                // ์์ 3 ํ์ธ
                FoodIntegrationTest.FoodDto food3Response = Arrays.stream(foodsResponse)
                        .filter(food -> food3.getName().equals(food.getName()))
                        .findAny()
                        .orElse(null);
                assertNotNull(food3Response);
                assertNotNull(food3Response.getId());
                assertEquals(food3.getName(), food3Response.getName());
                assertEquals(food3.getPrice(), food3Response.getPrice());
                food3.id = food3Response.getId();
            }
        
            @Test
            @Order(4)
            @DisplayName("์ฃผ๋ฌธํ๊ธฐ")
            void test4() throws JsonProcessingException {
                // given
                Long restaurantId = registeredRestaurant.id;
        
                FoodOrderRequestDto foodOrderRequest1 = FoodOrderRequestDto.builder()
                        .id(food1.id)
                        .quantity(1)
                        .build();
        
                FoodOrderRequestDto foodOrderRequest2 = FoodOrderRequestDto.builder()
                        .id(food2.id)
                        .quantity(2)
                        .build();
        
                FoodOrderRequestDto foodOrderRequest3 = FoodOrderRequestDto.builder()
                        .id(food3.id)
                        .quantity(3)
                        .build();
        
                List<FoodOrderRequestDto> foodOrderRequestDtos = new ArrayList<>();
                foodOrderRequestDtos.add(foodOrderRequest1);
                foodOrderRequestDtos.add(foodOrderRequest2);
                foodOrderRequestDtos.add(foodOrderRequest3);
        
                OrderRequestDto orderRequest = OrderRequestDto.builder()
                        .restaurantId(restaurantId)
                        .foods(foodOrderRequestDtos)
                        .build();
        
                String requestBody = mapper.writeValueAsString(orderRequest);
                HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                // when
                ResponseEntity<OrderDto> response = restTemplate.postForEntity(
                        "/order/request",
                        request,
                        OrderDto.class);
        
                // then
                assertEquals(HttpStatus.OK, response.getStatusCode());
                OrderDto orderDto = response.getBody();
                assertNotNull(orderDto);
                // ์์์  ์ด๋ฆ
                assertEquals(registeredRestaurant.name, orderDto.restaurantName);
        
                // ์์ ์ฃผ๋ฌธ ํ์ธ
                assertEquals(3, orderDto.foods.size());
                // ์์1 ์ฃผ๋ฌธ ํ์ธ
                FoodOrderDto foodOrder1 = orderDto.foods.stream()
                        .filter(foodOrderDto -> foodOrderDto.name.equals(food1.getName()))
                        .findAny().orElse(null);
                assertNotNull(foodOrder1);
                assertEquals(food1.name, foodOrder1.name);
                assertEquals(foodOrder1.quantity, foodOrder1.quantity);
                assertEquals(10900, foodOrder1.price);
                // ์์2 ์ฃผ๋ฌธ ํ์ธ
                FoodOrderDto foodOrder2 = orderDto.foods.stream()
                        .filter(foodOrderDto -> foodOrderDto.name.equals(food2.getName()))
                        .findAny().orElse(null);
                assertNotNull(foodOrder2);
                assertEquals(food2.name, foodOrder2.name);
                assertEquals(foodOrder2.quantity, foodOrder2.quantity);
                assertEquals(9800, foodOrder2.price);
                // ์์3 ์ฃผ๋ฌธ ํ์ธ
                FoodOrderDto foodOrder3 = orderDto.foods.stream()
                        .filter(foodOrderDto -> foodOrderDto.name.equals(food3.getName()))
                        .findAny().orElse(null);
                assertNotNull(foodOrder3);
                assertEquals(food3.name, foodOrder3.name);
                assertEquals(foodOrder3.quantity, foodOrder3.quantity);
                assertEquals(17700, foodOrder3.price);
        
                // ๋ฐฐ๋ฌ๋น ํ์ธ
                assertEquals(2000, orderDto.deliveryFee);
        
                // ์ด ๊ฒฐ์  ๊ธ์ก ํ์ธ
                assertEquals(40400, orderDto.totalPrice);
            }
        
            @Test
            @Order(5)
            @DisplayName("์ฃผ๋ฌธํ๊ธฐ - ์์ ์ฃผ๋ฌธ ์๋ 1 ๋ฏธ๋ง ์๋ฌ")
            void test5() throws JsonProcessingException {
                // given
                Long restaurantId = registeredRestaurant.id;
        
                FoodOrderRequestDto foodOrderRequest1 = FoodOrderRequestDto.builder()
                        .id(food1.id)
                        .quantity(0)
                        .build();
        
                List<FoodOrderRequestDto> foodOrderRequestDtos = new ArrayList<>();
                foodOrderRequestDtos.add(foodOrderRequest1);
        
                OrderRequestDto orderRequest = OrderRequestDto.builder()
                        .restaurantId(restaurantId)
                        .foods(foodOrderRequestDtos)
                        .build();
        
                String requestBody = mapper.writeValueAsString(orderRequest);
                HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                // when
                ResponseEntity<OrderDto> response = restTemplate.postForEntity(
                        "/order/request",
                        request,
                        OrderDto.class);
        
                // then
                assertTrue(
                        response.getStatusCode() == HttpStatus.BAD_REQUEST
                                || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        
            @Test
            @Order(6)
            @DisplayName("์ฃผ๋ฌธํ๊ธฐ - ์์ ์ฃผ๋ฌธ ์๋ 100 ์ด๊ณผ ์๋ฌ")
            void test6() throws JsonProcessingException {
                // given
                Long restaurantId = registeredRestaurant.id;
        
                FoodOrderRequestDto foodOrderRequest1 = FoodOrderRequestDto.builder()
                        .id(food1.id)
                        .quantity(101)
                        .build();
        
                List<FoodOrderRequestDto> foodOrderRequestDtos = new ArrayList<>();
                foodOrderRequestDtos.add(foodOrderRequest1);
        
                OrderRequestDto orderRequest = OrderRequestDto.builder()
                        .restaurantId(restaurantId)
                        .foods(foodOrderRequestDtos)
                        .build();
        
                String requestBody = mapper.writeValueAsString(orderRequest);
                HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                // when
                ResponseEntity<OrderDto> response = restTemplate.postForEntity(
                        "/order/request",
                        request,
                        OrderDto.class);
        
                // then
                assertTrue(
                        response.getStatusCode() == HttpStatus.BAD_REQUEST
                                || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        
            @Test
            @Order(7)
            @DisplayName("์ฃผ๋ฌธํ๊ธฐ - ์์์ ์ ์ต์์ฃผ๋ฌธ ๊ฐ๊ฒฉ ๋ฏธ๋ง ์ ์๋ฌ")
            void test7() throws JsonProcessingException {
                // given
                Long restaurantId = registeredRestaurant.id;
        
                FoodOrderRequestDto foodOrderRequest1 = FoodOrderRequestDto.builder()
                        .id(food2.id)
                        .quantity(1)
                        .build();
        
                List<FoodOrderRequestDto> foodOrderRequestDtos = new ArrayList<>();
                foodOrderRequestDtos.add(foodOrderRequest1);
        
                OrderRequestDto orderRequest = OrderRequestDto.builder()
                        .restaurantId(restaurantId)
                        .foods(foodOrderRequestDtos)
                        .build();
        
                String requestBody = mapper.writeValueAsString(orderRequest);
                HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        
                // when
                ResponseEntity<OrderDto> response = restTemplate.postForEntity(
                        "/order/request",
                        request,
                        OrderDto.class);
        
                // then
                assertTrue(
                        response.getStatusCode() == HttpStatus.BAD_REQUEST
                                || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        
            @Test
            @Order(8)
            @DisplayName("์ฃผ๋ฌธ ์กฐํํ๊ธฐ")
            void test8() {
                // when
                ResponseEntity<OrderDto[]> response = restTemplate.getForEntity(
                        "/orders",
                        OrderDto[].class);
        
                assertEquals(HttpStatus.OK, response.getStatusCode());
                assertNotNull(response.getBody());
                assertEquals(1, response.getBody().length);
        
                OrderDto orderDto = response.getBody()[0];
                // ์์์  ์ด๋ฆ
                assertEquals(registeredRestaurant.name, orderDto.restaurantName);
        
                // ์์ ์ฃผ๋ฌธ ํ์ธ
                assertEquals(3, orderDto.foods.size());
                // ์์1 ์ฃผ๋ฌธ ํ์ธ
                FoodOrderDto foodOrder1 = orderDto.foods.stream()
                        .filter(foodOrderDto -> foodOrderDto.name.equals(food1.getName()))
                        .findAny().orElse(null);
                assertNotNull(foodOrder1);
                assertEquals(food1.name, foodOrder1.name);
                assertEquals(foodOrder1.quantity, foodOrder1.quantity);
                assertEquals(10900, foodOrder1.price);
                // ์์2 ์ฃผ๋ฌธ ํ์ธ
                FoodOrderDto foodOrder2 = orderDto.foods.stream()
                        .filter(foodOrderDto -> foodOrderDto.name.equals(food2.getName()))
                        .findAny().orElse(null);
                assertNotNull(foodOrder2);
                assertEquals(food2.name, foodOrder2.name);
                assertEquals(foodOrder2.quantity, foodOrder2.quantity);
                assertEquals(9800, foodOrder2.price);
                // ์์3 ์ฃผ๋ฌธ ํ์ธ
                FoodOrderDto foodOrder3 = orderDto.foods.stream()
                        .filter(foodOrderDto -> foodOrderDto.name.equals(food3.getName()))
                        .findAny().orElse(null);
                assertNotNull(foodOrder3);
                assertEquals(food3.name, foodOrder3.name);
                assertEquals(foodOrder3.quantity, foodOrder3.quantity);
                assertEquals(17700, foodOrder3.price);
        
                // ๋ฐฐ๋ฌ๋น ํ์ธ
                assertEquals(2000, orderDto.deliveryFee);
        
                // ์ด ๊ฒฐ์  ๊ธ์ก ํ์ธ
                assertEquals(40400, orderDto.totalPrice);
            }
        
            @Getter
            @Setter
            @Builder
            static class OrderRequestDto {
                private Long restaurantId;
                private List<FoodOrderRequestDto> foods;
            }
        
            @Getter
            @Setter
            @Builder
            static class FoodOrderRequestDto {
                Long id;
                int quantity;
            }
        
            @Getter
            @Setter
            static class OrderDto {
                private String restaurantName;
                private List<FoodOrderDto> foods;
                private int deliveryFee;
                private int totalPrice;
            }
        
            @Getter
            @Setter
            static class FoodOrderDto {
                String name;
                int quantity;
                int price;
            }
        
            @Getter
            @Setter
            @Builder
            static class RestaurantDto {
                private Long id;
                private String name;
                private int minOrderPrice;
                private int deliveryFee;
            }
        
            @Getter
            @Setter
            @Builder
            static class FoodDto {
                private Long id;
                private String name;
                private int price;
            }
        }
        ```
        
    
    - ์ํ) ํ์คํธ ํจํค์ง ๋ด ํ์ผ ๊ตฌ์ฑ
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5e670d64-ef02-4210-8165-1b3e16a439b6/Untitled.png)
        
    - ํ์คํธ ์ฝ๋ ์คํ ์ํด build.gradle ํ์ผ์ ์๋ ๋ด์ฉ ์ถ๊ฐdependencies {
    		// ํ์คํธ ์ฝ๋๋ฅผ ์ํ Lombok ๋ผ์ด๋ธ๋ฌ๋ฆฌ
    		testCompileOnly 'org.projectlombok:lombok:1.18.12'
        testAnnotationProcessor 'org.projectlombok:lombok:1.18.12'
    		// ์คํ๋ง ๋ถํธ ํ์คํธ๋ฅผ ์ํ ๋ผ์ด๋ธ๋ฌ๋ฆฌ
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }
        
        ```json
        
        ```
        
    - ์ํ) ํ์คํธ ์ํ ์ฑ๊ณต ๊ฒฐ๊ณผ
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/80b68375-bf55-4e56-9281-6c09cadf09a4/Untitled.png)
