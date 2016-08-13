package com.example.controllers;

import com.example.dataAccess.TeamAndNightsDAO;
import com.example.models.TeamEntry;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ReadExcelFiles {

    private TeamAndNightsDAO teamAndNightsDAO;
    private InputStream file;

    @Autowired
    public ReadExcelFiles(TeamAndNightsDAO teamAndNightsDAO, InputStream file) {
        this.teamAndNightsDAO = teamAndNightsDAO;
        this.file = file;
    }

    public void persistEntry(TeamEntry team) {
        teamAndNightsDAO.save(team);
    }

    public void delete(String teamEntry) {
        teamAndNightsDAO.delete(teamEntry);
    }

    public List<TeamEntry> retrieveEntries(String leagueNight) {
        return teamAndNightsDAO.retrieveList(leagueNight);
    }

    @PostConstruct
    public void ReadFiles() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowStart = Math.min(1, 1); // 0 based not 1 based rows

            int rowEnd = Math.max(12, sheet.getLastRowNum());
            for (int rowNum = rowStart; rowNum < rowEnd + 1; rowNum++) {
                Row row = sheet.getRow(rowNum);
                String teamName = row.getCell(0).getStringCellValue();
                String leagueNight = row.getCell(1).getStringCellValue();
                TeamEntry teamEntry = new TeamEntry(teamName, leagueNight);
                persistEntry(teamEntry);
            }
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
