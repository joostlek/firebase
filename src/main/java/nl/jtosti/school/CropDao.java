package nl.jtosti.school;

import java.util.concurrent.ExecutionException;

public interface CropDao {
    public Crop save(Crop crop) throws ExecutionException, InterruptedException;
    public Crop update(Crop crop) throws ExecutionException, InterruptedException;
    public boolean delete(Crop crop);
    public Crop get(int id) throws ExecutionException, InterruptedException;
}
