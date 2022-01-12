# Wildlife Tracker

This is an application that allows Rangers to track wildlife sightings in the area.


## Technologies Used

- Java
- HTML
- CSS
- PostgreSQL


##### Setup Instructions and Installation

- Firstly, fork this project into your own repository.
- Run the git clone: `https://github.com/{{your-username}}/forest-service.git` command on your terminal.
- Open the project in your favorite text editor or IDE.
- Navigate to the project on your terminal.
- Run the `psql` command to open communications with the database.
- Open the `create.sql` file on your text editor or IDE
- Run the commands given to you in that file:

CREATE DATABASE wildlife_tracker;

\c wildlife_tracker

CREATE TABLE animals( id   SERIAL PRIMARY KEY, name varchar, type varchar, health varchar, age varchar);

CREATE TABLE sightings
(
id          SERIAL PRIMARY KEY,
animalid   int,
location    varchar,
ranger_name varchar,
type varchar,
sightedat timestamp
);

CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

- Once done navigate to the lines: `String connectionString = "jdbc:postgresql://ec2-3-232-22-121.compute-1.amazonaws.com:5432/dbie0sfc5mt62m";
  Sql2o sql2o = new Sql2o(connectionString, "bgyifudirguvza", "ce9fb937d9b5c0d02c15be407406c71b53ca8c269f8ce6353b43598931fdad63");` in the App.java file and comment them out.
- Uncomment out the lines: ` String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
  //            Sql2o sql2o = new Sql2o(connectionString, null, null);` and you may now run the app locally to your own convenience.
- Use the commands given in the drop.sql file in `psql` to reset the database according to your own will.


## Development

Want to contribute? Great!

To fix a bug or enhance an existing module, follow these steps:
- Fork the repo
- Create a new branch (git checkout -b improve-feature)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (git commit -am 'Improve feature')
- Push to the branch (git push origin improve-feature)
- Create a Pull Request


## Known Bugs

If you find a bug (the website couldn't handle the query and or gave undesired results), kindly open an issue here by including your search query and the expected result.

If you'd like to request a new function, feel free to do so by opening an issue here. Please include sample queries and their corresponding results.


### License

*MIT*
Copyright (c) 2021 **Timothy Kirathe**

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.