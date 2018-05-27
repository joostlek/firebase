package nl.jtosti.school;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

public class FirestoreDao {
    protected Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }

    public void closeConnection() throws Exception {
        FirestoreClient.getFirestore().close();
    }
}
