package com.example.icecreamadmin.services;

import com.google.firebase.database.*;
import com.example.icecreamadmin.config.FirebaseConfig;
import com.example.icecreamadmin.model.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FirebaseServiceProduct extends FirebaseConfig {
    private DatabaseReference database;

    public FirebaseServiceProduct(String path) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        database = firebaseDatabase.getReference(path);
    }

    // Method for saving a product announcement using the fields directly
    public void saveProduct(String title, String shortInfo, String description,
                                 double price, String currency, double oldPrice,
                                 String sku, boolean outOfStock, boolean featured,
                                 String categories, String imageUrl) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setTitle(title);
        productEntity.setShortInfo(shortInfo);
        productEntity.setDescription(description);
        productEntity.setPrice(price);
        productEntity.setCurrency(currency);
        productEntity.setOldPrice(oldPrice);
        productEntity.setSku(sku);
        productEntity.setOutOfStock(outOfStock);
        productEntity.setFeatured(featured);
        productEntity.setCategories(categories);
        productEntity.setImageUrl(imageUrl);
        productEntity.setId(database.push().getKey());  // Auto-generate Firebase key

        database.child(productEntity.getId()).setValueAsync(productEntity);
    }

    // Method for retrieving all announcements directly as ProductEntity objects
    public CompletableFuture<List<ProductEntity>> getProduct() {
        CompletableFuture<List<ProductEntity>> future = new CompletableFuture<>();
        List<ProductEntity> productList = new ArrayList<>();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ProductEntity productEntity = snapshot.getValue(ProductEntity.class);
                    if (productEntity != null) {
                        productList.add(productEntity);
                    }
                }
                future.complete(productList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    // Method for deleting a product by ID
    public void deleteById(String id) {
        database.child(id).removeValue((databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Error deleting data: " + databaseError.getMessage());
            } else {
                System.out.println("Data deleted successfully.");
            }
        });
    }

    // Method for updating a product by ID
    public void updateById(String id, ProductEntity updatedEntity) {
        database.child(id).setValue(updatedEntity, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Error updating data: " + databaseError.getMessage());
            } else {
                System.out.println("Data updated successfully.");
            }
        });
    }}
