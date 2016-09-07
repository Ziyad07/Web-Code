package com.example.controllers;

import com.example.configuration.ReadExcelFiles;
import com.example.dataAccess.DrawUpFixtures;
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
    private ReadExcelFiles excelFiles;
    private DrawUpFixtures drawUpFixtures;

    @Autowired
    public RootController(SessionFactory sessionFactory,
                          ReadExcelFiles excelFiles,
                          DrawUpFixtures drawUpFixtures) {
        this.sessionFactory = sessionFactory;
        this.excelFiles = excelFiles;
        this.drawUpFixtures = drawUpFixtures;
    }


    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/mondayLeague")
    public String monday(Model model) {

        List<TeamEntry> list = excelFiles.retrieveEntries("Monday");
        model.addAttribute("teams", list);
        drawUpFixtures.ConjureFixtures("Monday");
//        model.addAttribute("fixtures", fixtures);
        return "mondayLeague";
    }

    @RequestMapping(value = "/fridayLeague")
    public String friday(Model model) {

        List<TeamEntry> list = excelFiles.retrieveEntries("Friday");
        model.addAttribute("teams", list);
        return "fridayLeague";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TeamEntry.class);
        List list = criteria.list();
        System.out.print("\n\n\n" + list.size());
        model.addAttribute("teams", list);
        model.addAttribute("name", name);
        return "greeting";
    }
}
