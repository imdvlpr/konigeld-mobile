package com.application.jojobudiman.konigeldandroid.sqlconnection;

public class Confirguration {

    public static final String URL_LOGIN="http://10.2.2:8888/semester8/konigeld/assets/mobile/login.php";
    /*public static final String URL_GET_ALL = "http://192.168.1.9/Android/pegawai/tampilSemuaPgw.php";
    public static final String URL_GET_EMP = "http://192.168.1.9/Android/pegawai/tampilPgw.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.1.9/Android/pegawai/updatePgw.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.9/Android/pegawai/hapusPgw.php?id=";*/

    //Dibawah ini merupakan kunci digunakan untuk mengirim permintaan login ke PHP
    public static final String KEY_USER_ID = "id_user";
    public static final String KEY_USER_FIRSTNAME = "fname_user";
    public static final String KEY_USER_LASTNAME = "lname_user";
    public static final String KEY_USER_EMAIL = "email_user";
    public static final String KEY_USER_PASS = "pass_user";
    public static final String KEY_USER_ROLE = "jabatan";
    public static final String KEY_USER_PHONE = "hp_user";
    public static final String KEY_OUTLET_ID = "id_outlet";
    public static final String KEY_MERCHANT_ID = "id_merchant";
    public static final String KEY_USER_STATUS = "status_user";
    

    //JSON Tags
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_USER_ID = "id";
    public static final String TAG_USER_FIRSTNAME = "fname";
    public static final String TAG_USER_LASTNAME = "lname";
    public static final String TAG_USER_EMAIL = "email";
    public static final String TAG_USER_PASS = "pass";
    public static final String TAG_USER_ROLE = "jabatan";
    public static final String TAG_USER_PHONE = "handphone";
    public static final String TAG_OUTLET_ID = "outletid";
    public static final String TAG_MERCHANT_ID = "merchantid";
    public static final String TAG_USER_STATUS = "status";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";

}
