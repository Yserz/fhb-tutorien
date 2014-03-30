package de.fhb.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.fhb.rest.v1.dto.Owner;
import de.fhb.rest.v1.mapping.DTOMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuthorTest {

  private static ObjectMapper mapper;
  private static Properties properties;

  public AuthorTest() {
  }

  @BeforeClass
  public static void setUpClass() throws IOException {
    // Test cases
    String path = "AuthorTest.properties";
    InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    properties = new Properties();
    properties.load(in);

    // Jackson mapper
    mapper = new ObjectMapper();
  }

  @Test
  public void testRestServiceV1Mapping() throws IOException, URISyntaxException {
    Author author = new Author();
    author.setName("Tom Wendel & Felix Rieseberg");

    Owner dtoAuthor = DTOMapper.mapAuthor(author);

    String actual = mapper.writeValueAsString(dtoAuthor);
    String expected = properties.getProperty("testRestServiceV1Mapping");

    assertEquals(expected, actual);
  }
}
