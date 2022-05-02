package edu.qc.seclass.fim;

import java.util.Locale;

public class Floor {
    private int Fid,Sid;
    private String name,category,color,size,brand,price;

    public Floor(int FloorId, int StoreId, String FloorName,String FloorCategory,String FloorColor,String FloorSize,String FloorBrand,String FloorPrice)
    {
        this.Fid = FloorId;
        this.Sid = StoreId;
        this.name = FloorName;
        this.category = FloorCategory;
        this.color = FloorColor;
        this.size = FloorSize;
        this.brand = FloorBrand;
        this.price = FloorPrice;
    }

    public String toString()
    {
        return "Floor" + name + category+ color+size+brand+price;
    }
    public Integer getFloorId()
    {
        return Fid;
    }
    public void setFloorId(Integer FloorId)
    {
        Fid = FloorId;
    }
    public Integer getStoreId()
    {
        return Sid;
    }
    public void setStoreId(Integer StoreId)
    {
        Sid = StoreId;
    }
    public String getFloorName()
    {
        return name;
    }
    public void setFloorName(String FloorName)
    {
        name = FloorName;
    }
    public String getFloorCategory()
    {
        return category;
    }
    public void setFloorCategory(String FloorCategory)
    {
        category = FloorCategory;
    }
    public String getFloorColor()
    {
        return color;
    }
    public void setFloorColor(String FloorColor)
    {
        color = FloorColor;
    }
    public String getFloorSize()
    {
        return size;
    }
    public void setFloorSize(String FloorSize)
    {
        size = FloorSize;
    }
    public String getFloorBrand()
    {
        return brand;
    }
    public void setFloorBrand(String FloorBrand)
    {
        brand = FloorBrand;
    }
    public String getFloorPrice()
    {
        return price;
    }
    public void setFloorPrice(String FloorPrice)
    {
        price = FloorPrice;
    }

}
