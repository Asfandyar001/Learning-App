public class DB
{
    String url;
    
    DB()
    {
        url = "jdbc:sqlserver://103.31.104.114:1433;databaseName=Learning_System;user=user;password=12345678;trustServerCertificate=true;";
    }

    String geturl()
    {
        return url;
    }

}
