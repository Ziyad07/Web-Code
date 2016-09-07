package com.example.dataAccess;

import com.example.models.TeamEntry;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
@Transactional
public class TeamAndNightsDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public TeamAndNightsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(TeamEntry teamEntry) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(teamEntry);
    }

    public void update(TeamEntry teamEntry) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(teamEntry);
    }

    public void delete(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete TeamEntry AS t where t.name = :nameS");
        query.setParameter("nameS", name);
        query.executeUpdate();
    }

    public List<TeamEntry> retrieveList(String leagueNight) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TeamEntry.class);
        criteria.add(eq("leagueNight", leagueNight));
        return (List<TeamEntry>) criteria.list();
    }

    public List<TeamEntry> retrieveAllTeamsList() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TeamEntry.class);
        return (List<TeamEntry>) criteria.list();
    }

    public TeamEntry retrieveTeamEntry(String teamEntryName, String leagueNight) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TeamEntry.class);
        criteria.add(eq("name", teamEntryName));
        criteria.add(eq("leagueNight", leagueNight));
        return (TeamEntry) criteria.uniqueResult();
    }
}
