package com.example.dataAccess;

import com.example.configuration.ReadExcelFiles;
import com.example.models.FixtureTeams;
import com.example.models.TeamEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DrawUpFixtures {

    private ReadExcelFiles readExcelFiles;

    private FixtureDAO fixtureDAO;

    @Autowired
    public DrawUpFixtures(ReadExcelFiles readExcelFiles, FixtureDAO fixtureDAO) {
        this.readExcelFiles = readExcelFiles;
        this.fixtureDAO = fixtureDAO;
    }

    public void persist(FixtureTeams fixture) {
        fixtureDAO.saveFixtureTeams(fixture);
    }

    public void update(FixtureTeams fixture) {
        fixtureDAO.updateFixtureTeams(fixture);
    }

    public List<FixtureTeams> retrieveFixtureList(String leagueNight) {
        return fixtureDAO.retrieveListFixtureTeam(leagueNight);
    }

    //    @PostConstruct
    public void ConjureFixtures(String leagueNight) {
        List<TeamEntry> allTeams = readExcelFiles.retrieveEntries(leagueNight);
        int numberOfTeams = allTeams.size();
//        FixtureTeams [][] fixtures = new FixtureTeams[numberOfTeams][numberOfTeams];
// This only gets home games if j = i
        for (int i = 0; i < numberOfTeams; i++) {
            for (int j = i; j < numberOfTeams; j++) {
                if (i != j) {
                    FixtureTeams fixturesTeams = new FixtureTeams(allTeams.get(i), allTeams.get(j), leagueNight);
                    // persist this to database
                    persist(fixturesTeams);
                }
            }
        }
//        return fixtures;
    }

}
