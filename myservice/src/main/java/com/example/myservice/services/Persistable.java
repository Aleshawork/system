package com.example.myservice.services;

import org.springframework.lang.Nullable;

import java.io.Serializable;


public abstract class Persistable<T> implements Serializable {

    @Nullable
    public abstract T getId();

    @Override
    public int hashCode() {
        return getId() == null ? super.hashCode() : getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
  //      if (obj == null || getClass().equals(Hibernate.get))
        return super.equals(obj);
    }


}
