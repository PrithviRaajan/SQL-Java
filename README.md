# SQL-Java
Connect a local SQL database to your Java Program
Step 1:
Download Oracle JDBC Driver and companion Jars
Go ahead to the given link and download the respective file that supports both the Oracle database and the java version on your computer.
https://www.oracle.com/in/database/technologies/appdev/jdbc-downloads.html


Step 2:
Install Oracle client
Go ahead to the given link and download the oracle instant client on your device.
https://www.oracle.com/in/database/technologies/appdev/jdbc-downloads.html

Step 3:
Check the hostname, portno and service name
Open up your command prompt and run the command
          lsnrctl status
This will display the required hostname, portno and service name on the screen and make sure to copy them all so that its helpful while connecting the database in the Java code.

Step 4
Open up VScode or any Java supporting IDE and type the following code for connection and further using it for inputting queries and executing them. Make sure to place the jdbc file in the same folder as the one having the Java file as it is very important while running the code.
