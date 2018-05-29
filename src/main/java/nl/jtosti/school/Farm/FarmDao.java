package nl.jtosti.school.Farm;

import java.util.concurrent.ExecutionException;

public interface FarmDao {
    Farm get(int id) throws ExecutionException, InterruptedException;
    Farm update(Farm farm) throws ExecutionException, InterruptedException;
    Farm add(Farm farm) throws ExecutionException, InterruptedException;
    boolean delete(Farm farm);
}
