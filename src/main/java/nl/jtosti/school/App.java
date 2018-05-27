package nl.jtosti.school;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        FirestoreCrop firestoreCrop = new FirestoreCrop();
        Crop crop = new Crop(1, "asd", new HashMap<>());
        crop.getFarms().put("s", true);
        crop = firestoreCrop.save(crop);
//        Crop crop = firestoreCrop.get(1);
        firestoreCrop.delete(crop);


        crop.setName("BOEMKOOL");
        firestoreCrop.update(crop);
    }
}
