package caliber.User.Interface.Design.Controllers;

import caliber.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/course")
public class CoursePage {

    @Autowired
    private MongoOperations mongoOperations;

    @PostMapping
    public Course add(@RequestBody Course course){
        return mongoOperations.insert(course);
    }

    //responds to get requests at "/course"
    @GetMapping()
    public List<Course> getCourse(){//Dynamic request handler
        return mongoOperations.findAll(Course.class);
    }
}
