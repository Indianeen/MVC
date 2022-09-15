package MVCSolo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by magnus on 2017-01-27.
 */
public class SoloModel {
    private Connection conn;
    private int storyId;
    private String body;
    private ArrayList<String> descriptions;
    private ArrayList<Integer> storyLinks;

    public SoloModel() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname + "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", DatabaseLoginData.user, DatabaseLoginData.password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        storyId = 1;
        descriptions =  new ArrayList<>();
        storyLinks = new ArrayList<>();
        updateState();
    }

    public void setStoryId(int id) {
        storyId = id;
        updateState();
    }

    private void updateState() {
        updateBody();
        updateDescription();
    }

    private void updateBody() {
        String strSelect = "select body from story where id = " + storyId;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(strSelect);

            rset.next();
            body = rset.getString("body");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateDescription() {
        descriptions.clear();
        storyLinks.clear();
        String strSelect = "select description, storyLink from links where storyId = " + storyId;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                descriptions.add(rset.getString("description"));
                storyLinks.add(rset.getInt("storyLink"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getBody() {
        return body;
    }

    public ArrayList<String> getDescriptions() {
        return descriptions;
    }

    public ArrayList<Integer> getStoryLinks() {
        return storyLinks;
    }
}