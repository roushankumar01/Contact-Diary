package roushan.contactdiary.com.contactdiary;

/**
 * Created by Roushan on 9/10/2017.
 */

class Contact {

    private String _name, _phone, _email, _address,_dob;

    public Contact (String name, String phone, String email, String address, String dob){
        _name =  name;
        _phone = phone;
        _email = email;
        _address = address;
        _dob = dob;

    }

    public String getName(){
        return _name;
    }


    public String getPhone(){
        return _phone;
    }

    public String getEmail(){
        return _email;
    }

    public String getAddress(){
        return _address;
    }

    public String getDob(){
        return _dob;
    }
}
