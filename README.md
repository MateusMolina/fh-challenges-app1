# fh-challenges-app1

Simple form registration implemented with Java, Maven and Tomcat8.


## Set-up
1. Launch the MySQL Docker Container
2. Execute following query:
 ```SQL
 CREATE TABLE `app1_users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 ```
3. Deploy app on Tomcat8 Server
4. Access Endpoint [...]/app1/register


## To-Do
- [ ] Containerize Tomcat and make it seamless create the SQL table structure when deployed
- [ ] JPA, Spring?
- [ ] CSS, Design
