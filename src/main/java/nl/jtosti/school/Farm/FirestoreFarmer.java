package nl.jtosti.school.Farm;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import nl.jtosti.school.Crop;
import nl.jtosti.school.Farmer;
import nl.jtosti.school.FirestoreCrop;
import nl.jtosti.school.FirestoreDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FirestoreFarmer extends FirestoreDao {
    public static DocumentReference saveFarmer(Farmer farmer) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference collectionReference = db.collection("farmers");
        ApiFuture<QuerySnapshot> future = collectionReference.whereEqualTo("id", farmer.getId()).get();
        List<QueryDocumentSnapshot> documentSnapshots = future.get().getDocuments();
        if (documentSnapshots.size() >= 1) {
            return documentSnapshots.get(0).getReference();
        }
        return collectionReference.add(farmer).get();
    }
}
