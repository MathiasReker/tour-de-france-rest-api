# Tour de France

Restful CRUD API for a Tour de France web app.

## Steps to setup

**1. Clone the application**

```bash
git clone https://github.com/MathiasReker/tour-de-france-rest-api.git
```

**2. Create Mysql database**

- run `src/main/resources/dbdump.sql`

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Install the dependencies using maven**

```bash
mvn clean install
```

**5. Run the app using maven**

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>
