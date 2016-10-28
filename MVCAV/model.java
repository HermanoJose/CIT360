package com.company;
        import java.util.Collection;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.TreeMap;

public class model {
    public TreeMap sortedPersons = new TreeMap();

  //  private HashMap<String, PersonBean> personBeanHashMap = new HashMap<>();

    public void addPerson(String key, PersonBean bean)
    {
        sortedPersons.put(key, bean);
    }

    public PersonBean getPersonBean(String firstName)
    {

       // TreeMap sortedPersons = new TreeMap(this.personBeanHashMap);
        return (PersonBean)sortedPersons.get(firstName);
    }

  //  public PersonBean getPesonByName(String key) {
   //     return sortedPersons.get(key);
    }
