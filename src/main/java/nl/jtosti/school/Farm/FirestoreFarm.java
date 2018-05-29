package nl.jtosti.school.Farm;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import nl.jtosti.school.Crop;
import nl.jtosti.school.Farmer;
import nl.jtosti.school.FirestoreCrop;
import nl.jtosti.school.FirestoreDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FirestoreFarm extends FirestoreDao implements FarmDao {
    @Override
    public Farm get(int id) throws ExecutionException, InterruptedException {
        Firestore db = getFirestore();
        CollectionReference collectionReference = db.collection("farms");
        ApiFuture<QuerySnapshot> future = collectionReference.whereEqualTo("id", id).get();
        List<QueryDocumentSnapshot> querySnapshot = future.get().getDocuments();
        if (querySnapshot.size() >= 1) {
            return querySnapshot.get(0).toObject(Farm.class);
        }
        return null;
    }

    @Override
    public Farm update(Farm farm) throws ExecutionException, InterruptedException {
        Firestore db = getFirestore();
        CollectionReference collectionReference = db.collection("farms");
        ApiFuture<QuerySnapshot> future = collectionReference.whereEqualTo("id", farm.getId()).get();
        List<QueryDocumentSnapshot> querySnapshot = future.get().getDocuments();
        if (querySnapshot.size() >= 1) {
            DocumentReference document = querySnapshot.get(0).getReference();
            document.set(farm);
            return farm;
        }
        return null;
    }

    @Override
    public Farm add(Farm farm) throws ExecutionException, InterruptedException {
        Firestore db = getFirestore();
        CollectionReference collectionReference = db.collection("farms");
        ApiFuture<DocumentReference> future = collectionReference.add(farm);
        return farm;
    }

    @Override
    public boolean delete(Farm farm) throws ExecutionException, InterruptedException {
        Firestore db = getFirestore();
        CollectionReference collectionReference = db.collection("farms");
        ApiFuture<QuerySnapshot> future = collectionReference.whereEqualTo("id", farm.getId()).get();
        List<QueryDocumentSnapshot> querySnapshot = future.get().getDocuments();
        if (querySnapshot.size() >= 1) {
            DocumentReference document = querySnapshot.get(0).getReference();
            ApiFuture<WriteResult> future1 = document.delete();
            System.out.println(future1.get().getUpdateTime());
            return true;
        }
        return false;
    }
}
