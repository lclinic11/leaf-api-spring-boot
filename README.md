# Leaf-Api-Spring-Boot，一个从 Leaf Server 获取 ID 的起步依赖项目

- 默认使用 HttpClient 作为 RestTemplate 连接工具，支持配置 Http 连接池
- 默认使用 RestLeafApi 实现获取 Leaf Id
- 默认实现 Mybatis-Plus 自定义ID生成器

# 使用说明

#### 引入依赖

```xml
<dependency>
    <groupId>com.lemiao.leaf</groupId>
    <artifactId>leaf-api-spring-boot-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

#### 应用配置

```c
## leaf api config
leaf.server.url=http://dev-leaf.xinc818.com

## http连接池配置
http-pool.max-total=20
http-pool.default-max-per-route=10
http-pool.connect-timeout=1000
http-pool.connection-request-timeout=3000
http-pool.socket-timeout=5000
http-pool.validate-after-inactivity=7000
http-pool.async=false
```

#### 使用方式

1. 手动获取 Leaf Id

```java
public class LeafApiTest {

    @Autowired
    private LeafApi leafApi;

    /**
     * 获取Leaf号段ID
     */
    @Test
    public void testGetSegmentId() {
        Long id = leafApi.getSegmentId("bizKey");
        System.out.println(id);
    }

    /**
     * 获取Leaf雪花算法ID
     */
    @Test
    public void testGetSnowflakeId() {
        Long id = leafApi.getSnowflakeId("bizKey");
        System.out.println(id);
    }

}
```

2. Mybatis-Plus项目，使用注解方式自动获取 Leaf Id

```java
/**
 * 获取Leaf号段ID
 */
@LeafId(key = "bizKey", idType = LeafIdType.SEGMENT)
public class Entity implements Serializable {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

}

/**
 * 获取Leaf雪花算法ID
 */
@LeafId(key = "bizKey", idType = LeafIdType.SNOWFLAKE)
public class Entity implements Serializable {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

}
```
