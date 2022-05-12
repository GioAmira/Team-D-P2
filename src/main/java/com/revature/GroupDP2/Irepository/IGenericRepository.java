package com.revature.GroupDP2.Irepository;

<<<<<<< HEAD
import com.revature.GroupDP2.model.Product;

=======
>>>>>>> 2b3760bc5688d5d8eaa7326eee87c25b05134f3d
import java.util.Optional;

public interface IGenericRepository<T> {
    Product create(T t);
    Object update(T t);
    Optional<T> getById(int t);
    void delete(T t);
}
