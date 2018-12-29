# jdbctemplateTutorial1
spring JdbcTemplate takes care of the trival things like creation of connection statement and closing of statement result set and connection object.It also translate sql exception into meaning exceptions with the help of spring .

#In our example we are going to use mysql date base .Here we are going to perform CRUD operation on the employee table.
The following steps needs to be performed to use JdbcTemplate 
1.create a maven project with the following dependencies :spring-core ,spring-context,spring-jdbc and mysl-connector-java.
2.create the employee table in the date base emprecord
3.Create employee model class
4.creat employeeDAO classes
5.create employeeDAOImpl classes
6.create bean.xml to inject the dataSource
