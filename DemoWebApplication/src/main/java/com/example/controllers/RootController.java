package com.example.controllers;

import com.example.models.TeamEntry;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@Transactional
@Controller
public class RootController {
    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public RootController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/mondayLeague")
    public String monday(Model model) {
        session = sessionFactory.getCurrentSession();
        TeamEntry team = new TeamEntry("ManUtd2", "Tuesday");
        TeamEntry team2 = new TeamEntry("Liva2", "Tuesday");
        session.save(team);
        session.save(team2);
        team.setGamesPlayed(1);
        team.setGamesPlayed(1);
        Criteria criteria = session.createCriteria(TeamEntry.class);
        List<TeamEntry> list = criteria.list();

//        List<TeamEntry> list = new ArrayList<>();
//        list.add(team);
//        list.add(team2);
        model.addAttribute("teams", list);
        return "mondayLeague";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
