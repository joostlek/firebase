package nl.jtosti.school;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import nl.jtosti.school.Farm.Farm;
import nl.jtosti.school.Farm.FirestoreFarm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ExecutionException, InterruptedException {
        InputStream serviceAccount = new FileInputStream("src/main/java/nl/jtosti/school/Firebase.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);
        FirestoreFarm firestoreFarm = new FirestoreFarm();
        Farm farm = new Farm(2, "My Farm", "Daltonlaan 200, Utrecht", new ArrayList<>(), new ArrayList<>());
        Crop boemkool = new Crop(1, "BOEMKOOL", new ArrayList<>());
        Crop witlof = new Crop(2, "WITHLOV", new ArrayList<>());
        Farmer anderson = new Farmer(2, "Hans Anderson", farm.getId());
        Farmer anders = new Farmer(1, "Hans Anders", 0);
        farm.addCrop(boemkool);
        boemkool.addFarm(farm);
        farm.addFarmer(anderson);
        // CREATED OBJECTS
        pressKeyToContinue();
        firestoreFarm.add(farm);
        // ADDED FARM TO FIRESTORE
        pressKeyToContinue();
        System.out.println(firestoreFarm.get(2).getAddress());
        // GET FARM 1
        pressKeyToContinue();
        farm.setName("His Farm");
        farm.addCrop(witlof);
        witlof.addFarm(farm);
        firestoreFarm.update(farm);
        // UPDATED FARM (ADDED WITLOF AND CHANGED NAME
        pressKeyToContinue();
        System.out.print(firestoreFarm.delete(farm));
        // DELETED FARM
        pressKeyToContinue();
    }

    private static void pressKeyToContinue() {
        System.out.println("Press key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
