package com.company.chatterbook.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import com.company.chatterbook.models.User;
import com.company.chatterbook.models.ChatterPost;

@RestController
public class ChatterPostController {
    private List<User> userList;

    // Copy/Paste from instructions:
    public ChatterPostController() {
        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

        luis.setChatterPosts(Arrays.asList(new ChatterPost("Hey! This is my first post!"), new ChatterPost("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPost("I'm bored"), new ChatterPost("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPost("My life is awesome!"), new ChatterPost("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPost("I like pigs."), new ChatterPost("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPost("My cat is so cute"), new ChatterPost("My kitten is purr-fect.")));
        mariella.setChatterPosts(Arrays.asList(new ChatterPost("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPost("Have you ever heard of the band Nirvana?"), new ChatterPost("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPost("You definitely grew up in the 90s if you get these 10 references."), new ChatterPost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPost("I just wrecked my dad's car. He's going to kill me!"), new ChatterPost("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Arrays.asList(new ChatterPost("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPost("My roommate is awful!!!!"), new ChatterPost("Anyone know a room for rent in Hyde Park?")));

        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);
    }

    // URI and HTTP method to get JSON of a list of all users & their posts
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUserList() {
        return userList;
    }

    // URI and HTTP method to get JSON of one user
    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public User getUsersByName(@PathVariable String name) {
        User requested_user = null;
        for (User u : userList){
            if( u.getName().equals(name))
            {
                requested_user = u;
            }
        }
        return requested_user;
    }

    //URI and HTTP method to get specified user's posts
    @RequestMapping(value = "/users/{name}/chatterposts", method = RequestMethod.GET)
    public List<ChatterPost> getChatterpostsByName(@PathVariable String name) {
        User requested_user = null;

        for (User u : userList){
            if( u.getName().equals(name))
            {
                requested_user = u;
            }
        }

        return requested_user.getChatterPosts();
    }

}
