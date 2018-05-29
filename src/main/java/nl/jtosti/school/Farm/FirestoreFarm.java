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
            document.update("name", farm.getName());
            document.update("address", farm.getAddress());
            List<DocumentReference> crops = new ArrayList<>();
            for (Crop crop: farm.getCrops()) {
                crops.add(FirestoreCrop.saveCrop(crop));
            }
            document.update("crops", crops);
            List<DocumentReference> farmers = new ArrayList<>();
            for (Farmer farmer: farm.getFarmers()) {
                farmers.add(FirestoreFarmer.saveFarmer(farmer));
            }
            document.update("farmers", farmers);
            return farm;
        }
        return null;
    }

    @Override
    public Farm add(Farm farm) throws ExecutionException, InterruptedException {
        Firestore db = getFirestore();
        CollectionReference collectionReference = db.collection("farms");
        ApiFuture<DocumentReference> future = collectionReference.add(farm);
        FirestoreCrop firestoreCrop = new FirestoreCrop();
        List<DocumentReference> crops = new ArrayList<>();
        for (Crop crop: farm.getCrops()) {
            crops.add(firestoreCrop.saveCrop(crop));
        }
        future.get().update("crops", crops);
        FirestoreFarmer firestoreFarmer = new FirestoreFarmer();
        List<DocumentReference> farmers = new ArrayList<>();
        for (Farmer farmer: farm.getFarmers()) {
            farmers.add(firestoreFarmer.saveFarmer(farmer));
        }
        future.get().update("farmers", farmers);
        return farm;
    }

    @Override
    public boolean delete(Farm farm) {
        return false;
    }
}
