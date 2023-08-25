

[String Builder](https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/)


## Date Timestamps

**java.time**

The other Answers use the outmoded old date-time classes. After proving to be confusing, troublesome, and flawed, they have been supplanted by the java.time framework in Java 8 and later.

Do not use the *java.sql* classes in your business logic. They are a messy extension of those old date-time classes, and are a badly-designed hack. Use them only for transferring your data in/out of the database. Convert to java.time types immediately.

To convert, use the new methods added to the old classes.

In the case of java.sql.Date, it is pretending to hold a date-only value without time-of-day nor time zone. The java.time classes include a true date-only value, LocalDate. To convert from java.sql.Date to java.time.LocalDate, call java.sql.Date::toLocalDate.

`LocalDate ld = mySqlDate.toLocalDate();`

Adding a true month is built-in.

`LocalDate monthLater = ld.plusMonths( 1 );`

Convert back to java.sql for storage in the database.

`java.sql.Date sqlDate = java.sql.Date.valueOf( monthLater );`

Hopefully some day we will see the JDBC drivers updated to support the java.time types directly. Then the java.sql types will fade away as old relics of the past. But until then we need to perform these java.sql ↔ java.time conversions.

Update: JDBC 4.2 and later provides for passing java.time types directly with PreparedStatement::setObject, and fetching with ResultSet::getObject. So no need for conversion to java.sql types.

[Stack OverFlow](https://stackoverflow.com/questions/35668643/add-1-month-from-current-date-using-java-sql-date)
[Date Util in Java](https://www.javatpoint.com/java-util-date)
[DateUtils](https://stackoverflow.com/questions/4905416/how-do-i-add-one-month-to-current-date-in-java)
