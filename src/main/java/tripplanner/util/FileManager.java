package tripplanner.util;
import tripplanner.model.*;

import java.io.*;
import java.util.ArrayList;

    public class FileManager {

        public static void saveItinerary(ArrayList<Country> list) {
            try (PrintWriter pw = new PrintWriter("itinerary.txt")) {
                for (Country c : list) {
                    pw.println(c.getName());
                }
            } catch (Exception e) {
                System.out.println("Error saving file.");
            }
        }

        public static ArrayList<Country> loadItinerary() {
            ArrayList<Country> list = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader("itinerary.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    switch (line) {
                        case "Bosnia" -> list.add(new Bosnia());
                        case "Italy" -> list.add(new Italy());
                        case "France" -> list.add(new France());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error loading file.");
            }

            return list;
        }
    }

