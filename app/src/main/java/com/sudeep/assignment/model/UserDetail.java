package com.sudeep.assignment.model;

import java.util.List;

public class UserDetail {
    String uname, pass, cpass;
    boolean result = false;

   static List<UserDetail> userList;

    public UserDetail(String uname, String pass, String cpass) {
        this.uname = uname;
        this.pass = pass;
        this.cpass = cpass;
    }

    public UserDetail(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;
    }

    public String getUname() { return uname;  }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public List<UserDetail> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDetail> userList) {
        this.userList = userList;
    }

    public boolean loginChk() {
        if(getUserList()!= null) {

            for (int i = 0; i < getUserList().size(); i++) {
                final UserDetail userdetail = getUserList().get(i);
                if (uname.equals(userdetail.getUname()) && pass.equals(userdetail.getPass())) {
                    result = true;
                } else {
                    result = false;
                }

                //Toast.makeText(getActivity(), ""+userdetail.getUser(), Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            result=false;

        }


        return result;

    }




}
