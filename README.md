# University-Event-Management
## Frameworks and languages used
###### SpringBoot

## Data Flow

### Controller
##### 1.Student Controller
###### Iterable<Student> getAllStudents() --> get all getAllStudents ,String addStudent(Student) ---> add the Student , Student getStudentById(id) -->get Student by id , String updateStudentDepartment(id,Department) --> update the Student by id with department variable , String deleteStudent(id) --> delete the Student by id

##### 2.Event Controller
###### String addEvent(Event) --> add event , Iterable<Event> getAllEvents() --> get all events, Iterable<Event> getAllEvents(date) --> get all events by date,String updateEvent(id,locationOfEvents) --> update event,String deleteEvent(id) --> delete the event

### Service
###### 1.Student Service it is autowired in Controller so that it can perform required business logic
###### 2.Event Service it is autowired in Controller so that it can perform required business logic

### Repository
###### 1.Student Repo this interface will extends crudRepository , It is autowired in Service application , it will save the data to database
###### 2.Event Repo this interface will extends crudRepository , It is autowired in Service application , it will save the data to database

### Model
##### 1.Student Model
###### @Id private int studentId;
###### @Pattern(regexp="([A-Z][a-zA-Z]*)+") private String firstName;
###### private String lastName;
###### @Min(value=18,message = "age must be above or equal to 18") @Max(value=25,message = "age must be below or equal to 25") private Integer age;
###### private Department department;

##### Department(Enum) which will have department types

##### 2.Event Model
###### @Id private int eventId;
###### private String eventName;
###### private String locationOfEvent;
###### @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date of Birth must be in the format dd-mm-yyyy") private String date;
###### @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$") private String startTime;
###### @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$") private String endTime;

##### application.properties(this contains properties which will connect the h2 database)
###### spring.datasource.url=jdbc:h2:mem:h2db
###### spring.datasource.driverClassName=org.h2.Driver
###### spring.datasource.username=root
###### spring.datasource.password=7878
###### spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
###### spring.h2.console.enabled=true
###### spring.jpa.properties.hibernate.show_sql=true
###### spring.jpa.properties.hibernate.use_sql_comments=true
###### spring.jpa.properties.hibernate.format_sql=true


## Summary
###### Performing CRUD operations on University event management by using h2-Database
