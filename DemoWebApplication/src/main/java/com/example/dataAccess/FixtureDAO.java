package com.example.dataAccess;

import com.example.models.FixtureScores;
import com.example.models.FixtureTeams;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;


@Repository
@Transactional
public class FixtureDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public FixtureDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Start FixtureScores
    public void saveFixtureScore(FixtureScores teamScores) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(teamScores);
    }

    public void updateFixtureScores(FixtureScores teamScores) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(teamScores);
    }

    public List<FixtureScores> retrieveListFixtureScores(String leagueNight) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(FixtureScores.class);
        criteria.add(eq("leagueNight", leagueNight));
        return (List<FixtureScores>) criteria.list();
    }
    // End FixtureScores


    // ------------------------------------------------------------------------------------------------//


    // Start FixtureTeams
    public void saveFixtureTeams(FixtureTeams teamFixture) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(teamFixture);
    }

    public void updateFixtureTeams(FixtureTeams teamFixture) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(teamFixture);
    }

    public List<FixtureTeams> retrieveListFixtureTeam(String leagueNight) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(FixtureTeams.class);
        criteria.add(eq("leagueNight", leagueNight));
        return (List<FixtureTeams>) criteria.list();
    }
    // End FixtureTeams


    //    public void deleteFixtureScores(String name) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("delete TeamEntry AS t where t.name = :nameS");
//        query.setParameter("nameS", name);
//        query.executeUpdate();
//    }


//    public TeamEntry retrieveFixtureScores(String teamEntryName, String leagueNight) {
//        Session session = sessionFactory.getCurrentSession();
//        Criteria criteria = session.createCriteria(TeamEntry.class);
//        criteria.add(eq("name", teamEntryName));
//        criteria.add(eq("leagueNight", leagueNight));
//        return (TeamEntry) criteria.uniqueResult();
//    }

}
