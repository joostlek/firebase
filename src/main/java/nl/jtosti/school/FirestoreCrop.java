package nl.jtosti.school;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class FirestoreCrop extends FirestoreDao implements CropDao {

    @Override
    public Crop save(Crop crop) throws ExecutionException, InterruptedException {
        Firestore db = getFirestore();
        DocumentReference documentReference = db.collection("crops").document(Integer.toString(crop.getId()));
        ApiFuture<WriteResult> future = documentReference.set(crop);
        System.out.println(future.get().getUpdateTime());
        return crop;
    }

    @Override
    public Crop update(Crop crop) throws ExecutionException, InterruptedException {
        Firestore db = getFirestore();
        DocumentReference documentReference = db.collection("crops").document(Integer.toString(crop.getId()));
        ApiFuture<WriteResult> future = documentReference.update(crop.toMap());
        System.out.println(future.get().getUpdateTime());
        return crop;
    }

    @Override
    public boolean delete(Crop crop) {
        Firestore db = getFirestore();
        DocumentReference documentReference = db.collection("crops").document(Integer.toString(crop.getId()));
        ApiFuture<WriteResult> future = documentReference.delete();
        return future.isDone();
    }

    @Override
    public Crop get(int id) throws ExecutionException, InterruptedException {
        Firestore db = getFirestore();
        DocumentReference documentReference = db.collection("crops").document(Integer.toString(id));
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            return document.toObject(Crop.class);
        } else {
            return null;
        }
    }
}
