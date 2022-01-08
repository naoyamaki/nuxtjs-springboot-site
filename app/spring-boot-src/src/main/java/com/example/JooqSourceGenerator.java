package com.example;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;
import java.sql.*;
import javax.sql.*;
import org.jooq.*;
import org.jooq.impl.*;
import org.jooq.meta.jaxb.Configuration;

public class JooqSourceGenerator {
  public static void main(String[] args) throws Exception {
    Configuration configuration = new org.jooq.meta.jaxb.Configuration()
      .withJdbc(new Jdbc()
        .withDriver("com.mysql.jdbc.Driver")
        .withUrl("jdbc:mysql://localhost:3306/main")
        .withUser("root")
        .withPassword("#sample1234")
      )
      .withGenerator(new Generator()
        .withDatabase(new Database()
          .withName("org.jooq.meta.mysql.MySQLDatabase")
          .withIncludes(".*")
          .withExcludes("")
          .withInputSchema("main")
        )
        .withTarget(new Target()
          .withPackageName("com.example.jooq")
          .withDirectory("src/main/java")
        )
      );
    GenerationTool.generate(configuration);
  }
}