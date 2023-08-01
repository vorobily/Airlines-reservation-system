# Airlines Reservation System

# Airline Management Application

## What the program does

- `index.html`: Displays all available flights. Users can book flights, and admins can edit, delete, and add flights.
- `Login/Register/Logout`: Navigation bar

## Technologies Used

- PostgreSQL
- Java 8
- Spring
- Thymeleaf

## Program Installation

### IntelliJ IDEA:

1. File -> New -> Project from Existing Source (select your project folder)
2. Import project from external model -> Maven
3. Trust Project

### Setting Up PostgreSQL Database:

1. Start PostgreSQL.
2. Connect to the database.
3. Create a database with a name (e.g., "airlines").
4. Connect to the newly created database.

### Setting Up Database in IDE:

1. Navigate to `Airlines -> src -> main -> resources -> application.properties`.
2. The program uses PostgreSQL.
3. Set `spring.datasource.url=jdbc:postgresql://localhost:5432/{your_database_name}` (replace `{your_database_name}` with your database name).
4. Set `spring.datasource.username={your_username}` (replace `{your_username}` with your PostgreSQL username).
5. Set `spring.datasource.password={your_password}` (replace `{your_password}` with your PostgreSQL password).

### Creating Users:

You have two options to create users:
1. SQL command
2. Registering in the application (Admin can only be created using SQL)

#### Option 1: SQL Command

Use the Query Tool in PostgreSQL to execute the following SQL command:

```sql
INSERT INTO users (username, user_fullname, email, phone, is_admin, password)
VALUES
    ('admin', 'Administrator', 'admin@example.com', '+123456789', true, 'YWRtaW4='),
    ('user1', 'User One', 'user1@example.com', '+987654321', false, 'dXNlcjE='),
    ('user2', 'User Two', 'user2@example.com', '+111111111', false, 'dXNlcjI='),
    ('user3', 'User Three', 'user3@example.com', '+222222222', false, 'dXNlcjM='),
    ('user4', 'User Four', 'user4@example.com', '+333333333', false, 'dXNlcjQ=');
```

The passwords are stored in base64 encoding in the database.

Login Credentials:
* admin password: admin
* user1 password: user1
* user2 password: user2
* user3 password: user3
* user4 password: user4

#### Option 2: Registering in the Application
Use the Register feature in the application to create users (Admin cannot be created via the application, only SQL viable).

### Creating Flights:
You have two options to create users:

#### Option 1: SQL Command
Use the Query Tool in PostgreSQL to execute the following SQL command:

```sql
INSERT INTO flight (source, destination, travel_date, arrival_time, departure_time, price, available_seats)
VALUES
('Dallas', 'New York', '2023-07-22', '08:00:00', '05:30:00', 220.50, 100),
('Los Angeles', 'Chicago', '2023-08-05', '14:10:00', '11:45:00', 230.75, 120),
('Miami', 'San Francisco', '2023-08-12', '18:30:00', '16:00:00', 280.25, 80),
('Seattle', 'Atlanta', '2023-07-29', '11:20:00', '09:00:00', 200.00, 150),
('Las Vegas', 'Denver', '2023-08-08', '13:45:00', '11:15:00', 195.00, 90),
('New York', 'Dallas', '2023-08-15', '10:30:00', '08:15:00', 210.00, 100),
('Chicago', 'Los Angeles', '2023-07-24', '19:20:00', '16:45:00', 240.50, 120),
('San Francisco', 'Miami', '2023-08-06', '09:45:00', '07:30:00', 270.75, 80),
('Atlanta', 'Seattle', '2023-07-30', '16:30:00', '14:00:00', 185.25, 150),
('Denver', 'Las Vegas', '2023-08-13', '12:40:00', '10:15:00', 200.25, 90),
('New York', 'Chicago', '2023-08-01', '20:00:00', '17:30:00', 225.50, 100),
('Los Angeles', 'San Francisco', '2023-07-25', '08:40:00', '06:15:00', 260.75, 120),
('Miami', 'Atlanta', '2023-08-09', '15:30:00', '13:00:00', 190.25, 80),
('Seattle', 'Denver', '2023-07-31', '11:55:00', '09:30:00', 205.00, 150),
('Las Vegas', 'New York', '2023-08-14', '18:15:00', '15:45:00', 235.00, 90);
```

#### Option 2: Add Flight feature in the application (Admin only)
To add flights via the application, log in with the admin credentials, navigate to the "Add Flight" section, and fill in the flight details.

### Running the Program:
1. Next to the Run button in your IDE, choose AirlinesApplication. 
2. Click Run.
3. In your web browser, go to http://localhost:8080/.