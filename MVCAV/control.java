package com.company;

import java.util.HashMap;
import java.util.Map;


public class control {
        private model model;
        private view view;

        public control(model model, view view) {
            this.model = model;
            this.view = view;
        }

        public void getAndDisplayPerson(String firstName) {
          PersonBean aPerson = model.getPersonBean(firstName);
            view.showPerson(aPerson);
        }

        public void createAndStorePerson(String name, String last, int age, String position) {
            PersonBean bean = new PersonBean();
            bean.setFirstName(name);
            bean.setLastName(last);
            bean.setAge(age);
            bean.setPosition(position);
            model.addPerson(name,bean);
        }



public static void main(String[]args)throws Exception{
        model model=new model();
        view view=new view();
        control con=new control(model,view);


        con.createAndStorePerson("Ayancy", "Velarde", 25, "Administrator");
        con.createAndStorePerson("Tina", "Fraughton", 27, "Student");

        con.getAndDisplayPerson("Ayancy");
        con.getAndDisplayPerson("Tina");
        }
    }
