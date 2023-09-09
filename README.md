# 20230907

context.xml 파일에 </context> 바로 위에 아래 코드 추가
<ResourceLink global="jdbc/test" name="jdbc/test" type="javax.sql.DataSource" />


server.xml 파일에  <Resource ~ /> 추가
<GlobalNamingResources>
    <!-- Editable user database that can also be used by
         UserDatabaseRealm to authenticate users
    -->
    <Resource auth="Container" driverClassName="com.mysql.jdbc.Driver" factory="org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory" maxActive="50" name="jdbc/test" password="1234" type="javax.sql.DataSource" url="jdbc:mysql://localhost:3306/bookstore" username="root"/>
  </GlobalNamingResources>


  중요설정
  프로젝트에 build path 설정 : servlet.api.jar (tomcat 폴더 > lib 폴더에 있음), mysql-connector-j-8.1.0.jar(java 폴더 > lib 폴더에 있음)
  WEB-INF > lib : mysql-connector-j-8.1.0.jar, tomcat-dbcp-7.0.30.jar 붙여넣기
