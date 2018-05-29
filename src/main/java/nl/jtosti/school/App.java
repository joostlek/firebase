package nl.jtosti.school;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import nl.jtosti.school.Farm.Farm;
import nl.jtosti.school.Farm.FirestoreFarm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        Farm farm = new Farm(1, "SUNNY", "asd", new ArrayList<>(), new ArrayList<>());
        Crop boemkool = new Crop(1, "BOEMKOOL", new ArrayList<>());
        Crop witlof = new Crop(2, "WITHLOV", new ArrayList<>());
        Farmer anderson = new Farmer(2, "Hans Anderson", farm.getId());
        Farmer anders = new Farmer(1, "Hans Anders", 0);
        farm.addCrop(boemkool);
        boemkool.addFarm(farm);
        farm.addFarmer(anderson);
        firestoreFarm.add(farm);
        farm.setName("KEKEKEKEK");
        farm.addCrop(witlof);
        witlof.addFarm(farm);
        firestoreFarm.update(farm);

        Farm farm1 = new Farm(2, "FARMMRAF", "dsa", new ArrayList<>(), new ArrayList<>());
        farm1.addCrop(witlof);
        witlof.addFarm(farm1);
        farm1.addFarmer(anders);
        anders.setFarm(farm1.getId());
        firestoreFarm.add(farm1);
    }
}
