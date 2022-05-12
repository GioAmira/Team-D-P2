package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;

<<<<<<< HEAD
import java.util.List;

public interface IProductRepository<T> extends IGenericRepository<Product>{

    Product getByUserId(int l);

    Product getByCategoryId(int l);

    Product save(Product product);

    List<Product> getAll();

    Object getById(Integer id);

    void start();

    void stop();

    boolean isRunning();
=======
public interface IProductRepository<T> extends IGenericRepository<Product>{

    Product getByUserId(int l);

    Product getByCategoryId(int l);
>>>>>>> 2b3760bc5688d5d8eaa7326eee87c25b05134f3d
}
