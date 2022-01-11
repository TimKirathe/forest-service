import models.EndangeredAnimal;
import models.NormalAnimal;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;
import dao.*;
import org.sql2o.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        sql2oNormalAnimalDao sql2oNormalAnimalDao = new sql2oNormalAnimalDao(sql2o);
        sql2oEndangeredAnimalsDao sql2oEndangeredAnimalsDao = new sql2oEndangeredAnimalsDao(sql2o);
        sql2oSightingsDao sql2oSightingsDao = new sql2oSightingsDao(sql2o);

        // get: Homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> allSightings = sql2oSightingsDao.returnAll();
            model.put("allSightings", allSightings);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: Show Normal Animal Sighting Form
        get("/normal-sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "normal-sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //get: Show Endangered Animal Sighting Form
        get("/endangered-sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered-sighting-form.hbs");
        });

        //post: Post Normal Animal Form
        post("/normal-sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Integer animalId = Integer.parseInt(request.queryParams("animalId"));
            String animalName = request.queryParams("animalName");
            String animalType = request.queryParams("type");
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            NormalAnimal normalAnimal = new NormalAnimal(animalName);
            sql2oNormalAnimalDao.save(normalAnimal);
            Sighting newSighting = new Sighting(animalId, location, rangerName);
            sql2oSightingsDao.save(newSighting);
            List<NormalAnimal> normalAnimals = sql2oNormalAnimalDao.returnAll();
            model.put("normalAnimals", normalAnimals);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //post: Post Endangered Animal Form
        post("/endangered-sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Integer endangeredAnimalId = Integer.parseInt(request.queryParams("animalId"));
            String endangeredAnimalName = request.queryParams("animalName");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String type = request.queryParams("type");
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(endangeredAnimalName, health, age);
            sql2oEndangeredAnimalsDao.save(endangeredAnimal);
            Sighting newSighting = new Sighting(endangeredAnimalId, location, rangerName);
            sql2oSightingsDao.save(newSighting);
            List<EndangeredAnimal> endangeredAnimals = sql2oEndangeredAnimalsDao.returnAll();
            model.put("normalAnimals", endangeredAnimals);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }
}