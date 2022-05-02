package edu.qc.seclass.fim;

public class User {
    private Integer userId,userIdentity,empStoreId;
    private String userName,userPassword;


    public User(int UserId, String UserName, String UserPassword, int UserIdentity, int EmpStoreId)
    {
        this.userId = UserId;
        this.userName = UserName;
        this.userPassword = UserPassword;
        this.userIdentity = UserIdentity;
        this.empStoreId = EmpStoreId;
    }

    public String toString()
    {
        return "User [UserId ="+ userId + ", UserName = "+ userName + ", UserPassword = "+ userPassword +  ", UserIdentity = "+ userIdentity +", EmpStoreId = " + empStoreId + "]";
    }

    public Integer getUserId()
    {
        return userId;
    }
    public String getUserName()
    {
        return getUserName();
    }
    public void setUserName(String UserName){
        userName = UserName;
    }
    public String getUserPassword(){
        return userPassword;
    }
    public void setUserPassword(String password)
    {
        userPassword = password;
    }
    public Integer getUserIdentity(){
        return userIdentity;
    }
    public void setUserIdentity(int UserIdentity){
        userIdentity = UserIdentity;

    }
    public Integer getEmpStoreId(){
        return empStoreId;
    }
    public void setEmpStoreId(int EmpStoreId){
        empStoreId = EmpStoreId;
    }

}
